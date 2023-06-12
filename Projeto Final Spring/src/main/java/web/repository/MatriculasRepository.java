package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Matriculas;

@Repository

public interface MatriculasRepository extends CrudRepository<Matriculas, Long> {
}
