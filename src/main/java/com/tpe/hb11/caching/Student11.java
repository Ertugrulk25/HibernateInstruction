package com.tpe.hb11.caching;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int grade;

    public Student11(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student11() {
    }

    public Integer getId() {
        return id;
    }
    /*
        public void setId(Integer id) {
            this.id = id;
        }
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}