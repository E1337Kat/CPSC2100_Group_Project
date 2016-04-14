/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;
import java.util.ArrayList;
/**
 *
 * @author Will
 */
public class CourseCatalog {
    ArrayList<Course> courses = new ArrayList<Course>();
    
    public void addCourseToCatalog(Course c){
        this.courses.add(c);
    }
    
    public void removeCourseFromCatalog(Course c){
        this.courses.remove(c);
    }
    
    public ArrayList<Course> getCourseCatalogArray(){
        return this.courses;
    }
}
