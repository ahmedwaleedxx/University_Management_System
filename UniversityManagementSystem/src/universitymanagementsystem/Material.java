/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymanagementsystem;

import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.MaterialInterface;
import Student.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author ahmedwaleed
 */
public class Material implements MaterialInterface, ViewMaterial{

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

    @Override
    public int getID() throws RemoteException{
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getMaterialTitle() throws RemoteException{
        return MaterialTitle;
    }

    public void setMaterialTitle(String MaterialTitle) {
        this.MaterialTitle = MaterialTitle;
    }

    @Override
    public boolean isMaterialVisibility() throws RemoteException{
        return MaterialVisibility;
    }

    public void setMaterialVisibility(boolean MaterialVisibility) {
        this.MaterialVisibility = MaterialVisibility;
    }

    @Override
    public int getCourseID() throws RemoteException{
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    @Override
    public void changeMaterialVisibility(Boolean newVisibility) throws RemoteException{
        this.MaterialVisibility= newVisibility;
    }

    public void changeMaterialFileUrl(String newUrl) {

    }

    @Override
    public void changeMaterialTitle(String title) throws RemoteException{
        this.MaterialTitle = title;
    }
    
    

    
    
    

    public void registerObserv(Observer o) {

    }

    public void notifyObservers(Observer o) {

    }

    public void removeObserv(Observer o) {

    }

    @Override
  public ArrayList<Material>getMaterials(int courseID){
//      ArrayList<Material>result = new ArrayList();
//      ArrayList<Document>docs ;//= collection.find(Filters.eq("CourseID", courseID)).into(new ArrayList<Document>());
//      
//      for (int i = 0; i < docs.size(); i++) {
//            String jsonResult = docs.get(i).toJson();
//            result.add(gson.fromJson(jsonResult, Material.class));
//        }
//        return result;
//      
return null;
  }

}
