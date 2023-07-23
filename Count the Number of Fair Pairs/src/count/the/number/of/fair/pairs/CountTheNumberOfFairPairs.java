/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.the.number.of.fair.pairs;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountTheNumberOfFairPairs {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL -> O(N^2), O(1)----------------------------
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper)-count(nums, lower-1);
    }
    
    private long count(int[] nums, int val) {
        long res=0;
        for(int i=0, j=nums.length-1; i<j; i++) {
            while(i<j && nums[i]+nums[j]>val) {
                j--;
            }
            res+=j-i;
        }
        return res;
    }

    public static void main(String[] args) {
        CountTheNumberOfFairPairs c=new CountTheNumberOfFairPairs();
        System.out.println(c.countFairPairs(new int[]{0,1,7,4,4,5}, 3, 6));
    }
}
