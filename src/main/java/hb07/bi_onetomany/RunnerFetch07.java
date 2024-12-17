package hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure()//hibernate.cfg.xml
                .addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);


        SessionFactory sessionFactory= config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction trs= session.beginTransaction();

        //id si 101 olan kitap

        Book07 book = session.get(Book07.class,101);
        System.out.println(book);
        System.out.println(book.getStudent());

        //id si 1003 olan öğrenci

        Student07 student = session.get(Student07.class,1003);
        System.out.println(student);

        //yukarıdaki öğrencinin kitap bilgileri
        System.out.println(student.getBookList());

        //Book07 tabllosundaki tüm kitapları silelim

        String hql = "DELETE FROM Book07";
        int deleteBooks = session.createQuery(hql).executeUpdate();
        System.out.println("Silinen kitap sayısı: "+ deleteBooks);
        System.out.println(student.getBookList());

        //Student07 tabllosundaki tüm kitapları silelim
        String hql1 = "DELETE FROM Student07";
        int deleteStudents = session.createQuery(hql1).executeUpdate();
        System.out.println("Silinen ÖÖğrenci: "+ deleteStudents);

        // ismi Sefiller olan kitabı hql ile silelim.

        String hql2 = "DELETE FROM Book07 b WHHERE b.name = 'Sefiller'";
        int numDeleteBook = session.createQuery(hql2).executeUpdate();
        System.out.println("Silinen satır sayısı: "+ numDeleteBook);

        //id si 1002 olan öğrenciyi silelim.
        String hql3 = "DELETE FROM Student07 s WHERE s.id = 1002";
      session.delete(hql3);
        // Not: Öğrenciyi silmek için ilk önce kitapları silmeliyiz.













        trs.commit();
        session.close();
        sessionFactory.close();
    }
}








