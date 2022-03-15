/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.substring.without.repeating.characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    
    public int lengthOfLongestSubstring(String s) {
        int[] arr=new int[256];
        int b=0;
        int r=0;
        for(int i=0; i<s.length(); i++) {
            if(b<arr[s.charAt(i)]) b=arr[s.charAt(i)];
            arr[s.charAt(i)]=i+1;
            if(r<i-b+1) r=i-b+1;
        }
        return r;
    }
    
    
//    -------------------OPTIMAL -> ALTERNATE---------------------
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map=new HashMap<>();
//        int b=0;
//        int r=0;
//        for(int i=0; i<s.length(); i++) {
//            Integer t=map.put(s.charAt(i), i+1);
//            if(t!=null && b<t) {
//                b=t;
//            }
//            if(r<i-b+1) r=i-b+1;
//        }
//        return r;
//    }
    
    
//    -------------------ALTERNATE---------------------
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set=new HashSet<>();
//        int j=0;
//        int i=0;
//        int m=0;
//        while(i<s.length()) {
//            if(!set.contains(s.charAt(i))) {
//                set.add(s.charAt(i++));
//                if(set.size()>m) m=set.size();
//            } else {
//                while(j<i && set.contains(s.charAt(i))) {
//                    set.remove(s.charAt(j++));
//                }
//            }
//            System.out.println(set);
//        }
//        return m;
//    }
    
    
//    -------------------ALTERNATE---------------------
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set=new HashSet<>();
//        int j=0;
//        int i=0;
//        int m=0;
//        while(j<s.length()) {
//            if(!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                m=Math.max(m, set.size());
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return m;
//    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwww"));
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
        System.out.println(l.lengthOfLongestSubstring(""));
    }
    
}
