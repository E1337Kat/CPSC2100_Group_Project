/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.lang.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Will Steed
 */
public class checkBoxTable extends JPanel {
    
// Variables declaration
    private static final String EMPTY_STRING = "";
    private ArrayList<String> colHeadings = new ArrayList();
    private String col1;
    private String col2;
    private String col3;
    private String col4;
    private String col5;
    
    private JScrollPane scrollPane;
    private JTable customTable;
    // End of variables declaration 
    
    /**
     * Creates new form CourseList
     */
    public checkBoxTable() {
        colHeadings.add("CRN");
        colHeadings.add("Title");
        colHeadings.add("Class");
        colHeadings.add("Time");
        colHeadings.add("Place");
        initComponents(0);
    }
    
    public checkBoxTable(String col1) {
        colHeadings.add(col1);
        initComponents(1);
    }
    
    public checkBoxTable(String col1, String col2) {
        colHeadings.add(col1);
        colHeadings.add(col2);
        initComponents(2);
    }
    
    public checkBoxTable(String col1, String col2, String col3) {
        colHeadings.add(col1);
        colHeadings.add(col2);
        colHeadings.add(col3);
        initComponents(3);
    }
    
    public checkBoxTable(String col1, String col2, String col3, String col4) {
        colHeadings.add(col1);
        colHeadings.add(col2);
        colHeadings.add(col3);
        colHeadings.add(col4);
        initComponents(4);
    }
    
    public checkBoxTable(String col1, String col2, String col3, String col4, String col5) {
        colHeadings.add(col1);
        colHeadings.add(col2);
        colHeadings.add(col3);
        colHeadings.add(col4);
        colHeadings.add(col5);
        initComponents(5);
    }

   
    private JTable set1colModel(JTable cTable) {
        cTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                EMPTY_STRING, colHeadings.get(0)
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        return cTable;
    }
    private JTable set2colModel(JTable cTable) {
        cTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                EMPTY_STRING, colHeadings.get(0), colHeadings.get(1)
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        return cTable;
    }
    private JTable set3colModel(JTable cTable) {
        cTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                EMPTY_STRING, colHeadings.get(0), colHeadings.get(1), colHeadings.get(2)
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, Object.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        return cTable;
    }
    
    private JTable set4colModel(JTable cTable) {
        cTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                EMPTY_STRING, colHeadings.get(0), colHeadings.get(1), colHeadings.get(2), colHeadings.get(3)
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        return cTable;
    }
    private JTable set5colModel(JTable cTable) {
        cTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                EMPTY_STRING, colHeadings.get(0), colHeadings.get(1), colHeadings.get(2), colHeadings.get(3), colHeadings.get(4)
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        return cTable;
    }
    
    @SuppressWarnings("unchecked")                        
    private void initComponents(int colNum) {

        scrollPane = new JScrollPane();
        customTable = new JTable();
        

        switch (colNum) {
            case 0:
                set5colModel(customTable);
                break;
            case 1:
                set1colModel(customTable);
                break;
            case 2:
                set2colModel(customTable);
                break;
            case 3:
                set3colModel(customTable);
                break;
            case 4:
                set4colModel(customTable);
                break;
            case 5:
                set5colModel(customTable);
                break;
            default:
                throw new UnsupportedOperationException("Invalid Table Creation.");
        }
        
        scrollPane.setViewportView(customTable);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        //jButton1.setText("Register");

        //jLabel1.setText("Available Classes");

        //jButton2.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jButton1)
                .addGap(18, 18, 18)
                //.addComponent(jButton2)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                //.addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    //.addComponent(jButton1)
                    //.addComponent(jButton2)
                )
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        setOpaque(false);
    }        
}
