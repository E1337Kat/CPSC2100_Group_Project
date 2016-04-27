/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Ellie Peterson, Will Steed
 */
public class CheckBoxTable extends JPanel {
    
// Variables declaration
    private DefaultTableModel tableModel;
    private String col[];
    private int colNum;
    
    private int numRow;
    private int numCol;
    private Object[][] tableData;
    private Object[][] sorterArray;
    
    private JScrollPane scrollPane;
    private JTable customTable;
    // End of variables declaration 
    
    /**
     * Creates new form CourseList
     */
    public CheckBoxTable() {
        col = new String[6];
        col[0] = "";
        col[1] = "CRN";
        col[2] = "Title";
        col[3] = "Class";
        col[4] = "Time";
        col[5] = "Place";
        
        colNum = col.length;
        initComponents();
    }
    
    /**
     * Creates new CheckBoxTable with specified columns 
     * @param inCol String array of column headers
     * @param colNum number of columns
     */
    public CheckBoxTable(String inCol[], int colNum) {
        
        col = new String[colNum+1];
        
        col[0] = "";    //first column is checkbox
        
        //Cycle through rest and add col names to object
        for (int i = 1; i <= colNum; i++) {
            this.col[i] = inCol[i-1];
        }
        this.colNum = (colNum + 1); //Add one for empty first col
        
        for (int i = 0; i < this.colNum; i++) {
            System.out.println("Log: CheckBoxTable col[" + i + "] init with value: " + this.col[i]);
        }
        initComponents();
    }
    
    /**
     * adds data to table and repaints
     * @param objs 
     */
    public void addData(Object[] objs) {
        //create new opject array with length one greater than passed value
        Object[] o = new Object[objs.length+1];
        
        //set first object to false boolean
        o[0] = false;
        
        //assign the rest of the objs to o
        for (int i = 1; i < o.length; i++) {
            o[i] = objs[i-1];
        }
        
        //add o to table
        tableModel.addRow(o);
        
        //add table to screen and display
        customTable = new JTable(tableModel);
        //tableModel.addMouseListenerToHeaderInTable(customTable);
        scrollPane.setViewportView(customTable);
        customTable.setAutoCreateRowSorter(true);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        /*
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jButton1)
                .addGap(18, 18, 18)
                //.addComponent(jButton2)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                //.addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jButton1)
                    //.addComponent(jButton2)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        */
        
        /*if (tableModel.getRowCount() > 1) {
            sortData(1);
        }*/
        
        setOpaque(false);
    }
    
