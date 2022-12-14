package pe.edu.upeu.Spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.Spring.entity.Taller;

@Repository
public interface TallerRepository extends CrudRepository<Taller, Long> {

}