package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Perfil;
import com.example.demo.entityDto.PerfilDto;
import com.example.demo.service.PerfilService;

@Service
public class PerfilLogic {
	
	@Autowired
	private PerfilService perfilService;
	
	public Perfil save(PerfilDto perfilDto) {
		
		Iterable<Perfil> lTribu = perfilService.findAll();
		
		if(perfilDto.getNombrePerfil() == "") {
			throw new IllegalArgumentException();
		}
		
		for(Perfil item: lTribu) {
			if(item.getNombrePerfil().equals(perfilDto.getNombrePerfil())) {
				throw new IllegalArgumentException();
			}
		}
		
		Perfil perfil = new Perfil();
		perfil.setNombrePerfil(perfilDto.getNombrePerfil());
		perfil.setDescripcion(perfilDto.getDescripcion());
		return perfilService.save(perfil);
		
	}

}
