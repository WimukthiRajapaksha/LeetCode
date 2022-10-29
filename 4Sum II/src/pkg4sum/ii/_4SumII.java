/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4sum.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class _4SumII {

    /**
     * @param args the command line arguments
     */
    
//    --------------------------OPTIMAL-------------------------
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        int min=Math.min(nums1[0]+nums2[0], -(nums3[nums3.length-1]+nums4[nums4.length-1]));
        int max=Math.max(nums1[nums1.length-1]+nums2[nums1.length-1], -(nums3[0]+nums4[0]));
        
        int[] arr=new int[max-min+1];
        
        for(int i: nums1) {
            for(int j: nums2) {
                arr[i+j-min]++;
            }
        }
        int count=0;
        for(int i: nums3) {
            for(int j:nums4) {
                count+=arr[-i-j-min];
            }
        }
        return count;
    }
    
    
//    -----------------------OPTIMAL------------------------
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums1) {
//            for(int j: nums2) {
//                map.put(i+j, map.getOrDefault(i+j, 0)+1);
//            }
//        }
//        int count=0;
//        for(int i: nums3) {
//            for(int j:nums4) {
//                if(map.containsKey(-(i+j))) {
//                    count+=map.get(-(i+j));
//                }
//            }
//        }
//        return count;
//    }
    
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL -> CAN BE REDUCED TO ONE MAP----------------------------
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        Map<Integer, Integer> m1=new HashMap<>();
//        Map<Integer, Integer> m2=new HashMap<>();
//        for(int i=0; i<nums1.length; i++) {
//            for(int j=0; j<nums1.length; j++) {
//                m1.put(nums1[i]+nums2[j], m1.getOrDefault(nums1[i]+nums2[j], 0)+1);
//                m2.put(nums3[i]+nums4[j], m2.getOrDefault(nums3[i]+nums4[j], 0)+1);
//            }
//        }
//        int count=0;
//        System.out.println(m1);
//        System.out.println(m2);
//        for(int i: m1.keySet()) {
//            if(m2.containsKey(-i)) {
//                count+=(m1.get(i)*m2.get(-i));
//            }
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        _4SumII f=new _4SumII();
        System.out.println(f.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }
}
