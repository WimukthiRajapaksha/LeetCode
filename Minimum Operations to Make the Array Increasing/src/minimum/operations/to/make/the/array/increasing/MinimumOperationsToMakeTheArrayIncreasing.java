/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.operations.to.make.the.array.increasing;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumOperationsToMakeTheArrayIncreasing {

    /**
     * @param args the command line arguments
     */
    
    public int minOperations(int[] nums) {
        int n=0;
        int p=nums[0];
        for (int i=1; i<nums.length; i++) {
            if(nums[i]>p) {
                p=nums[i];
            } else {
                n+=++p-nums[i];
            }
        }
        System.out.println(n);
        return n;
    }
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL AS WE'RE DOING ARRAY VALUE CHANGINGS----------------------
//    public int minOperations(int[] nums) {
//        int c=0;
//        for (int i=1; i<nums.length; i++) {
//            if(nums[i-1]>=nums[i]) {
//                int t=nums[i];
//                nums[i]=nums[i-1]+1;
//                c+=nums[i]-t;
//            }
//        }
//        System.out.println(c);
//        return c;
//    }
    
    public static void main(String[] args) {
        MinimumOperationsToMakeTheArrayIncreasing m=new MinimumOperationsToMakeTheArrayIncreasing();
        m.minOperations(new int[]{1,5,2,4,1});
    }
    
}
