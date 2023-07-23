/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiggle.sort.ii;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author wimukthirajapaksha
 */
public class WiggleSortII {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N), O(1)----------------------
    public void wiggleSort(int[] nums) {
        int mid=(nums.length+1)>>1;
        int median=kthLargestNumber(nums, mid);
        int left=0;
        int right=nums.length-1;
        for(int i=0; i<=right;) {
            if(nums[vertualIndex(i, nums.length)]>median) {
                swap(nums, vertualIndex(left++, nums.length), vertualIndex(i++, nums.length));
            } else if(nums[vertualIndex(i, nums.length)]<median) {
                swap(nums, vertualIndex(right--, nums.length), vertualIndex(i, nums.length));
            } else {
                i++;
            }
        }
    }
    
    private int kthLargestNumber(int[] nums, int k) {
        int left=0;
        int right=nums.length-1;
        --k;
        while(left<=right) {
            int rand=new Random().nextInt(right-left+1)+left;
            swap(nums, rand, right);
            int l=left-1;
            int t=nums[right];
            for(int i=left; i<=right; i++) {
                if(nums[i]<t) {
                    swap(nums, i, ++l);
                }
            }
            swap(nums, right, ++l);
            if(nums.length-l-1==k) return nums[l];
            else if(nums.length-l-1<k) {
                right=l-1;
            } else {
                left=l+1;
            }
        }
        return left;
    }
    
    private int vertualIndex(int i, int len) {
        return (1+(2*i))%(len|1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    public static void main(String[] args) {
        WiggleSortII w=new WiggleSortII();
        int[] arr=new int[]{1,5,1,1,6,4};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
        arr=new int[]{1,3,2,2,3,1};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
        arr=new int[]{5,6,1};
        w.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
