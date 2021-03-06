package com.epam.repository.author;

import com.epam.domain.author.Author;
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
@ContextConfiguration(locations = {"/persistenceContextTest.xml"})
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Before
    public void clearDB() {
        jdbcTemplate.execute("TRUNCATE TABLE Authors");
        jdbcTemplate.execute("ALTER TABLE Authors ALTER COLUMN ID RESTART WITH 0;");
    }

    @Test
    public void testCreateAuthorNoExceptions() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author(1, "Name", "Surname");
        authorRepository.create(author);
        int size = jdbcTemplate.queryForObject("select count(*) from Authors", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByAuthorSurname() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
        Author actualResult = authorRepository.findBySurname("Surname");
        Assert.assertEquals(author, actualResult);
    }

    @Test
    public void testFindAllAuthors() {
        Author author1 = new Author(0, "Name", "Surname");
        Author author2 = new Author(1, "Name", "Surname");
        authorRepository.create(author1);
        authorRepository.create(author2);
        List<Author> actualResult = authorRepository.findAll();
        Assert.assertEquals(2, actualResult.size());
    }

    @Test
    public void testUpdateAuthorWithoutFindNameAfter() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
        String newSurname = "AnotherSurname";
        author.setSurname(newSurname);
        int expectedResult = 1;
        int result = authorRepository.update(author);
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testUpdateAuthorWithFindNameAfter() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
        String newSurname = "AnotherSurname";
        author.setSurname(newSurname);
        authorRepository.update(author);
        Author actualResult = authorRepository.findBySurname(newSurname);
        Assert.assertEquals(author, actualResult);
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
        int expectedCountOfAuthors = 0;
        authorRepository.delete(author);
        int actualCountOfAuthors = jdbcTemplate.queryForObject("SELECT COUNT(*)"
                + " FROM Authors", Integer.class);
        Assert.assertEquals(expectedCountOfAuthors, actualCountOfAuthors);
    }

    @Test
    public void testFindAuthorByID() {
        Author author = new Author(0, "Name", "Surname");
        authorRepository.create(author);
        Author actualResult = authorRepository.find(author.getId());
        Assert.assertEquals(author, actualResult);
    }
}
