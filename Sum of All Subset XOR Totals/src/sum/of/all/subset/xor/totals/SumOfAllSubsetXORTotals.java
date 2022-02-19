/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.all.subset.xor.totals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfAllSubsetXORTotals {

    /**
     * @param args the command line arguments
     */
    
    public int subsetXORSum(int[] nums) {
        int c=0;
        for (int i: nums) {
            c|=i;
        }
        System.out.println(c*Math.pow(2, nums.length-1));
        return c*(1<<(nums.length-1)); // SAME THING -> c*(int)Math.pow(2, nums.length-1);
    }
    
    
//    -----------------------ALTERNATE -> RECURSIVE------------------------------
//    public int subsetXORSum(int[] nums) {
//        int c=0;
//        c=xor(nums, 0, 0);
//        System.out.println(c);
//        return c;
//    }
//    
//    public int xor(int[] nums, int i, int c) {
//        if(i==nums.length) {
//            return c;
//        }
//        return xor(nums, i+1, c^nums[i])+xor(nums, i+1, c);
//    }
    
    
//    -----------------------ALTERNATE -> NOT OPTIMAL------------------------------
//    public int subsetXORSum(int[] nums) {
//        int c=0;
//        for(int i=0; i<(1<<nums.length); i++) {
//            int t=0;
//            for(int j=0; j<nums.length; j++) {
//                if((i&(1<<j))!=0) {
//                    t^=nums[j];
//                }
//            }
//            c+=t;
//        }
//        System.out.println(c);
//        return c;
//    }
    
    public static void main(String[] args) {
        SumOfAllSubsetXORTotals s=new SumOfAllSubsetXORTotals();
        s.subsetXORSum(new int[]{5,1,6});
        s.subsetXORSum(new int[]{3,4,5,6,7,8});
        int[] arr;
        if (arr==null) {
            System.out.println("null");
        }
    }
}
