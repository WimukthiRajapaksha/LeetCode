/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.triangle.number;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidTriangleNumber {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------------OPTIMAL -> O(N^2), O(N)-----------------------------
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=nums.length-1; i>=2; i--) {
            int l=0;
            int r=i-1;
            while(l<r) {
                if(nums[l]+nums[r]>nums[i]) {
                    count+=r-l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        ValidTriangleNumber v=new ValidTriangleNumber();
        System.out.println(v.triangleNumber(new int[]{2,2,3,4}));
        System.out.println(v.triangleNumber(new int[]{4,2,3,4}));
    }
}
