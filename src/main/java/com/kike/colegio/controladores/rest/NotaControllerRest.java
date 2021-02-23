/**
 * 
 */
package com.kike.colegio.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.repositorios.NotaRepository;

/**
 * @author 201909
 *
 */
@RestController
@RequestMapping("/v1")
public class NotaControllerRest {
	@Autowired
	private NotaRepository notaRepo;
	
	@Autowired
	private NotaDAO notaDAO;
	
	//Insertar nota
	@PostMapping(value = "/notas")
	public ResponseEntity<String> insertarNota(@RequestBody NotaEntity nota){
		notaRepo.save(nota);
		return new ResponseEntity<>("Inserción correcta!", HttpStatus.OK);
	}
	
	//Obtener notas
	@GetMapping(value = "/notas")
	public Iterable<NotaEntity> listarTodasNotas(){
		return notaRepo.findAll();
	}
	
	
}
