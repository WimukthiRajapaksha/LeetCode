/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.minimum.in.rotated.sorted.array.ii;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindMinimumInRotatedSortedArrayII {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(LOGN), O(1) -> WORST -> O(N)---------------
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if(nums[m]==nums[r]) {
                r--;
            } else if(nums[m]<nums[r]) {
                r=m;
            } else {
                l=m+1;
            }
        }
        return nums[l];
    }
    
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII f=new FindMinimumInRotatedSortedArrayII();
        System.out.println(f.findMin(new int[]{1,3,5}));
        System.out.println(f.findMin(new int[]{2,2,2,0,1}));
        System.out.println(f.findMin(new int[]{0,1,4,4,5,6,7}));
        System.out.println(f.findMin(new int[]{4,5,6,7,0,1,4}));
        System.out.println(f.findMin(new int[]{0,1,4,4,5,6,7}));
        System.out.println(f.findMin(new int[]{1,0,1,1,1,1}));
        System.out.println(f.findMin(new int[]{1,1,1,1,0,1}));
    }
}
