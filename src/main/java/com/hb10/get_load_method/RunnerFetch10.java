package com.hb10.get_load_method;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch10 {

    public static void main(String[] args) {


        Student10 student1=new Student10();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student10.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();


  //      student1= session.get(Student10.class,1001);
//        System.out.println(student1);

        //GET METHOD return null if it cant find any result
        //LOAD METHOD return ObjectNotFoundException if it cant find any result


        //GET METHOD  RETURN THE OBJECT
        //LOAD METHOD RETURN THE PROXY OBJECT


        //GET RUN EAGERLY
        //LOAD RUNS LAZILY


        //GET METHOD PERFORMANCE is SLOW -it always hits database
        //LOAD METHOD PERFORMANCE IS BETTER-it doesnt always hit the database a

       Student10 student2= session.load(Student10.class,1001);
       System.out.println(student2);



        tx.commit();
        session.close();
        sf.close();
    }
}
