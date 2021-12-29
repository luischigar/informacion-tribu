package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tribus")
public class Tribu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Tribu")
	private Long idTribu;
	
	@Column(length = 50, name = "nombre_Tribu")
	private String nombreTribu;
	
	@Column(length = 250)
	private String descripcion;
	
	public Long getIdTribu() {
		return idTribu;
	}

	public void setIdTribu(Long idTribu) {
		this.idTribu = idTribu;
	}

	public String getNombreTribu() {
		return nombreTribu;
	}

	public void setNombreTribu(String nombreTribu) {
		this.nombreTribu = nombreTribu;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTribu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tribu other = (Tribu) obj;
		return Objects.equals(idTribu, other.idTribu);
	}

	@Override
	public String toString() {
		return "Tribu [idTribu=" + idTribu + "]";
	}

}
