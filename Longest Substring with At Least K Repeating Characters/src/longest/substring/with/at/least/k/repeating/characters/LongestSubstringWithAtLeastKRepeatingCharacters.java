/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.substring.with.at.least.k.repeating.characters;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------OPTIMAL -> O(N), 0(1)-------------
    public int longestSubstring(String s, int k) {
        if(s.length()<k) return 0;
        if(k==1) return s.length();
        int[] counts=new int[26];
        int maxLength=0;
        for(int uniTaken=1; uniTaken<=26; uniTaken++) {
            Arrays.fill(counts, 0);
            int i=0;
            int j=0;
            int currUniq=0;
            int moreThanK=0;
            while(j<s.length()) {
                if(currUniq<=uniTaken) {
                    int place=s.charAt(j)-'a';
                    if(counts[place]==0) {
                        currUniq++;
                    }
                    counts[place]++;
                    if(counts[place]==k) {
                        moreThanK++;
                    }
                    j++;
                } else {
                    int place=s.charAt(i)-'a';
                    if(counts[place]==k) {
                        moreThanK--;
                    }
                    counts[place]--;
                    if(counts[place]==0) {
                        currUniq--;
                    }
                    i++;
                }
                if(uniTaken==currUniq && currUniq==moreThanK) {
                    maxLength=Math.max(maxLength, j-i);
                }
            }
        }
        return maxLength;
    }
    
    
    
//    ------------OPTIMAL -> O(N^2), 0(N)-------------
//    public int longestSubstring(String s, int k) {
//        if(k>s.length()) return 0;
//        if(k==1) return s.length();
//        return count(s, 0, s.length(), k);
//    }
//    
//    private int count(String s, int l, int r, int k) {
//        if(l>=r) return 0;
//        int[] arr=new int[26];
//        for(int i=l; i<r; i++) {
//            arr[s.charAt(i)-'a']++;
//        }
//        int result=0;
//        int curr=l;
//        boolean valid=true;
//        for(int i: arr) {
//            if(i>0 && i<k) {
//                valid=false;
//            }
//        }
//        if(valid) {
//            return r-l;
//        }
//        while(curr<r) {
//            if(arr[s.charAt(curr)-'a']<k) {
//                result=Math.max(result, count(s, l, curr, k));
//                l=curr+1;
//            }
//            curr++;
//        }
//        result=Math.max(result, count(s, l, r, k));
//        return result;
//    }
    
    
    
//    ------------OPTIMAL -> O(N^2), 0(N)-------------
//    public int longestSubstring(String s, int k) {
//        if(k>s.length()) return 0;
//        if(k==1) return s.length();
//        return count(s, 0, s.length()-1, k);
//    }
//    
//    private int count(String s, int l, int r, int k) {
//        if(l>=r) return 0;
//        int[] arr=new int[26];
//        for(int i=l; i<=r; i++) {
//            arr[s.charAt(i)-'a']++;
//        }
//        for(int i=l; i<=r; i++) {
//            if(i==r+1 || arr[s.charAt(i)-'a']>0 && arr[s.charAt(i)-'a']<k) {
//                int next=i+1;
//                while(next<=r && arr[s.charAt(next)-'a']<k) {
//                    next++;
//                }
//                return Math.max(count(s, l, i-1, k), count(s, next, r, k));
//            }
//        }
//        return r-l+1;
//    }
    
    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters l=new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(l.longestSubstring("aaabb", 3));
        System.out.println(l.longestSubstring("ababbc", 2));
        System.out.println(l.longestSubstring("ababacb", 3));
        System.out.println(l.longestSubstring("aaabbb", 3));
        System.out.println(l.longestSubstring("bbaaacbd", 3));
        System.out.println(l.longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3));
    }
}
