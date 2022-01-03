package com.example.demo.entityDto;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;


public class PersonaIngresoDto {
	
	private Long idPersona;
	
	private Long idIngreso;

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(Long idIngreso) {
		this.idIngreso = idIngreso;
	}

}
