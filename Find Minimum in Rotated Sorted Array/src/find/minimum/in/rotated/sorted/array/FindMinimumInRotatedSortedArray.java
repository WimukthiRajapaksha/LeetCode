/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.minimum.in.rotated.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * @param args the command line arguments
     */
    
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int l=0;
        int r=nums.length-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if(nums[m]>nums[r]) {
                l=m+1;
            } else {
                r=m;
            }
        }
        return nums[l];
    }
    
    
//    public int findMin(int[] nums) {
//        if(nums.length==1) return nums[0];
//        int l=0;
//        int r=nums.length-1;
//        while(l<r) {
//            int m=l+(r-l)/2;
//            if(m>0 && nums[m]<nums[m-1]) return nums[m];
//            if(nums[m]>nums[r]) {
//                l=m+1;
//            } else {
//                r=m;
//            }
//        }
//        return nums[l];
//    }
    
    
    
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f=new FindMinimumInRotatedSortedArray();
        System.out.println(f.findMin(new int[]{4,5,6,7,2,3}));
        System.out.println(f.findMin(new int[]{3,4,5,1,2}));
        System.out.println(f.findMin(new int[]{11,13,15,17}));
        System.out.println(f.findMin(new int[]{2,1}));
    }
}
