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
public class AdminRegistry implements Registry {
    ArrayList users = new ArrayList();
    
    public AdminRegistry(){
        users.add("SysAdmin");
    }
    
    public boolean isAdmin(String username) {
        
        return true;
    }
}
