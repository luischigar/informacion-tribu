package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Ingreso;


public interface IngresoService {
	
	public Iterable<Ingreso> findAll();
	
	public Optional<Ingreso> findById(Long id_Ingreso);
	
	public Ingreso save(Ingreso ingreso);
	
	public void deleteById(Long id_Ingreso);

}
