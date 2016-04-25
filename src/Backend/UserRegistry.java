/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle reading and writing of a data file
 * @author Will
 */
public class UserRegistry implements Registry{
    
    ArrayList<User> users = new ArrayList<User>();
    Security sec = new Security();
    //initializing ArrayList of User objects
    private static final String fileName = "User-Reg.txt";
    //ClassLoader cl = getClass().getClassLoader();
    //File file = new File(fileName);
    CourseCatalog catalog = CourseCatalog.getCourseCatalogInstance();
    private static UserRegistry userReg = null;
    
    private UserRegistry(){
        this.readFile();
    }
    
    public static UserRegistry getUserRegistryInstance(){
        if(userReg == null){
            userReg = new UserRegistry();
        }
        return userReg;
    }
    
    
    /**
     * Method that reads in information from the text file "User-Reg.txt"
     */
    public void readFile(){
        catalog.readFile();
        System.out.println("Log: User-Reg-DB located at: \n    " + fileName);
        String line = null;
        try {
            FileReader fR = new FileReader(fileName);
            BufferedReader bR = new BufferedReader(fR); 
            //wrapping FileReader in BufferedReader
            while((line = bR.readLine()) != null){
                Scanner reader = new Scanner(line).useDelimiter("\t"); 
                //using a delimiter of tab
                String firstName = reader.next();
                String lastName = reader.next();
                String username = reader.next();
                String password = reader.next();
                password = this.sec.decrypt(password, 8);
                String email = reader.next();
                Boolean isSt = reader.nextBoolean();
                Boolean isIn = reader.nextBoolean();
                Boolean isAd = reader.nextBoolean(); 
                //storing all info from text file into variables
                Schedule sc = new Schedule(); 
                //initializing schedule object
                if(reader.hasNext()){
                    String sched = reader.next();
                    Scanner schedReader = new Scanner(sched).useDelimiter("]");
                    //Another delimiter to go through each course 
                    String course = schedReader.next();
                    course = course.replace("[", "");
                    Scanner courseReader = new Scanner(course).useDelimiter(",");
                    //This delim goes through all the info for each course
                    while(courseReader.hasNext()){
                        int courseCRN = courseReader.nextInt();
                        sc.addCourse(catalog.getCourseByCRN(courseCRN));
                        
                        //Reading in all course info, creating a course, and adding it to the schedule
                        }
                    
                }
                
                if(reader.hasNext()){
                    //Checking for any fees
                    String fees = reader.next();
                    if(fees.contains("{")){
                        Scanner feeReader = new Scanner(fees).useDelimiter("}");
                        //Going through this in a similar fashion as above
                        ArrayList<Fee> aUsersFees = new ArrayList<Fee>();
                        //An ArrayList to store all of a user's fees
                        while(feeReader.hasNext()){
                            String fee = feeReader.next();
                            fee = fee.replace("{", "");
                            Scanner feeInfoReader = new Scanner(fee);
                            Double amount = feeInfoReader.nextDouble();
                            String desc = feeInfoReader.next();
                            aUsersFees.add(new Fee(amount,desc));
                            //getting the info, creating the fees, and adding them to the AL
                        }
                        User userRead = new User(firstName, lastName, username, password, email,
                            isSt, isIn, isAd, sc);
                        userRead.addAllFees(aUsersFees);
                        this.addUser(userRead);
                    //creating a user, adding the info gathered above and if the have fees
                    //add them to the user and add the user to the reg ArrayList
                    }
                } else {
                    //if the user has no fees it just creates and adds the user instead
                    this.addUser(new User(firstName, lastName, username, password, email, 
                        isSt, isIn, isAd, sc));
                }
                
            }
            
            bR.close();
            fR.close();
            //closing the BufferedReader and FileReader
        } catch (FileNotFoundException f){
            f.printStackTrace();
            //Exception handling
        }
        catch (IOException e){
            e.printStackTrace();
            //Exception handling
        }
    }
    
    
    /**
     * Method to write all necessary data to a file
     */
    public void writeFile(){
        try{
            PrintWriter writer = new PrintWriter(fileName);
            //The file to be written to
            for(User u : this.users){
                //Going through all the users in the ArrayList in UserRegistry object
                //And storing their info in instance variables
                String firstName = u.getFirstName();
                String lastName = u.getLastName();
                String username = u.getUsername();
                String password = u.getPassword();
                password = this.sec.encrypt(password, 8);
                String email = u.getEmail();
                Boolean isSt = u.studentStatus();
                Boolean isIn = u.instructorStatus();
                Boolean isAd = u.adminStatus();
                String sched = "[" + u.scheduleCRNsToString() + "]";
                if(u.hasFees()){
                    //writing all info to a file if a user has fees
                    String fees = u.printFees();
                    writer.println(firstName + "\t" + lastName + "\t" + username + "\t" + password + "\t" + email + "\t" + isSt + 
                        "\t" + isIn + "\t" + isAd + "\t" + sched + "\t" + fees);
                }else {
                    //writing all info to a file if a user does not have fees
                    writer.println(firstName + "\t" + lastName + "\t" + username + "\t" + password + "\t" + email + "\t" + isSt + 
                        "\t" + isIn + "\t" + isAd + "\t" + sched);
                }
            
            }
            writer.close();
            //closing the PrintWriter
        } catch(Exception e){
            e.printStackTrace();
            //Exception handling
        }
    }
    /**
     * Method to check if a user's login info is valid
     * @param user the username entered
     * @param pass the password entered
     * @return boolean if they match in the registry, returns true. Else, false
     */
    public boolean checkLogin(String user, String pass){
        for(User u : this.users){
            if(u.getUsername().toLowerCase().equals(user)){
                if(u.getPassword().equals(pass)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * Method to retrieve a user (To pass info if a user's login was valid
     * @param user the username of the user
     * @param pass the password of the user
     * @return User if the login was valid it returns the user object, else it returns null
     */
    public User getUser(String user){
        for(User u : this.users){
            if(u.getUsername().toLowerCase().equals(user)){
                return u;
            }
        }
        return null;
    }
    /**
     * Method to add a user to the registry
     * @param u the new user
     */
    public void addUser(User u){
        this.users.add(u);
    }
    /**
     * Method to overwrite changes made to a user outside of the registry
     * @param u the changed user
     */
    public void overwriteUser(User u){
        for(User aUser : this.users){
            if(u.getUsername().equals(aUser.getUsername())){
                int x = this.users.indexOf(aUser);
                this.users.set(x, u);
                break;
            }
        }
    }
    /**
     * Method to remove a user from the registry
     * @param u the user to remove
     */
    public void removeUser(User u){
        this.users.remove(u);
    }
    /**
     * Method to return an ArrayList of all the users in the registry
     * @return users the ArrayList of all users in reg
     */
    public ArrayList getListOfUsers(){
        return this.users;
    }
    /**
     * Method to get users that are registered in a certain course
     * @param c the course to check for users
     * @return usersInCourse an ArrayList of the users registered in course c
     */
    public ArrayList usersInCourse(Course c){
        ArrayList<User> usersInCourse = new ArrayList<>();
        for(User u : this.users){
            if(u.getScheduleObject().checkScheduleForCourse(c)){
                usersInCourse.add(u);
            }
        }
        
        return usersInCourse;
    }
}