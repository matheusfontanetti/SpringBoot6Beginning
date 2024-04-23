package guru.springframework.matheus.spring6webapp.services;

import guru.springframework.matheus.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
