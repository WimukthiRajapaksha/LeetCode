/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.arithmetic.subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestArithmeticSubsequence {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL -> O(N^2), O(N^2)--------------------
//    public int longestArithSeqLength(int[] nums) {
//        Map<Integer, Integer>[] arr=new HashMap[nums.length];
//        int max=0;
//        for(int i=0; i<nums.length; i++) {
//            Map<Integer, Integer> temp=new HashMap<>();
//            for(int j=0; j<i; j++) {
//                int curr=arr[j].getOrDefault(nums[i]-nums[j], 0)+1;
//                max=Math.max(max, curr);
//                temp.put(nums[i]-nums[j], curr);
//            }
//            arr[i]=temp;
//        }
//        return max+1;
//    }
    
    
//    -----------------------OPTIMAL -> O(N^2), O(N)--------------------
    public int longestArithSeqLength(int[] nums) {
        int[][] dp=new int[nums.length][1001];
        int max=0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                int diff=nums[i]-nums[j]+500;
                dp[i][diff]=dp[j][diff]+1;
                if(max<dp[i][diff]) {
                    max=dp[i][diff];
                }
            }
        }
        return max+1;
    }
    
    public static void main(String[] args) {
        LongestArithmeticSubsequence l=new LongestArithmeticSubsequence();
        System.out.println(l.longestArithSeqLength(new int[]{3,6,9,12}));
        System.out.println(l.longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(l.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}
