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
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    GenreRepository genreRepository;

    public BookService(AuthorRepository ar, BookRepository br, GenreRepository gr) {
        this.authorRepository = ar;
        this.bookRepository = br;
        this.genreRepository = gr;
    }

    public Book getBookById(int id) {
        Book book;
        book = bookRepository.find(id);
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        author = authorRepository.find(author.getId());
        genre = genreRepository.find(genre.getId());
        book.setAuthor(author);
        book.setGenre(genre);
        return book;
    }

    public Book getBookByTitle(String title) {
        Book book;
        book = bookRepository.findByTitle(title);
        Author author = book.getAuthor();
        Genre genre = book.getGenre();
        author = authorRepository.find(author.getId());
        genre = genreRepository.find(genre.getId());
        book.setAuthor(author);
        book.setGenre(genre);
        return book;

    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            Author author = book.getAuthor();
            Genre genre = book.getGenre();
            author = authorRepository.find(author.getId());
            genre = genreRepository.find(genre.getId());
            book.setAuthor(author);
            book.setGenre(genre);
        }
        return books;
    }

    public void deleteBookByID(Book book) {
        bookRepository.delete(book);
    }

    public void addNewBook(Book book) {
        bookRepository.create(book);
    }

    public void editBookDetails(Book bookWithNewDetails) {
        bookRepository.update(bookWithNewDetails);
    }

}
