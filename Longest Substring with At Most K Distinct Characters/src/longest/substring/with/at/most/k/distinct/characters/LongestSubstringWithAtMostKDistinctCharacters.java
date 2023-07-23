/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.substring.with.at.most.k.distinct.characters;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */

//https://www.lintcode.com/problem/386/description

public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * @param args the command line arguments
     */
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        if(k>=s.length()) return s.length();
        int[] arr=new int[128];
        int distinct=0;
        int max=0;
        int begin=0;
        int end=0;
        while(end<s.length()) {
//            System.out.println(begin+" "+end+" "+distinct);
            while(distinct>k) {
                if(--arr[s.charAt(begin++)]==0) {
                    distinct--;
                }
            }
            if(arr[s.charAt(end)]++==0) {
                distinct++;
            }
            
            if(distinct<=k) {
                max=Math.max(max, end-begin+1);
            }
            end++;
        }
        return max;
    }
    
    
//    ----------------------OPTIMAL-------------------
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if(k==0) return 0;
//        if(k>=s.length()) return s.length();
//        int[] arr=new int[128];
//        int distinct=0;
//        int max=0;
//        int begin=0;
//        int end=0;
//        while(end<s.length()) {
//            if(distinct>k) {
//                if(--arr[s.charAt(begin++)]==0) {
//                    distinct--;
//                }
//                continue;
//            }
//            if(arr[s.charAt(end)]++==0) {
//                distinct++;
//            }
//            
//            if(distinct<=k) {
//                max=Math.max(max, end-begin+1);
//            }
//            end++;
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters l=new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringKDistinct("eceba", 3));
        System.out.println(l.lengthOfLongestSubstringKDistinct("WORLD", 4));
        System.out.println(l.lengthOfLongestSubstringKDistinct("kb", 10));
        System.out.println(l.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
    }
}
