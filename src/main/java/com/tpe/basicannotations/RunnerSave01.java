package com.tpe.basicannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Ali");
        student1.setSurname("Can");
        student1.setGrade(99);

        Student student2=new Student();
        student2.setId(1002);
        student2.setName("Veli");
        student2.setSurname("Han");
        student2.setGrade(98);

        Student student3=new Student();
        student3.setId(1003);
        student3.setName("Ayşe");
        student3.setSurname("Öz");
        student3.setGrade(97);

        //cfg dosyasinin ismini yazıyorduk eğer yazmasanız hata vermez çünkü
//default olarak icerisine "hibernate.cfg.xml" yazar
        Configuration config=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();

    //1- new Configuration = Hibernate için bir konfigurasyon nesnesi oluşturur.
    //2- configure("hibernate.cfg.xml"): Hibernate’in konfigürasyon dosyasını
        // (internee hibernate.cfg.xml) okur ve veritabanı bağlantı bilgilerini alır.
    //3- addAnnotatedClass(Student.class): Hibernate'e, veritabanı işlemleri için hangi Java sınıfını
        // (Entity) kullanacağını söyler. Burada Student sınıfı tablo ile ilişkilendirilmiştir.
    //4- SessionFactory sessionFactory = config.buildSessionFactory(); Hibernate'in veritabanına
        // bağlanmasını ve oturumlar oluşturmasını sağlar. Thread-safe bir nesnedir, yani birden
        // fazla oturumda güvenle kullanılabilir.
    //5- Session session = sessionFactory.openSession(); Veritabanı işlemleri yapmak için bir
        // oturum açar.Oturum sayesinde INSERT, UPDATE, DELETE gibi işlemleri yapabiliriz

        //----------------------------//
        //Bu Kodun Tamamladığı Görevler
        //Hibernate ayarlarını yükler (hibernate.cfg.xml).
        //Annotated sınıfları (örneğin Student) Hibernate'e tanıtır.
        //Veritabanına balancer ve işlemler için bir oturum oluşturur

        Transaction trs = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

    trs.commit();//
    session.close();
    sessionFactory.close();
    }
}

