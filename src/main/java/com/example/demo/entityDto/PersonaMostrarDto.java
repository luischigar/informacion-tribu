package com.example.demo.entityDto;

import com.example.demo.entity.Perfil;
import com.example.demo.entity.Proveedor;

public class PersonaMostrarDto {

	private Long idPersona;
	
	private String nombres;
	
	private String apellidos;
	
	private String correo;
	
	private String telefono;
	
	private Boolean estado;
	
	private Perfil perfil;
	
	private Proveedor proveedor;
	
	private String tecnologia;
	
	private Boolean asignacion;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Boolean getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Boolean asignacion) {
		this.asignacion = asignacion;
	}
}
