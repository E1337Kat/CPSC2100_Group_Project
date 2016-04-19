/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PossibleNewBackend;
//Source: http://www.rosettacode.org/wiki/Caesar_cipher#Java
/**
 *
 * @author Will
 */
public class Security {
    
    

    public Security(){
        
    }
    
    public String encrypt(String toBeEncrypted, int shift){
        shift = shift % 26 + 26;
        StringBuilder ret = new StringBuilder();
        for(char c : toBeEncrypted.toCharArray()){
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    ret.append((char) ('A' + (c - 'A' + shift) % 26 ));
                } else {
                    ret.append((char) ('a' + (c - 'a' + shift) % 26 ));
                }
            }
            else{
                ret.append(c);
            }
        }
        return ret.toString();
    }
    
    public String decrypt(String toBeDecrypted, int shift){
        return encrypt(toBeDecrypted, 26-shift);
    }
}
