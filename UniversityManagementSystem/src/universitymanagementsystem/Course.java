/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Doctor.*;
import TA.*;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.CourseInterface;

/**
 *
 * @author ahmedwaleed
 */
public class Course implements CourseInterface {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> courseCollection;
    private MongoCollection<Document> StudentCollection;

    private Gson gson;

    private int CourseID;
    private String CourseTitle;
    private Doctor CourseDoctor;
    private ArrayList<TA> CourseTAs;
    private String Mail;
    private String Faculty;
    private ArrayList<Material> CourseMaterial;

    public Course(int CourseID, String CourseTitle, Doctor CourseDoctor, String Mail, String Faculty) throws RemoteException {
        this.CourseID = CourseID;
        this.CourseTitle = CourseTitle;
        this.CourseDoctor = CourseDoctor;
//        this.CourseTAs = CourseTAs;
//        CourseTAs.add(ta); 
        this.Mail = Mail;
        this.Faculty = Faculty;
        //this.CourseMaterial = CourseMaterial;

    }

    public Course() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        courseCollection = database.getCollection("Course");
        StudentCollection = database.getCollection("Student");
        gson = new Gson();
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String CourseTitle) {
        this.CourseTitle = CourseTitle;
    }

    public Doctor getCourseDoctor() {
        return CourseDoctor;
    }

    public void setCourseDoctor(Doctor CourseDoctor) {
        this.CourseDoctor = CourseDoctor;
    }

    public ArrayList<TA> getCourseTAs() {
        return CourseTAs;
    }

    public void setCourseTAs(ArrayList<TA> CourseTAs) {
        this.CourseTAs = CourseTAs;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public ArrayList<Material> getCourseMaterial() {
        return CourseMaterial;
    }

    public void setCourseMaterial(ArrayList<Material> CourseMaterial) {
        this.CourseMaterial = CourseMaterial;
    }

    @Override
    public void AddCourseTA(int courseid, int EmployeeID, String EmployeeFName, String EmployeeLName, String Email, String Password, float EmployeeSalary, ArrayList<String> EmployeeWorkingHours, String EmployeeBankAccountIBAN, String EmployeeType, int courseID) throws RemoteException {
        TA ta = new TA(EmployeeID, EmployeeFName, EmployeeLName, Email, Password, EmployeeSalary, EmployeeWorkingHours, EmployeeBankAccountIBAN, EmployeeType, courseID);
        System.out.println("Error");
        Document doc1 = Document.parse(gson.toJson(ta));
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTAs", doc1));
    }

    @Override
    public void RemoveCourseTA(int courseid) throws RemoteException {
        System.out.println("Error");
        Document doc = null;
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTAs", doc));
    }

    @Override
    public void UpdateCourseTitle(int courseid, String title) throws RemoteException {
        System.out.println("Title Edited");
        Document doc = Document.parse(gson.toJson(title));
        courseCollection.updateOne(Filters.eq("CourseID", courseid), Updates.set("CourseTitle", doc));
    }

    @Override
    public void DeleteCourse(int id) throws RemoteException {
        courseCollection.deleteOne(Filters.eq("CourseID", id));
        System.out.println("Deleted Successfully");
    }

}
