package guru.springframework.matheus.spring6webapp.services;

import guru.springframework.matheus.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
