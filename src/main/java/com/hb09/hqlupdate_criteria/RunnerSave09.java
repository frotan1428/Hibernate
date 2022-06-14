package com.hb09.hqlupdate_criteria;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave09 {

    public static void main(String[] args) {

        /*
        CRUD
        create(insert) session.save,session.persist, you can't make a insert with hql
        read(select): session.get,sql,hql and with criteria API
        update:
        delete: hql, sql, session.delete
        */



        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student09.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();


        Random r=new Random();
        for (int i =1; i<=50;i++){
            Student09 student=new Student09();
            student.setId(i);
            student.setName("Name"+i);
            student.setGrade(r.nextInt(100));
            session.save(student);
        }


        tx.commit();
        session.close();
        sf.close();
    }
}
