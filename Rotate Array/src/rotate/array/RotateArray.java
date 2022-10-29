/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotate.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class RotateArray {

    /**
     * @param args the command line arguments
     */
    
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k==0) return;
        int start=0;
        int curr=k;
        for(int i=0; i<nums.length; i++) {
            if(start==curr) {
                start++;
                curr=(start+k)%nums.length;
                continue;
            }
            int t=nums[start];
            nums[start]=nums[curr];
            nums[curr]=t;
            curr=(curr+k)%nums.length;
        }
    }
    
    
//    public void rotate(int[] nums, int k) {
//        k=k%nums.length;
//        if(k==0) return;
//        reverse(nums, 0, nums.length-1);
//        reverse(nums, 0, k-1);
//        reverse(nums, k, nums.length-1);
//    }
//    
//    private void reverse(int[] nums, int i, int j) {
//        while(i<j) {
//            int t=nums[i];
//            nums[i++]=nums[j];
//            nums[j--]=t;
//        }
//    }
    
    public static void main(String[] args) {
        RotateArray r=new RotateArray();
        int[] a=new int[]{1,2,3,4,5,6,7,8,9};
        r.rotate(a, 3);
        for(int i: a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
