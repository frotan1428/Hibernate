package com.hb03.onetoone;

import com.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {

        Diary diary1=new Diary();
        Diary diary2=new Diary();


        Student03 student1=new Student03();
        Student03 student2=new Student03();

        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(100);
        student1.setDiary(diary1);


        student2.setId(1002);
        student2.setName("Walter White");
        student2.setGrade(90);

        diary1.setId(101);
        diary1.setName(student1.getName()+"'s diary");
        diary1.setStudent(student1);

        diary2.setId(102);
        diary2.setName("Nobody's diary");

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                    addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(diary1);
        session.save(diary2);
        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        sf.close();







            }
}
