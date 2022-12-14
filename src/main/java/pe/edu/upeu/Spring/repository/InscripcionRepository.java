package pe.edu.upeu.Spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.Spring.entity.Inscripcion;

@Repository
public interface InscripcionRepository extends CrudRepository<Inscripcion, Long> {

    @Query(value = "SELECT * FROM inscripcion i WHERE i.persona_id = ?1 AND i.taller_id = ?2", nativeQuery = true)
    List<Inscripcion> isInscrito(Long idPersona, Long idTaller);

    @Query(value = "SELECT T.tema, COUNT(persona_id) AS cantidad FROM inscripcion I INNER JOIN persona P ON P.id = I.persona_id INNER JOIN taller T ON T.id = I.taller_id GROUP BY taller_id", nativeQuery = true)
    List<?> getCantidad();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM inscripcion i WHERE i.persona_id = ?1 AND i.taller_id = ?2", nativeQuery = true)
    void deleteInscripcion(Long idPersona, Long idTaller);

}