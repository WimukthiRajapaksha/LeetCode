/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicates.from.sorted.array.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * @param args the command line arguments
     */
    
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int i=0;
        for(int j: nums) {
            if(i<2 || nums[i-2]!=j) {
                nums[i++]=j;
            }
        }
        System.out.println("\n"+i);
        for(int a: nums) {
            System.out.print(a+" ");
        }
        return i;
    }
    
    
//    --------------------ALTERNATE -> OPTIMAL-------------------------
//    public int removeDuplicates(int[] nums) {
//        if(nums.length<=2) return nums.length;
//        int i=0;
//        int j=1;
//        while(j<nums.length) {
//            if(nums[i]==nums[j]) {
//                nums[++i]=nums[j];
//                while(j<nums.length && nums[i]==nums[j]) j++;
//            } else {
//                nums[++i]=nums[j++];
//            }
//        }
//        System.out.println("\n"+(i+1));
//        for(int a: nums) {
//            System.out.print(a+" ");
//        }
//        return i+1;
//    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII r=new RemoveDuplicatesFromSortedArrayII();
        r.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        r.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
