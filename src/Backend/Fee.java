/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 * A class that creates Fee objects
 * @author Will
 */
public class Fee {
    private double feeAmount;
    private String feeDescription;
    //initializing instance variables
    
    /**
     * Constructor for a Fee object
     * @param amount the amount of the fee
     * @param desc a description of the fee
     */
    public Fee(double amount, String desc){
        feeAmount = amount;
        feeDescription = desc;
    }
    /**
     * Method to get the amount of a fee
     * @return feeAmount the amount of the fee
     */
    public double getAmount(){
        return this.feeAmount;
    }
    /**
     * Method to get the description of a fee
     * @return feeDescription the description of the fee
     */
    public String getDescription(){
        return this.feeDescription;
    }
    /**
     * Method to convert the info in a fee object to a string
     * @return string the amount and description of a fee enclosed in {}
     */
    public String toString(){
        return "{" + this.feeAmount + " " + this.feeDescription + "}";
    }
}
