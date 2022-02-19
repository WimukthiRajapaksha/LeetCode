/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.the.number.of.consistent.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountTheNumberOfConsistentStrings {

    /**
     * @param args the command line arguments
     */
    
    public int countConsistentStrings(String allowed, String[] words) {
        int al=0;
        for (int i=0; i<allowed.length(); i++) {
            al|=(1<<(allowed.charAt(i)-'a'));
        }
        int count=0;
        System.out.println(al);
        for (String s: words) {
            int i=0;
            for (i=0; i<s.length(); i++) {
                if((al&(1<<s.charAt(i)-'a'))==0) {
                    break;
                }
            }
            if (i==s.length()) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
    
//    public int countConsistentStrings(String allowed, String[] words) {
//        boolean[] arr=new boolean[26];
//        for (int i=0; i<allowed.length(); i++) {
//            arr[allowed.charAt(i)-'a']=true;
//        }
//        int count=0;
//        int i=0;
//        for (String s: words) {
//            for (i=0; i<s.length(); i++) {
//                if (!arr[s.charAt(i)-'a']) {
//                    break;
//                }
//            }
//            if (i==s.length()) count++;
//        }
//        System.out.println(count);
//        return count;
//    }
    
    
//    public int countConsistentStrings(String allowed, String[] words) {
//        Set<Character> set=new HashSet<>();
//        for (int i=0; i<allowed.length(); i++) {
//            if (!set.contains(allowed.charAt(i))) {
//                set.add(allowed.charAt(i));
//            }
//        }
//        int count=0;
//        int i=0;
//        for (String s: words) {
//            for (i=0;i<s.length(); i++) {
//                if (!set.contains(s.charAt(i))) {
//                    break;
//                }
//            }
//            if (i==s.length()) count++;
//        }
//        return count;
//    }
    
    
//    public int countConsistentStrings(String allowed, String[] words) {
//        int count=0;
//        for (String s: words) {
//            boolean add=true;
//            for (int i=0; i<s.length(); i++) {
//                if (allowed.indexOf(s.charAt(i))<0) {
//                    add=false;
//                    break;
//                }
//            }
//            if (add) count++;
//        }
//        System.out.println(count);
//        return count;
//    }
    
    public static void main(String[] args) {
        CountTheNumberOfConsistentStrings c=new CountTheNumberOfConsistentStrings();
        c.countConsistentStrings("acd", new String[]{"cc","acd","b","ba","bac","bad","ac","d"});
    }
}
