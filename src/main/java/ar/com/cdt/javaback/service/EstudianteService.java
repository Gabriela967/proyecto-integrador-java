package ar.com.cdt.javaback.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.javaback.bo.EstudianteBO;
import ar.com.cdt.javaback.bo.impl.EstudianteBOImpl;
import ar.com.cdt.javaback.entity.EstudianteEntity;
import ar.com.cdt.javaback.models.EstudianteModel;

@SpringBootApplication
@RestController
public class EstudianteService {
	
	public static final Logger logger = LoggerFactory.getLogger(EstudianteService.class);

	@Autowired
	EstudianteBO estudianteBO;
	
	@GetMapping("/estudiante/{id}")
	public Optional<EstudianteEntity> getEstudiante(@PathVariable Long id) {
	  logger.info("EstudianteService - entra en getEstudiante: {}", id);
	  return estudianteBO.consultarPorEstudiante(id);

	}
	
	@GetMapping("/estudiantes")
	public List<EstudianteEntity> getAllEstudiantes() {
	  logger.info("EstudianteService - entra en getAllEstudiantes");
	  return estudianteBO.consultarTodosLosEstudiantes();

	}
	
	@PostMapping("/guardar")
	public EstudianteEntity save(@RequestBody EstudianteModel estudiante) {	
		logger.info("EstudianteService - entra en save: {}", estudiante.toString());
		return estudianteBO.guardarEstudiante(estudiante);
	};
	
	@PutMapping("/editar/{id}")
	public Optional<EstudianteEntity> update(@RequestBody EstudianteModel newEstudiante, @PathVariable Long id) {	
		logger.info("EstudianteService - entra en update: {}", newEstudiante.toString());
		
	    return estudianteBO.editarEstudiante(newEstudiante, id);
	};
	
	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id) {
		logger.info("EstudianteService - entra en delete: {}", id);
		estudianteBO.eliminarEstudiante(id);
	}
	
	@GetMapping("/bebidas")
	public String getBebidas() {
	  logger.info("EstudianteService - entra en getBebidas");
	  return estudianteBO.cantidadBebidas();

	}
	
	
}
