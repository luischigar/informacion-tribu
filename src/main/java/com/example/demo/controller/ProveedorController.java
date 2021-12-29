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

import com.example.demo.entity.Proveedor;
import com.example.demo.entityDto.ProveedorDto;
import com.example.demo.logic.ProveedorLogic;
import com.example.demo.service.ProveedorService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/proveedores")
@Api(tags = "Proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private ProveedorLogic proveedorLogic;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProveedorDto proveedorDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorLogic.save(proveedorDto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")Long id){
		Optional<Proveedor> oProveedor = proveedorService.findById(id);
		if(!oProveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProveedor);
	}
	
	@GetMapping
	public List<Proveedor> readAll(){
		List<Proveedor> lProveedor = StreamSupport
				.stream(proveedorService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return lProveedor;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedorUpdate, @PathVariable(value = "id") Long id){
		Optional<Proveedor> oProveedor = proveedorService.findById(id);
		
		if(!oProveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oProveedor.get().setNombreProveedor(proveedorUpdate.getNombreProveedor());
		oProveedor.get().setDescripcion(proveedorUpdate.getDescripcion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(oProveedor.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		//Optional<User> oUser = userService.findById(id);
		
		if(!proveedorService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		proveedorService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
