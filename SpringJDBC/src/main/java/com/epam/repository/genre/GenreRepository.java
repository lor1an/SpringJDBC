/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.genre;

import com.epam.domain.genre.Genre;
import com.epam.repository.CRUDRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class GenreRepository implements CRUDRepository<Genre> {

    private static final String FIND_GENRE_BY_ID = "SELECT name FROM Genres WHERE id = ?";
    private static final String FIND_GENRE_BY_NAME = "SELECT ID FROM Genres WHERE Name = ?;";
    private static final String ADD_GENRE = "INSERT INTO Genres (Name) VALUES (?);";
    private static final String UPDATE_GENRE = "UPDATE Genres SET Name=? WHERE ID=?;";
    private static final String GET_ALL_GENRES = "SELECT ID, Name FROM Genres;";
    private static final String DELETE_GENRE = "DELETE FROM Genres WHERE ID=?";

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean create(Genre genre) {
        int result = jdbcTemplate.update(
                ADD_GENRE,
                genre.getName());
        return result > 0;
    }

    public int update(Genre genre) {
        return jdbcTemplate.update(
                UPDATE_GENRE,
                genre.getName(),
                genre.getId());
    }

    public boolean delete(Genre genre) {
        int result = jdbcTemplate.update(
                DELETE_GENRE,
                genre.getId());
        return result > 0;
    }

    public Genre find(final Integer id) {
        return jdbcTemplate.queryForObject(FIND_GENRE_BY_ID,
                new Object[]{id},
                new RowMapper<Genre>() {
                    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Genre genre = new Genre();
                        genre.setId(id);
                        genre.setName(rs.getString("Name"));
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
                        genre.setName(rs.getString("Name"));
                        return genre;
                    }
                });
        return genres;
    }

}
