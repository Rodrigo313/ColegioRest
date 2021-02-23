package com.kike.colegio.controladores.rest;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.dtos.AsignaturaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.repositorios.AlumnoRepository;
import com.kike.colegio.repositorios.AsignaturaRepository;

@RestController
@RequestMapping("/v1")
public class AsignaturaControllerRest {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	//Insertar alumnos
		
	@PostMapping(value = "/asignaturas")
	public ResponseEntity <String> insertarAlumno(@RequestBody AsignaturaEntity asignatura){
		
		
		asignaturaRepository.save(asignatura);
		
		return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);	
		
	}
	
	//Obtener todos los alumnos
	
	@GetMapping(value = "/asignaturas")
	public Iterable<AsignaturaEntity> listarTodasAsignaturas() {
		return asignaturaRepository.findAll();
	}
	
	//Obtener alumnos por id
	
	@GetMapping(value = "/asignaturas/{id}")
	public Optional<AsignaturaEntity> buscarAsignaturaPorId(@PathVariable("id") Integer id) {
		return asignaturaRepository.findById(id);
	}
	
	
	//Obtener alumnos por id y nombre
	
	@GetMapping(value = "/asignaturas", params = {"id", "nombre"})
	public List<AsignaturaDTO> listarAsignaturaPorIdNombre(@RequestParam("id") Integer id, @RequestParam("nombre") String nombre) {
		
		return asignaturaDAO.obtenerAsignaturaporIdyNombre(id, nombre);
	}
	
	
	//Actualizar alumno
	
	@PutMapping(value = "/asignaturas")
	public ResponseEntity<String> actulizarAlumno(@RequestBody AsignaturaEntity asignatura){
		
		asignaturaRepository.save(asignatura);
		return new ResponseEntity<>("Actualizacion correcta!", HttpStatus.OK);
	}
	
	//BorrarAlumnos
	
	@DeleteMapping(value = "asignaturas/{id}")
	public ResponseEntity<String> MostrarFormularioBorrarAlumnos(@PathVariable("id") Integer id){
		
		asignaturaRepository.deleteById(id);
		return new ResponseEntity<>("Borrado correctamente!", HttpStatus.OK);
	}
	
	
	
}