/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic.slices;

/**
 *
 * @author wimukthirajapaksha
 */
public class ArithmeticSlices {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> O(N), O(1)-------------------
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int count=0;
        int matching=0;
        for(int i=0; i<nums.length-2; i++) {
            if(nums[i+1]-nums[i]==nums[i+2]-nums[i+1]) {
                matching++;
            } else {
                count+=(matching*(matching+1)/2);
                matching=0;
            }
        }
        if(matching>0) count+=(matching*(matching+1)/2);
        return count;
    }
    
    
//    -------------------------NOT OPTIMAL-> O(N^2), O(1)--------------------
//    public int numberOfArithmeticSlices(int[] nums) {
//        if(nums.length<3) return 0;
//        int count=0;
//        for(int i=0; i<nums.length-2; i++) {
//            int diff=nums[i+1]-nums[i];
//            for(int j=i+2; j<nums.length; j++) {
//                if(nums[j]-nums[j-1]==diff) {
//                    count++;
//                } else {
//                    break;
//                }
//            }
//        }
//        return count;
//    }
    
    
//    -------------------------NOT OPTIMAL-> O(n^2), O(1)--------------------
//    public int numberOfArithmeticSlices(int[] nums) {
//        if(nums.length<3) return 0;
//        int count=0;
//        int curr=0;
//        int diff=nums[1]-nums[0];
//        while(curr+2<nums.length) {
//            int temp=curr+1;
//            while(temp<nums.length && diff==nums[temp]-nums[temp-1]) {
//                temp++;
//            }
//            temp--;
//            if(temp-curr>=2) {
//                int val=temp-curr-1;
//                count+=(val*(val+1)/2);
//            }
//            curr=temp;
//            if(curr+1<nums.length) diff=nums[curr+1]-nums[curr];
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        ArithmeticSlices a=new ArithmeticSlices();
        System.out.println(a.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(a.numberOfArithmeticSlices(new int[]{1}));
        System.out.println(a.numberOfArithmeticSlices(new int[]{4,4,4,4,4,4}));
    }
}
