package com.epam.repository.book;

import com.epam.domain.author.Author;
import com.epam.domain.book.Book;
import com.epam.domain.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.genre.GenreRepository;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
    public BookRepository br;

    @Autowired
    public AuthorRepository ar;

    @Autowired
    public GenreRepository gr;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public final Genre genre = new Genre(0, "Name");
    public final Author author = new Author(0, "Name", "Surname");

    @Before
    public void clearDB() {
        jdbcTemplate.execute("TRUNCATE SCHEMA PUBLIC AND COMMIT");
        jdbcTemplate.execute("ALTER TABLE Books ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Authors ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Genres ALTER COLUMN ID RESTART WITH 0;");
        gr.create(genre);
        ar.create(author);
    }

    @Test
    public void testCreateBookNoExceptions() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
    }

    @Test
    public void testCreateBook() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        int size = jdbcTemplate.queryForObject("select count(*) from Books", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByBookTitle() {
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

    @Test
    public void testUpdateBookWithoutFindByTitleAfter() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        String newTitle = "AnotherTitle";
        book.setTitle(newTitle);
        int result = 1;
        int expectedResult = br.update(book);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testUpdateBookWithFindByTitleAfter() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        String newTitle = "AnotherTitle";
        book.setTitle(newTitle);
        br.update(book);
        Book actualResult = br.findByTitle(newTitle);
        Author actualAuthor = ar.find(actualResult.getAuthor().getId());
        Genre actualGenre = gr.find(actualResult.getGenre().getId());
        actualResult.setAuthor(actualAuthor);
        actualResult.setGenre(actualGenre);
        Assert.assertEquals(book, actualResult);
    }

    @Test
    public void testDeleteBook() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        int expectedCountOfBooks = 0;
        br.delete(book);
        int actualCountOfBooks = jdbcTemplate.queryForObject("SELECT COUNT(*)"
                + " FROM Books", Integer.class);
        Assert.assertEquals(expectedCountOfBooks, actualCountOfBooks);
    }

    @Test
    public void testFindBookByID() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        br.create(book);
        Book actualResult = br.find(book.getId());
        Author actualAuthor = ar.find(actualResult.getAuthor().getId());
        Genre actualGenre = gr.find(actualResult.getGenre().getId());
        actualResult.setAuthor(actualAuthor);
        actualResult.setGenre(actualGenre);
        Assert.assertEquals(book, actualResult);
    }

}
