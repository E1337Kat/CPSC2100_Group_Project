/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * A class that creates CourseCatalog objects
 * @author Will
 */
public class CourseCatalog implements Registry{
    ArrayList<Course> courses = new ArrayList<Course>();
    //initializing ArrayList of courses
    
    private static CourseCatalog catalog = null;
    
    private CourseCatalog(){
        
    }
    
    public static CourseCatalog getCourseCatalogInstance(){
        if(catalog == null){
            catalog = new CourseCatalog();
        }
        return catalog;
    }
    
    public void writeFile(){
        //use write function from user class to write courses
        //instead in user class store courses as just CRN and use this
        //class to add the full course to the user's schedule
        try {
            PrintWriter writer = new PrintWriter("Course-Reg.txt");
            
            for(Course c : this.courses){
                writer.println(c.toString());
            }
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void readFile(){
        //read in courses from text file
        ClassLoader cl = getClass().getClassLoader();
        String fileName = File.separator + "DBPackage" + File.separator + "Course-Reg.txt";
        //File file = new File(cl.getResource(fileName).getFile());
        String line = null;
        try {
            InputStream fR = getClass().getResourceAsStream(fileName);
            BufferedReader bR = new BufferedReader(new InputStreamReader(fR));
            while((line = bR.readLine()) != null){
                Scanner reader = new Scanner(line).useDelimiter("]");
                while(reader.hasNext()){
                    String course = reader.next();
                    Scanner courseReader = new Scanner(course).useDelimiter(",");
                        //This delim goes through all the info for each course
                        String courseName = courseReader.next();
                        courseName = courseName.replace("[", "");
                        //taking out the first [ char
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
                        this.addCourseToCatalog(newCourse);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
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
    
    public Course getCourseByCRN(int crn){
        for(Course c : this.courses){
            if(c.getCRN() == crn){
                return c;
            }
        }
        return null;
    }
}
