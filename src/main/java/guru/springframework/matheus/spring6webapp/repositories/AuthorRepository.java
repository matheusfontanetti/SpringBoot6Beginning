package guru.springframework.matheus.spring6webapp.repositories;

import guru.springframework.matheus.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
