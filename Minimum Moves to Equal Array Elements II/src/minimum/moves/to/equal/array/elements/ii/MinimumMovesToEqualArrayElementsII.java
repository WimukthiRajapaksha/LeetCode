/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.moves.to.equal.array.elements.ii;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumMovesToEqualArrayElementsII {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(N*LOG(N)), O(1)---------------
//    public int minMoves2(int[] nums) {
//        Arrays.sort(nums);
//        int mid=(nums.length%2==0) ? (nums[nums.length/2]+nums[nums.length/2-1])/2 : nums[nums.length/2];
//        long sum=0;
//        for(int i: nums) {
//            sum+= Math.abs(i-mid);
//        }
//        return (int)sum;
//    }
    
    
    
//    --------------OPTIMAL -> O(N*LOG(N)), O(1)---------------
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int low=0;
        int high=nums.length-1;
        int sum=0;
        while(low<high) {
            sum+=nums[high--]-nums[low++];
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII m=new MinimumMovesToEqualArrayElementsII();
        System.out.println(m.minMoves2(new int[]{1,2,3}));
        System.out.println(m.minMoves2(new int[]{1,10,2,9}));
    }
}
