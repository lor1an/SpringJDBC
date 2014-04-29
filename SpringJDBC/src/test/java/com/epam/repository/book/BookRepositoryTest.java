/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.book;

import com.epam.domain.author.Author;
import com.epam.domain.book.Book;
import com.epam.domain.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.genre.GenreRepository;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author lor1an
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/forBooksContext.xml"})
public class BookRepositoryTest {

    @Autowired
    private BookRepository br;

    @Autowired
    private AuthorRepository ar;

    @Autowired
    private GenreRepository gr;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Before
    public void clearDB() {
        jdbcTemplate.execute("ALTER TABLE Books DROP CONSTRAINT AuthorForeign");
        jdbcTemplate.execute("ALTER TABLE Books DROP CONSTRAINT GenreForeign");
        jdbcTemplate.execute("TRUNCATE TABLE Genres ");
        jdbcTemplate.execute("TRUNCATE TABLE Authors ");
        jdbcTemplate.execute("TRUNCATE TABLE Books");
        jdbcTemplate.execute("ALTER TABLE Books ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Authors ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Genres ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Books ADD CONSTRAINT AuthorForeign FOREIGN KEY "
                + "(Author) REFERENCES authors");
        jdbcTemplate.execute("ALTER TABLE Books ADD CONSTRAINT GenreForeign FOREIGN KEY "
                + "(Genre) REFERENCES genres");
        Genre genre = new Genre(0, "Name");
        Author author = new Author(0, "Name", "Surname");
        ar.create(author);
        gr.create(genre);
    }

    @Test
    public void testCreateBookNoExceptions() {
        Genre genre = new Genre(0, "Name");
        Author author = new Author(0, "Name", "Surname");
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
//        ar.create(author);
//        gr.create(genre);

        br.create(book);
    }

    @Test
    public void testCreateBook() {
        Genre genre = new Genre(0, "Name");
        Author author = new Author(0, "Name", "Surname");
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        int size = jdbcTemplate.queryForObject("select count(*) from Books", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByBookTitle() {
        Genre genre = new Genre(0, "Name");
        Author author = new Author(0, "Name", "Surname");
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        Book actualResult = br.findByTitle("Title");
        Author actualAuthor = ar.find(actualResult.getAuthor().getId());
        Genre actualGenre = gr.find(actualResult.getGenre().getId());
        actualResult.setAuthor(actualAuthor);
        actualResult.setGenre(actualGenre);
        Assert.assertEquals(book, actualResult);
    }

    @Test
    public void testFindAllBooks() {
        Genre genre = new Genre(0, "Name");
        Author author = new Author(0, "Name", "Surname");
        int id1 = 0;
        int id2 = 1;
        int stock = 0;
        Book book1 = new Book(id1, "Title", author, genre, stock);
        Book book2 = new Book(id2, "Title", author, genre, stock);
        br.create(book1);
        br.create(book2);

        List<Book> actualResult = br.findAll();
        Assert.assertEquals(2, actualResult.size());
    }

}
