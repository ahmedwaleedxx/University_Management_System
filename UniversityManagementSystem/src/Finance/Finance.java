/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import Employee.*;
import java.rmi.RemoteException;
import rmi.user;
import universitymanagementsystem.DBConnect;

/**
 *
 * @author ahmedwaleed
 */
public class Finance extends Employee implements user {

    public Finance() throws RemoteException {
    }

    public void setFacultyFees(String FacultyName, Double fees) {

    }

    public boolean setPaymentStatus(int TransactionID, boolean Status) {
        return false;
    }

    public void respondToEnquiries(int EnquiryID, String message) {

    }

    public void setSalaryToEmployee(int EmployeeID, Double salary) {
    }

    public void AddOverTimeBonus(int EmployeeID, Double overtimeBonus) {
    }

    public void discountSalaryFromEmployee(int EmployeeID, Double percent) {

    }

    public void HandleComplaint() {

    }

    @Override
    public user Login(String email, String password, String usertype) throws RemoteException {
        DBConnect db = new DBConnect();
        user u = db.Login(email, password, usertype);
        return u;
    }
}
