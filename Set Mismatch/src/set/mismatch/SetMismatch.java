/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.mismatch;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class SetMismatch {

    /**
     * @param args the command line arguments
     */
    
    
//    -------OPTIMAL -> O(N), O(1)----------
    public int[] findErrorNums(int[] nums) {
        int dup=0;
        int miss=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[Math.abs(nums[i])-1]<0) {
                dup=Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                miss = i+1;
            }
        }
        return new int[]{dup, miss};
    }
    
    public static void main(String[] args) {
        SetMismatch s=new SetMismatch();
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1,1})));
    }
}
