package com.example.bookshop;

import com.example.bookshop.entities.Author;
import com.example.bookshop.entities.Book;
import com.example.bookshop.services.AuthorRepository;
import com.example.bookshop.services.BookRepository;
import com.example.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService,
                         BookRepository bookRepository,
                         AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository=bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       // this.seedService.seedAuthors();
       // this.seedService.seedCategories();
       // this.seedService.seedBooks();
       // this.booksAfter2000();
       // this.authorsWithOneBook1990();
        this.authorOrderByBookSize();
    }

    private void authorOrderByBookSize() {
        //List<Author> authors this.authorRepository.findAllOrderByBooksCount();
    }

    private void authorsWithOneBook1990() {
        LocalDate year1990=LocalDate.of(1990,1,1);
        List<Author> authors=this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirstName()));
    }

    private void booksAfter2000() {
        LocalDate yearAfter= LocalDate.of(2000,12,31);
        List<Book> books= bookRepository.findByReleaseDateAfter(yearAfter);

        books.forEach(b -> System.out.println(b.getTitle()));
    }

}
