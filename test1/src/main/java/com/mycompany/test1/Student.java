/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1;

/**
 *
 * @author Lenovo
 */
class Student {
    private String studentID;
    private String name, dob, branch, phoneNumber, emailId;
    private float subject1Score, subject2Score, subject3Score, subject4Score, CGPA;

    

    public Student(String studentID, String name, String dob, String branch, String phoneNumber, String emailId) {
        this.studentID = studentID;
        this.name = name;
        this.dob = dob;
        this.branch = branch;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public Student(String studentID, String name, String dob, String branch, String phoneNumber, String emailId, float subject1Score, float subject2Score, float subject3Score, float subject4Score) {
        this.studentID = studentID;
        this.name = name;
        this.dob = dob;
        this.branch = branch;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.subject1Score = subject1Score;
        this.subject2Score = subject2Score;
        this.subject3Score = subject3Score;
        this.subject4Score = subject4Score;
    }

    
    
    

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getBranch() {
        return branch;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public float getSubject1Score() {
        return subject1Score;
    }

    public float getSubject2Score() {
        return subject2Score;
    }

    public float getSubject3Score() {
        return subject3Score;
    }

    public float getSubject4Score() {
        return subject4Score;
    }

    public float getCGPA() {
        CGPA = (subject1Score + subject2Score + subject3Score + subject4Score)/4;
        return CGPA;
    }
    
    
}
