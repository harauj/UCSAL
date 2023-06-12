package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Disciplinas;

@Repository
public interface DisciplinasRepository extends CrudRepository<Disciplinas, Long> {

}