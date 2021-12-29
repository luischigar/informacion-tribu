package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Ingreso;
import com.example.demo.repository.IngresoRepository;

@Service
public class IngresoServiceImpl implements IngresoService{
	
	@Autowired
	private IngresoRepository ingresoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Ingreso> findAll() {
		try {
			return ingresoRepository.findAll(Sort.by(Sort.Direction.DESC, "idIngreso"));
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Ingreso> findById(Long id_Ingreso) {
		try {
			return ingresoRepository.findById(id_Ingreso);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Ingreso save(Ingreso ingreso) {
		try {
			return ingresoRepository.save(ingreso);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void deleteById(Long id_Ingreso) {
		ingresoRepository.deleteById(id_Ingreso);
		
	}

}
