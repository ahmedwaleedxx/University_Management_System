/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finance;

import Employee.*;
import java.rmi.RemoteException;

/**
 *
 * @author ahmedwaleed
 */
public class Finance extends Employee {

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
}
