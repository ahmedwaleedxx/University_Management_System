/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import Employee.*;
import Student.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class TA extends Employee {

    private Course AssignedCourse;

    public TA(Course AssignedCourse) throws RemoteException{
        this.AssignedCourse = AssignedCourse;
    }

    public TA(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, Course AssignedCourse) throws RemoteException{
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
        this.AssignedCourse = AssignedCourse;
    }

    public Course getAssignedCourse() {
        return AssignedCourse;
    }

    public TA() throws RemoteException{
    }

    public void setAssignedCourse(Course AssignedCourse) {
        this.AssignedCourse = AssignedCourse;
    }

    public void setStudentAttendance(Course course, Student student) {

    }

    public void setStudentContribution(Course course, String Cotrib) {

    }

    public void setCourseMaterialVisbility(Material courseMaterial, Boolean isVibile) {

    }

    public void HandleComplaint() {

    }

}
