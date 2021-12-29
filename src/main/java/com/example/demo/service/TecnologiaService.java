package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Tecnologia;

public interface TecnologiaService {
	
	public Iterable<Tecnologia> findAll();
	
	public Optional<Tecnologia> findById(Long id_Tecnologia);
	
	public Tecnologia save(Tecnologia tecnologia);
	
	public void deleteById(Long id_Tecnologia);

}
