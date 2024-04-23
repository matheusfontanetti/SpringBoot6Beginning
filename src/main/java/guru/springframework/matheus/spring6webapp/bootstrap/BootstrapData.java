package guru.springframework.matheus.spring6webapp.bootstrap;

import guru.springframework.matheus.spring6webapp.domain.Author;
import guru.springframework.matheus.spring6webapp.domain.Book;
import guru.springframework.matheus.spring6webapp.domain.Publisher;
import guru.springframework.matheus.spring6webapp.repositories.AuthorRepository;
import guru.springframework.matheus.spring6webapp.repositories.BookRepository;
import guru.springframework.matheus.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Publisher pub1 = new Publisher();
        pub1.setPublisherName("Publisher");
        pub1.setAddress("Address 1");
        pub1.setCity("City 1");
        pub1.setZip("Zip 1");
        pub1.setState("State 1");

        Author ericSaved = authorRepository.save(eric);
        Book  bookSaved = bookRepository.save(ddd);
        Publisher publisherSave = publisherRepository.save(pub1);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEjB = new Book();
        noEjB.setTitle("J2EE Development without EJB");
        noEjB.setIsbn("54236987");

        Publisher pub2 = new Publisher();
        pub2.setPublisherName("Publisher 2");
        pub2.setAddress("Address 2");
        pub2.setCity("City 2");
        pub2.setZip("Zip 2");
        pub2.setState("State 2");
        Publisher publisherSaved = publisherRepository.save(pub1);
        bookSaved.setPublisher(publisherSaved);

        Author rodSaved = authorRepository.save(rod);
        Book  noEJBSaved = bookRepository.save(noEjB);
        noEJBSaved.setPublisher(publisherSaved);

        Publisher publisher2Saved = publisherRepository.save(pub2);

        ericSaved.getBooks().add(bookSaved);
        rodSaved.getBooks().add(noEJBSaved);
        bookSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(bookSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}
