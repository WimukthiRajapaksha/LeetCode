/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single.element.in.a.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class SingleElementInASortedArray {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL -> O(NLOGN), O(1)-----------------
//    public int singleNonDuplicate(int[] nums) {
//        int l=0;
//        int r=nums.length-1;
//        while(l<r) {
//            int m=l+(r-l)/2;
//            if((m%2==0 && nums[m]==nums[m+1]) || (m%2==1 && nums[m]==nums[m-1])) {
//                l=m+1;
//            } else {
//                r=m;
//            }
//        }
//        return nums[l];
//    }
    
    
    
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if(nums[m]==nums[m^1]) {
                l=m+1;
            } else {
                r=m;
            }
        }
        return nums[l];
    }
    
    
    
//    ---------------------OPTIMAL -> O(NLOGN), O(1)-----------------
//    public int singleNonDuplicate(int[] nums) {
//        int l=0;
//        int r=nums.length-1;
//        while(l<r) {
//            int m=l+(r-l)/2;
//            if(m%2==1) {
//                m--;
//            } 
//            if(nums[m]!=nums[m+1]) {
//                r=m;
//            } else {
//                l=m+2;
//            }
//        }
//        return nums[l];
//    }
    
    
//    ---------------------OPTIMAL -> O(NLOGN), O(1)-----------------
//    public int singleNonDuplicate(int[] nums) {
//        return bs(nums, 0, nums.length-1);
//    }
//
//    public int bs(int[] nums, int l, int r) {
//        if(l>=r) return nums[l];
//        int m=l+((r-l)/2);
//        if(m%2==0) {
//            if(m+1<nums.length && nums[m]==nums[m+1]) {
//                return bs(nums, m+2, r);
//            }
//            return bs(nums, l, m);
//        } else {
//            if(m-1>=0 && nums[m-1]==nums[m]) {
//                return bs(nums, m+1, r);
//            }
//            return bs(nums, l, m);
//        }
//    }
    
    public static void main(String[] args) {
        SingleElementInASortedArray s=new SingleElementInASortedArray();
        System.out.println(s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
