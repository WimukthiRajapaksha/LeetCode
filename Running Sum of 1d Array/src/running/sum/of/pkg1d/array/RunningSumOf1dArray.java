/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package running.sum.of.pkg1d.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class RunningSumOf1dArray {

    /**
     * @param args the command line arguments
     */
    
    public int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i]=nums[i]+nums[i-1];
        }
        for (int i: nums) {
            System.out.print(i+" ");
        }
        return nums;
    }
    
    public static void main(String[] args) {
        RunningSumOf1dArray r=new RunningSumOf1dArray();
        r.runningSum(new int[]{3,1,2,10,1});
    }
}
