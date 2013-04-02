package hibernateExample;

import javax.persistence.*;
import java.util.*;

/**
 * The persistent class for the contact database table.
 */
@Entity
@Table(name = "student",uniqueConstraints = {@UniqueConstraint(columnNames={"notenkonto_id"})})
public class Student implements Persistable {
    private String id;
    private String name;
    private Notenkonto notenkonto;
    private Set<Kurs> kurse;

    public Student() {

    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.kurse = new HashSet<Kurs>();
    }

    @OneToMany
    @JoinTable(name = "student_kurs", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "kurs_id")}, uniqueConstraints = {@UniqueConstraint(columnNames={"kurs_id"})})
    public Set<Kurs> getKurse() {
        return kurse;
    }

    public void setKurse(Set<Kurs> kurse) {
        this.kurse = kurse;
    }

    public void addKurs(Kurs kurs) {
        this.kurse.add(kurs);
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

    @OneToOne(cascade = CascadeType.ALL)

    public Notenkonto getNotenkonto() {
        return this.notenkonto;
    }

    public void setNotenkonto(Notenkonto notenkonto) {
        this.notenkonto = notenkonto;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}