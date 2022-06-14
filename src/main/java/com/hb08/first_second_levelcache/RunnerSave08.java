package com.hb08.first_second_levelcache;

import com.hb07.fetchtypes.Book07;
import com.hb07.fetchtypes.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student1=new Student08();
        Student08 student2=new Student08();

        //student1.setName("John Coffee");
        student1.setGrade(80);

        student2.setName("Walter White");
        student2.setGrade(90);


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        sf.close();


    }
}
