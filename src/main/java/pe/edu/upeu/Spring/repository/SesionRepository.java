package pe.edu.upeu.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.Spring.entity.Sesion;

@Repository
public interface SesionRepository extends CrudRepository<Sesion, Long> {

    @Query(
  value = "SELECT * FROM sesion s WHERE s.taller_id = ?1", 
  nativeQuery = true)
    List<Sesion> findByTallerId(Long id);

}