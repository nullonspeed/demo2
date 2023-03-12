package com.example.demo2;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

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


        return "index.jsp";
    }
}
