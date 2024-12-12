package com.tpe.hb02.embeddable;

import com.tpe.basicannotations.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();

        //id 1002 olan öğrenciyi geitr.

        Student02 student = session.get(Student02.class,1002);
        System.out.println(student);
        //adres
        System.out.println(student.getAddress());
    }
}
