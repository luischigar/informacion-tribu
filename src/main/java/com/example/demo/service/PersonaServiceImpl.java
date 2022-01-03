package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Persona;
import com.example.demo.entityDto.PersonaIngresoDto;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findAll() {
		try {
			return personaRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> findById(Long id_Persona) {
		try {
			return personaRepository.findById(id_Persona);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		try {
			return personaRepository.save(persona);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	@Transactional
	public void deleteById(Long id_Persona) {
		personaRepository.deleteById(id_Persona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonaIngresoDto> personaObtenerAsignacion() {
		try {
			return personaRepository.personaObtenerAsignacion();
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
	}

}
