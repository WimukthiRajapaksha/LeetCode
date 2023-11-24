/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.cost.tree.from.leaf.values;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumCostTreeFromLeafValues {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------OPTIMAL -> O(N^3) -> O(N^2)-------------
//    public int mctFromLeafValues(int[] arr) {
//        int[][] dp=new int[arr.length][arr.length];
//        return help(dp, arr, 0, arr.length-1);
//    }
//    
//    private int help(int[][] dp, int[] arr, int l, int r) {
//        if(l>=r) return 0;
//        if(dp[l][r]!=0) return dp[l][r];
//        int ret=Integer.MAX_VALUE;
//        for(int i=l; i<r; i++) {
//            int maxL=max(arr, l, i);
//            int maxR=max(arr, i+1, r);
//            ret=Math.min(ret, (maxL*maxR)+help(dp, arr, l, i)+help(dp, arr, i+1, r));
//        }
//        dp[l][r]=ret;
//        return ret;
//    }
//    
//    private int max(int[] arr, int l, int r) {
//        int max=0;
//        for(int i=l; i<=r; i++) {
//            max=Math.max(max, arr[i]);
//        }
//        return max;
//    }
    
    
    
//    -----------OPTIMAL -> MONOTONIC STACK -> O(N), O(N)--------------
    public int mctFromLeafValues(int[] arr) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for(int num: arr) {
            while(stack.peek()<=num) {
                int temp=stack.pop();
                res+=(temp*Math.min(stack.peek(), num));
            }
            stack.push(num);
        }
        while(stack.size()>2) {
            res+=(stack.pop()*stack.peek());
        }
        return res;
    }
    
    public static void main(String[] args) {
        MinimumCostTreeFromLeafValues m=new MinimumCostTreeFromLeafValues();
        System.out.println(m.mctFromLeafValues(new int[]{6,2,4}));
        System.out.println(m.mctFromLeafValues(new int[]{4,11}));
        System.out.println(m.mctFromLeafValues(new int[]{2,7,9,4,4}));
    }
}
