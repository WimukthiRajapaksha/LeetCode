/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coin.change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class CoinChange {

    /**
     * @param args the command line arguments
     */    
//    --------------------OPTIMAL -> DP -> TIME - O(M*N), SPACE - O(N)-----------------------------
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp=new int[amount+1];
        for(int i=1; i<dp.length; i++) {
            dp[i]=amount+1;
        }
        for(int i=0; i<coins.length; i++) {
            for(int j=0; j<dp.length; j++) {
                if(coins[i]>j) continue;
                dp[j]=Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[dp.length-1]==amount+1 ? -1 : dp[dp.length-1];
    }
    
    

//    --------------------OPTIMAL -> BFS -> TIME - O(M*N), SPACE - O(N)-----------------------------
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0) return 0;
//        Queue<Integer> queue=new LinkedList<>();
//        queue.offer(amount);
//        boolean[] visited=new boolean[amount+1];
//        visited[amount]=true;
//        int level=1;
//        while(!queue.isEmpty()) {
//            int size=queue.size();
//            while(size>0) {
//                int t=queue.poll();
//                for(int i: coins) {
//                    if(t-i<0) continue;
//                    if(t-i==0) return level;
//                    if(!visited[t-i]) {
//                        queue.offer(t-i);
//                        visited[t-i]=true;
//                    }
//                }
//                size--;
//            }
//            level++;
//        }
//        return -1;
//    }
    
    
    
    
//    --------------------OPTIMAL -> DFS -> TIME - O(M*N), SPACE - O(N)-----------------------------
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0) return 0;
//        int ret=dfs(coins, amount, new int[amount+1]);
//        if(ret>=100000) {
//            return -1;
//        }
//        return ret;
//    }
//    
//    private int dfs(int[] c, int a, int[] co) {
//        if(a<0) return -1;
//        if(a==0) return 0;
//        if(co[a]!=0) return co[a];
//        int min=100000;
//        for(int i=0; i<c.length; i++) {
//            int tc=dfs(c, a-c[i], co);
//            if(tc!=-1) {
//                min=Math.min(min, tc);
//            }
//        }
//        co[a]=min+1;
//        return min+1;
//    }
    
    public static void main(String[] args) {
        CoinChange c=new CoinChange();
        System.out.println(c.coinChange(new int[]{1,2,5}, 11));
        System.out.println(c.coinChange(new int[]{2}, 3));
        System.out.println(c.coinChange(new int[]{1}, 0));
        System.out.println(c.coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
        System.out.println(c.coinChange(new int[]{186,419,83,408}, 6249));
    }
}

