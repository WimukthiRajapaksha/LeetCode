/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.number.of.k.sum.pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaxNumberOfKSumPairs {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL -> O(N), O(N)--------------
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int ret=0;
        for(int i: nums) {
            if(map.containsKey(k-i)) {
                ret++;
                if(map.get(k-i)==1) map.remove(k-i);
                else map.put(k-i, map.get(k-i)-1);
            } else {
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }
        return ret;
    }
    
    
    
//    -------------OPTIMAL -> O(N), O(N)--------------
//    public int maxOperations(int[] nums, int k) {
//        Arrays.sort(nums);
//        int l=0;
//        int r=nums.length-1;
//        int count=0;
//        while(l<r) {
//            if(nums[l]+nums[r]==k) {
//                count++;
//                l++;
//                r--;
//            } else if(nums[l]+nums[r]>k) {
//                r--;
//            } else {
//                l++;
//            }
//        }
//        return count;
//    }
    
    
    public static void main(String[] args) {
        MaxNumberOfKSumPairs m=new MaxNumberOfKSumPairs();
        System.out.println(m.maxOperations(new int[]{1,2,3,4}, 5));
        System.out.println(m.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}
