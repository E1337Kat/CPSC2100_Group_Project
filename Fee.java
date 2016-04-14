/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;

/**
 *
 * @author Will
 */
public class Fee {
    private double feeAmount;
    private String feeDescription;
    
    public Fee(double amount, String desc){
        feeAmount = amount;
        feeDescription = desc;
    }
    
    public double getAmount(){
        return this.feeAmount;
    }
    
    public String getDescription(){
        return this.feeDescription;
    }
    
    public String toString(){
        return "{" + this.feeAmount + " " + this.feeDescription + "}";
    }
}
