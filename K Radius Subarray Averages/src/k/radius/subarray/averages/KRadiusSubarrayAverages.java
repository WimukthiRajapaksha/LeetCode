/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.radius.subarray.averages;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class KRadiusSubarrayAverages {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N), O(1)-------------
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int[] ret=new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            ret[i]=-1;
        }
        if(k>(nums.length-1)/2) {
            return ret;
        }
        long sum=0;
        for(int i=0; i<2*k; i++) {
            sum+=nums[i];
        }
        for(int i=0; i<nums.length-(2*k); i++) {
            sum+=nums[i+(2*k)];
            ret[i+k]=(int)(sum/(2*k+1));
            sum-=nums[i];
        }
        return ret;
    }
    
    
    
//    --------------OPTIMAL -> O(N), O(N)-------------
//    public int[] getAverages(int[] nums, int k) {
//        if(k==0) return nums;
//        int[] ret=new int[nums.length];
//        for(int i=0; i<nums.length; i++) {
//            ret[i]=-1;
//        }
//        if(k>(nums.length-1)/2) {
//            return ret;
//        }
//        long[] prefSum=new long[nums.length+1];
//        for(int i=0; i<nums.length; i++) {
//            prefSum[i+1]=prefSum[i]+nums[i];
//        }
//        for(int i=k; i<nums.length-k; i++) {
//            ret[i]=(int)((prefSum[i+k+1]-prefSum[i-k])/(2*k+1));
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        KRadiusSubarrayAverages k=new KRadiusSubarrayAverages();
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 0)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 1)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 2)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 4)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 5)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 6)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{100000}, 0)));
        System.out.println(Arrays.toString(k.getAverages(new int[]{100000}, 1)));
    }
}
