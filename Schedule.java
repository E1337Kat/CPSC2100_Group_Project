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
public class Schedule {
    ArrayList<Course> courseList = new ArrayList<Course>();
    
    public void addCourse(Course c){
        courseList.add(c);
        c.studentAdded();
    }
    
    public void dropCourse(Course c){
        courseList.remove(c);
        c.studentDropped();
    }
    
    public ArrayList<Course> getSchedule(){
        return this.courseList;
    }
    
    public String toString(){
        String ret = "";
        for(Course c : this.getSchedule()){
            ret += c.toString();
        }
        return ret;
    }
}
