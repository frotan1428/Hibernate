package com.hb02.embeddable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Student02 {

    @Id
    private int id;

    @Column(name="student_name")
    private String name;


    //if you dont want to create a column, you can use transient annotation
    @Transient
    private int grade;

    private Course02 courses;


    public Course02 getCourses() {
        return courses;
    }

    public void setCourses(Course02 courses) {
        this.courses = courses;
    }

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
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ",courses="+courses+
                '}';
    }
}
