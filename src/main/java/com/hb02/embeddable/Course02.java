package com.hb02.embeddable;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
  if you do not use @Embeddable annotation it does not add courses data into database
  You can embed other object variables into an entity with embeddable annotation without creating extra table.
 */
@Embeddable
public class Course02 {

    private String elective;
    private String mandatory;

    public String getElective() {
        return elective;
    }

    public void setElective(String elective) {
        this.elective = elective;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }


    @Override
    public String toString() {
        return "Course02{" +
                "elective='" + elective + '\'' +
                ", mandatory='" + mandatory + '\'' +
                '}';
    }
}
