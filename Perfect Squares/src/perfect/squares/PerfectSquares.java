/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfect.squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class PerfectSquares {

    /**
     * @param args the command line arguments
     */
    
    
    public int numSquares(int n) {
        int sq=(int)Math.sqrt(n);
        if(sq*sq==n) return 1;
        while((n&3)==0) {
            n>>>=2;
        }
        if((n&7)==7) {
            return 4;
        }
        for(int i=1; i*i<=n; i++) {
            int base=(int)Math.sqrt(n-(i*i));
            if(base*base==n-(i*i)) {
                return 2;
            }
        }
        return 3;
    }
    
    
    
    
    
//    ------------------OPTIMAL -> DP -> O(N*SQRT(N)), O(N)------------
//    public int numSquares(int n) {
//        Integer[] dp=new Integer[n+1];
//        dp[0]=0;
//        return back(n, n, dp);
//    }
//    
//    private int back(int i, int n, Integer[] dp) {        
//        if(n<0) return 10000000;
//        if(dp[n]!=null) return dp[n];
//        if(n==0) {
//            return 0;
//        }
//        int min=Integer.MAX_VALUE;
//        for(int j=(int)Math.sqrt(n); j*j>=1; j--) {
//            min=Math.min(min, back(j, n-j*j, dp)+1);
//        }
//        dp[n]=min;
//        return min;
//    }
    
    
    
    
//    ------------------WIRED, BUT OPTIMAL -> DP -> O(N*SQRT(N)), O(N)------------
//    public int numSquares(int n) {
//        int[] dp=new int[n+1];
//        for(int i=1; i*i<=n; i++) {
//            dp[i*i]=1;
//        }
//        for(int i=1; i<dp.length; i++) {
//            if(dp[i]==1) continue;
//            dp[i]=i;
//            for(int j=1; j*j<=i; j++) {
//                dp[i]=Math.min(dp[i], dp[i-(j*j)]+1);
//            }
//        }
//        return dp[dp.length-1];
//    }
    
    public static void main(String[] args) {
        PerfectSquares p=new PerfectSquares();
        System.out.println(p.numSquares(12));
        System.out.println(p.numSquares(13));
        System.out.println(p.numSquares(22));
        System.out.println(p.numSquares(7167));
        System.out.println(p.numSquares(7168));
        System.out.println(p.numSquares(7169));
//        System.out.println(p.numSquares(22));
//        System.out.println(p.numSquares(13));
//        System.out.println(p.numSquares(14));
    }
}
