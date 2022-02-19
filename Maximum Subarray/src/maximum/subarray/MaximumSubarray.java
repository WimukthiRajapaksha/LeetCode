/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumSubarray {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------Kadane's algorithm; O(N)------------------
    public int maxSubArray(int[] nums) {
        int temp=0;
        int max=nums[0];
        for (int i: nums) {  // -2,1,-3,4,-1,2,1,-5,4
//            temp+=i;
//            if (temp<i) { // temp<0 if i not added to temp
//                temp = i;
//            }
            temp = Math.max(temp+i, i);
            max = Math.max(max, temp);
        }
        System.out.println(temp+" "+max);
        return max;
    }
    
    
//    --------------------ALTERNATE------------------
//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0]=nums[0];
//        int max = nums[0];
//        for (int i=1; i<nums.length; i++) {
//            dp[i]=nums[i]+(dp[i-1]>0 ? dp[i-1] : 0);
//            max = Math.max(dp[i], max);
//        }
//        System.out.println(max);
//        return max;
//    }
    
    
//    --------------------ALTERNATE -> DP; O(N)------------------
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int[] dp = new int[nums.length];
//        dp[0]=nums[0];
//        
//        for (int i=1; i<nums.length; i++) {
//            dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
//            max = Math.max(dp[i], max);
//        }
//        System.out.println(max);
//        return max;
//    }
    
    
//    --------------------ALTERNATE -> NAIVE APPROACH; O(N^2)------------------, IF WE NEED WE COULD HAVE USED 3 LOOPS WITH O(N^3) COMPLEXITY
//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0]=nums[0];
//        int max=nums[0];
//        for (int i=1; i<nums.length; i++) {
//            dp[i]=nums[i]+dp[i-1];
//            for (int j=0; j<i; j++) {
//                max = Math.max(Math.max(dp[i]-dp[j], dp[i]), max);
//            }
//        }
//        for (int i: dp) {
//            System.out.print(i+" ");
//        }
//        System.out.println("\n"+max);
//        return max;
//    }
    
    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        m.maxSubArray(new int[]{5,4,-1,7,8});
        m.maxSubArray(new int[]{1});
        m.maxSubArray(new int[]{-2,-1});
        m.maxSubArray(new int[]{-2,-1,-2});
        m.maxSubArray(new int[]{-1,-2,-3,0});
    }
}
