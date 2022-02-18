package ar.com.cdt.javaback.bo.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.cdt.javaback.bo.EstudianteBO;
import ar.com.cdt.javaback.entity.EstudianteEntity;
import ar.com.cdt.javaback.models.EstudianteModel;
import ar.com.cdt.javaback.repository.EstudianteRepository;

@Component
public class EstudianteBOImpl implements EstudianteBO{
	
	int bebida;
	double pack;
	
	public static final Logger logger = LoggerFactory.getLogger(EstudianteBOImpl.class);
	
	@Autowired
	EstudianteRepository repository;
	
	@Override
	public Optional<EstudianteEntity> consultarPorEstudiante(Long id) {
		return repository.findById(id);
	}
	
	@Override
    public List<EstudianteEntity> consultarTodosLosEstudiantes(){
        return repository.findAll();
    }

	@Override
	public EstudianteEntity guardarEstudiante(EstudianteModel estudiante) {
		logger.info("entra en guardarEstudiante : {}", estudiante.toString());

		EstudianteEntity entity = new EstudianteEntity();
		entity.setNombre(estudiante.nombre);
		entity.setApellido(estudiante.apellido);
		entity.setDNI(estudiante.DNI);
		entity.setEdad(estudiante.edad);
		
		
		return repository.save(entity);
	}

	@Override
	public Optional<EstudianteEntity> editarEstudiante(EstudianteModel newEstudiante, Long id) {
		logger.info("EstudianteBOImpl - entra en editarEstudiante : {}", newEstudiante.toString());

		return repository.findById(id)
			.map(estudiante -> {
				estudiante.setNombre(newEstudiante.getNombre());
				estudiante.setApellido(newEstudiante.getApellido());
				estudiante.setDNI(newEstudiante.getDNI());
				estudiante.setEdad(newEstudiante.getEdad());
			    return repository.save(estudiante);
			 });
	
	}
	
	@Override
	public void eliminarEstudiante(Long id) {
		
		 repository.deleteById(id);
	}
	
	@Override
    public String cantidadBebidas(){
        bebida= 0;

           repository.findAll().forEach(estudiante -> {

	            if ((estudiante.edad >= 20) && (estudiante.edad <= 30)) {
	            	
	            	bebida += 3;
	            }
	            if ((estudiante.edad >= 31) && (estudiante.edad <= 45)) {
	            	bebida += 2;
	            }
	            if ((estudiante.edad >= 45)) {
	            	
	            	bebida += 1;
	            }
           });

           if(bebida >= 6) {
        	   
               pack = bebida / 6;

               if(pack % 2 != 0) {
            	             	   
                   pack = (int)pack + 1;
               }
           }else {
        	   return "Se debe comprar 1 pack de bebida es mejor que sobre :D";
           }

            return "Se deben comprar " + (int)pack + " packs de bebidas.";
    }
}
