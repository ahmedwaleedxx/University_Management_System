/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Employee.*;
import Student.*;
import TA.*;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import rmi.user;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class Doctor extends Employee {

    private Course AssignedCourse;
    private TA AssignedTA;

    public Doctor() throws RemoteException {
    }

    public Doctor(Course AssignedCourse, TA AssignedTA) throws RemoteException {
        this.AssignedCourse = AssignedCourse;
        this.AssignedTA = AssignedTA;
    }

    public Doctor(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse, TA AssignedTA) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        this.AssignedCourse = AssignedCourse;
        this.AssignedTA = AssignedTA;
    }

    public Course getAssignedCourse() {
        return AssignedCourse;
    }

    public void setAssignedCourse(Course AssignedCourse) {
        this.AssignedCourse = AssignedCourse;
    }

    public TA getAssignedTA() {
        return AssignedTA;
    }

    public void setAssignedTA(TA AssignedTA) {
        this.AssignedTA = AssignedTA;
    }

    
    
    public void setGrades(Course assignedCourse, Student student) {
        
    }

    public void assignTATasks(TA ta, String task) {

    }

    public void addCourseMaterial(Course course, Material material) {

    }

    public void addTAtoCourse(Course course, TA ta) {

    }

    public void removeCourseTA(Course course, TA ta) {

    }

    public void removeCourseMaterial(Course course, Material courseMaterial) {

    }

    public void sendAnnouncements(Student student) {

    }

    public void setMaterialVisibility(Material material, Boolean isVisible) {

    }

    public void HandleComplaint() {

    }

//    @Override
//    public void Login(String e, String p, String u) throws RemoteException{
//        
//    }
//    @Override
//    public user Login(String email, String password, String usertype) throws RemoteException {
//        DBConnect db = new DBConnect();
//        user u = db.Login(email, password, usertype);
//        return u;
//    }
//
//    @Override
//    public void ChangePassword(String OldPassword, String NewPassword) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void ForgotPassword(String emailAddress) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
