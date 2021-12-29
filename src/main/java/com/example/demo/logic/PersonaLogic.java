package com.example.demo.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ingreso;
import com.example.demo.entity.ManejoTecnologia;
import com.example.demo.entity.Perfil;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Proveedor;
import com.example.demo.entity.Tecnologia;
import com.example.demo.entityDto.PersonaDto;
import com.example.demo.entityDto.PersonaMostrarDto;
import com.example.demo.service.IngresoService;
import com.example.demo.service.ManejoTecnologiaService;
import com.example.demo.service.PerfilService;
import com.example.demo.service.PersonaService;
import com.example.demo.service.ProveedorService;
import com.example.demo.service.TecnologiaService;

@Service
public class PersonaLogic {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@Autowired
	private ManejoTecnologiaService manejoTecnologiaService;
	
	@Autowired
	private IngresoService ingresoService;
	
	public List<PersonaMostrarDto> findAllPersona() {
		try {
			Iterable<Persona> lPersona = personaService.findAll();
			Iterable<ManejoTecnologia> lManejoTecnologia = manejoTecnologiaService.findAll();
			Iterable<Ingreso> lIngreso = ingresoService.findAll();
			List<PersonaMostrarDto> lPersonaMostrarDto = new LinkedList<PersonaMostrarDto>();
			
			for(Persona item: lPersona) {
				String tecnologia = "";
				int contador = 0;
				for(ManejoTecnologia item2: lManejoTecnologia) {
					if(item.getIdPersona().equals(item2.getPersona().getIdPersona())) {
						if(contador > 0) {
							tecnologia = tecnologia +", " + item2.getTecnologia().getNombreTecnologia();
						}else {
							tecnologia = tecnologia + item2.getTecnologia().getNombreTecnologia();
						}
						contador++;
					}
				}
				Boolean asignacion = false;
				for(Ingreso item3: lIngreso) {
					if(item.getIdPersona().equals(item3.getPersona().getIdPersona())) {
						asignacion = true;
					}
				}
				
				PersonaMostrarDto personaMostrarDto = new PersonaMostrarDto();
				
				personaMostrarDto.setIdPersona(item.getIdPersona());
				personaMostrarDto.setNombres(item.getNombres());
				personaMostrarDto.setApellidos(item.getApellidos());
				personaMostrarDto.setCorreo(item.getCorreo());
				personaMostrarDto.setTelefono(item.getTelefono());
				personaMostrarDto.setEstado(item.getEstado());
				personaMostrarDto.setPerfil(item.getPerfil());
				personaMostrarDto.setProveedor(item.getProveedor());
				personaMostrarDto.setTecnologia(tecnologia);
				personaMostrarDto.setAsignacion(asignacion);
				
				lPersonaMostrarDto.add(personaMostrarDto);
			}
			
			return lPersonaMostrarDto;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}
	
	public Persona save(PersonaDto personaDto) {
		
		Iterable<Perfil> lperfil = perfilService.findAll();
		Iterable<Proveedor> lProveedor = proveedorService.findAll();
		
		//verificar tecnologia
		int longitud = personaDto.getIdTecnologia().size();
		int contador = 0;
		
		List<ManejoTecnologia> lManejoTecnologia = new ArrayList<ManejoTecnologia>();
		
		Iterable<Tecnologia> lTecnologia = tecnologiaService.findAll();
		
		for(Long item: personaDto.getIdTecnologia()) {
			for(Tecnologia item2: lTecnologia) {
				if(item2.getIdTecnologia() == item) {
					contador ++;
				}
			}
		}
		
		if(contador != longitud) {
			throw new IllegalArgumentException();
		}
		//end verificacion de la tecnologia
		
		if(personaDto.getNombres() == "" || personaDto.getApellidos() == "") {
			throw new IllegalArgumentException();
		}
				
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(personaDto.getIdPerfil());
		
		for(Perfil item: lperfil) {
			if(item.getIdPerfil().equals(personaDto.getIdPerfil())) {
				perfil.setNombrePerfil(item.getNombrePerfil());
				perfil.setDescripcion(item.getDescripcion());
			}
		}
		
		Proveedor proveedor = new Proveedor();
		proveedor.setIdProveedor(personaDto.getIdProveedor());
		
		for(Proveedor item: lProveedor) {
			if(item.getIdProveedor().equals(personaDto.getIdProveedor())) {
				proveedor.setDescripcion(item.getDescripcion());
				proveedor.setNombreProveedor(item.getNombreProveedor());
			}
		}
		
		Persona persona = new Persona();
		persona.setNombres(personaDto.getNombres());
		persona.setApellidos(personaDto.getApellidos());
		persona.setCorreo(personaDto.getCorreo());
		persona.setTelefono(personaDto.getTelefono());
		persona.setEstado(true);
		persona.setPerfil(perfil);
		persona.setProveedor(proveedor);
		
		Persona personaTecnologia = personaService.save(persona);
		
		//ingreso de la tecnologia
		Tecnologia tecnologia = new Tecnologia();
		ManejoTecnologia manejoTecnologia = new ManejoTecnologia();
				
		for(Long item: personaDto.getIdTecnologia()) {

			tecnologia.setIdTecnologia(item);
			
			manejoTecnologia.setPersona(personaTecnologia);
			manejoTecnologia.setTecnologia(tecnologia);
			
			manejoTecnologia = manejoTecnologiaService.save(manejoTecnologia);
			
			lManejoTecnologia.add(manejoTecnologia);
			
			tecnologia = new Tecnologia();
			manejoTecnologia = new ManejoTecnologia();
		}
		
		return personaTecnologia;
	}

}
