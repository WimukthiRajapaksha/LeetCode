/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removing.stars.from.a.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemovingStarsFromAString {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
//    public String removeStars(String s) {
//        Stack<Character> stack=new Stack<>();
//        for(char c: s.toCharArray()) {
//            if(c=='*') {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//        StringBuffer sb=new StringBuffer();
//        for(char c: stack) {
//            sb.append(c);
//        }
//        return sb.toString();
//    }
    
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
//    public String removeStars(String s) {
//        char[] arr=new char[s.length()];
//        int i=0;
//        for(char c: s.toCharArray()) {
//            if(c=='*') i--;
//            else arr[i++]=c;
//        }
//        StringBuffer sb=new StringBuffer();
//        for(int j=0; j<i; j++) {
//            sb.append(arr[j]);
//        }
//        return sb.toString();
//    }
    
    
//    ----------OPTIMAL -> O(N), O(N)--------------
    public String removeStars(String s) {
        char[] arr=s.toCharArray();
        int i=0;
        int j=0;
        while(j<s.length()) {
            if(arr[j]=='*') i--;
            else arr[i++]=arr[j];
            j++;
        }
        StringBuffer sb=new StringBuffer();
        for(int k=0; k<i; k++) {
            sb.append(arr[k]);
        }
        return sb.toString();
    }
    
    
    //    ----------OPTIMAL -> O(N), O(N)--------------
//    public String removeStars(String s) {
//        StringBuffer sb=new StringBuffer();
//        for(char c: s.toCharArray()) {
//            if(c=='*') sb.deleteCharAt(sb.length()-1);
//            else sb.append(c);
//        }
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        RemovingStarsFromAString r=new RemovingStarsFromAString();
        System.out.println(r.removeStars("leet**cod*e"));
        System.out.println(r.removeStars("erase*****"));
    }
}
