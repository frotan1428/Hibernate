package com.com.hb12.entitymanager;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class RunnerSaveFetch12 {
    public static void main(String[] args) {
        Student12 student=new Student12();

        student.setId(1001);
        student.setName("John Coffee");
        student.setGrade(10);

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("studentunit");

        EntityManager em= emf.createEntityManager();

        em.getTransaction().begin();
        //em.persist(student);//save,persist in the hibernate
        Student12 studentFound= em.find(Student12.class,1001); //like get method in to hibernate
        //System.out.println(studentFound);
        em.remove(studentFound);// delete in hibernate
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}