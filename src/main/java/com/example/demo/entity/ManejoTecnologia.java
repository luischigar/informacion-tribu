package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "manejo_Tecnologias")
public class ManejoTecnologia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Manejo_Tecnologia")
	private Long idManejoTecnologia;
	
	
	@ManyToOne
	@JoinColumn(name = "id_Persona", nullable = false)
	private Persona persona; 
	
	@ManyToOne
	@JoinColumn(name = "id_Tecnologia")
	private Tecnologia tecnologia;
	
	@Column(length = 250)
	private String descripcion;

	public Long getIdManejoTecnologia() {
		return idManejoTecnologia;
	}

	public void setIdManejoTecnologia(Long idManejoTecnologia) {
		this.idManejoTecnologia = idManejoTecnologia;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idManejoTecnologia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManejoTecnologia other = (ManejoTecnologia) obj;
		return Objects.equals(idManejoTecnologia, other.idManejoTecnologia);
	}

	@Override
	public String toString() {
		return "ManejoTecnologia [idManejoTecnologia=" + idManejoTecnologia + "]";
	}

}
