package com.example.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proveedor;
import com.example.demo.entityDto.ProveedorDto;
import com.example.demo.service.ProveedorService;

@Service
public class ProveedorLogic {
	
	@Autowired
	private ProveedorService proveedorService;
	
	public Proveedor save(ProveedorDto proveedorDto) {
		
		Iterable<Proveedor> lProveedor = proveedorService.findAll();
		
		if(proveedorDto.getNombreProveedor() == "") {
			throw new IllegalArgumentException();
		}
		
		for(Proveedor item: lProveedor) {
			if(item.getNombreProveedor().equals(proveedorDto.getNombreProveedor())) {
				throw new IllegalArgumentException();
			}
		}
		
		Proveedor proveedor = new Proveedor();
		
		proveedor.setNombreProveedor(proveedorDto.getNombreProveedor());
		proveedor.setDescripcion(proveedorDto.getDescripcion());
		
		return proveedorService.save(proveedor);
	}

}
