/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

/**
 *
 * @author ahmedwaleed
 */
public class Material {

    private int ID;
    private String MaterialTitle;
    private boolean MaterialVisibility;
    private int CourseID;
  

    public Material(int ID, String MaterialTitle, boolean MaterialVisibility, int CourseID) {
        this.ID = ID;
        this.MaterialTitle = MaterialTitle;
        this.MaterialVisibility = MaterialVisibility;
        this.CourseID = CourseID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaterialTitle() {
        return MaterialTitle;
    }

    public void setMaterialTitle(String MaterialTitle) {
        this.MaterialTitle = MaterialTitle;
    }

    public boolean isMaterialVisibility() {
        return MaterialVisibility;
    }

    public void setMaterialVisibility(boolean MaterialVisibility) {
        this.MaterialVisibility = MaterialVisibility;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void changeMaterialVisibility(Boolean newVisibility) {
        this.MaterialVisibility= newVisibility;
    }

    public void changeMaterialFileUrl(String newUrl) {

    }

    public void changeMaterialTitle(String title) {
        this.MaterialTitle = title;
    }
    
    

    public void registerObserv(Observer o) {

    }

    public void notifyObservers(Observer o) {

    }

    public void removeObserv(Observer o) {

    }
}
