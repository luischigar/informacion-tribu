package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Tribu;
import com.example.demo.repository.TribuRepository;

@Service
public class TribuServiceImpl implements TribuService{
	
	@Autowired
	private TribuRepository tribuRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tribu> findAll() {
		try {
			return tribuRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tribu> findById(Long id_Tribu) {
		try {
			return tribuRepository.findById(id_Tribu);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Tribu save(Tribu tribu) {
		try {
			return tribuRepository.save(tribu);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void deleteById(Long id_Tribu) {
		tribuRepository.deleteById(id_Tribu);
		
	}

}
