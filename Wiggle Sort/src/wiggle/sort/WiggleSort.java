/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiggle.sort;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class WiggleSort {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(N)-----------------------
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if((i%2==0 && nums[i-1]<=nums[i]) || (i%2==1 && nums[i-1]>=nums[i])) {
                swap(nums, i);
            }
        }
    }
    
    
//    ----------------------ALTERNATE -> O(NLOGN)--------------
//    public void wiggleSort(int[] nums) {
//        Arrays.sort(nums);
//        for(int i=2; i<nums.length; i+=2) {
//            swap(nums, i);
//        }
//    }
    
    private void swap(int[] nums, int p) {
        int t=nums[p-1];
        nums[p-1]=nums[p];
        nums[p]=t;
    }
    
    public static void main(String[] args) {
        WiggleSort w=new WiggleSort();
        int[] arr=new int[]{3,5,2,1,6,4};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
        
        arr=new int[]{1,2,3,4,5,6};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
        
        arr=new int[]{6,5,4,3,2,1};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
