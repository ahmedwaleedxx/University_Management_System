/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Doctor.*;
import java.util.*;

/**
 *
 * @author ahmedwaleed
 */
public class Faculty {

    private int FacultyID;
    private String Name;
    private String DeanName;
    private String Mail;
    private ArrayList<Doctor> doctors;

    public Faculty() {
    }

    public Faculty(int FacultyID, String Name, String DeanName, String Mail, ArrayList<Doctor> doctors) {
        this.FacultyID = FacultyID;
        this.Name = Name;
        this.DeanName = DeanName;
        this.Mail = Mail;
        this.doctors = doctors;
    }

    public int getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(int FacultyID) {
        this.FacultyID = FacultyID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDeanName() {
        return DeanName;
    }

    public void setDeanName(String DeanName) {
        this.DeanName = DeanName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void AddDoctor(Doctor doct) {

    }

    public void UpdateFacultyInfo() {

    }
}
