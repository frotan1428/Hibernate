package com.hb04.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Student04 student1=new Student04();
        Book04 book1=new Book04();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student04.class).addAnnotatedClass(Book04.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        /*fetch a student for given id then list all books by using booklist
        student1= session.get(Student04.class,1001);
        System.out.println(student1);

        for (Book04 book: student1.getBookList()){
            System.out.println(book);
        }
        */

        /* fetch a book for given book id then access the student from book object by calling getStudent
        book1= session.get(Book04.class,101);
        System.out.println(book1.getStudent().getName());
        */

//        String sqlQuery1="SELECT s.std_name, b.name " +
//                "FROM Student04 s INNER JOIN Book04 b ON s.id=b.std_id";
//        List<Object[]> resultList1= session.createSQLQuery(sqlQuery1).getResultList();
//        for (Object[] r:resultList1){
//            System.out.println(Arrays.toString(r));
//        }


        /* to fetch data you can use HQL query, please write object name (b.student) in JOIN
        String hqlQuery1="SELECT s.name,b.name  FROM Student04 s INNER JOIN FETCH Book04 b ON s.id=b.student";

       List<Object[]> resultList2=  session.createQuery(hqlQuery1).getResultList();

       for (Object [] r:resultList2){
           System.out.println(Arrays.toString(r));
       }

         */



//        String hqlQuery2="SELECT s.name,b.name  FROM Student04 s LEFT JOIN FETCH Book04 b ON s.id=b.student";
//
//        List<Object[]> resultList3=  session.createQuery(hqlQuery2).getResultList();
//
//        for (Object [] r:resultList3){
//            System.out.println(Arrays.toString(r));
//        }

//        String hqlQuery3="SELECT s.name,b.name  FROM Student04 s RIGHT JOIN FETCH Book04 b ON s.id=b.student";
//
//        List<Object[]> resultList4=  session.createQuery(hqlQuery3).getResultList();
//
//        for (Object [] r:resultList4) {
//            System.out.println(Arrays.toString(r));
//        }


        //Delete all books sql Query Example
//        String sqlQuery2="DELETE FROM Book04";
//        int numOfRec1=session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec1);


        //Delete all books HQL Query Example
//        String hqlQuery4="DELETE FROM Book04";
//        int numOfRec2=session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec2);


        //Delete book if the book's id =1001
//        String hqlQuery5="DELETE FROM Book04 b WHERE b.student=1001";
//        int numOfRec3=session.createQuery(hqlQuery5).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec3);


        //delete a student for a given id with HQL

        // If There is a book related with the student that you delete, You cant delete the student with sql or hql
        //But first you delete all books related with the student then you can delete student
//        String hqlQuery6="DELETE FROM Student04 s WHERE s.id=1002";
//        int numOfRec4= session.createQuery(hqlQuery6).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec4);


        student1=session.get(Student04.class,1002);
        session.delete(student1);










        tx.commit();
        session.close();
        sf.close();
    }
}
