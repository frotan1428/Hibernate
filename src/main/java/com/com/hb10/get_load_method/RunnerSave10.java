package com.hb10.get_load_method;
import com.hb09.hqlupdate_criteria.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Random;
public class RunnerSave10 {
    public static void main(String[] args) {
        Student10 student1=new Student10();
        Student10 student2=new Student10();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);
        student2.setId(1002);
        student2.setName("Walter White");
        student2.setGrade(11);
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student10.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
        //persist method return void
        //persist method doesn't guarantee that the identifier value will be assigned to the persistent instance immediately
        session.persist(student1);
        session.persist(student2);
        //save method return object
        //      session.save(student1);
        tx.commit();
        session.close();
        sf.close();
    }
}
