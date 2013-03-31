package com.srccodes.example.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.*;

/**
 * The persistent class for the contact database table.
 */
@Entity
@Table(name = "student")
public class Student {
    private String id;
    private String name;
//    private Notenkonto notenkonto;
    private Set<Kurs> kurse;

    public Student() {

    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.kurse = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Notenkonto getNotenkonto() {
//        return this.notenkonto;
//    }
//
//    public void setNotenkonto(Notenkonto notenkonto) {
//        this.notenkonto = notenkonto;
//    }

    public void addKurs(Kurs kurs) {
        this.kurse.add(kurs);
    }

}