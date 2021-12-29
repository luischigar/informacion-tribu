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

import com.example.demo.entity.Tecnologia;
import com.example.demo.entityDto.TecnologiaDto;
import com.example.demo.logic.TecnologiaLogic;
import com.example.demo.service.TecnologiaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/tecnologias")
@Api(tags = "Tecnologia")
public class TecnologiaController {
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@Autowired
	private TecnologiaLogic tecnologiaLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TecnologiaDto tecnologiaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(tecnologiaLogic.save(tecnologiaDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Tecnologia> oTecnologia = tecnologiaService.findById(id);
		if(!oTecnologia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oTecnologia);
	}
	
	@GetMapping
	public List<Tecnologia> readAll(){
		List<Tecnologia> lTecnologia = StreamSupport
				.stream(tecnologiaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lTecnologia;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Tecnologia tecnologiaUpdate, @PathVariable(value = "id") Long id){
		Optional<Tecnologia> oTecnologia = tecnologiaService.findById(id);
		
		if(!oTecnologia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oTecnologia.get().setNombreTecnologia(tecnologiaUpdate.getNombreTecnologia());
		oTecnologia.get().setDescripcion(tecnologiaUpdate.getDescripcion());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(tecnologiaService.save(oTecnologia.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!tecnologiaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		tecnologiaService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
