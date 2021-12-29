package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Proveedor;

public interface ProveedorService {
	
	public Iterable<Proveedor> findAll();
	
	public Optional<Proveedor> findById(Long id_Proveedor);
	
	public Proveedor save(Proveedor proveedor);
	
	public void deleteById(Long id_Proveedor);

}
