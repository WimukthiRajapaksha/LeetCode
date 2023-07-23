/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.length.of.repeated.subarray;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumLengthOfRepeatedSubarray {

    /**
     * @param args the command line arguments
     */
    
//    ------------------------OPTIMAL -> O(M*N), O(N)-------------------------
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        int[] dp=new int[nums2.length+1];
        for(int i=0; i<nums1.length; i++) {
            int prev=0;
            for(int j=0; j<nums2.length; j++) {
                int temp=dp[j+1];
                if(nums1[i]==nums2[j]) {
                    dp[j+1]=prev+1;
                } else {
                    dp[j+1]=0;
                }
                prev=temp;
                max=Math.max(max, dp[j+1]);
            }
        }
        return max;
    }
    
    
//    ------------------------OPTIMAL -> O(M*N), O(M*N)-------------------------
//    public int findLength(int[] nums1, int[] nums2) {
//        int[][] dp=new int[nums1.length+1][nums2.length+1];
//        for(int i=0; i<nums1.length; i++) {
//            for(int j=0; j<nums2.length; j++) {
//                if(nums1[i]==nums2[j]) {
//                    dp[i+1][j+1]=dp[i][j]+1;
//                }
//            }
//        }
//        int max=0;
//        for(int[] i: dp) {
//            for(int j: i) {
//                max=Math.max(max, j);
//            }
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray m=new MaximumLengthOfRepeatedSubarray();
        System.out.println(m.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
