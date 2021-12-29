package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ManejoTecnologia;
import com.example.demo.repository.ManejoTecnologiaRepository;

@Service
public class ManejoTecnologiaServiceImpl implements ManejoTecnologiaService{
	
	@Autowired
	private ManejoTecnologiaRepository manejoTecnologiaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<ManejoTecnologia> findAll() {
		try {
			return manejoTecnologiaRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ManejoTecnologia> findById(Long id_ManejoTecnologia) {
		try {
			return manejoTecnologiaRepository.findById(id_ManejoTecnologia);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public ManejoTecnologia save(ManejoTecnologia manejoTecnologia) {
		try {
			return manejoTecnologiaRepository.save(manejoTecnologia);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void deleteById(Long id_ManejoTecnologia) {
		manejoTecnologiaRepository.deleteById(id_ManejoTecnologia);
		
	}

}
