/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.size.subarray.sum;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumSizeSubarraySum {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------------OPTIMAL -> BST---------------------
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(i>0) nums[i]+=nums[i-1];
            if(nums[i]<target) continue;
            int closest=bst(nums, i, target);
            min=Math.min(min, i-closest+1);
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
    
    private int bst(int[] nums, int end, int target) {
        int start=0;
        int totalVal=nums[end];
        while(start<=end) {
            int m=start+(end-start)/2;
            int diff=totalVal-nums[m];
            if(diff==target) return m+1;
            else if(diff>target) start=m+1;
            else end=m-1;
        }
        return start;
    }
    
    
    
//    ----------------------OPTIMAL -> SLIDING WINDOW---------------------------
//    public int minSubArrayLen(int target, int[] nums) {
//        int min=Integer.MAX_VALUE;
//        int i=0;
//        int j=0;
//        int s=0;
//        while(j<nums.length) {
//            s+=nums[j];
//            while(target<=s) {
//                min=Math.min(min, j-i+1);
//                s-=nums[i++];
//            }
//            j++;
//        }
//        return min==Integer.MAX_VALUE ? 0 : min;
//    }
    
    
    

//    -------------------ALTERNATE -> NOT OPTIMAL---------------------
//    public int minSubArrayLen(int target, int[] nums) {
//        int min=Integer.MAX_VALUE;
//        int[] num=new int[nums.length+1];
//        for(int i=0; i<nums.length; i++) {
//            num[i+1]=num[i]+nums[i];
//        }
//        if(num[num.length-1]<target) return 0;
//        int i=0;
//        int j=1;
//        for(int n: num) {
//            System.out.print(n+" ");
//        }
//        System.out.println();
//        while(j<num.length) {
//            if(target<=num[j]-num[i]) {
//                i++;
//                min=Math.min(min, j-i+1);
//            } else {
//                j++;
//            }
//        }
//        return min;
//    }
    
    public static void main(String[] args) {
        MinimumSizeSubarraySum m=new MinimumSizeSubarraySum();
        System.out.println(m.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(m.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(m.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(m.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
