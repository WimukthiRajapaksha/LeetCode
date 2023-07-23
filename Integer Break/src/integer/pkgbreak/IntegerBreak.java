/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integer.pkgbreak;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntegerBreak {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(1), O(1)--------------------
//    public int integerBreak(int n) {
//        if(n<=3) return n-1;
//        if(n%3==1) {
//            return 4*(int)Math.pow(3, (n-4)/3);
//        } else if(n%3==0) {
//            return (int)Math.pow(3, n/3);
//        }
//        return 2*(int)Math.pow(3, n/3);
//    }
    
    
    
//    --------------OPTIMAL -> DP -> O(N^2), O(N)--------------------
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int[] dp=new int[Math.max(n+1,4)];
        dp[1]=1;
        for(int i=2; i<dp.length; i++) {
            dp[i]=Math.max(calc(dp, 1, i-1), i);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    
    private int calc(int[] dp, int i, int j) {
        if(j<i) return 0;
        return Math.max(dp[i]*dp[j], calc(dp, i+1, j-1));
    }
    
    public static void main(String[] args) {
        IntegerBreak i=new IntegerBreak();
        System.out.println(i.integerBreak(10));
        System.out.println(i.integerBreak(2));
        System.out.println(i.integerBreak(18));
        System.out.println(i.integerBreak(7));
    }
}
