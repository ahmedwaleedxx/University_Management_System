/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import java.io.Serializable;

/**
 *
 * @author infolos
 */
public class StudentDTO implements Serializable {
    private int StudentID;
    private String StudentFName;
    private String StudentLName;
    private String Email;
    private String Password;
    private float StudentOverAllGrade;
    private boolean isGraduated;
    private boolean paidTutionFees;
    private String Major;
    private String Faculty;

    public StudentDTO(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) {
        this.StudentID = StudentID;
        this.StudentFName = StudentFName;
        this.StudentLName = StudentLName;
        this.Email = Email;
        this.Password = Password;
        this.StudentOverAllGrade = StudentOverAllGrade;
        this.isGraduated = isGraduated;
        this.paidTutionFees = paidTutionFees;
        this.Major = Major;
        this.Faculty = Faculty;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentFName() {
        return StudentFName;
    }

    public void setStudentFName(String StudentFName) {
        this.StudentFName = StudentFName;
    }

    public String getStudentLName() {
        return StudentLName;
    }

    public void setStudentLName(String StudentLName) {
        this.StudentLName = StudentLName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public float getStudentOverAllGrade() {
        return StudentOverAllGrade;
    }

    public void setStudentOverAllGrade(float StudentOverAllGrade) {
        this.StudentOverAllGrade = StudentOverAllGrade;
    }

    public boolean isIsGraduated() {
        return isGraduated;
    }

    public void setIsGraduated(boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    public boolean isPaidTutionFees() {
        return paidTutionFees;
    }

    public void setPaidTutionFees(boolean paidTutionFees) {
        this.paidTutionFees = paidTutionFees;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }


    
    
    
}
