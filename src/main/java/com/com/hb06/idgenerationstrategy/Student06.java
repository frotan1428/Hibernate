package com.com.hb06.idgenerationstrategy;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Student06 {

    /*
    * AUTO
    * IDENTITY
    * SEQUENCE
    * TABLE
    *
    *
    * */



    @Id
    //if you dont specific strategy it will be AUTO.
    //@GeneratedValue(strategy = GenerationType.AUTO)

    //if you make a batch operations strategy SEQUENCE is better than the others
    //Hibernate requests the primary key value from a database sequence
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    //Hibernate relies on an auto-incremented database column to generate primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)


    //it is not used much.  It keeps a table to follow the id
    //@GeneratedValue(strategy = GenerationType.TABLE)


//    you can create custom sequence and you can specify initial value and allocation size
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="STD_SEQ")
    @SequenceGenerator(name="STD_SEQ", sequenceName ="STD_SEQ1",  initialValue = 1000, allocationSize = 50)
    private int id;


    //6bd3df3a-9632-4c06-8165-954c85accdbf
    //128 bit
    //8-4-4-4-12
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name="UUID", strategy = "uuid2")
//    private String id;

    private String name;

    private int grade;


//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

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




}
