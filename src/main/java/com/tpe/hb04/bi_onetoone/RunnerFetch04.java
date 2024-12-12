package com.tpe.hb04.bi_onetoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
    public static void main(String[] args) {


    Configuration config=new Configuration().configure()//hibernate.cfg.xml
            .addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

    SessionFactory sessionFactory= config.buildSessionFactory();
    Session session=sessionFactory.openSession();


    // id 1001 olan öğrenci getir.
    Student04 student = session.get(Student04.class,1001);
        System.out.println(student);

        System.out.println(student.getDiary());






    }
}
