package com.tpe.basicannotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_employee")
public class Employee {

    @Id
    private Long id;

    private String name;

    private Double salary;

    @Transient//DB'de bu fieldda karşılık gelicek sütunun olmasını engeller
    private Double bonus;
    //bonusun tabloda yer almasına gerek yok

    //    @Lob ///Large Object : bu sütunun database'de büyük boyutlu dataları saklamasını saglar:resim,video,ses,cv vb.
//    private byte[] image;

}
