/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.vowels.of.a.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseVowelsOfAString {

    /**
     * @param args the command line arguments
     */
    
//    --------------------OPTIMAL---------------------
    private boolean isVowel(char c) {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U');
    }
    
    public String reverseVowels(String s) {
        char[] c=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            while(i<j && !this.isVowel(c[i])) {
                i++;
            }
            while(i<j && !this.isVowel(c[j])) {
                j--;
            }
            char t=c[i];
            c[i]=c[j];
            c[j]=t;
            i++;
            j--;
        }
        return String.valueOf(c);
    }
    
    
    
//    --------------------OPTIMAL -> ALTERNATE---------------------
//    public String reverseVowels(String s) {
//        char[] c=s.toCharArray();
//        int i=0;
//        int j=s.length()-1;
//        while(i<j) {
//            while(i<j && "aeiouAEIOU".indexOf(String.valueOf(s.charAt(i)))==-1) {
//                i++;
//            }
//            while(i<j && "aeiouAEIOU".indexOf(String.valueOf(s.charAt(j)))==-1) {
//                j--;
//            }
//            char t=c[i];
//            c[i]=c[j];
//            c[j]=t;
//            i++;
//            j--;
//        }
//        return String.valueOf(c);
//    }
    
    
//    --------------------NOT OPTIMAL---------------------
//    public String reverseVowels(String s) {
//        int j=0;
//        int i=0;
//        char[] l=new char[s.length()];
//        while(i<s.length()) {
//            if("aeiouAEIOU".contains(String.valueOf(s.charAt(i)))) {
//                l[j]=s.charAt(i);
//                j++;
//            }
//            i++;
//        }
//        j--;
//        i=0;
//        StringBuffer ret=new StringBuffer();
//        while(i<s.length()) {
//            if("aeiouAEIOU".contains(String.valueOf(s.charAt(i)))) {
//                ret.append(l[j]);
//                j--;
//            } else {
//                ret.append(s.charAt(i));
//            }
//            i++;
//        }
//        return ret.toString();
//    }
    
    public static void main(String[] args) {
        ReverseVowelsOfAString r=new ReverseVowelsOfAString();
        System.out.println(r.reverseVowels("leetcode"));
        System.out.println(r.reverseVowels("aA"));
    }
    
}