    public void deleteData(int rowNum) {
        tableModel.removeRow(rowNum);
        
        customTable = new JTable(tableModel);
        //tableModel.addMouseListenerToHeaderInTable(customTable);
        scrollPane.setViewportView(customTable);
        customTable.setAutoCreateRowSorter(true);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jButton1)
                .addGap(18, 18, 18)
                //.addComponent(jButton2)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                //.addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jButton1)
                    //.addComponent(jButton2)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        
        setOpaque(false);
    }
    
    public void sortData(int colToSortBy) {

        //tableModel.sortByColumn(colToSortBy);
        /*
        if (colToSortBy <= 0) {
            this.tableData = new Object[tableModel.getRowCount()][tableModel.getColumnCount()];

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    this.tableData[i][j] = ((Vector)tableModel.getDataVector().elementAt(i)).elementAt(j);
                }
            }
            
            this.numRow = tableModel.getRowCount();
            this.numCol = tableModel.getColumnCount();

            this.sorterArray = new Object[tableModel.getRowCount()][tableModel.getColumnCount()];

            doMergeSort( colToSortBy, 0, (tableModel.getRowCount()-1) );

        }
        //tableModel.removeRow(rowNum);
        
        customTable = new JTable(tableModel);
        scrollPane.setViewportView(customTable);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jButton1)
                .addGap(18, 18, 18)
                //.addComponent(jButton2)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                //.addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jButton1)
                    //.addComponent(jButton2)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        setOpaque(false);*/
    }
    
    public int getColNum() {
        return this.tableModel.getColumnCount()-1;
    }
    
    private void doMergeSort( int colToSortBy, int low, int up ) {
        if (low < up) {
            int mid = low + (up-low) / 2;
            
            doMergeSort(colToSortBy, low, mid);
            
            doMergeSort(colToSortBy, mid +1, up);
            
            mergeParts(colToSortBy, low, mid, up);
        }
    }
    
    private void mergeParts(int colToSortBy, int low, int mid, int up) {
        for (int i = low; i <= up; i++) {
            for (int j = 0; j < numCol; j++) {
                sorterArray[i][j] = tableData[i][j];
            }
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        
        while(i <= mid && j <= up) {
            if ((sorterArray[i][colToSortBy] instanceof String) && (sorterArray[j][colToSortBy] instanceof String)) {
                if ( ( ( (String)sorterArray[i][colToSortBy] ).compareToIgnoreCase( (String)sorterArray[j][colToSortBy] ) ) >= 0) {
                    for (int m = 0; m < numCol; m++)
                        tableData[k][m] = sorterArray[i][m];
                    i++;
                } else {
                    for (int m = 0; m< numCol; m++)
                        tableData[k][m] = sorterArray[j][m];
                    j++;
                }
                k++;
            } else if ((sorterArray[i][colToSortBy] instanceof Integer) && (sorterArray[j][colToSortBy] instanceof Integer)){
                if ( ( ( (String)sorterArray[i][colToSortBy] ).compareToIgnoreCase( (String)sorterArray[j][colToSortBy] ) ) >= 0) {
                    for (int m = 0; m < numCol; m++)
                        tableData[k][m] = sorterArray[i][m];
                    i++;
                } else {
                    for (int m = 0; m< numCol; m++)
                        tableData[k][m] = sorterArray[j][m];
                    j++;
                }
                k++;
            } else {
                throw new UnsupportedOperationException("No Support provided for table sorting with Ojects that are not String or Integer: " + sorterArray[i][colToSortBy]);
            }
        }
        while (i <= mid) {
            for (int m = 0; m < numCol; m++)
                tableData[k][m] = sorterArray[i][m];
            k++;
            i++;
        }
    }
    
    public int getRows(){
        return this.tableModel.getRowCount();
    }
    
    public Object getData(int row, int col){
        return tableModel.getValueAt(row,col+1);
    }
    
    public boolean checkBoolean(int row){
        return (boolean) tableModel.getValueAt(row,0);
    }
    
    public void repaintTable(){
        customTable = new JTable(tableModel);
        //tableModel.addMouseListenerToHeaderInTable(customTable);
        scrollPane.setViewportView(customTable);
        customTable.setAutoCreateRowSorter(true);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        
        
        setOpaque(false);
    }
 
    /**
     * initializes components
     */
    private void initComponents() {
        
        scrollPane = new JScrollPane();
        
        tableModel = new GTableModel(col, 0) {
            
            @Override
            public Class getColumnClass(int columnIndex) {
                if (columnIndex == 0)
                    return Boolean.class;
                else 
                    return Object.class;
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIndex == 0)
                    return true;
                else 
                    return false;
            }
        };
        
        /*
        Object[] objs = new Object[colNum];
        
        for (int i = 0; i < colNum; i++) {
            objs[i] = null;
        }
        
        tableModel.addRow(objs);
        */
        customTable = new JTable(tableModel);
        //tableModel.addMouseListenerToHeaderInTable(customTable);
        scrollPane.setViewportView(customTable);
        if (customTable.getColumnModel().getColumnCount() > 0) {
            customTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        /*
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jButton1)
                .addGap(18, 18, 18)
                //.addComponent(jButton2)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                //.addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                //.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    //.addComponent(jButton1)
                    //.addComponent(jButton2)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
*/
        this.setLayout(new GridBagLayout());
        
        this.add(scrollPane);
            
        this.setSize(800, 200);
        
        setOpaque(false);
    }
}
