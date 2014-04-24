/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.genre;

import com.epam.model.genre.Genre;
import com.epam.repository.DAOTemplate;
import com.epam.repository.ModelRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class GenreRepository extends DAOTemplate implements ModelRepository<Genre> {

    private static final String FIND_GENRE_BY_ID = "select name from Genres where id = ?";
    private static final String FIND_GENRE_BY_NAME = "select ID from genres where Name = ?;";
    private static final String ADD_GENRE = "insert into genres (Name) values (?);";
    private static final String UPDATE_GENRE = "update genres set name=? where id=?;";
    private static final String GET_ALL_GENRES = "select ID, Name from genres;";
    private static final String DELETE_GENRE = "delete from genres where id=?";

    public GenreRepository() {

    }

    public GenreRepository(ApplicationContext appContext) {
        jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");
    }

    public boolean create(Genre genre) {
        jdbcTemplate.update(
                ADD_GENRE,
                genre.getName());
        return true;
    }

    public int update(Genre entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Genre entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Genre find(final Integer id) {
        return jdbcTemplate.queryForObject(FIND_GENRE_BY_ID,
                new Object[]{id},
                new RowMapper<Genre>() {
                    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Genre genre = new Genre();
                        genre.setId(id);
                        genre.setName(rs.getString("name"));
                        return genre;
                    }
                });
    }

    public Genre findByName(final String name) {
        return jdbcTemplate.queryForObject(FIND_GENRE_BY_NAME,
                new Object[]{name},
                new RowMapper<Genre>() {
                    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Genre genre = new Genre();
                        genre.setId(rs.getInt("ID"));
                        genre.setName(name);
                        return genre;
                    }
                });
    }

    public List<Genre> findAll() {
        List<Genre> genres = jdbcTemplate.query(
                GET_ALL_GENRES,
                new RowMapper<Genre>() {
                    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Genre genre = new Genre();
                        genre.setId(rs.getInt("ID"));
                        genre.setName(rs.getString("name"));
                        return genre;
                    }
                });
        return genres;
    }

}
