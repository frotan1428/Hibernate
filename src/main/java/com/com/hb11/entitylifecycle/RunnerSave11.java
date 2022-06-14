package com.com.hb11.entitylifecycle;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {
        Student11 student1=new Student11();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);
        //TRANSIENT- Normal java object and there is no association with the database.
        //PERSISTENT OR MANAGED-After you save / persist/load/get the object- entity state is persistent
        //DETACHED //after calling session.detached entity will be in detached state. After detaching hibernate not track the object.
        //after session close, entity state is detached state. After detachinf the object you can move the object into persistent state by calling update method.
        //REMOVED -- If you delete the object, entity state is in removed so you cant change anything in the database related with object
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();
        //session.save(student1);
        Student11 studentFound= session.get(Student11.class,1001);
        //studentFound.setName("Updated Name after Getting");
        //session.detach(studentFound);
        //
        session.delete(studentFound);
        //studentFound.setName("After Deletion");
        tx.commit();
        session.close();
        //after session close, entity state is detached
        //studentFound.setName("After Detached");
        sf.close();
    }
}
