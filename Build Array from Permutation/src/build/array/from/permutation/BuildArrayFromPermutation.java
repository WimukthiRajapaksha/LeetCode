/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build.array.from.permutation;

/**
 *
 * @author wimukthirajapaksha
 */
public class BuildArrayFromPermutation {

    /**
     * @param args the command line arguments
     */
    
//    -------------------WITHOUT COUPING ELEMENTS TO ANOTHER ARRAY-----------------
    public int[] buildArray(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            nums[i]=nums[i]+(nums.length*(nums[nums[i]]%nums.length));
        }
        for(int i=0; i<nums.length; i++) {
            nums[i]=nums[i]/nums.length;
        }
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        return nums;
    }
    
    public static void main(String[] args) {
        BuildArrayFromPermutation b=new BuildArrayFromPermutation();
        b.buildArray(new int[]{5,0,1,2,3,4});
//        b.buildArray(new int[]{5,0,1,2,3,4});
    }
}
