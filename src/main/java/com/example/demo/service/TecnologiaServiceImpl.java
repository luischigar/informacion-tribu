package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tecnologia;
import com.example.demo.repository.TecnologiaRepository;

@Service
public class TecnologiaServiceImpl implements TecnologiaService{
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tecnologia> findAll() {
		try {
			return tecnologiaRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tecnologia> findById(Long id_Tecnologia) {
		try {
			return tecnologiaRepository.findById(id_Tecnologia);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Tecnologia save(Tecnologia tecnologia) {
		try {
			return tecnologiaRepository.save(tecnologia);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id_Tecnologia) {
		tecnologiaRepository.deleteById(id_Tecnologia);
		
	}

}
