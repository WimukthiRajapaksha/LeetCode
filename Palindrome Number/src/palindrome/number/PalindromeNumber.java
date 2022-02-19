/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class PalindromeNumber {

    /**
     * @param args the command line arguments
     */
    
    public boolean isPalindrome(int x) {  
        if (x<0 || (x%10==0 && x>0)) {
            return false;
        }
        int rev=0;
        while(x>rev) {
            rev=(rev*10)+(x%10);
            x=x/10;
        }
        return rev==x || rev/10 == x;
        
        
        
//        ALTERNATE
//        if (x<0) {
//            return false;
//        }
//        String s = String.valueOf(x);
//        for (int i=0; i<s.length()/2; i++) {
//            if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
//                return false;
//            }
//        }
//        return true;
    }
    
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(0));
    }
}
