package com.hb07.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    /*
     Advantages of the LAZY FETCH
     1) Initial load time much smaller than eager fetch type
     2) Less memory need

     Disadvantage of the LAZY
     1) Delayed initialization may impact the performance


     Advantages of the EAGER FETCH
     1) No delayed initialization

     Disadvantage of the EAGER
     1)Longer initial loading time
     2) It uses more memory, It fetch the related data so unnecessary data may effect the performance negatively.

     */






    public static void main(String[] args) {

        Student07 student1=new Student07();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

      /*  Hibernate: EAGER FETCH TYPE SQL RESULT
        select
        student07x0_.id as id1_1_0_,
                student07x0_.grade as grade2_1_0_,
        student07x0_.std_name as std_name3_1_0_,
                booklist1_.std_id as std_id3_0_1_,
        booklist1_.id as id1_0_1_,
                booklist1_.id as id1_0_2_,
        booklist1_.name as name2_0_2_,
                booklist1_.std_id as std_id3_0_2_
        from
        Student07 student07x0_
        left outer join
        Book07 booklist1_
        on student07x0_.id=booklist1_.std_id
        where
        student07x0_.id=?
        */

         /*
           OneToMany:default is LAZY
           ManyToMany:default LAZY
           OneToOne: default EAGER
           ManyToOne: default EAGER

          */

        /*
        Hibernate: LAZY FETCH TYPE SQL RESULT
        select
        student07x0_.id as id1_1_0_,
                student07x0_.grade as grade2_1_0_,
        student07x0_.std_name as std_name3_1_0_
                from
        Student07 student07x0_
        where
        student07x0_.id=?
        */

        student1=session.get(Student07.class,1001);

        tx.commit();
        session.close();

        //If fetcht type is lazy, when you call  student1.getBookList() method after session close
        // you get "failed to lazily initialize a collection of role" exception.
        //System.out.println(student1.getBookList());
        sf.close();
    }
}
