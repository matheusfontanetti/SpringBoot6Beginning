package guru.springframework.matheus.spring6webapp.repositories;

import guru.springframework.matheus.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
