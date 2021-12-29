package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Celula;
import com.example.demo.entity.Ingreso;
import com.example.demo.entity.Persona;
import com.example.demo.entityDto.IngresoDto;
import com.example.demo.service.CelulaService;
import com.example.demo.service.IngresoService;
import com.example.demo.service.PersonaService;

@Service
public class IngresoLogic {
	
	@Autowired
	private IngresoService ingresoService;
	
	@Autowired
	private CelulaService celulaService;
	
	@Autowired
	private PersonaService personaService;
	
	public Ingreso save(IngresoDto ingresoDto) {
		
		Iterable<Persona> lPersona = personaService.findAll();
		Iterable<Celula> lCelula = celulaService.findAll();
		
		//long miliseconds = System.currentTimeMillis();
        //Date date = new Date(miliseconds);
		
		//System.out.println(ingresoDto);
		Persona persona = new Persona();
		
		for(Persona item: lPersona) {
			if(item.getIdPersona().equals(ingresoDto.idPersona)) {
				persona.setIdPersona(item.getIdPersona());
				persona.setNombres(item.getNombres());
				persona.setApellidos(item.getApellidos());
				persona.setCorreo(item.getCorreo());
				persona.setTelefono(item.getTelefono());
				persona.setEstado(item.getEstado());
				persona.setPerfil(item.getPerfil());
				persona.setProveedor(item.getProveedor());
			}
		}
		
		Celula celula = new Celula();
		
		for(Celula item: lCelula) {
			if(item.getIdCelula().equals(ingresoDto.idCelula)) {
				celula.setIdCelula(item.getIdCelula());
				celula.setNombreCelula(item.getNombreCelula());
				celula.setNombreEquipo(item.getNombreEquipo());
				celula.setNombreProducto(item.getNombreProducto());
				celula.setTribu(item.getTribu());
			}
		}
		
		Ingreso ingreso = new Ingreso();
		
		ingreso.setFechaIngreso(ingresoDto.getFechaIngreso());
		ingreso.setPorcentajeAsignacion(ingresoDto.getPorcentajeAsignacion());
		ingreso.setCelula(celula);
		ingreso.setPersona(persona);
		
		return ingresoService.save(ingreso);
		
	}

}
