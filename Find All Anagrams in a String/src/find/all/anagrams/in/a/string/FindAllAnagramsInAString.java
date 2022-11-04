/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.all.anagrams.in.a.string;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindAllAnagramsInAString {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> USING 2 CHAR ARRAYS -> O(N) -> O(1)-------------------
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list=new ArrayList<>();
//        if(s.length()<p.length()) return list;
//        if(s.equals(p)) {
//            list.add(0);
//            return list;
//        }
//        char[] arrP=new char[26];
//        for(char c: p.toCharArray()) {
//            arrP[c-'a']++;
//        }
//        char[] arrS=new char[26];
//        for(int i=0; i<p.length(); i++) {
//            arrS[s.charAt(i)-'a']++;
//        }
//        if (String.valueOf(arrP).equals(String.valueOf(arrS))) {
//            list.add(0);
//        }
//
//        for(int i=p.length(); i<s.length(); i++) {
//            arrS[s.charAt(i-p.length())-'a']--;
//            arrS[s.charAt(i)-'a']++;
//            if (String.valueOf(arrP).equals(String.valueOf(arrS))) {
//                list.add(i-p.length()+1);
//            }
//        }
//        return list;
//    }
    
    
//    -----------------OPTIMAL -> USING 2 INT ARRAYS -> O(N) -> O(1)-------------------
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list=new ArrayList<>();
//        if(s.length()<p.length()) return list;
//        if(s.equals(p)) {
//            list.add(0);
//            return list;
//        }
//        int[] arrP=new int[26];
//        for(char c: p.toCharArray()) {
//            arrP[c-'a']++;
//        }
//        int[] arrS=new int[26];
//        for(int i=0; i<p.length(); i++) {
//            arrS[s.charAt(i)-'a']++;
//        }
//        if(check(arrP, arrS)) {
//            list.add(0);
//        }
//
//        for(int i=p.length(); i<s.length(); i++) {
//            arrS[s.charAt(i-p.length())-'a']--;
//            arrS[s.charAt(i)-'a']++;
//            if(check(arrP, arrS)) {
//                list.add(i-p.length()+1);
//            }
//        }
//        return list;
//    }
//    
//    private boolean check(int[] f, int[] s) {
//        for(int i=0; i<f.length; i++) {
//            if(f[i]!=s[i]) return false;
//        }
//        return true;
//    }
    
    
    
//    -----------------OPTIMAL -> ONLY USING ONE ARRAY -> O(N) -> O(1)-------------------
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list=new ArrayList<>();
//        if(s.length()<p.length()) return list;
//        if(s.equals(p)) {
//            list.add(0);
//            return list;
//        }
//        int[] arrP=new int[26];
//        for(char c: p.toCharArray()) {
//            arrP[c-'a']--;
//        }
//        for(int i=0; i<p.length(); i++) {
//            arrP[s.charAt(i)-'a']++;
//        }
//        if(check(arrP)) {
//            list.add(0);
//        }
//
//        for(int i=p.length(); i<s.length(); i++) {
//            arrP[s.charAt(i-p.length())-'a']--;
//            arrP[s.charAt(i)-'a']++;
//            if(check(arrP)) {
//                list.add(i-p.length()+1);
//            }
//        }
//        return list;
//    }
//    
//    private boolean check(int[] f) {
//        for(int i=0; i<f.length; i++) {
//            if(f[i]!=0) return false;
//        }
//        return true;
//    }
    
    
    
//    -----------------OPTIMAL -> ONLY USING ONE ARRAY -> O(N) -> O(1)-------------------
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list=new ArrayList<>();
//        if(s.length()<p.length()) return list;
//        if(s.equals(p)) {
//            list.add(0);
//            return list;
//        }
//        int[] arrP=new int[26];
//        for(char c: p.toCharArray()) {
//            arrP[c-'a']++;
//        }
//        int difference=p.length();
//        for(int i=0; i<p.length(); i++) {
//            arrP[s.charAt(i)-'a']--;
//            if(arrP[s.charAt(i)-'a']>=0) difference--;
//        }
//        if(difference==0) {
//            list.add(0);
//        }
//
//        for(int i=p.length(); i<s.length(); i++) {
//            if(arrP[s.charAt(i-p.length())-'a']>=0) {
//                difference++;
//            }
//            arrP[s.charAt(i-p.length())-'a']++;
//            arrP[s.charAt(i)-'a']--;
//            if(arrP[s.charAt(i)-'a']>=0) difference--;
//            if(difference==0) {
//                list.add(i-p.length()+1);
//            }
//        }
//        return list;
//    }
    
    
    
    
//    -------------BEST SOLUTION -> O(N), O(1)--------------------
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if(s.length()<p.length()) return list;
        if(s.equals(p)) {
            list.add(0);
            return list;
        }
        int[] arrP=new int[26];
        for(char c: p.toCharArray()) {
            arrP[c-'a']++;
        }
        int difference=0;
        for(int i=0; i<p.length(); i++) {
            arrP[s.charAt(i)-'a']--;
            if(arrP[s.charAt(i)-'a']<0) difference++;
        }
        if(difference==0) {
            list.add(0);
        }

        for(int i=p.length(); i<s.length(); i++) {
            if(arrP[s.charAt(i-p.length())-'a']>=0) {
                difference++;
            }
            arrP[s.charAt(i-p.length())-'a']++;
            arrP[s.charAt(i)-'a']--;
            if(arrP[s.charAt(i)-'a']>=0) difference--;
            if(difference==0) {
                list.add(i-p.length()+1);
            }
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        FindAllAnagramsInAString f=new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
        System.out.println(f.findAnagrams("abab", "ab"));
    }
}
