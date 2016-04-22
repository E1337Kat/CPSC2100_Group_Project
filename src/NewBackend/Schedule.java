/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.util.ArrayList;
/**
 * Class to create Schedule objects
 * @author Will
 */
public class Schedule {
    ArrayList<Course> courseList = new ArrayList<Course>();
    //initializing the courseList in a schedule
    
    /**
     * Method to add a course to a schedule
     * @param c the course to be added
     */
    public void addCourse(Course c){
        this.courseList.add(c);
        c.studentAdded();
    }
    /**
     * Method to drop a course from a schedule
     * @param c the course to be dropped
     */
    public void dropCourse(Course c){
        this.courseList.remove(c);
        c.studentDropped();
    }
    /**
     * Method to get the ArrayList of courses in a schedule object
     * @return courseList the ArrayList of courses
     */
    public ArrayList<Course> getSchedule(){
        return this.courseList;
    }
    public boolean checkScheduleForCourse(Course c){
        return this.courseList.contains(c);
    }
    public String courseCRNsToString(){
        String ret = "";
        for(Course c : this.getSchedule()){
            ret =ret + c.getCRN() + ",";
        }
        return ret;
    }
    /**
     * Method to convert a schedule object to a string
     * @return ret the string of the schedule object
     */
    public String toString(){
        String ret = "";
        for(Course c : this.getSchedule()){
            ret += c.toString();
        }
        return ret;
    }
}
