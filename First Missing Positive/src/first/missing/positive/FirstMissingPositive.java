/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first.missing.positive;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class FirstMissingPositive {

    /**
     * @param args the command line arguments
     */  

//    ----------------OPTIMAL -> O(N), O(1)---------------
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            while(nums[i]>0 && nums[i]-1<nums.length && nums[nums[i]-1]!=nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    
    
//    ----------------OPTIMAL -> O(N), O(1)---------------
//    public int firstMissingPositive(int[] nums) {
//        for(int i=0; i<nums.length; i++) {
//            if(nums[i]<=0 || nums[i]>nums.length) {
//                nums[i]=nums.length+2;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        for(int i=0; i<nums.length; i++) {
//            int t=Math.abs(nums[i]);
//            if(t<=nums.length && nums[t-1]>0) {
//                nums[t-1]*=-1;
//            }
//            
//        }
//        System.out.println(Arrays.toString(nums));
//        for(int i=0; i<nums.length; i++) {
//            if(nums[i]>0) {
//                return i+1;
//            }
//        }
//        return nums.length+1;
//    }
    
    
    
    
//    -----------------NOT OPTIMAL-> O(N), O(N)----------------
//    public int firstMissingPositive(int[] nums) {
//        boolean[] arr=new boolean[nums.length];
//        for(int i: nums) {
//            if(i>0 && i<=nums.length) {
//                arr[i-1]=true;
//            }
//        }
//        for(int i=0; i<arr.length; i++) {
//            if(!arr[i]) {
//                return i+1;
//            }
//        }
//        return arr.length+1;
//    }
    
    
    
    
    public static void main(String[] args) {
        FirstMissingPositive f=new FirstMissingPositive();
        System.out.println(f.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(f.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(f.firstMissingPositive(new int[]{1}));
    }
}
