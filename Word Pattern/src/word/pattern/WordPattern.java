/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class WordPattern {

    /**
     * @param args the command line arguments
     */
    
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        if(arr.length!=pattern.length()) return false;
        Map map=new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(arr[i], i))) return false;
        }
        return true;
    }
    
    
    
//    public boolean wordPattern(String pattern, String s) {
//        String[] arr=s.split(" ");
//        if(arr.length!=pattern.length()) return false;
//        Set<String> set=new HashSet<>();
//        String[] a=new String[26];
//        
//        for(int i=0; i<pattern.length(); i++) {
//            if(set.contains(arr[i])) {
//                if(a[pattern.charAt(i)-'a']==null || !a[pattern.charAt(i)-'a'].equals(arr[i])) {
//                    return false;
//                }
//            } else {
//                if(a[pattern.charAt(i)-'a']==null) {
//                    set.add(arr[i]);
//                    a[pattern.charAt(i)-'a']=arr[i];
//                } else {
//                    return false;
//                }
//            }
//            System.out.println(set);
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        WordPattern w=new WordPattern();
        System.out.println(w.wordPattern("abba", "dog cat cat fish"));
        System.out.println(w.wordPattern("abba", "dog cat cat dog"));
        System.out.println(w.wordPattern("abba", "dog dog dog dog"));
    }
}
