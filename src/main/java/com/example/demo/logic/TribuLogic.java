package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tribu;
import com.example.demo.entityDto.TribuDto;
import com.example.demo.service.TribuService;

@Service
public class TribuLogic {
	
	@Autowired
	private TribuService tribuService;
	
	
	public Tribu save(TribuDto tribuDto) {
				
		Iterable<Tribu> lTribu = tribuService.findAll();
				
		if(tribuDto.getNombreTribu() == "") {
			throw new IllegalArgumentException();
		}
		for(Tribu item: lTribu) {
			if(item.getNombreTribu().equals(tribuDto.getNombreTribu())) {
				throw new IllegalArgumentException();
			}
		}
		Tribu tribu = new Tribu();
		tribu.setNombreTribu(tribuDto.getNombreTribu());
		tribu.setDescripcion(tribuDto.getDescripcion());
		return tribuService.save(tribu);
	}

}
