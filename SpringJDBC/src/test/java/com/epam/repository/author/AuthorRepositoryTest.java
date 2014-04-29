/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.author;

import com.epam.domain.author.Author;
import com.epam.domain.genre.Genre;
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
@ContextConfiguration(locations = {"/persistenceContextTest.xml"})
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository ar;

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
        ar.create(author);
    }

    @Test
    public void testCreateAuthor() {
        Author author = new Author(1, "Name", "Surname");
        ar.create(author);
        int size = jdbcTemplate.queryForObject("select count(*) from Authors", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByAuthorSurname() {
        Author author = new Author(0, "Name", "Surname");
        ar.create(author);
        Author actualResult = ar.findBySurname("Surname");
        Assert.assertEquals(author, actualResult);
    }

    @Test
    public void testFindAllAuthors() {
        Author author1 = new Author(0, "Name", "Surname");
        Author author2 = new Author(1, "Name", "Surname");
        ar.create(author1);
        ar.create(author2);

        List<Author> actualResult = ar.findAll();
        Assert.assertEquals(2, actualResult.size());
    }
}
