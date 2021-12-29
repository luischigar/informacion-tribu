package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Perfil;

public interface PerfilService {
	
	public Iterable<Perfil> findAll();
	
	public Optional<Perfil> findById(Long id_Perfil);
	
	public Perfil save(Perfil perfil);
	
	public void deleteById(Long id_Perfil);

}
