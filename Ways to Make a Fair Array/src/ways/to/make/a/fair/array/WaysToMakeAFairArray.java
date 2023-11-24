/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ways.to.make.a.fair.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class WaysToMakeAFairArray {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL -> O(N), O(1)---------------
//    public int waysToMakeFair(int[] nums) {
//        int leftO=0;
//        int leftE=0;
//        int rightO=0;
//        int rightE=0;
//        for(int i=0; i<nums.length; i++) {
//            if(i%2==0) {
//                rightE+=nums[i];
//            } else {
//                rightO+=nums[i];
//            }
//        }
//        int count=0;
//        for(int i=0; i<nums.length; i++) {
//            if(i%2==0) {
//                rightE-=nums[i];
//            } else {
//                rightO-=nums[i];
//            }
//            if(leftO+rightE==leftE+rightO) count++;
//            if(i%2==0) {
//                leftE+=nums[i];
//            } else {
//                leftO+=nums[i];
//            }
//        }
//        return count;
//    }
    
    
//    ---------------------OPTIMAL -> O(N), O(1)---------------
    public int waysToMakeFair(int[] nums) {
        int[] left=new int[2];
        int[] right=new int[2];
        for(int i=0; i<nums.length; i++) {
            right[i%2]+=nums[i];
        }
        int count=0;
        for(int i=0; i<nums.length; i++) {
            right[i%2]-=nums[i];
            if(left[0]+right[1]==left[1]+right[0]) count++;
            left[i%2]+=nums[i];
        }
        return count;
    }
    
    public static void main(String[] args) {
        WaysToMakeAFairArray w=new WaysToMakeAFairArray();
        System.out.println(w.waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(w.waysToMakeFair(new int[]{1,1,1}));
        System.out.println(w.waysToMakeFair(new int[]{1,2,3}));
    }
}
