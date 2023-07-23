/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.number.of.vowels.in.a.substring.of.given.length;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(N), O(1)-----------
    public int maxVowels(String s, int k) {
        int count=0;
        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
        }
        int maxCount=count;
        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(i-k))) {
                count--;
            }
            if(isVowel(s.charAt(i))) {
                count++;
            }
            if(maxCount<count) {
                maxCount=count;
            }
        }
        return maxCount;
    }
    
    private boolean isVowel(char c) {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    
    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength m=new MaximumNumberOfVowelsInASubstringOfGivenLength();
        System.out.println(m.maxVowels("abciiidef", 3));
        System.out.println(m.maxVowels("aeiou", 2));
        System.out.println(m.maxVowels("leetcode", 3));
    }
}
