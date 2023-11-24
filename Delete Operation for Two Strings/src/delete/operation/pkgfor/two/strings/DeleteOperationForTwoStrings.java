/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete.operation.pkgfor.two.strings;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class DeleteOperationForTwoStrings {

    /**
     * @param args the command line arguments
     */
    
//    --------OPTIMAL -> O(M*N), O(M*N)--------------
//    public int minDistance(String word1, String word2) {
//        int[][] dp=new int[word1.length()+1][word2.length()+1];
//        for(int i=0; i<dp[0].length; i++) {
//            dp[0][i]=i;
//        }
//        for(int i=0; i<dp.length; i++) {
//            dp[i][0]=i;
//        }
//        for(int i=0; i<word1.length(); i++) {
//            for(int j=0; j<word2.length(); j++) {
//                if(word1.charAt(i)==word2.charAt(j)) {
//                    dp[i+1][j+1]=dp[i][j];
//                } else {
//                    dp[i+1][j+1]=Math.min(dp[i+1][j], dp[i][j+1])+1;
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
//    --------OPTIMAL -> O(M*N), O(N)--------------
    public int minDistance(String word1, String word2) {
        int[] dp=new int[word2.length()+1];
        for(int i=0; i<dp.length; i++) {
            dp[i]=i;
        }
        for(int i=0; i<word1.length(); i++) {
            int prev=dp[0];
            dp[0]=i+1;
            for(int j=0; j<word2.length(); j++) {
                int temp=dp[j+1];
                if(word1.charAt(i)==word2.charAt(j)) {
                    dp[j+1]=prev;
                } else {
                    dp[j+1]=Math.min(dp[j], dp[j+1])+1;
                }
                prev=temp;
            }
        }
        return dp[dp.length-1];
    }
    
    public static void main(String[] args) {
        DeleteOperationForTwoStrings d=new DeleteOperationForTwoStrings();
        System.out.println(d.minDistance("sea", "eat"));
        System.out.println(d.minDistance("leetcode", "etco"));
    }
}
