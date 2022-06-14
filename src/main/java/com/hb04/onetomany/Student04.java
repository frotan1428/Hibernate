package com.hb04.onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student04 {

    @Id
    private int id;


    @Column(name="std_name")
    private String name;

    private int grade;

    //Defines the set of cascadable operations that are propagated to the associated entity
    //if orphanremoval=true, if you delete parent, child of the parent is removed automatically
    @OneToMany(mappedBy = "student", orphanRemoval = true /*cascade = CascadeType.ALL*/)
    private List<Book04> bookList = new ArrayList<>();

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

    public List<Book04> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book04> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +

                '}';
    }

//    @Override
//    public String toString() {
//        return "Student04{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", grade=" + grade +
//                ", bookList=" + bookList +
//                '}';
//    }
}
