/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.in.rotated.sorted.array.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchInRotatedSortedArrayII {

    /**
     * @param args the command line arguments
     */
    
    public boolean search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return true;
            if(nums[start]==nums[mid] && nums[end]==nums[mid]) {
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]) {
                if(nums[start]<=target && target<nums[mid]) {
                    end=mid-1;
                } else {
                    start=mid+1;
                }
            } else {
                if(nums[mid]<target && target<=nums[end]) {
                    start=mid+1;
                } else {
                    end=mid-1;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII s=new SearchInRotatedSortedArrayII();
        System.out.println(s.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(s.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(s.search(new int[]{1,0,1,1,1}, 0));
        System.out.println(s.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }
}
