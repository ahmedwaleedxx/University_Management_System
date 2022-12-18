/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import rmi.EmployeeInterface;
import rmi.user;
import universitymanagementsystem.DBConnect;

/**
 *
 * @author ahmedwaleed
 */
public class Employee extends UnicastRemoteObject implements user, EmployeeInterface {

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
    @Override
    public int getEmployeeID() throws RemoteException{
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    @Override
    public String getEmployeeFName() throws RemoteException{
        return EmployeeFName;
    }

    public void setEmployeeFName(String EmployeeFName) {
        this.EmployeeFName = EmployeeFName;
    }

    @Override
    public String getEmployeeLName() throws RemoteException {
        return EmployeeLName;
    }

    public void setEmployeeLName(String EmployeeLName) {
        this.EmployeeLName = EmployeeLName;
    }

    @Override
    public String getEmail() throws RemoteException {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String getPassword() throws RemoteException{
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public float getEmployeeSalary() throws RemoteException{
        return EmployeeSalary;
    }

    public void setEmployeeSalary(float EmployeeSalary) {
        this.EmployeeSalary = EmployeeSalary;
    }

    @Override
    public ArrayList<String> getEmployeeWorkingHours() throws RemoteException{
        return EmployeeWorkingHours;
    }

    public void setEmployeeWorkingHours(ArrayList<String> EmployeeWorkingHours) {
        this.EmployeeWorkingHours = EmployeeWorkingHours;
    }

    @Override
    public String getEmployeeBankAccountIBAN() throws RemoteException{
        return EmployeeBankAccountIBAN;
    }

    public void setEmployeeBankAccountIBAN(String EmployeeBankAccountIBAN) {
        this.EmployeeBankAccountIBAN = EmployeeBankAccountIBAN;
    }

    @Override
    public String getEmployeeType() throws RemoteException {
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

    @Override
    public String toString() {
        return EmployeeID + EmployeeFName +  EmployeeLName  +  Email + Password  + EmployeeSalary + EmployeeWorkingHours +  EmployeeBankAccountIBAN + EmployeeType + '}';
    }

}
