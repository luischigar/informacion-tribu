package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Perfil;
import com.example.demo.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{
	
	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Perfil> findById(Long id_Perfil) {
		try {
			return perfilRepository.findById(id_Perfil);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	@Transactional
	public Perfil save(Perfil perfil) {
		try {
			return perfilRepository.save(perfil);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	@Transactional
	public void deleteById(Long id_Perfil) {
		perfilRepository.deleteById(id_Perfil);
	}

}
