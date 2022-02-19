/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.first.palindromic.string.in.the.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindFirstPalindromicStringInTheArray {

    /**
     * @param args the command line arguments
     */
    
    public String firstPalindrome(String[] words) {
        for (String s: words) {
            if (isPalindromic(s)) return s;
        }
        return "";
    }
    
    public boolean isPalindromic(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        FindFirstPalindromicStringInTheArray f=new FindFirstPalindromicStringInTheArray();
        System.out.println(f.firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
        System.out.println(f.firstPalindrome(new String[]{"def","ghi"}));
    }
}
