/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import Backend.AdminRegistry;
import Backend.InstructorRegistry;
import Backend.StudentRegistry;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;


/**
 *
 * @author EMCS306
 */
public class MainWindow extends javax.swing.JFrame {

    public AdminRegistry adminReg = new AdminRegistry() ;
    public InstructorRegistry instructorReg = new InstructorRegistry() ;
    public StudentRegistry stuReg = new StudentRegistry() ;
    public ImageIcon img = new ImageIcon("G:\\Users\\Ellie\\Documents\\College\\Senior 2\\CPSC 2100\\GP2\\CourseRegistrationSystem\\res\\poo.png");
    public String username;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        
        setIconImage(img.getImage());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        try {
            student_welcome = new StudentPanel_Welcome();
            studentPane = new StudentPanel();
            InstructorPane = new InstructorPanel();
            AdminPane = new AdminPanel();
        } catch (IOException e1)
        {
            System.out.println("Exception thrown  :" + e1);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentPane.setLayout(new java.awt.BorderLayout());

        if ( adminReg.isAdmin(username) || stuReg.isStudent(username)  ) {

            jTabbedPane5.addTab("Student", studentPane);
        }

        jTabbedPane5.addTab("Bullshit", student_welcome);
        studentPane.getAccessibleContext().setAccessibleName("");
        student_welcome.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout InstructorPaneLayout = new javax.swing.GroupLayout(InstructorPane);
        InstructorPane.setLayout(InstructorPaneLayout);
        InstructorPaneLayout.setHorizontalGroup(
            InstructorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        InstructorPaneLayout.setVerticalGroup(
            InstructorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        if ( adminReg.isAdmin(username) || instructorReg.isInstructor(username) ) {

            jTabbedPane5.addTab("Teacher", InstructorPane);
        }
        InstructorPane.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout AdminPaneLayout = new javax.swing.GroupLayout(AdminPane);
        AdminPane.setLayout(AdminPaneLayout);
        AdminPaneLayout.setHorizontalGroup(
            AdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        AdminPaneLayout.setVerticalGroup(
            AdminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        if (adminReg.isAdmin(username)) {

            jTabbedPane5.addTab("Administrator", AdminPane);
        }
        AdminPane.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminPane;
    private javax.swing.JPanel InstructorPane;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JPanel studentPane;
    private javax.swing.JPanel student_welcome;
    // End of variables declaration//GEN-END:variables
}
