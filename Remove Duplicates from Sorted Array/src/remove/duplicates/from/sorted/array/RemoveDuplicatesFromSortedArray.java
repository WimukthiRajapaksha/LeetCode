/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicates.from.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * @param args the command line arguments
     */
    
    public int removeDuplicates(int[] nums) {
        if (nums.length==0 || nums.length==1) {
            return nums.length;
        }
        int j=1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1]<nums[i]) {
                nums[j++]=nums[i];
            }
        }
        return j;
    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        r.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
