package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tecnologia;
import com.example.demo.entityDto.TecnologiaDto;
import com.example.demo.service.TecnologiaService;

@Service
public class TecnologiaLogic {
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	public Tecnologia save(TecnologiaDto tecnologiaDto) {
		
		Iterable<Tecnologia> lTecnologia = tecnologiaService.findAll();
		
		if(tecnologiaDto.getNombreTecnologia() == "") {
			throw new IllegalArgumentException();
		}
		
		for(Tecnologia item: lTecnologia) {
			if(item.getNombreTecnologia().equals(tecnologiaDto.getNombreTecnologia())) {
				throw new IllegalArgumentException();
			}
		}
		
		Tecnologia tecnologia = new Tecnologia();
		tecnologia.setNombreTecnologia(tecnologiaDto.getNombreTecnologia());
		tecnologia.setDescripcion(tecnologiaDto.getDescripcion());
		return tecnologiaService.save(tecnologia);
	}

}
