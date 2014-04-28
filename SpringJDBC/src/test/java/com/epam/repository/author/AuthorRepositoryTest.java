/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.repository.author;

import com.epam.domain.author.Author;
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
public class AuthorRepositoryTest {
    
    public AuthorRepositoryTest() {
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
     * Test of setJdbcTemplate method, of class AuthorRepository.
     */
    @Test
    public void testSetJdbcTemplate() {
        System.out.println("setJdbcTemplate");
        JdbcTemplate jdbcTemplate = null;
        AuthorRepository instance = new AuthorRepository();
        instance.setJdbcTemplate(jdbcTemplate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AuthorRepository.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Author author = null;
        AuthorRepository instance = new AuthorRepository();
        boolean expResult = false;
        boolean result = instance.create(author);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AuthorRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Author author = null;
        AuthorRepository instance = new AuthorRepository();
        int expResult = 0;
        int result = instance.update(author);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AuthorRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Author author = null;
        AuthorRepository instance = new AuthorRepository();
        boolean expResult = false;
        boolean result = instance.delete(author);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class AuthorRepository.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Integer id = null;
        AuthorRepository instance = new AuthorRepository();
        Author expResult = null;
        Author result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBySurname method, of class AuthorRepository.
     */
    @Test
    public void testFindBySurname() {
        System.out.println("findBySurname");
        String name = "";
        AuthorRepository instance = new AuthorRepository();
        Author expResult = null;
        Author result = instance.findBySurname(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class AuthorRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        AuthorRepository instance = new AuthorRepository();
        List<Author> expResult = null;
        List<Author> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
