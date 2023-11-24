/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.duplicate.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheDuplicateNumber {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(N), O(1)---------
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        while(true) {
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast) break;
        }
        slow=0;
        while(slow!=fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
    
//    ----------OPTIMAL -> O(N), O(1)------------
//    public int findDuplicate(int[] nums) {
//        for(int i=0; i<nums.length; i++) {
//            if(nums[Math.abs(nums[i])-1]<0) return Math.abs(nums[i]);
//            nums[Math.abs(nums[i])-1]*=-1;
//        }
//        return -1;
//    }
    
    public static void main(String[] args) {
        FindTheDuplicateNumber f=new FindTheDuplicateNumber();
        System.out.println(f.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
