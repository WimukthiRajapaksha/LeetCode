/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.increasing.subsequence;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestIncreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    
//    ----------------O(NLOG(N)), O(1)--------------
    int len=0;
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        for(int i=0; i<nums.length; i++) {
            int p=bs(nums, nums[i]);
            nums[p]=nums[i];
        }
        return len+1;
    }
    
    private int bs(int[] dp, int target) {
        int l=0;
        int r=len;
        while(l<=r) {
            int m=l+(r-l)/2;
            if(target==dp[m]) {
                return m;
            } else if(target<dp[m]) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        if(l>len) {
            len=l;
        }
        return l;
    }
    
    
    
//    ----------------O(NLOG(N)), O(N)--------------
//    int len=0;
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length<=1) return nums.length;
//        int[] dp=new int[nums.length];
//        for(int i=0; i<dp.length; i++) {
//            dp[i]=Integer.MAX_VALUE;
//        }
//        
//        for(int i=0; i<dp.length; i++) {
//            int p=bs(dp, nums[i]);
//            dp[p]=nums[i];
//        }
//        return len+1;
//    }
//    
//    private int bs(int[] dp, int target) {
//        int l=0;
//        int r=len;
//        while(l<=r) {
//            int m=l+(r-l)/2;
//            if(target==dp[m]) {
//                return m;
//            } else if(target<dp[m]) {
//                r=m-1;
//            } else {
//                l=m+1;
//            }
//        }
//        if(l>len) {
//            len=l;
//        }
//        return l;
//    }
    
    
    
//    ----------------O(NLOG(N)), O(N)--------------
//    public int lengthOfLIS(int[] nums) {
//        if(nums.length<=1) return nums.length;
//        int[] dp=new int[nums.length];
//        for(int i=0; i<dp.length; i++) {
//            dp[i]=Integer.MAX_VALUE;
//        }
//        
//        for(int i=0; i<dp.length; i++) {
//            int p=bs(dp, nums[i], i);
//            dp[p]=nums[i];
//        }
//        for(int i=dp.length-1; i>=0; i--) {
//            if(dp[i]!=Integer.MAX_VALUE) return i+1;
//        }
//        return 0;
//    }
//    
//    private int bs(int[] dp, int target, int i) {
//        int l=0;
//        int r=i;
//        while(l<=r) {
//            int m=l+(r-l)/2;
//            if(target==dp[m]) {
//                return m;
//            } else if(target<dp[m]) {
//                r=m-1;
//            } else {
//                l=m+1;
//            }
//        }
//        return l;
//    }
    
    
//    ----------------------O(N^2), O(N)--------------
//    public int lengthOfLIS(int[] nums) {
//        int[] dp=new int[nums.length];
//        int max=1;
//        for(int i=0; i<nums.length; i++) {
//            int j=0;
//            dp[i]=1;
//            while(j<i) {
//                if(nums[j]<nums[i]) {
//                    dp[i]=Math.max(dp[i], dp[j]+1);
//                }
//                j++;
//                max=Math.max(dp[i], max);
//            }
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        LongestIncreasingSubsequence l=new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(l.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
