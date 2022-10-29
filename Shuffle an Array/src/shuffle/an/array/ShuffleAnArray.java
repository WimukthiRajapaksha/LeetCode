/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuffle.an.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums=nums;
        this.rand=new Random();
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    private int[] copy() {
        int[] ret=new int[this.nums.length];
        for(int i=0; i<nums.length; i++) {
            ret[i]=nums[i];
        }
        return ret;
    }
    
    private void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    
    public int[] shuffle() {
        int[] ret=this.copy();
        for(int i=nums.length-1; i>=0; i--) {
            swap(ret, i, this.rand.nextInt(i+1));
        }
        return ret;
    }
}

public class ShuffleAnArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution s=new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
    }
}
