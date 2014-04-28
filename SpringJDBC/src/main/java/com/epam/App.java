package com.epam;

import com.epam.domain.book.Book;
import com.epam.domain.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.book.BookRepository;
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
        GenreRepository gr = (GenreRepository) appContext.getBean("genreDAO");
        Genre g1 = gr.find(0);
        Genre g2 = gr.find(1);
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(gr.findAll());
        Genre g3 = new Genre("Detective");
        gr.create(g3);
//        g3 = gr.findByName(g3.getName());
//        System.out.println(gr.findAll());
//        gr.delete(g3);
//        System.out.println(gr.findAll());
//        g2.setName("Comics");
//        gr.update(g2);
//        System.out.println(gr.findAll());

        AuthorRepository ar = (AuthorRepository) appContext.getBean("authorDAO");
        System.out.println(ar.findAll());
        BookRepository br = (BookRepository) appContext.getBean("bookDAO");
        BookService bs = new BookService(ar, br, gr);
        Book b1 = bs.getBookById(0);
        Book b2 = bs.getBookByTitle("Profession");
        System.out.println(b1);
        System.out.println(b2);
        b1.setTitle("Smith of Wootton Major");
        bs.editBookDetails(b1);
        System.out.println(bs.getAllBooks());
        bs.deleteBookByID(b1);
        b2.setTitle("Foundation");
        bs.addNewBook(b2);
        System.out.println(bs.getAllBooks());
    }
}
