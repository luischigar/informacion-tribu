package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ManejoTecnologia;
import com.example.demo.entityDto.ManejoTecnologiaDto;
import com.example.demo.logic.ManejoTecnologiaLogic;
import com.example.demo.service.ManejoTecnologiaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/menejoTecnologias")
@Api(tags = "Manejo Tecnologia")
public class ManejoTecnologiaController {
	
	@Autowired
	private ManejoTecnologiaService manejoTecnologiaService;
	
	@Autowired
	private ManejoTecnologiaLogic manejoTecnologia;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ManejoTecnologiaDto manejoTecnologiaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(manejoTecnologia.save(manejoTecnologiaDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<ManejoTecnologia> oManejoTecnologia = manejoTecnologiaService.findById(id);
		if(!oManejoTecnologia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oManejoTecnologia);
	}
	
	@GetMapping
	public List<ManejoTecnologia> readAll(){
		List<ManejoTecnologia> lManejoTecnologia = StreamSupport
				.stream(manejoTecnologiaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lManejoTecnologia;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ManejoTecnologia manejoTecnologiaUpdate, @PathVariable(value = "id") Long id){
		Optional<ManejoTecnologia> oManejoTecnologia = manejoTecnologiaService.findById(id);
		
		if(!oManejoTecnologia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oManejoTecnologia.get().setDescripcion(manejoTecnologiaUpdate.getDescripcion());
		oManejoTecnologia.get().setPersona(manejoTecnologiaUpdate.getPersona());
		oManejoTecnologia.get().setTecnologia(manejoTecnologiaUpdate.getTecnologia());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(manejoTecnologiaService.save(oManejoTecnologia.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!manejoTecnologiaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		manejoTecnologiaService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
