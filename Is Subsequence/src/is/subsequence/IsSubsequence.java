/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.subsequence;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class IsSubsequence {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> BINARY SEARCH -> WHEN S GETS K TIMES MORE EFFICIENT----------------------
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map=new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                map.get(t.charAt(i)).add(i);
            } else {
                List<Integer> l=new ArrayList<>();
                l.add(i);
                map.put(t.charAt(i), l);
            }
        }
        int l=-1;
        for(char c: s.toCharArray()) {
            if(map.containsKey(c)) {
                int n=binarySearch(map.get(c), l);
                if(n!=-1) {
                    l=n;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    private int binarySearch(List<Integer> l, int lastFound) {
        int i=0;
        int j=l.size()-1;
        int r=-1;
        while(i<=j) {
            int m=(i+j)/2;
            if(lastFound<l.get(m)) {
                r=l.get(m);
                j=m-1;
            } else {
                i=m+1;
            }
        }
        return r;
    }
    
    
//    ----------------------OPTIMAL -> TWO POINTERS----------------------
//    public boolean isSubsequence(String s, String t) {
//        if (s.length()==0) return true;
//        else if(t.length()==0) return false;
//        int i=0;
//        for(int j=0; j<t.length(); j++) {
//            if(s.charAt(i)==t.charAt(j)) {
//                i++;
//            }
//            if(i==s.length()) return true;
//        }
//        return false;
//    }
    
    
//    ----------------------OPTIMAL -> TWO POINTERS LIKE----------------------
//    public boolean isSubsequence(String s, String t) {
//        int j=0;
//        for(int i=0; i<s.length(); i++) {
//            j=t.indexOf(s.charAt(i), j)+1;
//            if(j==0) return false;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        IsSubsequence i=new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
    }
}
