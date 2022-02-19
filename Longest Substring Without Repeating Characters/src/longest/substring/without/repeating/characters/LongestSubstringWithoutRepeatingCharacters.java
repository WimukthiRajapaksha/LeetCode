/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.substring.without.repeating.characters;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=1;
        int l=1;
        while(i<=j && j<s.length() && i<s.length()) {
            if(s.charAt(i)==s.charAt(j)) {
                i++;
//                while(i<s.length() && j<s.length() && s.charAt(i)==s.charAt(j)) {
//                    i++;
//                }
//                j=i+1;
            } else {
//                j++;
//                l=Math.max(l, j-i+1);
                if (j<s.length()-1 && s.charAt(j)!=s.charAt(j+1)) {
                    j++;
                } else {
                    i=j+1;
                    j++;
                }
            }
            System.out.println(i+" "+j);
            
        }
        return l;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
    
}
