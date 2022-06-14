package com.hb05.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book05 {

    @Id
    private int id;

    private String name;

    //in birectional many to many relation you need to use mappedby,
    // If you dont use mappedby, extra tables will be created.
    @ManyToMany(mappedBy = "books")
    private List<Student05> students=new ArrayList<>();

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

    public List<Student05> getStudents() {
        return students;
    }

    public void setStudents(List<Student05> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Book05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
