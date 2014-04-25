/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.repository;

import java.util.List;

/**
 *
 * @author Anatolii_Hlazkov
 * @param <T>
 */
public interface ModelRepository<T> {

    abstract boolean create(T entity);

    abstract int update(T entity);

    abstract boolean delete(T entity);

    abstract T find(Integer id);

    abstract List<T> findAll();

}
