/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;
import java.util.ArrayList;
/**
 * A class to create User objects
 * @author Will
 */
public class User {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Boolean isStudent;
    private Boolean isInstructor;
    private Boolean isAdmin;
    Schedule s;
    ArrayList<Fee> fees;
    //above is initializing instance variables to be used in this class
    
    /**
     * Constructor for the User class/object
     * @param fn A user's first name
     * @param ln A user's last name
     * @param usern a user's username
     * @param pass a user's password
     * @param eM a user's email
     * @param isS boolean to check if user is a student
     * @param isI boolean to check if user is an instructor
     * @param isA boolean to check if user is an admin
     * @param sc  a schedule object to hold courses for a user
     */
    public User(String fn, String ln, String usern, String pass, String eM, Boolean isS, Boolean isI, 
            Boolean isA, Schedule sc){
        this.firstName = fn;
        this.lastName = ln;
        this.username = usern;
        this.password = pass;
        this.email = eM;
        this.isStudent = isS;
        this.isInstructor = isI;
        this.isAdmin = isA;
        this.s = sc;
    }
    /**
     * Method to change a user's first name
     * @param newName the new name of the user
     */
    public void setFirstName(String newName){
        this.firstName = newName;
    }
    /**
     * Method to change a user's last name
     * @param newName the new name of the user
     */
    public void setLastName(String newName){
        this.lastName = newName;
    }
    /**
     * Method to get the user's first name
     * @return firstName the user's first name
     */
    public String getFirstName(){
        return this.firstName;
    }
    /**
     * Method to get the user's last name
     * @return lastName the user's last name
     */
    public String getLastName(){
        return this.lastName;
    }
    /**
     * Method to change a user's password
     * @param newPass the user's new password
     */
    public void setPassword(String newPass){
        this.password = newPass;
    }
    /**
     * Method to get the user's password
     * @return password the user's password
     */
    public String getPassword(){
        return this.password;
    }
    /**
     * Method to change the user's username
     * @param newUserName the user's new username
     */
    public void setUsername(String newUserName){
        this.username = newUserName;
    }
    /**
     * Method to get the user's username
     * @return username the user's username
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * Method to change the user's email address
     * @param newEmail the new email address of the user
     */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    /**
     * Method to get the user's email address
     * @return email the user's email address
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * Method to set the Instructor status of a user
     * @param bool the new status of the user
     */
    public void setInstructorStatus(Boolean bool){
        this.isInstructor = bool;
    }
    /**
     * Method to get the Instructor status of a user
     * @return isInstructor the boolean of the Instructor status of a user
     */
    public Boolean instructorStatus(){
        return this.isInstructor;
    }
    /**
     * Method to set the Student status of a user
     * @param bool the new Student status of a user
     */
    public void setStudentStatus(Boolean bool){
        this.isStudent = bool;
    }
    /**
     * Method to get the Student status of a user
     * @return isStudent the Student status of a user
     */
    public Boolean studentStatus(){
        return this.isStudent;
    }
    /**
     * Method to set the Admin status of a user
     * @param bool the new Admin status of a user
     */
    public void setAdminStatus(Boolean bool){
        this.isAdmin = bool;
    }
    /**
     * Method to get the Admin status of a user
     * @return isAdmin the Admin status of a user
     */
    public Boolean adminStatus(){
        return this.isAdmin;
    }
    /**
     * Method to get the schedule of a user in the form of an ArrayList
     * @return s the schedule of the user
     */
    public ArrayList getSchedule(){
        return this.s.getSchedule();
    }
    /**
     * Method to get the schedule object of a user
     * @return s the schedule object
     */
    public Schedule getScheduleObject(){
        return this.s;
    }
    /**
     * Method to add a fee to a user
     * @param f a new fee to be applied
     */
    public void addFee(Fee f){
        this.fees.add(f);
    }
    /**
     * Method to remove a fee from a user
     * @param f a fee to be removed
     */
    public void removeFee(Fee f){
        this.fees.remove(f);
    }
    /**
     * Method to print the fees a user has
     * @return ret the string of all the fees a user has
     */
    public String printFees(){
        String ret = "";
        for(Fee f : this.fees){
            ret = ret + f.toString();
        }
        return ret;
    }
    /**
     * Method to check if a user has fees
     * @return boolean based on if a user has fees or not
     */
    public boolean hasFees(){
        if(this.fees.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    /**
     * Method that adds all fees from an ArrayList to a user object
     * @param f the input array of fees
     */
    public void addAllFees(ArrayList<Fee> f){
        this.fees = f;
    }
    /**
     * Method to print the schedule of a user
     * @return s the string of all courses in the user's schedule
     */
    public String printSchedule(){
        return this.s.toString();
    }
}
