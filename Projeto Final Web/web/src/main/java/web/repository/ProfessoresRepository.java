package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Professores;
public interface ProfessoresRepository extends CrudRepository<Professores, String>{
	
	Professores findById(long id);
}
