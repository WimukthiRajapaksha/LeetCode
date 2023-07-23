/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.pivot.index;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindPivotIndex {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> O(N), O(1)-------------
//    public int pivotIndex(int[] nums) {
//        for(int i=1; i<nums.length; i++) {
//            nums[i]+=nums[i-1];
//        }
//        for(int i=0; i<nums.length; i++) {
//            if(
//                (i==0 && nums[nums.length-1]-nums[0]==0) || 
//                (i==nums.length-1 && nums[i-1]==0) ||
//                (i> 0 && nums[i-1]==nums[nums.length-1]-nums[i])
//            ) return i;
//        }
//        return -1;
//    }
    
    
    
//    --------------OPTIMAL -> O(N), O(1)-------------
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i: nums) {
            sum+=i;
        }
        int leftSum=0;
        for(int i=0; i<nums.length; i++) {
            if(leftSum==sum-leftSum-nums[i]) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FindPivotIndex f=new FindPivotIndex();
        System.out.println(f.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(f.pivotIndex(new int[]{1,2,3}));
        System.out.println(f.pivotIndex(new int[]{2,1,-1}));
    }
}
