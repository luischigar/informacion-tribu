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

import com.example.demo.entity.Ingreso;
import com.example.demo.entityDto.IngresoDto;
import com.example.demo.logic.IngresoLogic;
import com.example.demo.service.IngresoService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/ingresos")
@Api(tags = "Ingreso")
public class IngresoController {
	
	@Autowired
	private IngresoService ingresoService;
	
	@Autowired
	private IngresoLogic ingresoLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody IngresoDto ingresoDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(ingresoLogic.save(ingresoDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Ingreso> oIngreso = ingresoService.findById(id);
		if(!oIngreso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oIngreso);
	}
	
	@GetMapping
	public List<Ingreso> readAll(){
		List<Ingreso> lIngreso = StreamSupport
				.stream(ingresoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lIngreso;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Ingreso ingresoUpdate, @PathVariable(value = "id") Long id){
		Optional<Ingreso> oIngreso = ingresoService.findById(id);
		
		if(!oIngreso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oIngreso.get().setFechaIngreso(ingresoUpdate.getFechaIngreso());
		oIngreso.get().setFechaSalida(ingresoUpdate.getFechaSalida());
		oIngreso.get().setPorcentajeAsignacion(ingresoUpdate.getPorcentajeAsignacion());
		oIngreso.get().setCelula(ingresoUpdate.getCelula());
		oIngreso.get().setPersona(ingresoUpdate.getPersona());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ingresoService.save(oIngreso.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!ingresoService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		ingresoService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
