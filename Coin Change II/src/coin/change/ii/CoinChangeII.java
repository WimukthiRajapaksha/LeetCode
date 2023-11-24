/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coin.change.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CoinChangeII {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(M*N) -> O(M*N)---------
//    public int change(int amount, int[] coins) {
//        Arrays.sort(coins);
//        int[][] dp=new int[coins.length+1][amount+1];
//        for(int i=0; i<dp.length; i++) {
//            dp[i][0]=1;
//        }
//        for(int i=1; i<dp.length; i++) {
//            for(int j=1; j<dp[i].length; j++) {
//                dp[i][j]=dp[i-1][j]+((j<coins[i-1]) ? 0 : dp[i][j-coins[i-1]]);
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
//    ----------------OPTIMAL -> O(M*N) -> O(N)---------
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        for(int i=0; i<dp.length; i++) {
            dp[0]=1;
        }
        for(int i=0; i<coins.length; i++) {
            for(int j=1; j<dp.length; j++) {
                dp[j]=dp[j]+((j<coins[i]) ? 0 : dp[j-coins[i]]);
            }
        }
        return dp[dp.length-1];
    }
    
    public static void main(String[] args) {
        CoinChangeII c=new CoinChangeII();
        System.out.println(c.change(5, new int[]{1,2,5}));
        System.out.println(c.change(3, new int[]{2}));
        System.out.println(c.change(10, new int[]{10}));
    }
}
