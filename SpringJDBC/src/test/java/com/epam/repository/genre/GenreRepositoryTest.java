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
        jdbcTemplate.execute("ALTER TABLE Genres ALTER COLUMN ID RESTART WITH 0;");
    }

    @Test
    public void testCreateGenreNoExceptions() {
        Genre genre = new Genre(1, "QQQ");
        gr.create(genre);
    }

    @Test
    public void testCreateGenre() {
        Genre genre = new Genre(1, "QQQ");
        gr.create(genre);
        int size = jdbcTemplate.queryForObject("select count(*) from Genres", Integer.class);
        Assert.assertEquals(1, size);
    }

    @Test
    public void testFindByNameGenre() {
        Genre genre = new Genre(0, "QQQ");
        gr.create(genre);
        Genre actualResult = gr.findByName("QQQ");
        Assert.assertEquals(genre, actualResult);
    }

    @Test
    public void testFindAllGenres() {
        Genre genre1 = new Genre(0, "QQQ");
        Genre genre2 = new Genre(1, "QQQ");
        gr.create(genre1);
        gr.create(genre2);
        List<Genre> actualResult = gr.findAll();
        Assert.assertEquals(2, actualResult.size());
    }

    @Test
    public void testUpdateGenreWithoutFindNameAfter() {
        Genre genre = new Genre(0, "QQQ");
        gr.create(genre);
        genre.setName("WWW");
        int expecteResult = 1;
        int result = gr.update(genre);
        Assert.assertEquals(result, expecteResult);
    }

    @Test
    public void testUpdateGenreWithFindNameAfter() {
        Genre genre = new Genre(0, "QQQ");
        gr.create(genre);
        genre.setName("WWW");
        gr.update(genre);
        Genre actualResult = gr.findByName("WWW");
        Assert.assertEquals(genre, actualResult);
    }

    @Test
    public void testDeleteGenre() {
        Genre genre = new Genre(0, "QQQ");
        gr.create(genre);
        int expectedCountOfGenres = 0;
        gr.delete(genre);
        int actualCountOfGenres = jdbcTemplate.queryForObject("SELECT COUNT(*)"
                + " FROM Genres", Integer.class);
        Assert.assertEquals(expectedCountOfGenres, actualCountOfGenres);
    }

    @Test
    public void testFindByID() {
        Genre genre = new Genre(0, "QQQ");
        gr.create(genre);
        Genre actualResult = gr.find(genre.getId());
        Assert.assertEquals(genre, actualResult);
    }
}
