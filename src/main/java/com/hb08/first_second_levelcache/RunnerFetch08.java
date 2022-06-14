package com.hb08.first_second_levelcache;

import com.hb07.fetchtypes.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        //First lavel cache is related with the same session
        //even if you are in the same session, If you wnat to get students that have difference id, Hibernate create two queries
        //because first level cache runs with same object in the same session


        Student08 student1=new Student08();
        Student08 student2=new Student08();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student08.class);
        SessionFactory sf= con.buildSessionFactory();


        //session1
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
        student1= session.get(Student08.class,1);
        System.out.println(student1);
        System.out.println("------------------------------------");
//        student1= session.get(Student08.class,1);

//        student1= session.get(Student08.class,2);
//        System.out.println(student1);
        tx.commit();
        session.close();
        //close session1

        //session2
        Session session2= sf.openSession();
        Transaction tx2= session2.beginTransaction();

        student1= session2.get(Student08.class,1);
        System.out.println(student1);

        tx2.commit();
        session2.close();


        sf.close();
    }
}
