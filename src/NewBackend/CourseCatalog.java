/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;
import java.util.ArrayList;
/**
 * A class that creates CourseCatalog objects
 * @author Will
 */
public class CourseCatalog {
    ArrayList<Course> courses = new ArrayList<Course>();
    //initializing ArrayList of courses
    
    public void writeFile(){
        //use write function from user class to write courses
        //instead in user class store courses as just CRN and use this
        //class to add the full course to the user's schedule
    }
    
    public void readFile(){
        //read in courses from text file
    }
    /**
     * Method to add a course to the catalog
     * @param c the course to be added
     */
    public void addCourseToCatalog(Course c){
        this.courses.add(c);
    }
    /**
     * Method to remove a course from the catalog
     * @param c the course to be removed
     */
    public void removeCourseFromCatalog(Course c){
        this.courses.remove(c);
    }
    /**
     * Method to get the entire course catalog ArrayList
     * @return courses the ArrayList of the courses in the CourseCatalog
     */
    public ArrayList<Course> getCourseCatalogArray(){
        return this.courses;
    }
}
