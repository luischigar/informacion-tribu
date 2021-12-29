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

import com.example.demo.entity.Celula;
import com.example.demo.entityDto.CelulaDto;
import com.example.demo.logic.CelulaLogic;
import com.example.demo.service.CelulaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/celulas")
@Api(tags = "Celula")
public class CelulaController {
	
	@Autowired
	private CelulaService celulaService;
	
	@Autowired
	private CelulaLogic celulaLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CelulaDto celulaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaLogic.save(celulaDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Celula> oCelula = celulaService.findById(id);
		if(!oCelula.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCelula);
	}
	
	@GetMapping
	public List<Celula> readAll(){
		List<Celula> lCelula = StreamSupport
				.stream(celulaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lCelula;
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Celula celulaUpdate, @PathVariable(value = "id") Long id){
		Optional<Celula> oCelula = celulaService.findById(id);
		
		if(!oCelula.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oCelula.get().setNombreCelula(celulaUpdate.getNombreCelula());
		oCelula.get().setNombreEquipo(celulaUpdate.getNombreEquipo());
		oCelula.get().setNombreProducto(celulaUpdate.getNombreProducto());
		oCelula.get().setTribu(celulaUpdate.getTribu());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(celulaService.save(oCelula.get()));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!celulaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		celulaService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
