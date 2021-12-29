package com.example.demo.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ManejoTecnologia;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Tecnologia;
import com.example.demo.entityDto.ManejoTecnologiaDto;
import com.example.demo.service.ManejoTecnologiaService;
import com.example.demo.service.TecnologiaService;

@Service
public class ManejoTecnologiaLogic {
	
	@Autowired
	private ManejoTecnologiaService manejoTecnologiaService;
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	public List<ManejoTecnologia> save(ManejoTecnologiaDto manejoTecnologiaDto) {
		
		int longitud = manejoTecnologiaDto.getIdTecnologia().size();
		int contador = 0;
		
		List<ManejoTecnologia> lManejoTecnologia = new ArrayList<ManejoTecnologia>();
		
		Iterable<Tecnologia> lTecnologia = tecnologiaService.findAll();
		
		for(Long item: manejoTecnologiaDto.getIdTecnologia()) {
			for(Tecnologia item2: lTecnologia) {
				if(item2.getIdTecnologia() == item) {
					contador ++;
				}
			}
		}
		
		if(contador != longitud) {
			throw new IllegalArgumentException();
		}
		
		
		Persona persona = new Persona();
		Tecnologia tecnologia = new Tecnologia();
		ManejoTecnologia manejoTecnologia = new ManejoTecnologia();
		
		persona.setIdPersona(manejoTecnologiaDto.getIdPersona());
		
		for(Long item: manejoTecnologiaDto.getIdTecnologia()) {

			tecnologia.setIdTecnologia(item);
			
			manejoTecnologia.setDescripcion(manejoTecnologiaDto.getDescripcion());
			manejoTecnologia.setPersona(persona);
			manejoTecnologia.setTecnologia(tecnologia);
			
			manejoTecnologia = manejoTecnologiaService.save(manejoTecnologia);
			
			lManejoTecnologia.add(manejoTecnologia);
			
			tecnologia = new Tecnologia();
			manejoTecnologia = new ManejoTecnologia();
		}
		
		return lManejoTecnologia;
		
	}

}
