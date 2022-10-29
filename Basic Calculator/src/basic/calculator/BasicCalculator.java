/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BasicCalculator {

    /**
     * @param args the command line arguments
     */
    
    public int calculate(String s) {
        return calc(s, 0, false);
    }
    
    public int calc(String s, int i, boolean nega) {
//        if(i==s.length()) return 0;
//        if(s.charAt(i)==' ') {
//            return calc(s, i+1, nega);
//        } else if(s.charAt(i)>='0' && s.charAt(i)<='9') {
//            int t=0;
//            while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
//                t=(t*10)+s.charAt(i)-'0';
//                i++;
//            }
//            return nega ? -t+calc(s, i, false) : t+calc(s, i, false);
//        } else if(s.charAt(i)=='+') {
//            return calc(s, i+1, false);
//        } else if(s.charAt(i)=='-') {
//            return calc(s, i+1, true);
//        } else {
//            return nega ? -calc(s, i+1, false) : calc(s, i+1, false);
//        }
        return 0;
    }
    
    public static void main(String[] args) {
        BasicCalculator b=new BasicCalculator();
        System.out.println(b.calculate("1+1"));
        System.out.println(b.calculate("1 + 1"));
        System.out.println(b.calculate("2-1+2"));
        System.out.println(b.calculate(" 2-1 + 2 "));
        System.out.println(b.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(b.calculate("- (3 + (4 + 5))"));
    }
}

