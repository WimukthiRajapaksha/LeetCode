/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isomorphic.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class IsomorphicStrings {

    /**
     * @param args the command line arguments
     */
    
    public boolean isIsomorphic(String s, String t) {
        int[] a=new int[256];
        int[] b=new int[256];
        for(int i=0; i<s.length(); i++) {
            if(a[s.charAt(i)]!=b[t.charAt(i)]) {
                return false;
            } else {
                a[s.charAt(i)]=i+1;
                b[t.charAt(i)]=i+1;
            }
        }
        return true;
    }
    
    
//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map=new HashMap<>();
//        Set<Character> set=new HashSet<>();
//        
//        for(int i=0; i<s.length(); i++) {
//            if(map.containsKey(s.charAt(i))) {
//                if(t.charAt(i)!=map.get(s.charAt(i))) {
//                    return false;
//                }
//            } else {
//                if (set.contains(t.charAt(i))) {
//                    return false;
//                } else {
//                    map.put(s.charAt(i), t.charAt(i));
//                    set.add(t.charAt(i));
//                }
//            }
//        }
//        return true;
//    }
    
    
//    public boolean isIsomorphic(String s, String t) {
//        Set<Character> set=new HashSet<>();
//        for(int i=0; i<s.length(); i++) {
//            set.add(s.charAt(i));
//        }
//        int ss=set.size();
//        set.clear();
//        for(int i=0; i<t.length(); i++) {
//            set.add(t.charAt(i));
//        }
//        int st=set.size();
//        if(ss!=st) return false;
//        
//        Map<Character, Character> map=new HashMap<>();
//        
//        for(int i=0; i<s.length(); i++) {
//            if(map.containsKey(s.charAt(i))) {
//                if(t.charAt(i)!=map.get(s.charAt(i))) {
//                    return false;
//                }
//            } else {
//                map.put(s.charAt(i), t.charAt(i));
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        IsomorphicStrings i=new IsomorphicStrings();
        System.out.println(i.isIsomorphic("egg", "add"));
        System.out.println(i.isIsomorphic("foo", "bar"));
        System.out.println(i.isIsomorphic("paper", "title"));
        System.out.println(i.isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}
