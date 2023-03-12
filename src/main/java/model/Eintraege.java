package model;

import jakarta.persistence.*;

@Entity
@Table(name = "eintraege")
public class Eintraege {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Eintraege_SEQ")
    @SequenceGenerator(name = "Eintraege_SEQ")
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String eintrag;

    public Eintraege() {
    }

    public Eintraege(String eintrag) {
        this.eintrag = eintrag;
    }

    public String getEintrag() {
        return eintrag;
    }

    public void setEintrag(String eintrag) {
        this.eintrag = eintrag;
    }
}