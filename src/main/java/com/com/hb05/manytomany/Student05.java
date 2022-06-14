package com.hb05.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name = "student_name")
    private String name;

    private int grade;


    @ManyToMany
    //we specify the join table name and column name with the @JoinTable annotation for manytomany relation
    //Student05_Book05, it's name of the join table
    //student_id is the foreign key in the join table for student id. it is created depending on the @Id annotation
    //book_id is the foreign key in the join table for book id. it is created depending on the @Id annotation in the Book05 class
    @JoinTable(name = "Student05_Book05",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})

    private List<Book05> books = new ArrayList<>();


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

    public List<Book05> getBooks() {
        return books;
    }

    public void setBooks(List<Book05> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
