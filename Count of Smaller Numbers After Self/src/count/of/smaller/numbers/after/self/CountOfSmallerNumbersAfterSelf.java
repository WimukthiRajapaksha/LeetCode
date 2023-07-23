/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountOfSmallerNumbersAfterSelf {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret=new ArrayList(nums.length);
        for(int i=nums.length-1; i>=0; i--) {
            int v=bst(nums, i, nums.length-1, nums[i]);
            shift(nums, i, v);
            ret.set(i, nums.length-1-v);
            System.out.println(Arrays.toString(nums)+" "+ret);
        }
        return ret;
    }
    
    private void shift(int[] arr, int i, int j) {
        int t=arr[i];
        for(int k=i; k<j; k++) {
            arr[k]=arr[k+1];
        }
        arr[j]=t;
    }
    
    private int bst(int[] arr, int l, int r, int t) {
        int m;
        while(l<=r) {
            m=l+(r-l)/2;
            if(arr[m]<t) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return r;
    }
    
    
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> arr=new ArrayList<>();
//        List<Integer> ret=new ArrayList<>();
//        for(int i=nums.length-1; i>=0; i--) {
//            int v=bst(arr, 0, arr.size()-1, nums[i]);
//            arr.add(v, nums[i]);
//            ret.add(v);
//        }
//        Collections.reverse(ret);
//        return ret;
//    }
//    
//    private int bst(List<Integer> arr, int l, int r, int t) {
//        int m;
//        while(l<=r) {
//            m=l+(r-l)/2;
//            if(arr.get(m)<t) {
//                l=m+1;
//            } else {
//                r=m-1;
//            }
//        }
//        return l;
//    }
    
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c=new CountOfSmallerNumbersAfterSelf();
        System.out.println(c.countSmaller(new int[]{5,2,6,1}));
        System.out.println(c.countSmaller(new int[]{-1}));
        System.out.println(c.countSmaller(new int[]{-1,-1}));
    }
}
