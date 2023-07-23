/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.window.substring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumWindowSubstring {

    /**
     * @param args the command line arguments
     */
    
//    -------------------OPTIMAL -> O(S+T), O(S+T)---------------
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(s.equals("") || t.equals("")) return "";
        int[] mapT=new int[128];
        int uniqueT=0;
        for(char c: t.toCharArray()) {
            if(mapT[c]==0) {
                uniqueT++;
            }
            mapT[c]++;
        }
        
        int[] mapS=new int[128];
        int l=0;
        int r=0;
        int formed=0;
        int returnLeft=-1;
        int returnRight=-1;
        while(r<s.length()) {
            char c = s.charAt(r);
            mapS[c]++;
            if(mapS[c]==mapT[c]) {
                formed++;
            }
            while(l<=r && formed==uniqueT) {
                if(returnLeft==-1 || r-l+1<returnRight-returnLeft) {
                    returnLeft=l;
                    returnRight=r+1;
                }
                c=s.charAt(l);
                mapS[c]--;
                if(mapS[c]+1==mapT[c]) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return returnLeft == -1 ? "" : s.substring(returnLeft, returnRight);
    }
    
    
    
//    -------------------OPTIMAL -> O(S+T), O(S+T)---------------
//    public String minWindow(String s, String t) {
//        if(s.equals(t)) return s;
//        if(s.equals("") || t.equals("")) return "";
//        Map<Character, Integer> mapT=new HashMap<>();
//        for(char c: t.toCharArray()) {
//            mapT.put(c, mapT.getOrDefault(c, 0)+1);
//        }
//        int uniqueT=mapT.size();
//        Map<Character, Integer> mapS=new HashMap<>();
//        int l=0;
//        int r=0;
//        int formed=0;
//        int returnLeft=-1;
//        int returnRight=-1;
//        while(r<s.length()) {
//            char c = s.charAt(r);
//            mapS.put(c, mapS.getOrDefault(c, 0)+1);
//            if(mapS.get(c).equals(mapT.get(c))) {
//                formed++;
//            }
//            while(l<=r && formed==uniqueT) {
//                if(returnLeft==-1 || r-l+1<returnRight-returnLeft) {
//                    returnLeft=l;
//                    returnRight=r+1;
//                }
//                c=s.charAt(l);
//                mapS.put(c, mapS.get(c)-1);
//                if(mapT.get(c)!= null && mapS.get(c)+1==(mapT.get(c))) {
//                    formed--;
//                }
//                l++;
//            }
//            r++;
//        }
//        return returnLeft == -1 ? "" : s.substring(returnLeft, returnRight);
//    }
    
    public static void main(String[] args) {
        MinimumWindowSubstring m=new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("abc", "ac"));
    }
}
