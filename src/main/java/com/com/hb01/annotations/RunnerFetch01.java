package com.com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Student01 student1=new Student01();
        Student01 student2=new Student01();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();


        Transaction tx=session.beginTransaction();

        //1.way to fetch student
//        student1=session.get(Student01.class,1001);
//        student2=session.get(Student01.class,1002);
//
//        System.out.println(student1);
//        System.out.println(student2);

//2.way to use sql to fetch data
/*
        String sqlQuery1="SELECT * FROM t_student01";
       List<Object[]> resultList1=  session.createSQLQuery(sqlQuery1).getResultList();

       for (Object[] r:resultList1){
           System.out.println(Arrays.toString(r));
       }
*/

        //3.way use HQL
        /*
        String hqlQuery1="FROM Student01";
        List<Student01> resultList2= (List<Student01>) session.createQuery(hqlQuery1).list();

        for(Student01 r:resultList2){
            System.out.println(resultList2);
        }
        */


//        String sqlQuery2="SELECT * FROM t_student01 where name='John Coffee'";
//        List<Object[]> resultList3=session.createSQLQuery(sqlQuery2).getResultList();
//        for (Object[] r:resultList3){
//            System.out.println(Arrays.toString(r));
//        }

//       Object[] array= resultList3.get(0);
//        System.out.println(array[0]+":"+array[1]+":"+array[2]);


        //if you are sure result is unique you can use unique result SQL way

//        String sqlQuery3="SELECT * FROM t_student01 where id=1001";
//        Object [] result=(Object[]) session.createSQLQuery(sqlQuery3).uniqueResult();
//        Object array keeps the columns for a record
//        System.out.println(Arrays.toString(result));


        //if you are sure result is unique you can use unique result HQL way
//        String hqlQuery3="FROM Student01 s where s.id=1001";
//
//        Student01 student= (Student01)session.createQuery(hqlQuery3).uniqueResult();
//        System.out.println(student);


        //write an HQL query, fetch all student if the grade=100.
        String hqlQuery4="SELECT s.name,s.grade FROM Student01 s where s.grade=100";
        List<Object[]> resultList4= session.createQuery(hqlQuery4).getResultList();

        for(Object[] r:resultList4){
            System.out.println(Arrays.toString(r));
        }


        tx.commit();
        session.close();
        sf.close();




    }
}
