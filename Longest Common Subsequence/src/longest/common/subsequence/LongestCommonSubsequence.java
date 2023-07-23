/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.common.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestCommonSubsequence {

    /**
     * @param args the command line arguments
     */
    
//    --------------DP -> OPTIMAL -> O(M*N), O(min(M,N))-------------
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()<text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] dp=new int[text2.length()+1];
        for(int i=0; i<text1.length(); i++) {
            int pre=0;
            for(int j=0; j<text2.length(); j++) {
                int temp=dp[j+1];
                if(text1.charAt(i)==text2.charAt(j)) {
                    dp[j+1]=1+pre;
                } else {
                    dp[j+1]=Math.max(dp[j+1], dp[j]);
                }
                pre=temp;
            }
        }
        return dp[dp.length-1];
    }
    
//    --------------DP -> OPTIMAL -> O(M*N), O(min(M,N))-------------
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[] dp=new int[text2.length()+1];
//        for(int i=0; i<text1.length(); i++) {
//            int pre=0;
//            for(int j=0; j<text2.length(); j++) {
//                int temp=dp[j+1];
//                if(text1.charAt(i)==text2.charAt(j)) {
//                    dp[j+1]=1+pre;
//                } else {
//                    dp[j+1]=Math.max(dp[j+1], dp[j]);
//                }
//                pre=temp;
//            }
//        }
//        return dp[dp.length-1];
//    }
    
//    --------------DP -> OPTIMAL -> O(M*N), O(M*N)-------------
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp=new int[text1.length()+1][text2.length()+1];
//        for(int i=0; i<text1.length(); i++) {
//            for(int j=0; j<text2.length(); j++) {
//                if(text1.charAt(i)==text2.charAt(j)) {
//                    dp[i+1][j+1]=1+dp[i][j];
//                } else {
//                    dp[i+1][j+1]=Math.max(dp[i+1][j], dp[i][j+1]);
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
//    --------------MEMOIZATION -> NOT OPTIMAL -> O(M*N), O(M*N)-------------
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] mem=new int[text1.length()][text2.length()];
//        for(int i=0; i<mem.length; i++) {
//            for(int j=0; j<mem[i].length; j++) {
//                mem[i][j]=-1;
//            }
//        }
//        return help(text1.toCharArray(), text2.toCharArray(), 0, 0, mem);
//    }
//    
//    public int help(char[] s1, char[] s2, int i, int j, int[][] mem) {
//        if(i==s1.length || j==s2.length) {
//            return 0;
//        }
//        if(mem[i][j]!=-1) {
//            return mem[i][j];
//        }
//        if(s1[i]==s2[j]) {
//            mem[i][j]=help(s1, s2, i+1, j+1, mem)+1;
//        } else {
//            int t1=help(s1, s2, i+1, j, mem);
//            int t2=help(s1, s2, i, j+1, mem);
//            mem[i][j]=Math.max(t1, t2);
//        }
//        return mem[i][j];
//    }
    
    
    
    
//    --------------MEMOIZATION -> NOT OPTIMAL -> O(2^N), O(2^N)-------------
//    public int longestCommonSubsequence(String text1, String text2) {
//        return help(text1.toCharArray(), text2.toCharArray(), 0, 0);
//    }
//    
//    public int help(char[] s1, char[] s2, int i, int j) {
//        if(i==s1.length || j==s2.length) {
//            return 0;
//        }
//        if(s1[i]==s2[j]) {
//            return help(s1, s2, i+1, j+1)+1;
//        } else {
//            int t1=help(s1, s2, i+1, j);
//            int t2=help(s1, s2, i, j+1);
//            return Math.max(t1, t2);
//        }
//    }
    
    public static void main(String[] args) {
        LongestCommonSubsequence l=new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequence("abcde", "ace")==3);
        System.out.println(l.longestCommonSubsequence("abc", "abc")==3);
        System.out.println(l.longestCommonSubsequence("abc", "def")==0);
        System.out.println(l.longestCommonSubsequence("abc", "")==0);
        System.out.println(l.longestCommonSubsequence("ezupkr", "ubmrapg")==2);
        System.out.println(l.longestCommonSubsequence("abcba", "abcbcba")==5);
        System.out.println(l.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy")==2);
    }
}
