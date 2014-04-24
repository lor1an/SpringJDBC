package com.epam;

import com.epam.model.author.ClassForInjection;
import com.epam.model.genre.Genre;
import com.epam.repository.genre.GenreRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/newSpringXMLConfig.xml");
        ClassForInjection cfi = (ClassForInjection) appContext.getBean("classForInjection");
        System.out.println(cfi.toString());
        cfi.printFullName();
        Genre g1 = new GenreRepository(appContext).find(0);
        System.out.println(g1);
        Genre g2 = new GenreRepository(appContext).find(1);
        System.out.println(g2);
        System.out.println(new GenreRepository(appContext).findAll());
        Genre g3 = new Genre("detective");
        new GenreRepository(appContext).create(g3);
        System.out.println(new GenreRepository(appContext).findAll());
        System.out.println(new GenreRepository(appContext).findByName("sci-fi"));
    }
}
