package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Persona;
import com.example.demo.entityDto.PersonaIngresoDto;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	@Query(value = "SELECT personas.id_persona as idPersona, ingresos.id_Ingreso as idIngreso FROM personas LEFT JOIN ingresos ON personas.id_persona = ingresos.id_persona WHERE(ingresos.fecha_salida IS NULL)", nativeQuery = true)
	List<PersonaIngresoDto> personaObtenerAsignacion();

}
