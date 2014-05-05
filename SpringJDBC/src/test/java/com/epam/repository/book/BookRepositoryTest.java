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
    public BookRepository bookRepository;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public final Genre genre = new Genre(0, "Name");
    public final Author author = new Author(0, "Name", "Surname");
    public final Genre genre0 = new Genre(0, null);
    public final Author author0 = new Author(0, null, null);

    @Before
    public void clearDB() {
        jdbcTemplate.execute("TRUNCATE SCHEMA PUBLIC AND COMMIT");
        jdbcTemplate.execute("ALTER TABLE Books ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Authors ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("ALTER TABLE Genres ALTER COLUMN ID RESTART WITH 0;");
        jdbcTemplate.execute("INSERT INTO authors (Name, Surname) values ('Name', 'Surname');");
        jdbcTemplate.execute("INSERT INTO genres (Name) values ('Name'); ");
    }

    @Test
    public void testCreateBookNoExceptions() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        bookRepository.create(book);
    }

    @Test
    public void testCreateBook() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        bookRepository.create(book);
        int size = jdbcTemplate.queryForObject("select count(*) from Books", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByBookTitle() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author0, genre0, stock);
        bookRepository.create(book);
        Book actualResult = bookRepository.findByTitle("Title");;
        Assert.assertEquals(book, actualResult);
    }

    @Test
    public void testFindAllBooks() {
        int id1 = 0;
        int id2 = 1;
        int stock = 0;
        Book book1 = new Book(id1, "Title", author, genre, stock);
        Book book2 = new Book(id2, "Title", author, genre, stock);
        bookRepository.create(book1);
        bookRepository.create(book2);
        List<Book> actualResult = bookRepository.findAll();
        Assert.assertEquals(2, actualResult.size());
    }

    @Test
    public void testUpdateBookWithoutFindByTitleAfter() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        bookRepository.create(book);
        String newTitle = "AnotherTitle";
        book.setTitle(newTitle);
        int result = 1;
        int expectedResult = bookRepository.update(book);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testUpdateBookWithFindByTitleAfter() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author0, genre0, stock);
        bookRepository.create(book);
        String newTitle = "AnotherTitle";
        book.setTitle(newTitle);
        bookRepository.update(book);
        Book actualResult = bookRepository.findByTitle(newTitle);
        Assert.assertEquals(book, actualResult);
    }

    @Test
    public void testDeleteBook() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author, genre, stock);
        bookRepository.create(book);
        int expectedCountOfBooks = 0;
        bookRepository.delete(book);
        int actualCountOfBooks = jdbcTemplate.queryForObject("SELECT COUNT(*)"
                + " FROM Books", Integer.class);
        Assert.assertEquals(expectedCountOfBooks, actualCountOfBooks);
    }

    @Test
    public void testFindBookByID() {
        int id = 0;
        int stock = 0;
        Book book = new Book(id, "Title", author0, genre0, stock);
        bookRepository.create(book);
        Book actualResult = bookRepository.find(book.getId());
        Assert.assertEquals(book, actualResult);
    }

}
