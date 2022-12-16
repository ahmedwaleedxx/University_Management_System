/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import Employee.Employee;
import Student.Student;
import com.mongodb.client.MongoDatabase;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public interface DBInterface extends Remote {

    public MongoDatabase getDatabase() throws RemoteException;

    public void SignUpStudent(Student s) throws RemoteException;

    public void UpdateStudent(Student s) throws RemoteException;

    public void DeleteStudent(Student s) throws RemoteException;

    public Employee getEmployee(String email, String password, String EmployeeType) throws RemoteException;

    public Course getCourse(int Course) throws RemoteException;

    public ArrayList<Student> getStudents() throws RemoteException;

    public ArrayList<Faculty> getFaculties() throws RemoteException;

    public void close() throws RemoteException;
}
