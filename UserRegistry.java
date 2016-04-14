/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Will
 */
public class UserRegistry {
    
    ArrayList<User> users = new ArrayList<User>();
    
    public void readFile(){
        String fileName = "User-Reg.txt";
        String line = null;
        try {
            FileReader fR = new FileReader(fileName);
            BufferedReader bR = new BufferedReader(fR);
            while((line = bR.readLine()) != null){
                Scanner reader = new Scanner(line).useDelimiter("\t");
                String firstName = reader.next();
                String lastName = reader.next();
                String username = reader.next();
                String password = reader.next();
                String email = reader.next();
                Boolean isSt = reader.nextBoolean();
                Boolean isIn = reader.nextBoolean();
                Boolean isAd = reader.nextBoolean();
                Schedule sc = new Schedule();
                if(reader.hasNext()){
                    String sched = reader.next();
                    Scanner schedReader = new Scanner(sched).useDelimiter("]");
                    while(schedReader.hasNext()){
                        String course = schedReader.next();
                        
                        Scanner courseReader = new Scanner(course).useDelimiter(",");
                        String courseName = courseReader.next();
                        courseName = courseName.replace("[", "");
                        String courseDesc = courseReader.next();
                        String courseDays = courseReader.next();
                        int courseStart = courseReader.nextInt();
                        int courseEnd = courseReader.nextInt();
                        String courseLoc = courseReader.next();
                        String courseDept = courseReader.next();
                        int courseCRN = courseReader.nextInt();
                        int studentsEnrolled = courseReader.nextInt();
                        int maxStudents = courseReader.nextInt();
                        Course newCourse = new Course(courseName, courseDesc, courseDays, courseStart,
                        courseEnd, courseLoc, courseDept, courseCRN, studentsEnrolled, maxStudents);
                        sc.addCourse(newCourse);
                    }
                }
                if(reader.hasNext()){
                    String fees = reader.next();
                    Scanner feeReader = new Scanner(fees).useDelimiter("}");
                    ArrayList<Fee> aUsersFees = new ArrayList<Fee>();
                    while(feeReader.hasNext()){
                        String fee = feeReader.next();
                        fee = fee.replace("{", "");
                        Scanner feeInfoReader = new Scanner(fee);
                        Double amount = feeInfoReader.nextDouble();
                        String desc = feeInfoReader.next();
                        aUsersFees.add(new Fee(amount,desc));
                    }
                    User userRead = new User(firstName, lastName, username, password, email,
                        isSt, isIn, isAd, sc);
                    userRead.addAllFees(aUsersFees);
                    this.addUser(userRead);
                    
                } else {
                    this.addUser(new User(firstName, lastName, username, password, email, 
                        isSt, isIn, isAd, sc));
                }
                
            }
            
            bR.close();
            fR.close();
        } catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    public void writeFile(){
        try{
            PrintWriter writer = new PrintWriter("User-Reg.txt");
            for(User u : this.users){
                String firstName = u.getFirstName();
                String lastName = u.getLastName();
                String username = u.getUsername();
                String password = u.getPassword();
                String email = u.getEmail();
                Boolean isSt = u.studentStatus();
                Boolean isIn = u.instructorStatus();
                Boolean isAd = u.adminStatus();
                String sched = u.printSchedule();
                if(u.hasFees()){
                    String fees = u.printFees();
                    writer.println(firstName + "\t" + lastName + "\t" + username + "\t" + password + "\t" + email + "\t" + isSt + 
                        "\t" + isIn + "\t" + isAd + "\t" + sched + "\t" + fees);
                }else {
                    writer.println(firstName + "\t" + lastName + "\t" + username + "\t" + password + "\t" + email + "\t" + isSt + 
                        "\t" + isIn + "\t" + isAd + "\t" + sched);
                }
            
            }
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean checkLogin(String user, String pass){
        for(User u : this.users){
            if(u.getUsername().equals(user)){
                if(u.getPassword().equals(pass)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    public User getUser(String user, String pass){
        for(User u : this.users){
            if(u.getUsername().equals(user)){
                if(u.getPassword().equals(pass)){
                    return u;
                }
            }
        }
        return null;
    }
    
    public void addUser(User u){
        this.users.add(u);
    }
    
    public void overwriteUser(User u){
        for(User aUser : this.users){
            if(u.getUsername().equals(aUser.getUsername())){
                int x = this.users.indexOf(aUser);
                this.users.set(x, u);
                break;
            }
        }
    }
    
    public void removeUser(User u){
        this.users.remove(u);
    }
    
    public ArrayList getListOfUsers(){
        return this.users;
    }
}