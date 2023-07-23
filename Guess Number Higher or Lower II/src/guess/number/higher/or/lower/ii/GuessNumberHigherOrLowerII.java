/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.number.higher.or.lower.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class GuessNumberHigherOrLowerII {

    /**
     * @param args the command line arguments
     */
    
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        return help(dp, 1, n);
    }
    
    private int help(int[][] dp, int s, int e) {
        if(s>=e) return 0;
        if(dp[s][e]!=0) return dp[s][e];
        int res=Integer.MAX_VALUE;
        for(int i=s; i<=e; i++) {
            int temp=Math.max(help(dp, s, i-1), help(dp, i+1, e))+i;
            res=Math.min(res, temp);
        }
        dp[s][e]=res;
        return res;
    }
    
    public static void main(String[] args) {
        GuessNumberHigherOrLowerII g=new GuessNumberHigherOrLowerII();
        System.out.println(g.getMoneyAmount(10));
    }
}
