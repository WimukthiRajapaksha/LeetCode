/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first.unique.character.in.a.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FirstUniqueCharacterInAString {

    /**
     * @param args the command line arguments
     */
    
//    --------------------OPTIMAL---------------------
//    public int firstUniqChar(String s) {
//        int i=0;
//        Set<Character> set=new HashSet<>();
//        for(char c: s.toCharArray()) {
//            if(!set.contains(c) && s.indexOf(c, i+1)==-1) return i;
//            i++;
//            set.add(c);
//        }
//        return -1;
//    }
    
    
//------------------------OPTIMAL----------------------
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        for(int i=0; i<s.length(); i++) {
            if(freq[s.charAt(i)-'a']==0) {
                freq[s.charAt(i)-'a']=i+1;
            } else {
                freq[s.charAt(i)-'a']=-1;
            }
        }
        int m=Integer.MAX_VALUE;
        for(int i=0; i<freq.length; i++) {
            if(freq[i]>0 && m>freq[i]) {
                m=freq[i];
            }
        }
        return m==Integer.MAX_VALUE ? -1 : m-1;
    }
    
    
//    -----------------ALTERNATE -> NOT OPTIMAL; SAME CHAR ADDING TO QUEUE---------------
//    public int firstUniqChar(String s) {
//        int[] l=new int[26];
//        Queue<Character> q=new LinkedList<>();
//        for(char c: s.toCharArray()) {
//            if(++l[c-'a']==1) {
//                q.add(c);
//            }
//        }
//        for(int i: l) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        while(!q.isEmpty()) {
//            char c=q.poll();
//            if(l[c-'a']==1) {
//                return s.indexOf(c);
//            }
//        }
//        return -1;
//    }
    
    public static void main(String[] args) {
        FirstUniqueCharacterInAString f=new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar("aabb"));
        System.out.println(f.firstUniqChar("leetcode"));
        System.out.println(f.firstUniqChar("loveleetcode"));
    }
}
