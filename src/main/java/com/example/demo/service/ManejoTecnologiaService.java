package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.ManejoTecnologia;

public interface ManejoTecnologiaService {
	
	public Iterable<ManejoTecnologia> findAll();
	
	public Optional<ManejoTecnologia> findById(Long id_ManejoTecnologia);
	
	public ManejoTecnologia save(ManejoTecnologia manejoTecnologia);
	
	public void deleteById(Long id_ManejoTecnologia);

}
