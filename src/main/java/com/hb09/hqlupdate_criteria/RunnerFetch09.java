package com.hb09.hqlupdate_criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Student09 student1=new Student09();


        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student09.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//        id, name,grade
//        findById();
//        findByName(),
//        findByGrade(),


        //fetch a student for given id then set new name then call update.
//        student1= session.get(Student09.class,1);
//        student1.setName("Updated:"+student1.getName());
//        student1.setGrade(92);
//        session.update(student1);


        //update a student for given id with the HQL
//        String hqlQuery1="UPDATE Student09 s SET s.name='Updated with HQL' WHERE s.id=5";
//        int numOfRec= session.createQuery(hqlQuery1).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec);


        //make 100 for all student if their grade is greater than 90
//        String hqlQuery2="UPDATE Student09 s SET s.grade=100 WHERE s.grade>90";
//        int numOfRec2=session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Effected row count:"+numOfRec2);


        //fetch students that have the grade less than 50 then set 50
//         String hqlQuery3="FROM Student09 s WHERE s.grade<50";
//         List<Student09> resultList1= session.createQuery(hqlQuery3).getResultList();
//
//         for (Student09 student: resultList1){
//             student.setGrade(50);
//             session.update(student);
//         }


        //CRITERIA API Examples
        //Criteria api is a feature in hibernate It allows us to create dynamic queries.

        //Firstly we get a Criteria Builder to build a query
        CriteriaBuilder cb=session.getCriteriaBuilder();
        //via criteria builder we create a query for specific class
        CriteriaQuery<Student09> criteriaQuery=cb.createQuery(Student09.class);
        Root<Student09> root= criteriaQuery.from(Student09.class);

        //criteriaQuery.select(root);

//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Name19"));
//
//        Query<Student09> query= session.createQuery(criteriaQuery);
//        List<Student09> resultList1= query.getResultList();
//
//        resultList1.forEach(s-> System.out.println(s));

          //WHERE s.name="Name20" and s.grade>50
          //fetch student who has the name Name20 and / or grade >50
        //With the Predicate we create a restriction for the query.
//        Predicate predicateForName=cb.equal(root.get("name"),"Name20");
//        Predicate predicateForGradeGt50=cb.gt(root.get("grade"),50);
//
//        Predicate predicateStd=cb.and(predicateForName,predicateForGradeGt50);
//        criteriaQuery.where(predicateStd);
//
//        Query<Student09> query= session.createQuery(criteriaQuery);
//        List<Student09> resultList2= query.getResultList();
//
//        resultList2.forEach(s-> System.out.println(s));


        //Aggregate function example for sum
        //calculate sum of the students grade
        CriteriaBuilder cb2=session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQueryInteger=cb.createQuery(Integer.class);
        Root<Student09> root1= criteriaQueryInteger.from(Student09.class);

        criteriaQueryInteger.select(cb.sum(root1.get("grade")));
        Query<Integer> queryForSum= session.createQuery(criteriaQueryInteger);
        Integer sum= queryForSum.getSingleResult();
        System.out.println("Total:"+sum);



        tx.commit();
        session.close();
        sf.close();
    }

}
