/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.product.subarray;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumProductSubarray {

    /**
     * @param args the command line arguments
     */
    
    public int maxProduct(int[] nums) {
        int ret=Integer.MIN_VALUE;
        int prod=1;
        for(int i: nums) {
            prod*=i;
            ret=Math.max(prod, ret);
            if(prod==0) {
                prod=1;
            }
        }
        
        prod=1;
        
        for(int i=nums.length-1; i>=0; i--) {
            prod*=nums[i];
            ret=Math.max(prod, ret);
            if(prod==0) {
                prod=1;
            }
        }
        System.out.println(ret);
        return ret;
    }
    
//    public int maxProduct(int[] nums) {
//        int retMax=Integer.MIN_VALUE;
//        int tempMin=1;
//        int tempMax=1;
//        
//        for(int i=0; i<nums.length; i++) {
//            if(nums[i]<0) {
//                int t=tempMin;
//                tempMin=tempMax;
//                tempMax=t;
//            }
//            tempMax=Math.max(nums[i]*tempMax, nums[i]);
//            tempMin=Math.min(nums[i]*tempMin, nums[i]);
//            retMax=Math.max(tempMax, retMax);
//        }
//        System.out.println(retMax);
//        return retMax;
//    }
    
    
//    public int maxProduct(int[] nums) {
//        int retMax=nums[0];
//        int tempMin=nums[0];
//        int tempMax=nums[0];
//        
//        for(int i=1; i<nums.length; i++) {
//            if(nums[i]==0) {
//                tempMax=1;
//                tempMin=1;
//                retMax=Math.max(0, retMax);
//                continue;
//            } else if(nums[i]<0) {
//                int t=tempMax;
//                tempMax=Math.max(nums[i]*tempMin, nums[i]);
//                tempMin=Math.min(nums[i]*t, nums[i]);
//            } else {
//                tempMax=Math.max(nums[i]*tempMax, nums[i]);
//                tempMin=Math.min(nums[i]*tempMin, nums[i]);
//            }
//            retMax=Math.max(tempMax, retMax);
//        }
//        System.out.println(retMax);
//        return retMax;
//    }
    
    public static void main(String[] args) {
        MaximumProductSubarray m=new MaximumProductSubarray();
        m.maxProduct(new int[]{2,3,-2,4});
        m.maxProduct(new int[]{2,3,-2,4,-4});
        m.maxProduct(new int[]{-2,0,-1});
        m.maxProduct(new int[]{3,-1,4});
    }
}
