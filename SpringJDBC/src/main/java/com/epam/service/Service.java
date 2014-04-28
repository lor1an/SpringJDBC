/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.service;

import com.epam.repository.author.AuthorRepository;
import com.epam.repository.book.BookRepository;
import com.epam.repository.genre.GenreRepository;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class Service {

    AuthorRepository ar;
    BookRepository br;
    GenreRepository gr;

    public Service(AuthorRepository ar, BookRepository br, GenreRepository gr) {
        this.ar = ar;
        this.br = br;
        this.gr = gr;
    }
    
}
