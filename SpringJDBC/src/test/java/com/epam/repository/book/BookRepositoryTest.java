/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.repository.book;

import com.epam.domain.book.Book;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lor1an
 */
public class BookRepositoryTest {
    
    public BookRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class BookRepository.
     */
    @Test
    public void testSetJdbcTemplate() {
        System.out.println("setJdbcTemplate");
        JdbcTemplate jdbcTemplate = null;
        BookRepository instance = new BookRepository();
        instance.setJdbcTemplate(jdbcTemplate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class BookRepository.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Integer id = null;
        BookRepository instance = new BookRepository();
        Book expResult = null;
        Book result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class BookRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        BookRepository instance = new BookRepository();
        List<Book> expResult = null;
        List<Book> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BookRepository.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Book book = null;
        BookRepository instance = new BookRepository();
        boolean expResult = false;
        boolean result = instance.create(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByTitle method, of class BookRepository.
     */
    @Test
    public void testFindByTitle() {
        System.out.println("findByTitle");
        String title = "";
        BookRepository instance = new BookRepository();
        Book expResult = null;
        Book result = instance.findByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BookRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Book book = null;
        BookRepository instance = new BookRepository();
        int expResult = 0;
        int result = instance.update(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BookRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Book book = null;
        BookRepository instance = new BookRepository();
        boolean expResult = false;
        boolean result = instance.delete(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
