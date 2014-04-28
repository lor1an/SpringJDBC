package com.epam.service;

import com.epam.domain.author.Author;
import com.epam.domain.book.Book;
import com.epam.domain.genre.Genre;
import com.epam.repository.author.AuthorRepository;
import com.epam.repository.book.BookRepository;
import com.epam.repository.genre.GenreRepository;
import java.util.List;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class BookService extends Service {
    
    public BookService(AuthorRepository ar, BookRepository br, GenreRepository gr) {
        super(ar, br, gr);
    }
    
    public Book getBookById(int id) {
        Book book;
        book = br.find(id);
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        author = ar.find(author.getId());
        genre = gr.find(genre.getId());
        book.setAuthor(author);
        book.setGenre(genre);
        return book;
    }
    
    public Book getBookByTitle(String title) {
        Book book;
        book = br.findByTitle(title);
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        author = ar.find(author.getId());
        genre = gr.find(genre.getId());
        book.setAuthor(author);
        book.setGenre(genre);
        return book;
        
    }
    
    public List<Book> getAllBooks() {
        List<Book> books = br.findAll();
        for (Book book : books) {
            Author author = book.getAuthor();
            Genre genre = book.getGenre();
            author = ar.find(author.getId());
            genre = gr.find(genre.getId());
            book.setAuthor(author);
            book.setGenre(genre);
        }
        return books;
    }
    
    public void deleteBookByID(Book book) {
        br.delete(book);
    }
    
    public void addNewBook(Book book) {
        br.create(book);
    }
    
    public void editBookDetails(Book bookWithNewDetails) {
        br.update(bookWithNewDetails);
    }
    
}
