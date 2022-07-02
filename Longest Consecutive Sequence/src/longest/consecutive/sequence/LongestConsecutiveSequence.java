/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.consecutive.sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestConsecutiveSequence {

    /**
     * @param args the command line arguments
     */
    
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        int max=0;
        for(int i: nums) {
            if(!set.contains(i-1)) {
                int currNum=i+1;
                while(set.contains(currNum)) {
                    currNum++;
                }
                max=Math.max(currNum-i, max);
            }
        }
        return max;
    }
    
    
    
//    public int longestConsecutive(int[] nums) {
//        int max=nums[0];
//        int min=nums[0];
//        for(int i: nums) {
//            if(i>max) {
//                max=i;
//            } else if(i<min) {
//                min=i;
//            }
//        }
//        int[] arr=new int[max-min+1];
//        for(int i: nums) {
//            arr[i-min]++;
//        }
//        int i=0;
//        int maxLen=1;
//        while(i<arr.length) {
//            if(arr[i]!=0) {
//                int tempLen=0;
//                while(i<arr.length && arr[i]!=0) {
//                    i++;
//                    tempLen++;
//                }
//                maxLen=Math.max(maxLen, tempLen);
//            } else {
//                while(i<arr.length && arr[i]==0) {
//                    i++;
//                }
//            }
//        }
//        return maxLen;
//    }
    
    
    
//    public int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        int i=1;
//        int c=1;
//        int maxC=0;
//        while(i<nums.length) {
//            if(nums[i]==nums[i-1]+1) {
//                c++;
//            } else if(nums[i]==nums[i-1]) {
//            } else {
//                maxC = Math.max(c, maxC);
//                c=1;
//            }
//            i++;
//        }
//        maxC = Math.max(c, maxC);
//        return maxC;
//    }
    
    public static void main(String[] args) {
        LongestConsecutiveSequence l=new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(l.longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(l.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
    }
}
