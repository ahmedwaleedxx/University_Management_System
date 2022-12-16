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
import rmi.user;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class Doctor extends Employee {

    private Course AssignedCourse;
    private TA AssignedTA;

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> MaterialCollection;
        private MongoCollection<Document> courseCollection;
    private Gson gson = new Gson();

    public Doctor() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem"); // Database name
        MaterialCollection = database.getCollection("Material"); // Collection name
        courseCollection = database.getCollection("Course");
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

    public void AddCourseMaterial(Material m) {
        MaterialCollection.insertOne(Document.parse(gson.toJson(m)));
        System.out.println("File Inserted Succesfully");
    }

    
    
    public void RemoveCourseMaterial(Material m) throws RemoteException {
        MaterialCollection.deleteOne(Filters.eq("ID", m.getID()));
        System.out.println("File Deleted Successfully");
    }

    public void UpdateMaterialTitle(int matid, String title) throws RemoteException {
        System.out.println("Title Edited");
        Document doc = Document.parse(gson.toJson(title));
        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("MaterialTitle", doc));
    }

    public void UpdateMaterialVisibility(int matid, boolean vis) throws RemoteException {
        System.out.println("Visibility Edited");
        Document doc = Document.parse(gson.toJson(vis));
        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("MaterialVisibility", doc));
    }

    public void UpdateMaterialCourse(int matid, int cid) throws RemoteException {
        System.out.println("Course Edited");
        Document doc = Document.parse(gson.toJson(cid));
        MaterialCollection.updateOne(Filters.eq("ID", matid), Updates.set("MaterialVisibility", doc));
    }
    
    
      public void UpdateCourseTitle(int courseid, String title) throws RemoteException {
        System.out.println("Title Edited");
        Document doc = Document.parse(gson.toJson(title));
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTitle",doc));
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
