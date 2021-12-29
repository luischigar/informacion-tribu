package com.example.demo.entity;

import java.sql.Date;
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
@Table(name = "ingresos")
public class Ingreso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Ingreso")
	private Long idIngreso;
	
	@Column(name = "fecha_Ingreso")
	private Date fechaIngreso;
	
	@Column(name = "fecha_Salida")
	private Date fechaSalida;
	
	@Column(name = "porcentaje_Asignacion")
	private int porcentajeAsignacion;
	
	@ManyToOne
	@JoinColumn(name = "id_Celula")
	private Celula celula;
	
	@ManyToOne
	@JoinColumn(name = "id_Persona")
	private Persona persona;

	public Long getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(Long idIngreso) {
		this.idIngreso = idIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getPorcentajeAsignacion() {
		return porcentajeAsignacion;
	}

	public void setPorcentajeAsignacion(int porcentajeAsignacion) {
		this.porcentajeAsignacion = porcentajeAsignacion;
	}

	public Celula getCelula() {
		return celula;
	}

	public void setCelula(Celula celula) {
		this.celula = celula;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idIngreso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingreso other = (Ingreso) obj;
		return Objects.equals(idIngreso, other.idIngreso);
	}

	@Override
	public String toString() {
		return "Ingreso [idIngreso=" + idIngreso + "]";
	}

}
