package com.example.demo2;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Person;

import java.io.PrintWriter;

@Named(value="user")
@RequestScoped
public class user {

    public user() {}

    String name;
    String password;

    public user(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String greet(){

        System.out.println("Hello " + name);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Person(name, password));
        em.getTransaction().commit();

        return "dbface.xhtml";
    }
}
