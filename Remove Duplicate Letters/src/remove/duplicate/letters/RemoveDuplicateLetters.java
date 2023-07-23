/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicate.letters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicateLetters {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N), O(N)----------------------
//    public String removeDuplicateLetters(String s) {
//        int[] lastIndex=new int[26];
//        for(int i=0; i<s.length(); i++) {
//            lastIndex[s.charAt(i)-'a']=i;
//        }
//        boolean[] visited=new boolean[26];
//        StringBuffer sb=new StringBuffer();
//        for(int i=0; i<s.length(); i++) {
//            char currChar=s.charAt(i);
//            if(visited[currChar-'a']) continue;
//            while(sb.length()!=0 && sb.charAt(sb.length()-1)>=currChar && lastIndex[sb.charAt(sb.length()-1)-'a']>i) {
//                visited[sb.charAt(sb.length()-1)-'a']=false;
//                sb.deleteCharAt(sb.length()-1);
//            }
//            visited[s.charAt(i)-'a']=true;
//            sb.append(currChar);
//        }
//        return sb.toString();
//    }
    

//    ------------------OPTIMAL -> O(N), O(N)----------------------
    public String removeDuplicateLetters(String s) {
        int[] lastIndex=new int[26];
        for(int i=0; i<s.length(); i++) {
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] visited=new boolean[26];
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char currChar=s.charAt(i);
            if(visited[currChar-'a']) continue;
            while(!stack.isEmpty() && stack.peek()>=currChar && lastIndex[stack.peek()-'a']>i) { // max -> O(26), 
//                then time complexity would be O(N*26) = O(N)
                visited[stack.pop()-'a']=false;
            }
            stack.push(currChar);
            visited[s.charAt(i)-'a']=true;
        }
        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        RemoveDuplicateLetters r=new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters("bcabc"));
        System.out.println(r.removeDuplicateLetters("cbacdcbc"));
        System.out.println(r.removeDuplicateLetters("abcd"));
    }
}
