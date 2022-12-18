/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import Admin.Admin;
import Doctor.Doctor;
import Employee.Employee;
import Finance.Finance;
import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import java.util.List;
import java.util.logging.*;
import Student.Student;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.bson.Document;
import rmi.CourseInterface;
import rmi.EmployeeInterface;
import rmi.FacultyInterface;

import rmi.user;

/**
 *
 * @author ahmedwaleed
 */
public class DBConnect extends UnicastRemoteObject {

    private MongoClient client;
    private MongoDatabase database;

    private MongoCollection<Document> collection;

    private MongoCollection<Document> StudentsCollection;
    private MongoCollection<Document> EmployeesCollection;
    private MongoCollection<Document> CoursesCollection;
    private MongoCollection<Document> facultiesCollection;
    private MongoCollection<Document> AdminCollection;
    private MongoCollection<Document> doctorcollection;
    private MongoCollection<Document> tacollection;
    private MongoCollection<Document> superioradmincollection;
    private MongoCollection<Document> financecollection;
    private Gson gson = new Gson();

    //ConnectionString connectionString = new ConnectionString("mongodb://admin:<password>@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority");
    public DBConnect() throws RemoteException {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient(new MongoClientURI("mongodb://admin:jl6fIl0vxg1oyuME@ac-tm8fwxy-shard-00-00.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-01.bnsnciy.mongodb.net:27017,ac-tm8fwxy-shard-00-02.bnsnciy.mongodb.net:27017/?ssl=true&replicaSet=atlas-117fq2-shard-0&authSource=admin&retryWrites=true&w=majority"));
        database = client.getDatabase("UniversityManagementSystem"); // Database name
        collection = database.getCollection("Depertmant"); // Collection name

        AdminCollection = database.getCollection("Admin");
        StudentsCollection = database.getCollection("Student");
        EmployeesCollection = database.getCollection("Employee");
        CoursesCollection = database.getCollection("Course");
        facultiesCollection = database.getCollection("Faculty");
        doctorcollection = database.getCollection("Doctor");
        tacollection = database.getCollection("TA");
        superioradmincollection = database.getCollection("SuperiorAdmin");
        financecollection = database.getCollection("Finance");

    }

    public user Login(String email, String Password, String userType) {

        switch (userType) {
            case "Student":
                Document student = StudentsCollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (student == null) {
                    return null;
                }
                System.out.println(gson.fromJson(student.toJson(), Student.class));
                Student studentresult = gson.fromJson(student.toJson(), Student.class);

                return studentresult;

            case "Doctor":
                Document doctor = doctorcollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (doctor == null) {
                    return null;
                }
                Doctor doctorresult = gson.fromJson(doctor.toJson(), Doctor.class);
                return doctorresult;
            case "Admin":
                Document adminn = AdminCollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                //System.out.println(adminn); 
                if (adminn == null) {
                    return null;
                }

                Admin adminresult = gson.fromJson(adminn.toJson(), Admin.class);
                //System.out.println(adminresult);
                return adminresult;
            case "TA":
                Document ta = tacollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (ta == null) {
                    return null;
                }
                TA taresult = gson.fromJson(ta.toJson(), TA.class);
                return taresult;
            case "Superior Admin":
                Document superioradmin = superioradmincollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (superioradmin == null) {
                    return null;
                }
                SuperiorAdmin superiorresult = gson.fromJson(superioradmin.toJson(), SuperiorAdmin.class);
                return superiorresult;
            case "Finance":
                Document finance = financecollection.find(Filters.and(Filters.eq("Email", email), Filters.eq("Password", Password))).first();
                if (finance == null) {
                    return null;
                }
                Finance financeresult = gson.fromJson(finance.toJson(), Finance.class);
                return financeresult;
            default:
                break;
        }
        return null;
    }

    public MongoDatabase getDatabase() throws RemoteException {
        return database;
    }

    public void SignUpStudent(Student s) throws RemoteException {
        StudentsCollection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student Inserted Succesfully");
    }

    public void UpdateStudent(Student s) throws RemoteException {
        Document doc = Document.parse(gson.toJson(s));
        StudentsCollection.replaceOne(Filters.eq("StudentID", s.getStudentID()), doc);
    }

    public void DeleteStudent(Student s) throws RemoteException {
        StudentsCollection.deleteOne(Filters.eq("StudentID", s.getStudentID()));
    }

