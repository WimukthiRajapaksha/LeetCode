/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.in.rotated.sorted.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchInRotatedSortedArray {

    /**
     * @param args the command line arguments
     */
    
    public int search(int[] nums, int target) {
        int b=0;
        int e=nums.length-1;
        int m=0;
        while(b<e) {
            m=(b+e)/2;
            if(nums[m]>nums[e]) {
                b=m+1;
            } else {
                e=m;
            }
        }
        System.out.println(m+" "+b);
        m=b;
        if(nums[b]<=target && nums[nums.length-1]>=target) {
            return bin(nums, b, nums.length-1, target);
        } else {
            return bin(nums, 0, b-1, target);
        }
    }
    
    private int bin(int[] nums, int i, int j, int t) {
        int m;
        while(i<=j) {
            m=(i+j)/2;
            if(nums[m]==t) return m;
            else if (nums[m]<t) {
                i=m+1;
            } else {
                j=m-1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        SearchInRotatedSortedArray s=new SearchInRotatedSortedArray();
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(s.search(new int[]{1}, 0));
        System.out.println(s.search(new int[]{1,3}, 3));
//        System.out.println(s.search(new int[]{3,1}, 1));
    }
}
