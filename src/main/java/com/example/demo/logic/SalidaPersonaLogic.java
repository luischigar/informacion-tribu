package com.example.demo.logic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ingreso;
import com.example.demo.entityDto.SalidaPersonaDto;
import com.example.demo.service.IngresoService;

@Service
public class SalidaPersonaLogic {
	
	@Autowired
	private IngresoService ingresoService;
	
	public Ingreso salidaPersona(SalidaPersonaDto salidaPersonaDto) {
		
		Optional<Ingreso> oIngreso = ingresoService.findById(salidaPersonaDto.idIngreso);
		//System.out.println(salidaPersonaDto.getFechaSalida());
		if(!oIngreso.isPresent()) {
			throw new IllegalArgumentException();
		}
		oIngreso.get().setFechaSalida(salidaPersonaDto.getFechaSalida());
		return ingresoService.save(oIngreso.get());
	}

}
