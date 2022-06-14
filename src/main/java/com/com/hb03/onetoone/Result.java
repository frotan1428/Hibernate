package com.hb03.onetoone;

public class Result {
    private int studentId;
    private String studentName;
    private String diaryName;


    public Result(){

    }

    public Result(int studentId, String studentName, String diaryName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.diaryName = diaryName;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }



}
