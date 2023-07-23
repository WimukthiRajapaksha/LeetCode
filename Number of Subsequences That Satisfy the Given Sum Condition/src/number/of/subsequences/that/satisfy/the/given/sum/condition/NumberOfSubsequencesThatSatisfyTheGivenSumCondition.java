/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.subsequences.that.satisfy.the.given.sum.condition;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    /**
     * @param args the command line arguments
     */
    
    
//    -------OPTIMAL -> O(N*LOG(N)), O(N)-----------
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums[0]>target) return 0;
        int count=0;
        int mod=1_000_000_007;
        int l=0;
        int r=nums.length-1;
        int[] pow=new int[nums.length];
        pow[0]=1;
        for(int i=1; i<nums.length; i++) {
            pow[i]=(pow[i-1]<<1)%mod;
        }
        while(l<=r) {
            if(l<=r && nums[l]+nums[r]<=target) {
                count=(count+pow[r-l++])%mod;
            } else {
                r--;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition n=new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        System.out.println(n.numSubseq(new int[]{3,5,6,7}, 9));
        System.out.println(n.numSubseq(new int[]{3,3,6,8}, 10));
        System.out.println(n.numSubseq(new int[]{2,3,3,4,6,7}, 12));
    }
}
