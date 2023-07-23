/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.diff.pairs.in.an.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class KDiffPairsInAnArray {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(N), O(N)-------------------------
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int count=0;
        for(int i: nums) {
            if(map.containsKey(i)) {
                if(k==0 && map.get(i)==1) {
                    count++;
                }
                map.put(i, map.get(i)+1);
            } else {
                if(map.containsKey(i+k)) {
                    count++;
                }
                if(map.containsKey(i-k)) {
                    count++;
                }
                map.put(i, 1);
            }
        }
        return count;
    }
    
    
    
//    -------------------OPTIMAL -> O(N*LOGN), O(N)-------------------------
//    public int findPairs(int[] nums, int k) {
//        Arrays.sort(nums);
//        int i=0;
//        int j=1;
//        int count=0;
//        while(i<nums.length && j<nums.length && i<=j) {
//            int diff=nums[j]-nums[i];
//            if(diff<k) j++;
//            else if(diff>k) i++;
//            else if(i==j) j++;
//            else {
//                count++;
//                i++;
//                j++;
//                while(i<nums.length && nums[i-1]==nums[i]) i++;
//                while(j<nums.length && nums[j-1]==nums[j]) j++;
//            }
//        }
//        return count;
//    }
    
    
    
//    -------------------OPTIMAL -> O(N), O(N)-------------------------
//    public int findPairs(int[] nums, int k) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        int count=0;
//        for(int i: map.keySet()) {
//            if(k==0) {
//                if(map.get(i)>=2) {
//                    count++;
//                }
//                continue;
//            }
//            if(map.containsKey(i+k)) {
//                count++;
//            }
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        KDiffPairsInAnArray k=new KDiffPairsInAnArray();
        System.out.println(k.findPairs(new int[]{3,1,4,1,5}, 2));
        System.out.println(k.findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(k.findPairs(new int[]{1,3,1,5,4}, 0));
        System.out.println(k.findPairs(new int[]{6,3,5,7,2,3,3,8,2,4}, 2));
    }
}
