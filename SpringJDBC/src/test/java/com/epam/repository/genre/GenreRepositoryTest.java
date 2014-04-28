/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.genre;

import com.epam.domain.genre.Genre;
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
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository gr;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Before
    public void clearDB() {
        jdbcTemplate.execute("TRUNCATE TABLE Genres");
    }

    @Test
    public void testCreateGenretNoExceptions() {
        Genre genre = new Genre(1, "QQQ");
        gr.create(genre);
    }

    @Test
    public void testCreateStudent() {
        Genre genre = new Genre(1, "QQQ");
        gr.create(genre);

        int size = jdbcTemplate.queryForObject("select count(*) from Genres", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByNameGenre() {
        clearDB();
        Genre genre = new Genre(1, "QQQ");
        gr.create(genre);

        Genre actualResult = gr.findByName("QQQ");
        Assert.assertEquals(genre, actualResult);
    }

    @Test
    public void testFindAllStudents() {
        Genre genre1 = new Genre(0, "QQQ");
        Genre genre2 = new Genre(1, "QQQ");
        gr.create(genre1);
        gr.create(genre2);

        List<Genre> actualResult = gr.findAll();
        Assert.assertEquals(2, actualResult.size());
    }
}