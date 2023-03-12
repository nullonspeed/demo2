package model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Person_SEQ")
    @SequenceGenerator(name = "Person_SEQ")
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String name;
    String password;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    List<Eintraege> eintrag = new LinkedList<>();


    public List<Eintraege> getEintrag() {
        return eintrag;
    }

    public void setEintrag(List<Eintraege> eintrag) {
        this.eintrag = eintrag;
    }

    public Person() {
    }

    public Person(String name, String password) {
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

}