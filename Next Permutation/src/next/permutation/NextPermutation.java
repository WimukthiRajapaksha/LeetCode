/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package next.permutation;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class NextPermutation {

    /**
     * @param args the command line arguments
     */
    
    public void nextPermutation(int[] nums) {
        int index=nums.length-1;
        while(index>0 && nums[index-1]>=nums[index]) {
            index--;
        }
        if(index==0) {
            swap(nums, 0, nums.length-1);
            return;
        }
        int t=nums.length-1;
        while(t>=index && nums[t]<=nums[index-1]) {
            t--;
        }
        int temp=nums[index-1];
        nums[index-1]=nums[t];
        nums[t]=temp;
        swap(nums, index, nums.length-1);
    }
    
    private void swap(int[] nums, int b, int e) {
        int t;
        while(b<e) {
            t=nums[b];
            nums[b]=nums[e];
            nums[e]=t;
            b++;
            e--;
        }
    }
    
    public static void main(String[] args) {
        NextPermutation n=new NextPermutation();
//        int[] arr=new int[]{4,3,2,1};
//        int[] arr=new int[]{1,2,3,4,3,2,3,4,2};
//        int[] arr=new int[]{1,2,3,4};
        int[] arr=new int[]{1,5,1};
        n.nextPermutation(arr);
        for(int i: arr) {
            System.out.print(i+" ");
        }
    }
}
