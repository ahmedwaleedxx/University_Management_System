/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author ahmedwaleed
 */
public class Complaint {

    private int ComplaintID;
    private int ComplaintOwnerID;
    private String ComplaintMessage;
    private String ComplaintStatus;
    private ArrayList<String> comments;
    private String ComplaintSubject;

    public Complaint(int ComplaintID, int ComplaintOwnerID, String ComplaintMessage, String ComplaintStatus, ArrayList<String> comments, String ComplaintSubject) {
        this.ComplaintID = ComplaintID;
        this.ComplaintOwnerID = ComplaintOwnerID;
        this.ComplaintMessage = ComplaintMessage;
        this.ComplaintStatus = ComplaintStatus;
        this.comments = comments;
        this.ComplaintSubject = ComplaintSubject;
    }

    public int getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(int ComplaintID) {
        this.ComplaintID = ComplaintID;
    }

    public int getComplaintOwnerID() {
        return ComplaintOwnerID;
    }

    public void setComplaintOwnerID(int ComplaintOwnerID) {
        this.ComplaintOwnerID = ComplaintOwnerID;
    }

    public String getComplaintMessage() {
        return ComplaintMessage;
    }

    public void setComplaintMessage(String ComplaintMessage) {
        this.ComplaintMessage = ComplaintMessage;
    }

    public String getComplaintStatus() {
        return ComplaintStatus;
    }

    public void setComplaintStatus(String ComplaintStatus) {
        this.ComplaintStatus = ComplaintStatus;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getComplaintSubject() {
        return ComplaintSubject;
    }

    public void setComplaintSubject(String ComplaintSubject) {
        this.ComplaintSubject = ComplaintSubject;
    }

    public boolean AddComment(String comment) {
        return false;
    }

    public boolean CloseComplaint() {
        return false;
    }

}
