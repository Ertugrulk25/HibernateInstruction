package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Entity
public class Student02 {
@Id
private Integer id;
@Column(name = "std_name",nullable = false,unique = true,length = 50)
private String name;

private int grade;

//private String street;
//private String city;
//private String country;
//private String zipcode;

    @Embedded
private Address address;

    public Student02(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student02() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +

                '}';
    }
}
