package guru.springframework.matheus.spring6webapp.repositories;

import guru.springframework.matheus.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
