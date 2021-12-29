package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Tribu;

public interface TribuService {
	
	public Iterable<Tribu> findAll();
	
	public Optional<Tribu> findById(Long id_Tribu);
	
	public Tribu save(Tribu tribu);
	
	public void deleteById(Long id_Tribu);

}
