package ar.com.cdt.javaback.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import ar.com.cdt.javaback.entity.EstudianteEntity;
import ar.com.cdt.javaback.models.EstudianteModel;

public interface EstudianteBO {

	public EstudianteEntity guardarEstudiante(EstudianteModel estudiante);
	
	public Optional<EstudianteEntity> editarEstudiante(EstudianteModel newEstudiante, Long id);
	
	public void eliminarEstudiante(Long id);
	
	public Optional<EstudianteEntity> consultarPorEstudiante(Long id);
		
	public List<EstudianteEntity> consultarTodosLosEstudiantes();
	
	public String cantidadBebidas();
	
}
