package pe.edu.upeu.Spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.Spring.entity.Asistencia;

@Repository
public interface AsistenciaRepository extends CrudRepository<Asistencia, Long> {

    @Query(value = "SELECT * FROM asistencia a WHERE a.sesion_id = ?1", nativeQuery = true)
    List<Asistencia> findBySesionId(Long id);

    @Query(value = "SELECT T.tema, A.estado, COUNT(estado) AS cant_estado FROM asistencia A INNER JOIN sesion S ON S.id = A.sesion_id INNER JOIN taller T ON T.id = S.taller_id GROUP BY A.estado, T.id", nativeQuery = true)
    List<?> getEstadosByTaller();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM asistencia a WHERE a.persona_id = ?1 AND a.sesion_id = ?2", nativeQuery = true)
    void deleteByPersonaSesion(Long idPersona, Long idSesion);
}