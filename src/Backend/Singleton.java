/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;


/**
 *
 * @author EllieKat
 */
public class Singleton {
    private static Singleton singleton = null;
    private static AdminRegistry admin = null;
    private static InstructorRegistry inst = null;
    private static StudentRegistry stu = null;
    
    private Singleton() {
        admin = new AdminRegistry();
        inst = new InstructorRegistry();
        stu = new StudentRegistry();
    }
    
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
    
    public static AdminRegistry getAdminRegInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        if (admin == null) {
            admin = new AdminRegistry();
        }
        return admin;
    }
    
    public static InstructorRegistry getInstructorRegInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        if (inst == null) {
            inst = new InstructorRegistry();
        }
        return inst;
    }
    
    public static StudentRegistry getStuRegInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        if (stu == null) {
            stu = new StudentRegistry();
        }
        return stu;
    }
}
