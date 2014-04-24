/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository.author;

import com.epam.repository.DAOTemplate;
import com.epam.repository.ModelRepository;
import java.util.List;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class AuthorRepository extends DAOTemplate implements ModelRepository<AuthorRepository> {

    public AuthorRepository find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<AuthorRepository> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(AuthorRepository student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AuthorRepository findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
