package com.epam;

import com.epam.model.author.ClassForInjection;
import com.epam.model.book.Book;
import com.epam.model.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.book.BookRepository;
import com.epam.repository.genre.GenreRepository;
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
        Book b1 = br.find(0);
        System.out.println(b1);
    }
}
