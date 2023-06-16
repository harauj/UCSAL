package web.repository;
import org.springframework.data.repository.CrudRepository;
import web.model.Disciplinas;
public interface DisciplinasRepository extends CrudRepository<Disciplinas, String>{
	
	Disciplinas findById(long id);
}
