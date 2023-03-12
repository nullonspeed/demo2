package com.example.demo2;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Eintraege;
import model.Person;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

 //make an entity manager for default with 2 persons
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("simon", "Doe");
        Eintraege e1 = new Eintraege("Eintrag 1");
        p1.getEintrag().add(e1);
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        em.close();


        response.sendRedirect("Anmeldeformular.xhtml");


    }

    public void destroy() {
    }
}