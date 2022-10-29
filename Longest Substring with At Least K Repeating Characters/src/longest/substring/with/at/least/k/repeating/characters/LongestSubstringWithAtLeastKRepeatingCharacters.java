/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.substring.with.at.least.k.repeating.characters;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    
    public int longestSubstring(String s, int k) {
        if(k==0) return s.length();
        int[] arr=new int[26];
        int start=0;
        int end=0;
        int max=0;
        while(end<s.length()) {
            arr[s.charAt(end)-'a']++;
            if(valid(arr, k)) {
                max=Math.max(max, end-start+1);
            } else {
                
            }
        }
    }
    
    private boolean valid(int[] arr, int k) {
        for(int i: arr) {
            if(i>0 && i<k) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
