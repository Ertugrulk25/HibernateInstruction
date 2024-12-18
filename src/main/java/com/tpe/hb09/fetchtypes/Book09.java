package com.tpe.hb09.fetchtypes;

import javax.persistence.*;

@Entity
public class Book09 {//Many
    @Id
    private Integer id;

    private String name;

    //bir kitap database ye kaydedildiği zaman
    // bu kitabın sahibi datasade yoksa kitabın sahibi de databaseye yakdedilir.

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)//FetcgType değiştirilebilir.
    private Student09 student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}