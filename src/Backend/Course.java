/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.util.ArrayList;
/**
 * A class that creates course objects
 * @author Will
 */
public class Course {
    private String name;
    private String description;
    private String days;
    private int startTime;
    private int endTime;
    private String location;
    private String department;
    private int crn;
    private int studentsEnrolled;
    private int maxStudentsAllowed;
    //initializing instance variables
    
    
    /**
     * Constructor method for the Course class
     * (Used for making brand new courses)
     * @param courseName the name of the course
     * @param courseDescription the description of the course
     * @param courseDays the days the course is on
     * @param courseStartTime the start time of the course
     * @param courseEndTime the end time of the course
     * @param courseLoc the location of the course
     * @param courseDept the department of the course
     * @param courseCRN the CourseRegistrationNumber of the course
     * @param maxStudents the max students allowed in the course
     */
    public Course(String courseName, String courseDescription, String courseDays, int courseStartTime, 
            int courseEndTime, String courseLoc, String courseDept, int courseCRN, int maxStudents){
        name = courseName;
        description = courseDescription;
        days = courseDays;
        startTime = courseStartTime;
        endTime = courseEndTime;
        location = courseLoc;
        department = courseDept;
        crn = courseCRN;
        studentsEnrolled = 0;
        maxStudentsAllowed = maxStudents;
    }
    
    
    /**
     * Alternate constructor method for the Course class
     * (Used for reading in courses from the registry)
     * @param cN the name of the course
     * @param cD the description of the course
     * @param cDS the days the course is on
     * @param cST the start time of the course
     * @param cET the end time of the course
     * @param cL the location of the course
     * @param cDP the department of the course
     * @param cCRN the CourseRegistrationNumber of the course
     * @param sE the current students enrolled in the course
     * @param mS the maximum students allowed in the course
     */
    public Course(String cN, String cD, String cDS, int cST, int cET, String cL, String cDP, int cCRN,int sE,int mS){
        name = cN;
        description = cD;
        days = cDS;
        startTime = cST;
        endTime = cET;
        location = cL;
        department = cDP;
        crn = cCRN;
        studentsEnrolled = sE;
        maxStudentsAllowed = mS;
        
    }
    /**
     * Method to get the name of the course
     * @return name the name of the course
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to set the name of a course
     * @param newName the new name of the course
     */
    public void setName(String newName){
        this.name = newName;
    }
    /**
     * Method to get the description of the course
     * @return description the description of the course
     */
    public String getDescription(){
        return this.description;
    }
    /**
     * Method to set the description of the course
     * @param newDescr the new description of the course
     */
    public void setDescription(String newDescr){
        this.description = newDescr;
    }
    /**
     * Method to get the days the course is on
     * @return days the days the course is on
     */
    public String getDays(){
        return this.days;
    }
    /**
     * Method to set the new days that the course is on
     * @param newDays the new days for the course
     */
    public void setDays(String newDays){
        this.days = newDays;
    }
    /**
     * Method to get the start time for the course
     * @return startTime the start time for the course
     */
    public int getStartTime(){
        return this.startTime;
    }
    /**
     * Method to set a new start time for the course
     * @param newTime the new start time for the course
     */
    public void setStartTime(int newTime){
        this.startTime = newTime;
    }
    /**
     * Method to get the end time for the course
     * @return endTime the end time of the course
     */
    public int getEndTime(){
        return this.endTime;
    }
    /**
     * Method to set a new end time for the course
     * @param newTime the new end time for the course
     */
    public void setEndTime(int newTime){
        this.endTime = newTime;
    }
    /**
     * Method to get the Course time as a String. Format: startTime-endTime
     * @return String the time of the course
     */
    public String getTimeAsString(){
        return this.getStartTime() + "-" + this.getEndTime();
    }
    /**
     * Method to get the location of the course
     * @return location the location of the course
     */
    public String getLocation(){
        return this.location;
    }
    /**
     * Method to set a new location for the course
     * @param newLoc the new location of the course
     */
    public void setLocation(String newLoc){
        this.location = newLoc;
    }
    /**
     * Method to get the department of the course
     * @return department the department of the course
     */
    public String getDepartment(){
        return this.department;
    }
    /**
     * Method to set a new department of the course
     * @param newDept the new department of the course
     */
    public void setDepartment(String newDept){
        this.department = newDept;
    }
    /**
     * Method to get the CourseRegistrationNumber for the course
     * @return crn the CourseRegistrationNumber for the course
     */
    public int getCRN(){
        return this.crn;
    }
    /**
     * Method to set a new CRN for the course
     * @param newCRN the new CRN for the course
     */
    public void setCRN(int newCRN){
        this.crn = newCRN;
    }
    /**
     * Method to get the number of students enrolled in the course
     * @return studentsEnrolled the number of students currently enrolled
     */
    public int getStudentsEnrolled(){
        return this.studentsEnrolled;
    }
    /**
     * Method to get the max number of students that can be enrolled
     * @return maxStudentsAllowed the maximum number of students allowed to be enrolled
     */
    public int getMaxStudentsAllowed(){
        return this.maxStudentsAllowed;
    }
    
    /**
     * Method to add a student to the course
     * @return boolean true if successful, false if there is no room
     */
    public boolean studentAdded(){
        if(this.getStudentsEnrolled() < this.getMaxStudentsAllowed()){
            this.studentsEnrolled += 1;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method to drop a student from the class
     */
    public void studentDropped(){
        this.studentsEnrolled -= 1;
    }
    /**
     * Method to convert a course object to a string
     * @return string the string of the course object
     */
    public String toString(){
        
        return "[" + this.getName() + "," + this.getDescription() + "," + this.getDays() + "," + this.getStartTime() + ","
                + this.getEndTime() + "," + this.getLocation() + "," + this.getDepartment()
                + "," + this.getCRN() + "," + this.getStudentsEnrolled() + "," + this.getMaxStudentsAllowed() + "]";
    }
}