/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.consecutive.ones.iii;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaxConsecutiveOnesIII {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL -> O(N), O(1)----------
//    public int longestOnes(int[] nums, int k) {
//        int l=0;
//        int r=0;
//        int max=0;
//        while(r<nums.length) {
//            if(k>0 || nums[r]==1) {
//                if(nums[r]==0) {
//                    k--;
//                }
//                r++;
//            } else {
//                max=Math.max(max, r-l);
//                while(nums[l]==1 && l<r) {
//                    l++;
//                }
//                k++;
//                l++;
//            }
//        }
//        max=Math.max(max, r-l);
//        return max;
//    }
    
    
    
//    -------------OPTIMAL - BEAUTIFUL -> O(N), O(1)----------
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        for(;r<nums.length; r++) {
            if(nums[r]==0) k--;
            if(k<0 && nums[l++]==0) k++;
        }
        return r-l;
    }


    public static void main(String[] args) {
        MaxConsecutiveOnesIII m=new MaxConsecutiveOnesIII();
        System.out.println(m.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(m.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(m.longestOnes(new int[]{0,0,0,0}, 2));
    }
}
