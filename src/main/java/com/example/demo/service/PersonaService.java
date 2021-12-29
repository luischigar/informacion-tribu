package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Persona;


public interface PersonaService {
	
	public Iterable<Persona> findAll();
		
	public Optional<Persona> findById(Long id_Persona);
	
	public Persona save(Persona persona);
	
	public void deleteById(Long id_Persona);
}
