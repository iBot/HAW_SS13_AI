package com.srccodes.example.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the contact database table.
 */
@Entity
@Table(name = "kurs")
public class Kurs {
    private String id;
    private String title;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "kurs_buch", joinColumns = { @JoinColumn(name = "kurs_id") }, inverseJoinColumns = { @JoinColumn(name = "buch_id") })
    public List<Buch> getBuchempfehlungen() {
        return buchempfehlungen;
    }

    public void setBuchempfehlungen(List<Buch> buchempfehlungen) {
        this.buchempfehlungen = buchempfehlungen;
    }

    private List<Buch> buchempfehlungen;

    public Kurs() {

    }

    public Kurs(String id, String title) {
        this.id = id;
        this.title = title;
        this.buchempfehlungen = new ArrayList<Buch>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kurs kurs = (Kurs) o;

        if (!id.equals(kurs.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addBuchempfehlung(Buch buch) {
        this.buchempfehlungen.add(buch);
    }
}