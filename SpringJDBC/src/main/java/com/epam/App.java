package com.epam;

import com.epam.domain.book.Book;
import com.epam.domain.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.genre.GenreRepository;
import com.epam.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/newSpringXMLConfig.xml");
        GenreRepository genreRepository = (GenreRepository) appContext.getBean("genreDAO");
        Genre g1 = genreRepository.find(0);
        Genre g2 = genreRepository.find(1);
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(genreRepository.findAll());
        Genre g3 = new Genre("Detective");
        genreRepository.create(g3);

        AuthorRepository authorRepository = (AuthorRepository) appContext.getBean("authorDAO");
        System.out.println(authorRepository.findAll());
        BookService bookService = (BookService) appContext.getBean("bookService");
        Book b1 = bookService.getBookById(0);
        Book b2 = bookService.getBookByTitle("Profession");
        System.out.println(b1);
        System.out.println(b2);
        b1.setTitle("Smith of Wootton Major");
        bookService.editBookDetails(b1);
        System.out.println(bookService.getAllBooks());
        bookService.deleteBookByID(b1);
        b2.setTitle("Foundation");
        bookService.addNewBook(b2);
        System.out.println(bookService.getAllBooks());
    }
}