    public Employee getEmployee(String email, String password, String EmployeeType) throws RemoteException {
        Document employee = EmployeesCollection.find(Filters.eq("email", email)).first();
        Employee result = gson.fromJson(employee.toJson(), Employee.class);
        if (result.getPassword() == password && result.getEmployeeType() == EmployeeType) {
            return result;
        } else {
            return null;
        }
    }

    public Course getCourse(int Course) throws RemoteException {
        Document course = CoursesCollection.find(Filters.eq("CourseID", Course)).first();
        Course result = gson.fromJson(course.toJson(), Course.class);
        return result;
    }

    public ArrayList<Student> getStudents() throws RemoteException {
        ArrayList<Document> students = StudentsCollection.find().into(new ArrayList<>());
        ArrayList<Student> finalList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student result = gson.fromJson(students.get(i).toJson(), Student.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }

    public ArrayList<Employee> getTAs() throws RemoteException {
        ArrayList<Document> tas = tacollection.find().into(new ArrayList<>());
        ArrayList<Employee> finalList = new ArrayList<>();

        for (int i = 0; i < tas.size(); i++) {
            TA result = gson.fromJson(tas.get(i).toJson(), TA.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }

    public ArrayList<Employee> getAdmins() throws RemoteException {
        ArrayList<Document> admins = AdminCollection.find().into(new ArrayList<>());
        ArrayList<Employee> finalList = new ArrayList<>();

        for (int i = 0; i < admins.size(); i++) {
            Admin result = gson.fromJson(admins.get(i).toJson(), Admin.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }

    public ArrayList<FacultyInterface> getFaculties() throws RemoteException {
        ArrayList<Document> faculties = facultiesCollection.find().into(new ArrayList<>());
        ArrayList<FacultyInterface> finalList = new ArrayList<>();

        for (int i = 0; i < faculties.size(); i++) {
            FacultyInterface result = gson.fromJson(faculties.get(i).toJson(), Faculty.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }
    
        public ArrayList<CourseInterface> getCourses() throws RemoteException {
        ArrayList<Document> courses = CoursesCollection.find().into(new ArrayList<>());
        ArrayList<CourseInterface> finalList = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            CourseInterface result = gson.fromJson(courses.get(i).toJson(), Course.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }


//     public ArrayList<Material> getMaterialbyCourseID(int courseID) {
//        ArrayList<Material> result = new ArrayList();
//        ArrayList<Document> docs = courseCollection.find(Filters.eq("CourseID", courseID)).into(new ArrayList<>());
//          //System.out.println(docs);
//        for (int i = 0; i < docs.size(); i++) {
//            String jsonResult = docs.get(i).toJson();
//            result.add(gson.fromJson(jsonResult, Material.class));
////            System.out.println(result);
//        }
//          System.out.println(result);
//        return result;
//    }
    public ArrayList<Employee> getDoctors() throws RemoteException {
        ArrayList<Document> doctors = doctorcollection.find().into(new ArrayList<>());
        //System.out.println(doctors);
        ArrayList<Employee> finalList = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor result = gson.fromJson(doctors.get(i).toJson(), Doctor.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }

//    public ArrayList<Faculty> getFaculties() throws RemoteException {
//        ArrayList<Document> facs = (ArrayList<Document>) facultiesCollection.find();
//        ArrayList<Faculty> finalFacs = new ArrayList<>();
//        for (int i = 0; i < facs.size(); i++) {
//            Faculty result = gson.fromJson(facs.get(i).toJson(), Faculty.class);
//            finalFacs.add(result);
//        }
//        return finalFacs;
//    }


    public ArrayList<Employee> getSuperiorAdmins() throws RemoteException {
        ArrayList<Document> superioradmins = superioradmincollection.find().into(new ArrayList<>());
        //System.out.println(doctors);
        ArrayList<Employee> finalList = new ArrayList<>();
        for (int i = 0; i < superioradmins.size(); i++) {
            Doctor result = gson.fromJson(superioradmins.get(i).toJson(), Doctor.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }

   public ArrayList<Employee> getFinanciers() throws RemoteException {
        ArrayList<Document> finance = financecollection.find().into(new ArrayList<>());
        ArrayList<Employee> finalList = new ArrayList<>();

        for (int i = 0; i < finance.size(); i++) {
            Finance result = gson.fromJson(finance.get(i).toJson(), Finance.class);
            System.out.println(result.toString());
            finalList.add(result);
        }
        return finalList;
    }




    public void close() throws RemoteException {
        client.close();
    }

}
