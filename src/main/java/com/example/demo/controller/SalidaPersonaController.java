package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entityDto.SalidaPersonaDto;
import com.example.demo.logic.SalidaPersonaLogic;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/salidas")
@Api(tags = "Salida Persona")
public class SalidaPersonaController {
	
	@Autowired
	private SalidaPersonaLogic salidaPersonaLogic;
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody SalidaPersonaDto salidaPersonaDto){
		System.out.println(salidaPersonaDto.getFechaSalida());
		return ResponseEntity.status(HttpStatus.CREATED).body(salidaPersonaLogic.salidaPersona(salidaPersonaDto));
	}

}
