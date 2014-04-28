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

    private static final String ADD_BOOK = "insert into books(Title, Author, Genre, Stock) values (?,?,?,?);";
    private static final String GET_ALL_BOOKS = "select Id, Title, Author, Genre, Stock from books;";
    private static final String FIND_BOOK_BY_ID
            = "select Title,a.ID aid, a.Name aname, a.Surname asur, g.ID gen_id, g.Name gen_name, Stock "
            + "from Books b inner join Genres g on b.Genre=g.ID "
            + "inner join Authors a on b.Author = a.ID "
            + "where Id=?";
    private static final String FIND_BOOKS_BY_GENRE = "select ID, Title, Author,Stock from books where Genre=?;";
    private static final String FIND_BOOKS_BY_AUTHOR = "select ID, Title, Genre,Stock from books where Author=?;";
    private static final String FIND_BOOKS_BY_TITLE = "select ID, Author,Genre, Stock from books where Title=?;";
    private static final String UPDATE_BOOK_STOCK = "update books set Stock=? where ID =?;";
    private static final String UPDATE_BOOK = "update books set Title=?, Author=?, Genre=?, Stock=? where ID=?;";
    private static final String DELETE_BOOK = "delete from books where id=?";

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
                        int aID = rs.getInt("aid");
                        String aname = rs.getString("aname");
                        String asurname = rs.getString("asur");
                        book.setId(id);
                        book.setGenre(new Genre(rs.getInt("gen_id"), rs.getString("gen_name")));
                        book.setStock(rs.getInt("Stock"));
                        book.setAuthor(new Author(aID, aname, asurname));
                        book.setTitle(rs.getString("Title"));
                        return book;
                    }
                });
    }

    public List<Book> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Book findByTitle(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
