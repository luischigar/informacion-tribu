package com.example.demo.entityDto;

import java.util.List;

public class PersonaDto {
	
	private String nombres;
	
	private String apellidos;
	
	private String correo;
	
	private String telefono;
	
	private Long idPerfil;
	
	private Long idProveedor;
	
	private List<Long> idTecnologia;

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public List<Long> getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(List<Long> idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

}
