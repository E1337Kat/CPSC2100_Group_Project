/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;

/**
 *
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
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String newDescr){
        this.description = newDescr;
    }
    
    public String getDays(){
        return this.days;
    }
    
    public void setDays(String newDays){
        this.days = newDays;
    }
    
    public int getStartTime(){
        return this.startTime;
    }
    
    public void setStartTime(int newTime){
        this.startTime = newTime;
    }
    
    public int getEndTime(){
        return this.endTime;
    }
    
    public void setEndTime(int newTime){
        this.endTime = newTime;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setLocation(String newLoc){
        this.location = newLoc;
    }
    
    public String getDepartment(){
        return this.department;
    }
    
    public void setDepartment(String newDept){
        this.department = newDept;
    }
    
    public int getCRN(){
        return this.crn;
    }
    
    public void setCRN(int newCRN){
        this.crn = newCRN;
    }
    
    public int getStudentsEnrolled(){
        return this.studentsEnrolled;
    }
    
    public int getMaxStudentsAllowed(){
        return this.maxStudentsAllowed;
    }
    
    public boolean studentAdded(){
        if(this.getStudentsEnrolled() < this.getMaxStudentsAllowed()){
            this.studentsEnrolled += 1;
            return true;
        } else {
            return false;
        }
    }
    
    public void studentDropped(){
        this.studentsEnrolled -= 1;
    }
    
    public String toString(){
        
        return "[" + this.getName() + "," + this.getDescription() + "," + this.getDays() + "," + this.getStartTime() + ","
                + this.getEndTime() + "," + this.getLocation() + "," + this.getDepartment()
                + "," + this.getCRN() + "," + this.getStudentsEnrolled() + "," + this.getMaxStudentsAllowed() + "]";
    }
}