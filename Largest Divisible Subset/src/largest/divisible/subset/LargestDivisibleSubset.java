/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largest.divisible.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class LargestDivisibleSubset {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] length=new int[nums.length];
        int[] prev=new int[nums.length];
        Arrays.sort(nums);
        int max=0;
        int index=0;
        for(int i=0; i<nums.length; i++) {
            length[i]=1;
            prev[i]=-1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]%nums[j]==0 && length[i]<length[j]+1) {
                    length[i]=length[j]+1;
                    prev[i]=j;
                }
            }
            if(max<length[i]) {
                max=length[i];
                index=i;
            }
        }
        List<Integer> ret=new ArrayList<>();
        while(index!=-1) {
            ret.add(nums[index]);
            index=prev[index];
        }
        return ret;
    }
    
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//        List<Integer>[] dp=new ArrayList[nums.length];
//        dp[0]=new ArrayList<>();
//        dp[0].add(nums[0]);
//        for(int i=1; i<dp.length; i++) {
//            dp[i]=new ArrayList<>();
//            int max=-1;
//            for(int j=0; j<i; j++) {
//                if(nums[i]%nums[j]==0 && (max==-1 || dp[max].size()<dp[j].size())) {
//                    max=j;
//                }
//            }
//            if(max!=-1) dp[i].addAll(dp[max]);
//            dp[i].add(nums[i]);
//        }
//        int max=0;
//        for(int i=0; i<dp.length; i++) {
//            if(dp[max].size()<dp[i].size()) {
//                max=i;
//            }
//        }
//        return dp[max];
//    }
    
    public static void main(String[] args) {
        LargestDivisibleSubset l=new LargestDivisibleSubset();
        System.out.println(l.largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(l.largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}
