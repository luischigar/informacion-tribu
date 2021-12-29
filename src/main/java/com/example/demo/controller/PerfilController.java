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

import com.example.demo.entity.Perfil;
import com.example.demo.entityDto.PerfilDto;
import com.example.demo.logic.PerfilLogic;
import com.example.demo.service.PerfilService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/perfiles")
@Api(tags = "Perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private PerfilLogic perfilLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PerfilDto perfilDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilLogic.save(perfilDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Perfil> oPerfil = perfilService.findById(id);
		if(!oPerfil.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPerfil);
	}
	
	@GetMapping
	public List<Perfil> readAll(){
		List<Perfil> lPerfil = StreamSupport
				.stream(perfilService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lPerfil;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Perfil perfilUpdate, @PathVariable(value = "id") Long id){
		Optional<Perfil> oPerfil = perfilService.findById(id);
		
		if(!oPerfil.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oPerfil.get().setNombrePerfil(perfilUpdate.getNombrePerfil());
		oPerfil.get().setDescripcion(perfilUpdate.getDescripcion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(oPerfil.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!perfilService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		perfilService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
