package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Celula;
import com.example.demo.entity.Tribu;
import com.example.demo.entityDto.CelulaDto;
import com.example.demo.service.CelulaService;

@Service
public class CelulaLogic {
	
	@Autowired
	private CelulaService celulaService;
	
	public Celula save(CelulaDto celulaDto) {
		
		Iterable<Celula> lCelula = celulaService.findAll();
		
		if(celulaDto.getNombreCelula() == "") {
			throw new IllegalArgumentException();
		}
		
		for(Celula item: lCelula) {
			if(item.getNombreCelula().equals(celulaDto.getNombreCelula())) {
				throw new IllegalArgumentException();
			}
		}
		
		Tribu tribu = new Tribu();
		tribu.setIdTribu(celulaDto.getIdTribu());
		
		Celula celula = new Celula();
		celula.setNombreCelula(celulaDto.getNombreCelula());
		celula.setNombreEquipo(celulaDto.getNombreEquipo());
		celula.setNombreProducto(celulaDto.getNombreProducto());
		celula.setTribu(tribu);
		return celulaService.save(celula);
	}

}
