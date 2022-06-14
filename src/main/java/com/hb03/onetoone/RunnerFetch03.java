package com.hb03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {

    public static void main(String[] args) {


        Student03 student1=new Student03();
        Diary diary1=new Diary();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();



//        student1= session.get(Student03.class,1001);
//        System.out.println(student1);

//        diary1=session.get(Diary.class,101);
//        System.out.println(diary1);

        //INNER JOIN
        //While you are writing hqlquery to make a join you have to use for on statement (ON s.id=d.student) object name
//        String hqlQuery1="SELECT s.name,s.grade, d.name  from Student03 s INNER JOIN FETCH Diary d ON s.id=d.student";
//        List<Object[]> resultList1=session.createQuery(hqlQuery1).getResultList();
//
//        for (Object[] r:resultList1) {
//            System.out.println(Arrays.toString(r));
//
//        }

// HQL LEFT JOIN
//        String hqlQuery2="SELECT s.name,s.grade, d.name  from Student03 s LEFT JOIN FETCH Diary d ON s.id=d.student";
//        List<Object[]> resultList2=session.createQuery(hqlQuery2).getResultList();
//        for (Object[] r:resultList2) {
//            System.out.println(Arrays.toString(r));
//        }


    //RIGHT JOIN
//        String hqlQuery3="SELECT s.name,s.grade, d.name  from Student03 s RIGHT JOIN FETCH Diary d ON s.id=d.student";
//        List<Object[]> resultList3=session.createQuery(hqlQuery3).getResultList();
//        for (Object[] r:resultList3) {
//            System.out.println(Arrays.toString(r));
//        }

        //It is the shorter way of the HQL to fetch all common records
//        String hqlQuery4="FROM Student03 s INNER JOIN FETCH s.diary";
//       List<Student03> resultList4= session.createQuery(hqlQuery4).getResultList();
//        for (Student03 student:resultList4){
//            System.out.println(student);
//        }

        //Fetch the Diary records common with the student--HQL Way
//        String hqlQuery5="FROM Diary d INNER JOIN FETCH d.student";
//        List<Diary> resultList5= session.createQuery(hqlQuery5).list();
//        for (Diary diary:resultList5){
//            System.out.println(diary);
//        }



        //We use custom class to get the variables What we need. so We dont get unnecessary data. we use this object for data transfer object(DTO)
        Query<Result> query=session.
                createQuery("SELECT new com.hb03.onetoone.Result(s.id,s.name,d.name) " +
                        "FROM Student03 s inner join fetch Diary d on s.id=d.student");

        List<Result> resultList6= query.getResultList();

        for (Result result:resultList6 ){
            System.out.println(result.getStudentName()+":"+result.getStudentId()+":"+result.getDiaryName());
        }

        tx.commit();
        session.close();
        sf.close();

    }
}
