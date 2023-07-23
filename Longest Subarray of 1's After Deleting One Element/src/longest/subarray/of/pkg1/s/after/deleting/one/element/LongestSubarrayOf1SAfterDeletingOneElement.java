/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.subarray.of.pkg1.s.after.deleting.one.element;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestSubarrayOf1SAfterDeletingOneElement {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL, BEAUTIFUL -> O(N), O(1)---------
    public int longestSubarray(int[] nums) {
        int maxLength=0;
        int l=0;
        int k=1;
        for(int r=0;r<nums.length; r++) {
            if(nums[r]==0) {
                k--;
            } 
            while(k<0) {
                if(nums[l]==0) {
                    k++;
                }
                l++;
            }
            maxLength=Math.max(maxLength, r-l);
        }
        return maxLength;
    }
    
    
    
//    -------------OPTIMAL, BEAUTIFUL -> O(N), O(1)---------
//    public int longestSubarray(int[] nums) {
//        int zero=0;
//        int l=0;
//        int r=0;
//        for(; r<nums.length; r++) {
//            if(nums[r]==0) zero++;
//            if(zero>1 && nums[l++]==0) zero--;
//        }
//        return r-l-1;
//    }
    
    public static void main(String[] args) {
        LongestSubarrayOf1SAfterDeletingOneElement l=new LongestSubarrayOf1SAfterDeletingOneElement();
        System.out.println(l.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(l.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(l.longestSubarray(new int[]{1,1,1}));
    }
}
