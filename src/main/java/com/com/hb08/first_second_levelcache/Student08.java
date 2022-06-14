package com.com.hb08.first_second_levelcache;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region="Student08")
public class Student08 {


    /*First level cache is default in hibernate
    second level cache is optional If you want to add second level cache feature
        You need to add some dependencies into pom.
        You need to add some property int hibernate.cfg xml
        You need to add some annotation into entity class

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //You can give a default value with the PrePersist annotation
//    @PrePersist
//    public void prePersist(){
//        if(name==null){
//            name="John";
//        }
//    }

    private String name="John Coffee";

    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
