package ar.com.cdt.javaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.cdt.javaback.entity.EstudianteEntity;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {

	EstudianteEntity findById(long id);
	List<EstudianteEntity> findAll();
}
