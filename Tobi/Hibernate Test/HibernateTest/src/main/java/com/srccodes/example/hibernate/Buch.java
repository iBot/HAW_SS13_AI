package com.srccodes.example.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the contact database table.
 */
@Entity
@Table(name = "buch")
public class Buch {
    private String id;
    private String title;
    private List<Kurs> kurse;

    public Buch() {

    }

    public Buch(String id, String title) {
        this.id = id;
        this.title = title;
        this.kurse = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buch buch = (Buch) o;

        if (!id.equals(buch.id)) return false;

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

    public void addKurs(Kurs kurs) {
        this.kurse.add(kurs);
    }
}