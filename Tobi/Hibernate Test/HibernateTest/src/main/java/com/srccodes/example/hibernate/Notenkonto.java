package com.srccodes.example.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the contact database table.
 */
@Entity
@Table(name = "notenkonto")
public class Notenkonto implements Persistable {
    private String id;
    private Double gesamtnote;

    public Notenkonto() {

    }

    public Notenkonto(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Notenkonto{" +
                "id='" + id + '\'' +
                ", gesamtnote=" + gesamtnote +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notenkonto that = (Notenkonto) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Double getGesamtnote() {
        return gesamtnote;
    }

    public void setGesamtnote(Double gesamtnote) {
        this.gesamtnote = gesamtnote;
    }

    @Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}