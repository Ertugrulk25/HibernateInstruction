package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//uygulamaya veritabanından data cekme işlemi saglar
public class RunnerFetch01 {
    public static void main(String[] args) {

        /*
        DB den data cekmek icin
                   Task id=1001 olan öğrenciyi tüm fieldlarıyla birlikte getirmek(fetch)istiyoruz
                   1)session methodu:get() en pratik ama kullanım alanı kısıtlı
                   2)SQL kodu oluşturarak DB'ce
                   3) HQL (Hibernate Query Language), Hibernate ORM tarafından sağlanan,
           nesne odaklı bir sorgulama dilidir. HQL, SQL'e benzer şekilde çalışır
           ancak doğrudan veritabanı tablolarıyla değil,
           Java sınıfları (entity'ler) ve onların özellikleriyle çalışır

         */
        Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf= config.buildSessionFactory();
        Session session=sf.openSession();
        System.out.println("-------------GET-------------------");

        //1) session icerisinde bulunan get methodunu id ile veri cekerken kullanabiliriz
        Student student= session.get(Student.class,1001);//student classında database'de karsılık gelen tablosuna git ve 1001 id'sine sahip degeri getir
        System.out.println(student);


        //2) SQL
        System.out.println("-------------SQL-------------------");
        String sql="select * from t_student where id=1002";
        Object [] student2= (Object[]) session.createSQLQuery(sql).uniqueResult();
        //uniqueResult(): sorgunun tek satır getirecegi durumlarda kullanılır
        //geriye bir satırdan birden fazla farklı data geldigi icin data tipleri farklı oldugu icin
        //Object[] icine alınır
        System.out.println(Arrays.toString(student2));
        System.out.println("-------------HQL-------------------");

        //3) HQL Javaca
        String hql="From Student where id=1003";
        Student student3=session.createQuery(hql, Student.class).uniqueResult();
        System.out.println(student3);

        //tüm kayıtları cekelim
//HQL
        List<Student> studentList =session.createQuery("From Student", Student.class).getResultList();
//birden fazla kayıt ya da veri donduruldugunde getResultList() kullanılır.
        System.out.println("Tüm Öğrenciler");
        for (Student s:studentList) {
            System.out.println(s);
        }
// sql ile tüm kayıtları çekelim

        //HQL ile grade değeri 98 olan öğrencilerin id ve name bilgilerini getirin.
        String hql2="select id,name from Student where grade=98";
       List<Object[]> resultList = session.createQuery(hql2).getResultList();
        for (Object[] a : resultList){
            System.out.println(Arrays.toString(a));

        }
        session.close();
        sf.close();

        //practice:HQL ile
    //1-ismi Ali Can olan öğrencileri getirelim
    //2-tüm öğrencilerin sadece isimlerini getirelim
    //SQL ile
    //1-tüm öğrencilerin sadece isimlerini getirelim




    }

}