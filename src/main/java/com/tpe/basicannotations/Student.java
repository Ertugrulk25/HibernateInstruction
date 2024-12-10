package com.tpe.basicannotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Hedef:
//dataları persist etmek icin bu classa karsılık bir tablo gereklidir
//tablonun sutunları : id,name,surname,grade
//create table student(id int ,name varchar()...);
//hibernate(ORM) bizim icin bu hedefi otomatik olarak yapar.

@Entity //Bu sınıfın Databasede bir tabloya karşılık gelmesini sağlar,tablo adı: student
@Table(name= "t_student")//tablomuzun istedigimiz ismi verilmesini saglar
//biz burada pojo classları direkt olarak buyuk harfle
public class Student {
    //DB SQL'CE t_student isimlendirilir

    @Id //Id sütununun PK olmasını sağlar.
    private Integer id;//Integer'in default degeri ise=null idi; // int'in default degeri = 0;

    @Column(name= "std_name",unique = false,nullable = false,length = 50)// default: =255 varchar
    private String name;

    @Column(name = "std_surname",unique = true,nullable = false,length = 30)
    private String surname;

    private Integer grade;

    public Student(Integer id, String name, String surname, Integer grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public Student() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                '}';
    }
}
