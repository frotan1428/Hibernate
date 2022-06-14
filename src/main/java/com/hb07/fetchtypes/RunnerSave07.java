package com.hb07.fetchtypes;

import com.hb04.onetomany.Book04;
import com.hb04.onetomany.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {

    public static void main(String[] args) {

        Book07 book1=new Book07();
        Book07 book2=new Book07();
        Book07 book3=new Book07();
        Book07 book4=new Book07();

        Student07 student1=new Student07();
        Student07 student2=new Student07();
        Student07 student3=new Student07();


        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(100);

        student2.setId(1002);
        student2.setName("Walter White");
        student2.setGrade(90);

        student3.setId(1003);
        student3.setName("Maximus Decimus");
        student3.setGrade(85);

        book1.setId(101);
        book1.setName(student1.getName()+"'science book");
        //this setting very important
        book1.setStudent(student1);

        book2.setId(102);
        book2.setName(student1.getName()+"'html book");
        book2.setStudent(student1);

        book3.setId(103);
        book3.setName(student2.getName()+"'java book");
        book3.setStudent(student2);

        book4.setId(104);
        book4.setName("No body's book");


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);



        tx.commit();
        session.close();
        sf.close();

    }


}
