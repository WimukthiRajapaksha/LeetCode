/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination.sum.iv;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CombinationSumIV {
//    public int combinationSum4(int[] nums, int target) {
//        int[] arr=new int[target+1];
//        arr[0]=1;
//        for(int i=1; i<arr.length; i++) {
//            for(int j: nums) {
//                if(j>i) {
//                    continue;
//                }
//                arr[i]+=arr[i-j];
//            }
//        }
//        return arr[arr.length-1];
//    }


//    -------------OPTIMAL -> TOP-DOWN-------------------
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp=new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        help(nums, target);
        return dp[target];
    }

    private int help(int[] nums, int t) {
        if(dp[t]!=-1) {
            return dp[t];
        }
        int res=0;
        for(int i: nums) {
            if(t>=i) {
                res+=help(nums, t-i);
            }
        }
        dp[t]=res;
        return res;
    }

    public static void main(String[] args) {
        CombinationSumIV c=new CombinationSumIV();
        System.out.println(c.combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(c.combinationSum4(new int[]{9}, 3));
        System.out.println(c.combinationSum4(new int[]{2,1,3}, 35));
        System.out.println(c.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
    }
}
