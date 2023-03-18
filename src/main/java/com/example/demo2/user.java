package com.example.demo2;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.PostActivate;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.persistence.*;
import model.Eintraege;
import model.Person;

import java.io.PrintWriter;
import java.util.List;

@Named(value = "user")
@RequestScoped
public class user {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    Person z ;





    @PostConstruct
    public void init() {
        if (em.find(Person.class, 1) == null) {


            Person p1 = new Person("John", "123");
            Person p2 = new Person("simon", "1234");
            Eintraege e1 = new Eintraege("Eintrag 1");

            p1.getEintrag().add(e1);
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        }


    }

    public user() {


    }

    String name;
    String svn;

    public String getSvn() {
        return svn;
    }

    public void setSvn(String svn) {
        this.svn = svn;
    }

    public user(String name, String svn) {
        this.name = name;
        this.svn = svn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String greet() {



        Query q = em.createQuery("select p from Person p where p.name = :val1 and p.svn = :val2");
        q.setParameter("val1", name);
        q.setParameter("val2", svn);
        if (q.getResultList().size() > 0) {
            z= em.find(Person.class, svn);
        } else {

            try
            {
                z=new Person(name, svn);
                em.getTransaction().begin();
                em.persist(z);
                em.getTransaction().commit();
            }
            catch (Exception e){
             return "Anmeldeforumular.xhtml";
            }
        }

        return "dbface.xhtml";

    }
}
