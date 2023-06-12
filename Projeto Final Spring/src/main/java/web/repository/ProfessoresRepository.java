package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Professores;

@Repository

public interface ProfessoresRepository extends CrudRepository<Professores, Long> {

}