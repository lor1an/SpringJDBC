/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.book;

import com.epam.domain.author.Author;
import com.epam.domain.book.Book;
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
public class BookRepository implements CRUDRepository<Book> {

    private static final String ADD_BOOK = "INSERT INTO books(Title, Author, Genre, Stock) VALUES (?,?,?,?);";
    private static final String GET_ALL_BOOKS = "SELECT ID, Title, Author, Genre, Stock FROM books;";
    private static final String FIND_BOOK_BY_ID = "SELECT Title, Author, Genre, Stock FROM books WHERE ID=?;";
    private static final String FIND_BOOKS_BY_TITLE = "SELECT ID, Author,Genre, Stock FROM books WHERE Title=?;";
    private static final String UPDATE_BOOK = "UPDATE books SET Title=?, Author=?, Genre=?, Stock=? WHERE ID=?;";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE ID=?";

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book find(final Integer id) {
        return jdbcTemplate.queryForObject(FIND_BOOK_BY_ID,
                new Object[]{id},
                new RowMapper<Book>() {
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        int authorID = rs.getInt("Author");
                        int genreID = rs.getInt("Genre");
                        book.setId(id);
                        book.setGenre(new Genre(genreID, null));
                        book.setStock(rs.getInt("Stock"));
                        book.setAuthor(new Author(authorID, null, null));
                        book.setTitle(rs.getString("Title"));
                        return book;
                    }
                });
    }

    public List<Book> findAll() {
        List<Book> books = jdbcTemplate.query(
                GET_ALL_BOOKS,
                new RowMapper<Book>() {
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        int authorID = rs.getInt("Author");
                        int genreID = rs.getInt("Genre");
                        book.setId(rs.getInt("ID"));
                        book.setGenre(new Genre(genreID, null));
                        book.setStock(rs.getInt("Stock"));
                        book.setAuthor(new Author(authorID, null, null));
                        book.setTitle(rs.getString("Title"));
                        return book;
                    }
                });
        return books;
    }

    public boolean create(Book book) {
        int result = jdbcTemplate.update(ADD_BOOK,
                book.getTitle(),
                book.getAuthor().getId(), book.getGenre().getId(),
                book.getStock());
        return result > 0;
    }

    public Book findByTitle(final String title) {
        return jdbcTemplate.queryForObject(FIND_BOOKS_BY_TITLE,
                new Object[]{title},
                new RowMapper<Book>() {
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        int authorID = rs.getInt("Author");
                        int genreID = rs.getInt("Genre");
                        book.setId(rs.getInt("ID"));
                        book.setGenre(new Genre(genreID, null));
                        book.setStock(rs.getInt("Stock"));
                        book.setAuthor(new Author(authorID, null, null));
                        book.setTitle(title);
                        return book;
                    }
                });
    }

    public int update(Book book) {
        return jdbcTemplate.update(UPDATE_BOOK,
                book.getTitle(), book.getAuthor().getId(),
                book.getGenre().getId(), book.getStock(),
                book.getId());
    }

    public boolean delete(Book book) {
        int result = jdbcTemplate.update(
                DELETE_BOOK,
                book.getId());
        return result > 0;
    }
}
