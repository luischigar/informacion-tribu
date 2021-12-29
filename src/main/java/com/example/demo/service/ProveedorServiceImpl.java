package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedor> findAll() {
		try {
			return proveedorRepository.findAll();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findById(Long id_Proveedor) {
		try {
			return proveedorRepository.findById(id_Proveedor);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		try {
			return proveedorRepository.save(proveedor);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	@Transactional
	public void deleteById(Long id_Proveedor) {
		proveedorRepository.deleteById(id_Proveedor);
		
	}
	
	

}
