/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import rmi.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import universitymanagementsystem.*;

/**
 *
 * @author ahmedwaleed
 */
public class Student extends UnicastRemoteObject implements user, rmi.Student {

     private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> NotificationCollection;
        private MongoCollection<Document> CourseCollection;
    private Gson gson;
    
//Private Attributes
    private int StudentID;
    private String StudentFName;
    private String StudentLName;
    private String Email;
    private String Password;
    private float StudentOverAllGrade;
    private boolean isGraduated;
    private boolean paidTutionFees;
    private String Major;
    private String Faculty;
    private ArrayList<String> Courses;
    private ArrayList<Observer> Observers;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Constructors
    public Student() throws RemoteException {
         Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem");
        NotificationCollection = database.getCollection("Notification");
        CourseCollection = database.getCollection("Course");
        gson = new Gson();
    }

    public Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<String> Courses, ArrayList<Observer> Observers) throws RemoteException {
        this.StudentID = StudentID;
        this.StudentFName = StudentFName;
        this.StudentLName = StudentLName;
        this.Email = Email;
        this.Password = Password;
        this.StudentOverAllGrade = StudentOverAllGrade;
        this.isGraduated = isGraduated;
        this.paidTutionFees = paidTutionFees;
        this.Major = Major;
        this.Faculty = Faculty;
        this.Courses = Courses;
        this.Observers = Observers;
    }

    public Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException {
        this.StudentID = StudentID;
        this.StudentFName = StudentFName;
        this.StudentLName = StudentLName;
        this.Email = Email;
        this.Password = Password;
        this.StudentOverAllGrade = StudentOverAllGrade;
        this.isGraduated = isGraduated;
        this.paidTutionFees = paidTutionFees;
        this.Major = Major;
        this.Faculty = Faculty;
    }

    public void setCourses(ArrayList<String> courses){
        this.Courses=courses;
    }
    @Override
    public int getStudentID() throws RemoteException {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Override
    public String getStudentFName() throws RemoteException {
        return StudentFName;
    }

    public void setStudentFName(String StudentFName) {
        this.StudentFName = StudentFName;
    }

    @Override
    public String getStudentLName() throws RemoteException {
        return StudentLName;
    }

    public void setStudentLName(String StudentLName) {
        this.StudentLName = StudentLName;
    }

    @Override
    public String getEmail() throws RemoteException {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String getPassword() throws RemoteException {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public float getStudentOverAllGrade() throws RemoteException {
        return StudentOverAllGrade;
    }

    public void setStudentOverAllGrade(float StudentOverAllGrade) {
        this.StudentOverAllGrade = StudentOverAllGrade;
    }

    @Override
    public boolean isIsGraduated() throws RemoteException {
        return isGraduated;
    }

    public void setIsGraduated(boolean isGraduated) {
        this.isGraduated = isGraduated;
    }

    @Override
    public boolean isPaidTutionFees() throws RemoteException {
        return paidTutionFees;
    }

    public void setPaidTutionFees(boolean paidTutionFees) {
        this.paidTutionFees = paidTutionFees;
    }

    @Override
    public String getMajor() throws RemoteException {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    @Override
    public String getFaculty() throws RemoteException {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public ArrayList<Observer> getObservers() throws RemoteException {
        return Observers;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters And Setters
    public void setObservers(ArrayList<Observer> Observers) {
        this.Observers = Observers;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Student Functions
    ArrayList<Grade> getGrades() {
        return getGrades();
    }

    public ArrayList<String> getCourses() {
        return getCourses();
    }

    ArrayList<Material> viewCoursesMaterial() {
        return viewCoursesMaterial();
    }

    float getOutStandingFees() {
        return 0;
    }

    boolean payOutStandingFees() {
        return false;
    }

    void createComplaint(String complaintBody, String complaintSubject) {

    }

    void viewTranscript() {

    }

    void update(String message) {

    }

    @Override
    public String toString() {
        return StudentID + StudentFName + StudentLName + Email + Password + StudentOverAllGrade + isGraduated + paidTutionFees + Major + Faculty + Courses + '}';
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public user Login(String email, String password, String usertype) throws RemoteException {
        DBConnect db = new DBConnect();
        user u = db.Login(email, password, usertype);
        return u;
    }

    @Override
    public void ChangePassword(String OldPassword, String NewPassword) throws RemoteException {

    }

    @Override
    public void ForgotPassword(String emailAddress) throws RemoteException {

    }

//    @Override   
//    public ArrayList<String> getNotificationsByFacultyName(String FacultyName) throws RemoteException{
//        ArrayList<Notification> result = new ArrayList();
//        ArrayList<Document> docs = NotificationCollection.find(Filters.eq("FacultyName", FacultyName)).into(new ArrayList<>());
//        //System.out.println(docs);
//        ArrayList<String> notifications = new ArrayList<>();
//        for (int i = 0; i < docs.size(); i++) {
//            String jsonResult = docs.get(i).toJson();
//            Notification noti = gson.fromJson(jsonResult, Notification.class);
//            notifications.add(noti.getNotificationContent());
////            System.out.println(result);
//        }
//        System.out.println(notifications);
//        return notifications;
//    }
        
        @Override
         public ArrayList<String> getCoursessByFacultyName(String FacultyName) throws RemoteException{
        ArrayList<Course> result = new ArrayList();
        ArrayList<Document> docs = CourseCollection.find(Filters.eq("Faculty", FacultyName)).into(new ArrayList<>());
        //System.out.println(docs);
        ArrayList<String> courses = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            Course noti = gson.fromJson(jsonResult, Course.class);
            courses.add(noti.getCourseTitle());
//            System.out.println(result);
        }
        System.out.println(courses);
        return courses;
    }
    
//    @Override
//    public Student students(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException {
//        this.StudentID = StudentID;
//        this.StudentFName = StudentFName;
//        this.StudentLName = StudentLName;
//        this.Email = Email;
//        this.Password = Password;
//        this.StudentOverAllGrade = StudentOverAllGrade;
//        this.isGraduated = isGraduated;
//        this.paidTutionFees = paidTutionFees;
//        this.Major = Major;
//        this.Faculty = Faculty;
//
//        Student s = new Student(StudentID, StudentFName, StudentLName, Email, Password, StudentOverAllGrade, isGraduated, paidTutionFees, Major, Faculty);
//        return s;
//    }

}
