package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {


    Configuration config=new Configuration().configure()//hibernate.cfg.xml
            .addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

    SessionFactory sessionFactory= config.buildSessionFactory();
    Session session=sessionFactory.openSession();


    // id 1001 olan öğrenci getir.
    Student04 student = session.get(Student04.class,1001);
        System.out.println(student);

        System.out.println("==========================");
        //i si 1001 olan öğrencinin günlüğü
        System.out.println(student.getDiary());

        //id 88 olan günlüğü getir

        Diary04 diary = session.get(Diary04.class,88);
        System.out.println(diary);

        System.out.println("==========================");
        // id si 88 olan günlüğün sahibinin bilgileri

        System.out.println(diary.getStudent());

        // id si 1003 olan öğrencinin günlüğünü getirin

        Student04 student2 = session.get(Student04.class,1003);
        System.out.println(student2.getDiary());

        // tüm öğrenciler ve varsa bu öğrencilerin günlükleri (öğrenci ismi ve günlük ismi)

        String hqlQuery = "SELECT s.name,d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id=d.student";
       List<Object[]> resultList= session.createQuery(hqlQuery).getResultList();

        for (Object[] s: resultList){
            System.out.println(Arrays.toString(s));

        }



    }
}
