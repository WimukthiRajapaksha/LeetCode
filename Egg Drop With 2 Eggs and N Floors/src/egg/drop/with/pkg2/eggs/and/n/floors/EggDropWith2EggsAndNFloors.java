/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.drop.with.pkg2.eggs.and.n.floors;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class EggDropWith2EggsAndNFloors {

    /**
     * @param args the command line arguments
     */
    
    public int twoEggDrop(int n) {
        int[][] dp=new int[3][n+1];
        for(int i=0; i<dp[0].length; i++) {
            dp[1][i]=i;
        }
        for(int i=1; i<dp.length; i++) {
            dp[i][1]=1;
        }
        for(int i=2; i<dp[0].length; i++) {
            int val=Integer.MAX_VALUE;
            for(int j=1; j<=(i+1)/2; j++) {
                val=Math.min(val, 1+Math.max(dp[1][j-1], dp[2][i-j]));
            }
            dp[2][i]=val;
        }
        for(int[] i: dp) {
            System.out.println(Arrays.toString(i));
        }
        return dp[2][dp[0].length-1];
    }
    
    
//    public int twoEggDrop(int n) {
//        double val=(-1+Math.sqrt(1+8*n))/2;
//        if(val-(int)val==0) return (int)val;
//        return (int)val+1;
//    }
    
    public static void main(String[] args) {
        EggDropWith2EggsAndNFloors e=new EggDropWith2EggsAndNFloors();
        System.out.println(e.twoEggDrop(10));
    }
}
