/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.author;

import com.epam.model.author.Author;
import com.epam.model.genre.Genre;
import com.epam.repository.DAOTemplate;
import com.epam.repository.ModelRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class AuthorRepository extends DAOTemplate implements ModelRepository<Author> {

    private static final String FIND_AUTHOR_BY_ID = "select Name,Surname from authors where ID = ?;";
    private static final String FIND_AUTHORS_BY_NAME = "select ID,Surname from authors where Name = ?;";
    private static final String FIND_AUTHORS_BY_SURNAME = "select ID,Name from authors where Surname = ?;";
    private static final String FIND_AUTHORS_BY_ALL = "select ID from authors where Name = ? and Surname = ?;";
    private static final String UPDATE_AUTHOR = "update authors set Name = ?, Surname=? where ID=?;";
    private static final String ADD_AUTHOR = "insert into authors(Name, Surname) values (?,?);";
    private static final String GET_ALL_AUTHORS = "select id, name. surname from authors;";
    private static final String DELETE_AUTHOR = "delete from authors where id=?";

    public boolean create(Author author) {
        jdbcTemplate.update(
                ADD_AUTHOR,
                author.getName(),
                author.getSurname());
        return true;
    }

    public int update(Author entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Author entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Author findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
