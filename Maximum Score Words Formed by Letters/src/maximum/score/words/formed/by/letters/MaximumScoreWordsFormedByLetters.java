/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.score.words.formed.by.letters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumScoreWordsFormedByLetters {

    /**
     * @param args the command line arguments
     */
    
//    public int maxScoreWords(String[] words, char[] letters, int[] score) {
//        int[] letterCounts=new int[26];
//        for(char c: letters) {
//            letterCounts[c-'a']++;
//        }
//        List<String> valid=new ArrayList<>();
//        for(String w: words) {
//            if(isValid(w, letterCounts)) {
//                valid.add(w);
//            }
//        }
//        int max=0;
//        for(int i=0; i<(1<<valid.size()); i++) {
//            int sum=value(valid, i, score, letterCounts);
//            max=Math.max(max, sum);
//        }
//        return max;
//    }
//    
//    private int value(List<String> list, int j, int[] score, int[] lettersCount) {
//        int[] counts=new int[26];
//        int sc=0;
//        for(int i=0; i<list.size(); i++) {
//            if((j&(1<<i))==(1<<i)) {
//                String s=list.get(i);
//                for(char c: s.toCharArray()) {
//                    counts[c-'a']++;
//                    sc+=score[c-'a'];
//                }
//            }
//        }
//        for(int i=0; i<counts.length; i++) {
//            if(counts[i]>lettersCount[i]) return -1;
//        }
//        return sc;
//    }
//    
//    private boolean isValid(String s, int[] count) {
//        int[] sCount=new int[26];
//        for(char c: s.toCharArray()) {
//            sCount[c-'a']++;
//        }
//        for(int i=0; i<count.length; i++) {
//            if(sCount[i]>count[i]) return false;
//        }
//        return true;
//    }
    
    
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if(words.length==0 || letters.length==0) return 0;
        int[] arr=new int[26];
        for(char c: letters) {
            arr[c-'a']++;
        }
        return help(words, arr, score, 0);
    }
    
    private int help(String[] words, int[] arr, int[] score, int index) {
        if(index==words.length) return 0;
        int max=0;
        for(int i=index; i<words.length; i++) {
            boolean isValid=true;
            int sum=0;
            for(char c: words[i].toCharArray()) {
                sum+=score[c-'a'];
                if(--arr[c-'a']<0) {
                    isValid=false;
                }
            }
            if(isValid) {
                sum+=help(words, arr, score, i+1);
                max=Math.max(max, sum);
            }
            for(char c: words[i].toCharArray()) {
                arr[c-'a']++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        MaximumScoreWordsFormedByLetters m=new MaximumScoreWordsFormedByLetters();
        System.out.println(m.maxScoreWords(new String[]{"dog","cat","dad","good"}, new char[]{'a','a','c','d','d','d','g','o','o'}, new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(m.maxScoreWords(new String[]{"xxxz","ax","bx","cx"}, new char[]{'z','a','b','c','x','x','x'}, new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10}));
        System.out.println(m.maxScoreWords(new String[]{"leetcode"}, new char[]{'l','e','t','c','o','d'}, new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0}));
    }
}
