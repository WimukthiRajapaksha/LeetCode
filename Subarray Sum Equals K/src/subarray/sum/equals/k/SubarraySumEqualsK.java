/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subarray.sum.equals.k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class SubarraySumEqualsK {

    /**
     * @param args the command line arguments
     */
    
    public int subarraySum(int[] nums, int k) {
        int[] arr=new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            arr[i+1]=arr[i]+nums[i];
        }
        System.out.println(Arrays.toString(arr));
        int c=0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i]-arr[j]==k) {
                    c++;
                }
            }
        }
        return c;
    }
    
//    public int subarraySum(int[] nums, int k) {
//        return dfs(nums, 0, k, true)+dfs(nums, 0, k, false);
//    }
//    
//    public int dfs(int[] nums, int i, int t, boolean take) {
//        if(i==nums.length) return 0;
//        if(take) {
//            int c=0;
//            if(t==nums[i]) {
//                c=1;
//            }
//            c+=dfs(nums, i+1, t-nums[i], take);
//            return c;
//        } else {
//            return dfs(nums, i+1, t, true)+dfs(nums, i+1, t, false);
//        }
//    }
    
    public static void main(String[] args) {
        SubarraySumEqualsK s=new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(s.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(s.subarraySum(new int[]{1,2,1,2,1}, 3));
    }
}

