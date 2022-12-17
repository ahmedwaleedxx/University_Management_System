/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.ArrayList;
import universitymanagementsystem.Material;

/**
 *
 * @author ahmedwaleed
 */
public interface ViewMaterial {

    public ArrayList<Material>getMaterials(int courseID);
}
