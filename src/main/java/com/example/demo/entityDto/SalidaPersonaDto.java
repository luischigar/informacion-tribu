package com.example.demo.entityDto;

import java.sql.Date;

public class SalidaPersonaDto {
	
	public Long idIngreso;
	
	private Date fechaSalida;

	public Long getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(Long idIngreso) {
		this.idIngreso = idIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
