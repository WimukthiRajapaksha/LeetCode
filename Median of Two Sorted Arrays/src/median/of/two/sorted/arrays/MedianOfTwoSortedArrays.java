/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package median.of.two.sorted.arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MedianOfTwoSortedArrays {

    /**
     * @param args the command line arguments
     */
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int x=nums1.length;
        int y=nums2.length;
        
        int low=0;
        int high=x;
        while(low<=high) {
            int partitionX=(low+high)/2;
            int partitionY=(y+x+1)/2-partitionX;
            
            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX==x) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY==y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX<=minRightY && maxLeftY<=minRightX) return ((x+y)%2==0) ? (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2.0 : Math.max(maxLeftX, maxLeftY);
            else if (maxLeftX>minRightY) high=partitionX-1;
            else low=partitionX+1;
        }
        return 0;
    }
    
    
//    ----------------------------OPTIMAL -> NOT REFACTORED-------------------------
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length>nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//        int x=nums1.length;
//        int y=nums2.length;
//        
//        int low=0;
//        int high=x;
//        while(low<=high) {
//            int partitionX=(low+high)/2;
//            int partitionY=(y+x+1)/2-partitionX;
//            System.out.println(partitionX+" - "+partitionY);
//            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : nums1[partitionX-1];
//            int minRightX = (partitionX==x) ? Integer.MAX_VALUE : nums1[partitionX];
//            
//            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : nums2[partitionY-1];
//            int minRightY = (partitionY==y) ? Integer.MAX_VALUE : nums2[partitionY];
//            
//            if (maxLeftX<=minRightY && maxLeftY<=minRightX) {
//                if((x+y)%2==0) {
//                    return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2.0;
//                } else {
//                    return Math.max(maxLeftX, maxLeftY);
//                }
//            } else if (maxLeftX>minRightY) {
//                high=partitionX-1;
//            } else {
//                low=partitionX+1;
//            }
//        }
//        return 0;
//    }
    
    
//    ------------------ALTERNATE -> NAIVE APPROACH -> NOT OPTIMAL------------------
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] n=new int[nums1.length+nums2.length];
//        int l=n.length;
//        int i=0;
//        int j=0;
//        while(i<nums1.length || j<nums2.length) {
//            if (i>=nums1.length) {
//                n[i+j]=nums2[j++];
//            } else if (j>=nums2.length) {
//                n[i+j]=nums1[i++];
//            } else if (nums1[i]<nums2[j]) {
//                n[i+j]=nums1[i++];
//            } else {
//                n[i+j]=nums2[j++];
//            }
//        }
//        if (l%2==0) {
//            return (n[l/2-1]+n[l/2])/2.0;
//        } else {
//            return n[l/2];
//        }
//    }
    
    public static void main(String[] args) {
        MedianOfTwoSortedArrays m=new MedianOfTwoSortedArrays();
        System.out.println(m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
