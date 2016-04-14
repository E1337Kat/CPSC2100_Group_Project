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
    
    public void setFirstName(String newName){
        this.firstName = newName;
    }
    
    public void setLastName(String newName){
        this.lastName = newName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setPassword(String newPass){
        this.password = newPass;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUsername(String newUserName){
        this.username = newUserName;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setInstructorStatus(Boolean bool){
        this.isInstructor = bool;
    }
    
    public Boolean instructorStatus(){
        return this.isInstructor;
    }
    
    public void setStudentStatus(Boolean bool){
        this.isStudent = bool;
    }
    
    public Boolean studentStatus(){
        return this.isStudent;
    }
    
    public void setAdminStatus(Boolean bool){
        this.isAdmin = bool;
    }
    
    public Boolean adminStatus(){
        return this.isAdmin;
    }
    
    public ArrayList getSchedule(){
        return this.s.getSchedule();
    }
    
    public void addFee(Fee f){
        this.fees.add(f);
    }
    
    public void removeFee(Fee f){
        this.fees.remove(f);
    }
    
    public String printFees(){
        String ret = "";
        for(Fee f : this.fees){
            ret = ret + f.toString();
        }
        return ret;
    }
    
    public boolean hasFees(){
        if(this.fees.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    
    public void addAllFees(ArrayList<Fee> f){
        this.fees = f;
    }
    
    public String printSchedule(){
        return this.s.toString();
    }
}
