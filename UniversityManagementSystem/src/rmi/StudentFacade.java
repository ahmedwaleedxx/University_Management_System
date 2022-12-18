/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import Student.Student;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author infolos
 */
public class StudentFacade extends UnicastRemoteObject implements StudentFacadeInterface {

    Student student;

    public StudentFacade() throws RemoteException {
        this.student = new Student();
    }

    
    @Override
    public void setStudent(int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty) throws RemoteException {
        student.setEmail(Email);
        student.setFaculty(Faculty);
        student.setIsGraduated(isGraduated);
        student.setPaidTutionFees(paidTutionFees);
        student.setStudentID(StudentID);
        student.setMajor(Major);
        student.setPassword(Password);
        student.setStudentFName(StudentFName);
        student.setStudentLName(StudentLName);
        student.setStudentOverAllGrade(StudentOverAllGrade);
    }

    // int StudentID, String StudentFName, String StudentLName, String Email, String Password, float StudentOverAllGrade, boolean isGraduated, boolean paidTutionFees, String Major, String Faculty
    
    @Override
    public StudentDTO getStudnetDTO() throws RemoteException{
        StudentDTO s = new StudentDTO(student.getStudentID(),student.getStudentFName(),student.getStudentLName(),student.getEmail(),student.getPassword(), student.getStudentOverAllGrade(),student.isIsGraduated(),student.isPaidTutionFees(),student.getMajor(),student.getFaculty(),student.getCourses());
        return s;
   
    }
    
}
