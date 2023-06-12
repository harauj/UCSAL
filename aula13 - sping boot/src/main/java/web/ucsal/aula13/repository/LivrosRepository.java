package web.ucsal.aula13.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.ucsal.aula13.model.Livros;

@Repository
public interface LivrosRepository extends CrudRepository<Livros, Long>{
}
