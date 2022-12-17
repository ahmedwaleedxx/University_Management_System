/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ahmedwaleed
 */
public interface CourseInterface {

    public void AddCourseTA(int courseid, int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, int courseID) throws RemoteException;

    public void RemoveCourseTA(int courseid) throws RemoteException;

    public void UpdateCourseTitle(int courseid, String title) throws RemoteException;

    public void DeleteCourse(int id) throws RemoteException;
}
