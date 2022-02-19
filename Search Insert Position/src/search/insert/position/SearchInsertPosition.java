/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.insert.position;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchInsertPosition {

    /**
     * @param args the command line arguments
     */
    
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int mid=0;
        while(i<=j) {
            mid=(i+j)/2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]<target) {
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        s.searchInsert(new int[]{1,3,5,6}, 5);
        s.searchInsert(new int[]{1,3,5,6}, 2);
        s.searchInsert(new int[]{1,3,5,7}, 6);
    }
}
