/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.palindromic.subsequence;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestPalindromicSubsequence {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL -> O(N^2) -> O(N^2)-------------
//    public int longestPalindromeSubseq(String s) {
//        int[][] dp=new int[s.length()][s.length()];
//        for(int i=0; i<dp.length; i++) {
//            dp[i][i]=1;
//        }
//        for(int i=2; i<=s.length(); i++) {
//            for(int j=0; j<s.length()-i+1; j++) {
//                if(s.charAt(j)==s.charAt(j+i-1)) {
//                    dp[j][j+i-1]=2+dp[j+1][j+i-2];
//                } else {
//                    dp[j][j+i-1]=Math.max(dp[j][j+i-2], dp[j+1][j+i-1]);
//                }
//            }
//        }
//        for(int[] i: dp) System.out.println(Arrays.toString(i));
//        return dp[0][dp[0].length-1];
//    }
    
    
    
//    -------------OPTIMAL -> O(N^2) -> O(N^2)-------------
    public int longestPalindromeSubseq(String s) {
        return calc(s, 0, s.length()-1, new int[s.length()][s.length()]);
    }
    
    private int calc(String s, int l, int r, int[][] mem) {
        if(l>r) return 0;
        if(l==r) return 1;
        if(mem[l][r]!=0) return mem[l][r];
        int val=0;
        if(s.charAt(l)==s.charAt(r)) {
            val=calc(s, l+1, r-1, mem)+2;
        } else {
            val=Math.max(calc(s, l+1, r, mem), calc(s, l, r-1, mem));
        }
        mem[l][r]=val;
        return val;
    }
    
    public static void main(String[] args) {
        LongestPalindromicSubsequence l=new LongestPalindromicSubsequence();
        System.out.println(l.longestPalindromeSubseq("bbbab"));
        System.out.println(l.longestPalindromeSubseq("cbbd"));
        System.out.println(l.longestPalindromeSubseq("agbdba"));
    }
}
