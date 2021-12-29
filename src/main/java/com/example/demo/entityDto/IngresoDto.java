package com.example.demo.entityDto;

import java.sql.Date;

public class IngresoDto {
	
	public Long idCelula;
	
	public Long idPersona;
	
	public Date fechaIngreso;
	
	public int porcentajeAsignacion;

	public Long getIdCelula() {
		return idCelula;
	}

	public void setIdCelula(Long idCelula) {
		this.idCelula = idCelula;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getPorcentajeAsignacion() {
		return porcentajeAsignacion;
	}

	public void setPorcentajeAsignacion(int porcentajeAsignacion) {
		this.porcentajeAsignacion = porcentajeAsignacion;
	}

}
