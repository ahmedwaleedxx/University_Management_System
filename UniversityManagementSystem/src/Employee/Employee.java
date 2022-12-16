/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import rmi.user;
import universitymanagementsystem.DBConnect;

/**
 *
 * @author ahmedwaleed
 */
public class Employee extends UnicastRemoteObject implements user {

    //Private Attributes
    private int EmployeeID;
    private String EmployeeFName;
    private String EmployeeLName;
    private String Email;
    private String Password;
    private float EmployeeSalary;
    private ArrayList<String> EmployeeWorkingHours;
    private String EmployeeBankAccountIBAN;
    private String EmployeeType;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    //Constructors
    public Employee() throws RemoteException{
    }

    public Employee(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        this.EmployeeID = EmployeeID;
        this.EmployeeFName = EmployeeFName;
        this.EmployeeLName = EmployeeLName;
        this.Email = Email;
        this.Password = Password;
        this.EmployeeSalary = EmployeeSalary;
        this.EmployeeWorkingHours = EmployeeWorkingHours;
        this.EmployeeBankAccountIBAN = EmployeeBankAccountIBAN;
        this.EmployeeType = EmployeeType;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Getters And Setters
    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getEmployeeFName() {
        return EmployeeFName;
    }

    public void setEmployeeFName(String EmployeeFName) {
        this.EmployeeFName = EmployeeFName;
    }

    public String getEmployeeLName() {
        return EmployeeLName;
    }

    public void setEmployeeLName(String EmployeeLName) {
        this.EmployeeLName = EmployeeLName;
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

    public float getEmployeeSalary() {
        return EmployeeSalary;
    }

    public void setEmployeeSalary(float EmployeeSalary) {
        this.EmployeeSalary = EmployeeSalary;
    }

    public ArrayList<String> getEmployeeWorkingHours() {
        return EmployeeWorkingHours;
    }

    public void setEmployeeWorkingHours(ArrayList<String> EmployeeWorkingHours) {
        this.EmployeeWorkingHours = EmployeeWorkingHours;
    }

    public String getEmployeeBankAccountIBAN() {
        return EmployeeBankAccountIBAN;
    }

    public void setEmployeeBankAccountIBAN(String EmployeeBankAccountIBAN) {
        this.EmployeeBankAccountIBAN = EmployeeBankAccountIBAN;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String EmployeeType) {
        this.EmployeeType = EmployeeType;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Employee Functions
    public void setWorkingHours(ArrayList<String> WorkingHoursPerWeek) {

    }

    public float viewSalary() {
        return 0;
    }

    public boolean AddBankAccountInfo(String accountIban) {
        return false;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //User Implemented Functions
    @Override
    public user Login(String email, String password, String usertype) throws RemoteException{
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
