/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import rmi.user;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class Student extends UnicastRemoteObject implements user {

//Private Attributes
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
    private ArrayList<Course> Courses;
    private ArrayList<Observer> Observers;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Constructors
    public Student() throws RemoteException {
    }

    public Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<Course> Courses, ArrayList<Observer> Observers) throws RemoteException{
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
        this.Courses = Courses;
        this.Observers = Observers;
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

    public ArrayList<Observer> getObservers() {
        return Observers;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters And Setters
    public void setObservers(ArrayList<Observer> Observers) {
        this.Observers = Observers;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Student Functions
    ArrayList<Grade> getGrades(){
        return getGrades();
    }

    ArrayList<Course> getCourses(){
        return getCourses();
    }

    ArrayList<Material> viewCoursesMaterial() {
        return viewCoursesMaterial();
    }

    float getOutStandingFees() {
        return 0;
    }

    boolean payOutStandingFees() {
        return false;
    }

    void createComplaint(String complaintBody, String complaintSubject) {

    }

    void viewTranscript() {

    }

    void update(String message) {

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public user Login(String email, String password, String usertype) throws RemoteException {
        DBConnect db = new DBConnect();
        user u = db.Login(email, password, usertype);        
        return u;
    }

    @Override
    public void ChangePassword(String OldPassword, String NewPassword) throws RemoteException{

    }

    @Override
    public void ForgotPassword(String emailAddress) throws RemoteException{

    }

}
