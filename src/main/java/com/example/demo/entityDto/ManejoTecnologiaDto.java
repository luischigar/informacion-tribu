package com.example.demo.entityDto;

import java.util.List;

public class ManejoTecnologiaDto {
	
	private Long idPersona;
	
	private List<Long> idTecnologia;
	
	private String descripcion;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public List<Long> getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(List<Long> idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
