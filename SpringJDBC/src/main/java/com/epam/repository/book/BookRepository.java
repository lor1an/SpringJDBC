/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.book;

import com.epam.model.book.Book;
import com.epam.repository.DAOTemplate;
import com.epam.repository.ModelRepository;
import java.util.List;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class BookRepository extends DAOTemplate implements ModelRepository<Book> {

    private static final String ADD_BOOK = "insert into books(Title, Author, Genre, Stock) values (?,?,?,?);";
    private static final String GET_ALL_BOOKS = "select Id, Title, Author, Genre, Stock from books;";
    private static final String FIND_BOOK_BY_ID = "select Title, Author, Genre, Stock from books where Id=?";
    private static final String FIND_BOOKS_BY_GENRE = "select ID, Title, Author,Stock from books where Genre=?;";
    private static final String FIND_BOOKS_BY_AUTHOR = "select ID, Title, Genre,Stock from books where Author=?;";
    private static final String FIND_BOOKS_BY_TITLE = "select ID, Author,Genre, Stock from books where Title=?;";
    private static final String UPDATE_BOOK_STOCK = "update books set Stock=? where ID =?;";
    private static final String UPDATE_BOOK = "update books set Title=?, Author=?, Genre=?, Stock=? where ID=?;";
    private static final String DELETE_BOOK = "delete from books where id=?";

    public Book find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Book> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Book findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
