package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
public class Student05 {
    @Id
    private Integer id;

    private String name;

    private int grade;

    private LocalDateTime creatOn; // üniversiteye kayıt tarihi

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;


    @PrePersist
    public void orePersist() {
        creatOn = LocalDateTime.now();
    }

    public Student05(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student05() {
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreatOn() {
        return creatOn;
    }
//
//    public void setCreatOn(LocalDateTime creatOn) {
//        this.creatOn = creatOn;
//    }

    public University getUniversty() {
        return university;
    }

    public void setUniversty(University universty) {
        this.university = universty;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", creatOn=" + creatOn +
                ", universty=" + university +
                '}';
    }

    public void setUniversity(University university) {
    }

    public boolean getUniversity() {
        return false;
    }

}
