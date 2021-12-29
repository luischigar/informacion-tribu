package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Celula;
import com.example.demo.repository.CelulaRepository;

@Service
public class CelulaServiceImpl implements CelulaService{
	
	@Autowired
	private CelulaRepository celulaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Celula> findAll() {
		try {
			return celulaRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Celula> findById(Long id_Celula) {
		try {
			return celulaRepository.findById(id_Celula);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Celula save(Celula celula) {
		try {
			return celulaRepository.save(celula);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void deleteById(Long id_Celula) {
		celulaRepository.deleteById(id_Celula);
		
	}

}
