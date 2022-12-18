/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Employee.*;
import Student.*;
import TA.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.DoctorInterface;
import rmi.user;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class Doctor extends Employee implements DoctorInterface {

    private Course AssignedCourse;
    private TA AssignedTA;

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> MaterialCollection;
    private MongoCollection<Document> courseCollection;
    private Gson gson;

    public Doctor() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem"); // Database name
        MaterialCollection = database.getCollection("Material"); // Collection name
        courseCollection = database.getCollection("Course");
        gson= new Gson();
    }

    public Doctor(Course AssignedCourse, TA AssignedTA) throws RemoteException {
        this.AssignedCourse = AssignedCourse;
        this.AssignedTA = AssignedTA;
    }

    public Doctor(int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType) throws RemoteException {
        super(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType);
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

    
    @Override
    public ArrayList<Material> getMaterialbyDoctorID(int id) throws RemoteException{
        
        Course c = new Course();
        return c.getMaterialbyDoctorID(id);
    }
    
    
//    public void setGrades(Course assignedCourse, Student student) {
//
//    }
//
//    public void assignTATasks(TA ta, String task) {
//
//    }
//
//    public void addCourseMaterial(Course course, Material material) {
//
//    }
//
//    public void addTAtoCourse(Course course, TA ta) {
//
//    }
//
//    public void removeCourseTA(Course course, TA ta) {
//
//    }
//
//    public void removeCourseMaterial(Course course, Material courseMaterial) {
//
//    }
//
//    public void sendAnnouncements(Student student) {
//
//    }
//
//    public void setMaterialVisibility(Material material, Boolean isVisible) {
//
//    }
//    @Override
//    public void HandleComplaint() {
//
//    }
//    @Override
//    public void UpdateCourseTitle(int courseid, String title) throws RemoteException {
//
//    }
//
//    @Override
//    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException {
//
//    }
//
//    @Override
//    public void UpdateMaterialTitle(int matid, String title) throws RemoteException {
//
//    }
//
//    @Override
//    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException {
//
//    }
//
//    @Override
//    public void sendAnnouncements(rmi.Student student) {
//
//    }
}
