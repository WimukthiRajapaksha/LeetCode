/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uncrossed.lines;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class UncrossedLines {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(M*N), O(M*N)-------------
//    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        int[][] dp=new int[nums1.length+1][nums2.length+1];
//        for(int i=0; i<nums1.length; i++) {
//            for(int j=0; j<nums2.length; j++) {
//                if(nums1[i]==nums2[j]) {
//                    dp[i+1][j+1]=dp[i][j]+1;
//                } else {
//                    dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
    
//    ----------OPTIMAL -> O(M*N), O(N)-------------
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp=new int[nums2.length+1];
        for(int i=0; i<nums1.length; i++) {
            int prev=0;
            for(int j=0; j<nums2.length; j++) {
                int temp=dp[j+1];
                if(nums1[i]==nums2[j]) {
                    dp[j+1]=prev+1;
                } else {
                    dp[j+1]=Math.max(dp[j], dp[j+1]);
                }
                prev=temp;
            }
        }
        return dp[dp.length-1];
    }
    
    public static void main(String[] args) {
        UncrossedLines u=new UncrossedLines();
        System.out.println(u.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(u.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(u.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}
