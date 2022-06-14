package com.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Pojo class (plain old java object)
//Entity: JPA annotated Pojo
//annotations: mark
//Entity is an object and Entity has an associated a table in database
@Entity
@Table(name="t_student01")
public class Student01
{
    @Id
    //we must put @Id in order to make primary
    private int id;

    //@Column(name="student_name",length=100,unique = true,nullable = false,insertable = false,updatable = false)


    private String name;

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
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
