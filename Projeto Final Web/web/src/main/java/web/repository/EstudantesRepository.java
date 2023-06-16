package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Estudantes;
public interface EstudantesRepository extends CrudRepository<Estudantes, String>{
	
	Estudantes findById(long id);
}
