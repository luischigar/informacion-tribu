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

import com.example.demo.entity.Tribu;
import com.example.demo.entityDto.TribuDto;
import com.example.demo.logic.TribuLogic;
import com.example.demo.service.TribuService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/tribus")
@Api(tags = "Tribu")
public class TribuController {
	
	@Autowired
	private TribuService tribuService;
	
	@Autowired
	private TribuLogic tribuLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TribuDto tribuDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(tribuLogic.save(tribuDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Tribu> oTribu = tribuService.findById(id);
		if(!oTribu.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oTribu);
	}
	
	@GetMapping
	public List<Tribu> readAll(){
		List<Tribu> lTribu = StreamSupport
				.stream(tribuService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lTribu;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Tribu tribuUpdate, @PathVariable(value = "id") Long id){
		Optional<Tribu> oTribu = tribuService.findById(id);
		
		if(!oTribu.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oTribu.get().setNombreTribu(tribuUpdate.getNombreTribu());
		oTribu.get().setDescripcion(tribuUpdate.getDescripcion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tribuService.save(oTribu.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!tribuService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		tribuService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
