/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiply.strings;

import java.math.BigInteger;

/**
 *
 * @author wimukthirajapaksha
 */
public class MultiplyStrings {

    /**
     * @param args the command line arguments
     */
    
    public String multiply(String num1, String num2) {
        for(int i=num2.length()-1; i>=0; i--) {
            int r=num2.length()-1-i;
            for(int j=num1.length()-1-r; j)
        }
        return b1.multiply(b2).toString();
    }
    
    public static void main(String[] args) {
        MultiplyStrings m=new MultiplyStrings();
        System.out.println(m.multiply("123", "456"));
    }
}
