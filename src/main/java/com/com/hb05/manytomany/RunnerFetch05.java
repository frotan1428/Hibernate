package com.hb05.manytomany;

import com.hb04.onetomany.Book04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Student05 student1=new Student05();
        Book05 book1=new Book05();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        //it is the session get method to fetch the Student05 for given id
//        student1=session.get(Student05.class,1001);
//        System.out.println(student1);
//
//        for (Book05 b:student1.getBooks()){
//            System.out.println(b);
//        }

        //it is the session get method to fetch the Book05 for given id
//        book1=session.get(Book05.class,101);
//        System.out.println(book1);

        //fetch Book for a given book name and print the owners of the book
//        String hqlQuery1="FROM Book05 b WHERE b.name='Math Book'";
//        book1= (Book05) session.createQuery(hqlQuery1).getSingleResult();
//        System.out.println(book1.getId()+":"+ book1.getName());
//
//        book1.getStudents().forEach(student-> System.out.println(student));


        //fetch Student for a given student name and print the books of the student
//        String hqlQuery2="FROM Student05 s WHERE s.name='John Coffee'";
//        student1 = (Student05)  session.createQuery(hqlQuery2).getSingleResult();
//        student1.getBooks().forEach(b-> System.out.println(b));


        //fetch student name and book name if the student id is 1001, use inner join fetch to get common records.
         String hqlQuery3="SELECT s.name, b.name FROM Student05 s INNER JOIN FETCH Book05 b ON s.id=1001";
         List<Object[]> resultList1= session.createQuery(hqlQuery3).getResultList();

         for (Object[] r: resultList1){
             System.out.println(Arrays.toString(r));
         }

        tx.commit();
        session.close();
        sf.close();





    }

}
