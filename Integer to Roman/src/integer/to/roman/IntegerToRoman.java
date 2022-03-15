/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integer.to.roman;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntegerToRoman {

    /**
     * @param args the command line arguments
     */
    
    public String intToRoman(int num) {
        String[] arr=new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] l=new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; num>0; i++) {
            while(num>=l[i]) {
                sb.append(arr[i]);
                num-=l[i];
            }
        }
        return sb.toString();
    }
    
    
//    -------------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public String intToRoman(int num) {
//        String[] arr=new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int[] l=new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        
//        StringBuilder sb=new StringBuilder();
//        int c=0;
//        while(num>0) {
//            for(int i=c; i<l.length; i++) {
//                if(l[i]<=num) {
//                    sb.append(arr[i]);
//                    num-=l[i];
//                    c=i;
//                    break;
//                }
//            }
//        }
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        IntegerToRoman i=new IntegerToRoman();
        System.out.println(i.intToRoman(1994));
    }
}
