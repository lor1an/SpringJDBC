/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.author;

import com.epam.domain.author.Author;
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
public class AuthorRepository implements CRUDRepository<Author> {

    private static final String FIND_AUTHOR_BY_ID = "SELECT Name,Surname FROM Authors WHERE ID = ?;";
    private static final String FIND_AUTHORS_BY_SURNAME = "SELECT ID,Name FROM Authors WHERE Surname = ?;";
    private static final String UPDATE_AUTHOR = "UPDATE Authors SET Name = ?, Surname=? WHERE ID=?;";
    private static final String ADD_AUTHOR = "INSERT INTO Authors(Name, Surname) VALUES (?,?);";
    private static final String GET_ALL_AUTHORS = "SELECT ID, Name, Surname FROM Authors;";
    private static final String DELETE_AUTHOR = "DELETE FROM Authors WHERE ID=?";

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean create(Author author) {
        int result = jdbcTemplate.update(
                ADD_AUTHOR,
                author.getName(),
                author.getSurname());
        return result > 0;
    }

    public int update(Author author) {
        return jdbcTemplate.update(
                UPDATE_AUTHOR,
                author.getName(),
                author.getSurname(),
                author.getId());
    }

    public boolean delete(Author author) {
        int result = jdbcTemplate.update(
                DELETE_AUTHOR,
                author.getId());
        return result > 0;
    }

    public Author find(final Integer id) {
        return jdbcTemplate.queryForObject(FIND_AUTHOR_BY_ID,
                new Object[]{id},
                new RowMapper<Author>() {
                    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Author author = new Author();
                        author.setId(id);
                        author.setName(rs.getString("Name"));
                        author.setSurname(rs.getString("Surname"));
                        return author;
                    }
                });
    }

    public Author findBySurname(final String surname) {
        return jdbcTemplate.queryForObject(FIND_AUTHORS_BY_SURNAME,
                new Object[]{surname},
                new RowMapper<Author>() {
                    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Author author = new Author();
                        author.setId(rs.getInt("ID"));
                        author.setName(rs.getString("Name"));
                        author.setSurname(surname);
                        return author;
                    }
                });
    }

    public List<Author> findAll() {
        return jdbcTemplate.query(GET_ALL_AUTHORS,
                new RowMapper<Author>() {
                    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Author author = new Author();
                        author.setId(rs.getInt("ID"));
                        author.setName(rs.getString("Name"));
                        author.setSurname(rs.getString("Surname"));
                        return author;
                    }
                });
    }

}
