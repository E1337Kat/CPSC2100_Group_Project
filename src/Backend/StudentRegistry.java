/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author EllieKat
 */
public class StudentRegistry implements Registry {
    ArrayList users = new ArrayList();
    
    public StudentRegistry(){
        
    }
    
    public boolean isStudent(String username) {
        
        return true;
    }
}
