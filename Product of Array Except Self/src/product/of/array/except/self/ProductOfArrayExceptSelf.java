/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.of.array.except.self;

/**
 *
 * @author wimukthirajapaksha
 */
public class ProductOfArrayExceptSelf {

    /**
     * @param args the command line arguments
     */
    
    public int[] productExceptSelf(int[] nums) {
        int[] ret=new int[nums.length];
        ret[0]=1;
        for(int i=1; i<nums.length-1; i++) {
            ret[i]=ret[i-1]*nums[i-1];
        }
        int pre=1;
        for(int i=nums.length-1; i>=0; i--) {
            ret[i]=ret[i]*pre;
            pre=pre*nums[i];
        }
        for(int i: ret) {
            System.out.print(i+" ");
        }
        System.out.println();
        return ret;
    }
    
    
//    public int[] productExceptSelf(int[] nums) {
//        int[] prefix=new int[nums.length];
//        int[] postfix=new int[nums.length];
//        prefix[0]=1;
//        for(int i=0; i<nums.length-1; i++) {
//            prefix[i+1]=prefix[i]*nums[i];
//        }
//        postfix[postfix.length-1]=1;
//        for(int i=nums.length-2; i>=0; i--) {
//            postfix[i]=postfix[i+1]*nums[i+1];
//        }
//        for(int i=0; i<nums.length; i++) {
//            nums[i]=prefix[i]*postfix[i];
//        }
//        for(int i: nums) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        return nums;
//    }
    
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p=new ProductOfArrayExceptSelf();
        p.productExceptSelf(new int[]{1,2,3,4});
        p.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
