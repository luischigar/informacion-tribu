package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Celula;

public interface CelulaService {
	
	public Iterable<Celula> findAll();
	
	public Optional<Celula> findById(Long id_Celula);
	
	public Celula save(Celula celula);
	
	public void deleteById(Long id_Celula);

}
