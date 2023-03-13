package com.example.demo2;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Person;

import java.util.List;

@Named(value = "data")
@RequestScoped
public class databaseClass {

    private List<Person> db;

    public List<Person> getDb() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em= emf.createEntityManager();


        db =  em.createQuery("select p from Person p").getResultList();
        return db;
    }
}
