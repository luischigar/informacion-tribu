package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecnologias")
public class Tecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Tecnologia")
	private Long idTecnologia;
	
	@Column(name = "nombre_Tecnologia", length = 50)
	private String nombreTecnologia;
	
	@Column(length = 250)
	private String descripcion;

	public Long getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(Long idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

	public String getNombreTecnologia() {
		return nombreTecnologia;
	}

	public void setNombreTecnologia(String nombreTecnologia) {
		this.nombreTecnologia = nombreTecnologia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTecnologia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnologia other = (Tecnologia) obj;
		return Objects.equals(idTecnologia, other.idTecnologia);
	}

	@Override
	public String toString() {
		return "Tecnologia [idTecnologia=" + idTecnologia + "]";
	}

}
