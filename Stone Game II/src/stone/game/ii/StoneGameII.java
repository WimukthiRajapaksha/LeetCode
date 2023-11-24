/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stone.game.ii;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class StoneGameII {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------OPTIMAL -> O(N^3), O(N^2)--------------
    public int stoneGameII(int[] piles) {
        int[][][] dp=new int[piles.length+1][2][piles.length+1];
        return dfs(piles, 1, 0, true, dp);
    }
    
    private int dfs(int[] piles, int m, int i, boolean isAlice, int[][][] mem) {
        if(i>=piles.length) return 0;
        if(mem[i][isAlice ? 0 : 1][m]!=0) return mem[i][isAlice ? 0 : 1][m];
        int max=isAlice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum=0;
        for(int x=1; x<Math.min(piles.length-i+1, 2*m+1); x++) {
            sum+=piles[i+x-1];
            if(isAlice) {
                max=Math.max(max, sum+dfs(piles, Math.max(m, x), i+x, !isAlice, mem));
            } else {
                max=Math.min(max, dfs(piles, Math.max(m, x), i+x, !isAlice, mem));
            }
        }
        mem[i][isAlice ? 0 : 1][m]=max;
        return max;
    }
    
    public static void main(String[] args) {
        StoneGameII s=new StoneGameII();
        System.out.println(s.stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(s.stoneGameII(new int[]{1,2,3,4,5,100}));
        System.out.println(s.stoneGameII(new int[]{1}));
    }
}
