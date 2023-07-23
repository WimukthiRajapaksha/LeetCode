/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.cost.to.make.array.equal;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumCostToMakeArrayEqual {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL -> O(N*LOG(N)), O(N)---------------------
//    public long minCost(int[] nums, int[] cost) {
//        int n=nums.length;
//        int[][] grid=new int[n][2];
//        for(int i=0; i<nums.length; i++) {
//            grid[i]=new int[]{nums[i], cost[i]};
//        }
//        Arrays.sort(grid, (a, b)-> a[0]-b[0]);
//        for(int[] g: grid) {
//            System.out.println(Arrays.toString(g));
//        }
//        long[] prefCost=new long[n+1];
//        for(int i=0; i<nums.length; i++) {
//            prefCost[i+1]=prefCost[i]+grid[i][1];
//        }
//        System.out.println(Arrays.toString(prefCost));
//        long totalCost=0;
//        for(int i=0; i<nums.length; i++) {
//            totalCost+=(long)grid[i][1]*(grid[i][0]-grid[0][0]);
//        }
//        long res=totalCost;
//        for(int i=1; i<nums.length; i++) {
//            long gap=grid[i][0]-grid[i-1][0];
//            totalCost+=gap*prefCost[i];
//            totalCost-=gap*(prefCost[prefCost.length-1]-prefCost[i]);
//            if(totalCost<res) res=totalCost;
//        }
//        return res;
//    }
    
    
    
//    ---------------OPTIMAL -> O(N*LOG(A)), O(1)--------------
    public long minCost(int[] nums, int[] cost) {
        int left=nums[0];
        int right=nums[0];
        for(int i: nums) {
            if(i<left) left=i;
            if(i>right) right=i;
        }
        long ret=cost(nums, cost, nums[0]);
        while(left<right) {
            int mid=left+(right-left)/2;
            long first=cost(nums, cost, mid);
            long second=cost(nums, cost, mid+1);
            ret=Math.min(first, second);
            if(first>second) {
                left=mid+1;
            } else {
                right=mid;
            }
        }
        return ret;
    }
    
    private long cost(int[] nums, int[] cost, int t) {
        long costSum=0;
        for(int i=0; i<nums.length; i++) {
            costSum+=Math.abs(nums[i]-t)*(long)cost[i];
        }
        return costSum;
    }
    
    public static void main(String[] args) {
        MinimumCostToMakeArrayEqual m=new MinimumCostToMakeArrayEqual();
        System.out.println(m.minCost(new int[]{1,3,5,2}, new int[]{2,3,1,14}));
        System.out.println(m.minCost(new int[]{2,2,2,2,2}, new int[]{4,2,8,1,3}));
    }
}
