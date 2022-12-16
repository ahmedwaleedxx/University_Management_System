/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

//import universitymanagementsystemclient.GUIs.SplashScreen;
import Admin.Admin;
import Doctor.Doctor;
import Employee.Employee;
import Finance.Finance;
import rmi.user;
import com.mongodb.client.MongoDatabase;
import Student.Student;
import SuperiorAdmin.SuperiorAdmin;
import TA.TA;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


// import PackageName.ClassName;
/**
 *
 * @author ahmedwaleed
 */
public class UniversityManagementSystem {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        //Calling the class for the database 
        DBConnect db = new DBConnect();

        // Here we create our remote object
        user student = new Student();
        user superior = new SuperiorAdmin();
        user admin = new Admin();
        user finance = new Finance();
        user doctor = new Doctor();
        user tas = new TA();
        user employee=new Employee();

// An RMI Registry initialized on port 1099
        Registry r = LocateRegistry.createRegistry(1099);

        // Our remote object g is binded to the name "grade"
        r.bind("database", db);
        r.bind("student", student);
        r.bind("employee", employee);
        r.bind("admin", admin);
       r.bind("doctor", doctor);
       r.bind("ta", tas);
        r.bind("finance", finance);
        r.bind("superior", superior);

        
        
        
        
        Admin a = new Admin();
        Student s1 = new Student(9, "Menna", "Waleed", "menna@gmail.com", "menna123", 0, false, true, "SE", "ICS", null, null);
        //a.RegisterStudent(s1);
        // a.DeleteStudent(s1);
        //db.getStudents();
        //db.Login("test@test.com", "testing", "Student");
//public Student(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty, ArrayList<Course> Courses, ArrayList<Observer> Observers) {

//SuperiorAdmin sa = new SuperiorAdmin(1, "Superior", "Admin", "superioradmin@wmf.edu.eg", "1234", 500, null, "CIB", "Superior Admin");
        SuperiorAdmin sa = new SuperiorAdmin();
        ArrayList<Material> materials = new ArrayList<>();

        Doctor d = new Doctor(1, "Abeer", "Hamdy", "abeerhamdy@wmf.edu.eg", "1234", 1000, null, "CIB", "Doctor", null, null);
        TA ta = new TA(5, "Meriam", "Sherif", "meriam.sherif@wmf.edu.eg", "1234", 500, null, "CIB", "TA", null);
       
         
        Material m = new Material(1, "Lecture 1", true, 1);
        materials.add(m);
         Course c = new Course(1, "AOOSE", d, null, "aoose@wmf.edu.eg", "ICS", materials);
        Faculty f = new Faculty(2, "ICS", "Omar Karam", "omar.karam@wmf.edu.eg", null);
              
//Student student = new Student(2, "Ahmed", "Waleed", "testing@test.com", "testing", 0, false, true, "SE", "ICS", null, null);
sa.AddCourse(c);
//sa.AssignTA(ta);
//sa.AssignTA(ta);
//sa.RemoveTA(ta);
//sa.UpdateDoctorInfo(d);
//sa.AddFaculty(f);
//c.AddCourseMaterial(m);
        
//sa.DeleteCourse(c);
    
    
    System.out.println("Server is ready");
    }

}
