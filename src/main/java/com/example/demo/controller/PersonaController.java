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

import com.example.demo.entity.Persona;
import com.example.demo.entityDto.PersonaDto;
import com.example.demo.entityDto.PersonaMostrarDto;
import com.example.demo.logic.PersonaLogic;
import com.example.demo.service.PersonaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/personas")
@Api(tags = "Persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PersonaLogic personaLogic;
	
	@PostMapping
	//@ControllerAdvice consultar 
	public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(personaLogic.save(personaDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Persona> oPersona = personaService.findById(id);
		if(!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPersona);
	}
	
	@GetMapping
	public List<PersonaMostrarDto> readAll(){
		List<PersonaMostrarDto> lPersonaMostrarDto = StreamSupport
				.stream(personaLogic.findAllPersona().spliterator(), false)
				.collect(Collectors.toList());
		return lPersonaMostrarDto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Persona personaUpdate, @PathVariable(value = "id") Long id){
		Optional<Persona> oPersona = personaService.findById(id);
		
		if(!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oPersona.get().setNombres(personaUpdate.getNombres());
		oPersona.get().setApellidos(personaUpdate.getApellidos());
		oPersona.get().setCorreo(personaUpdate.getCorreo());
		oPersona.get().setTelefono(personaUpdate.getTelefono());
		oPersona.get().setEstado(personaUpdate.getEstado());
		oPersona.get().setIdPersona(personaUpdate.getIdPersona());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(oPersona.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!personaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		personaService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
