package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Estudantes;

import java.util.List;

@Repository
public interface EstudantesRepository extends CrudRepository<Estudantes, Long> {
}
