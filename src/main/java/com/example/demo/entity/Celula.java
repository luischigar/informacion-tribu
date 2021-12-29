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
@Table(name = "celulas")
public class Celula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_celula")
	private Long idCelula;
	
	@Column(length = 50, name = "nombre_Celula")
	private String nombreCelula;
	
	@Column(length = 50, name = "nombre_Equipo")
	private String nombreEquipo;
	
	@Column(length = 50, name = "nombre_Producto")
	private String nombreProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_Tribu",nullable = false)
	private Tribu tribu;

	public Long getIdCelula() {
		return idCelula;
	}

	public void setIdCelula(Long idCelula) {
		this.idCelula = idCelula;
	}

	public String getNombreCelula() {
		return nombreCelula;
	}

	public void setNombreCelula(String nombreCelula) {
		this.nombreCelula = nombreCelula;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Tribu getTribu() {
		return tribu;
	}

	public void setTribu(Tribu tribu) {
		this.tribu = tribu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCelula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celula other = (Celula) obj;
		return Objects.equals(idCelula, other.idCelula);
	}

	@Override
	public String toString() {
		return "Celula [idCelula=" + idCelula + "]";
	}

	

}
