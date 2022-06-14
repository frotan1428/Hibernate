package com.hb07.fetchtypes;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id;


    @Column(name="std_name")
    private String name;

    private int grade;



    @OneToMany(mappedBy = "student"/*,fetch = FetchType.LAZY*/)
    private List<Book07> bookList = new ArrayList<>();

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

    public
    void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +

                '}';
    }
}
