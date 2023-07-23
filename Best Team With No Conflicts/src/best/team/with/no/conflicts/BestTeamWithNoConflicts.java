/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best.team.with.no.conflicts;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class BestTeamWithNoConflicts {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> DP -> BOTTOM UP -> O(N^2), O(N)----------------
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr=new int[scores.length][2];
        for(int i=0; i<scores.length; i++) {
            arr[i]=new int[]{ages[i], scores[i]};
        }
        Arrays.sort(arr, (i1, i2)->i1[0]==i2[0] ? Integer.compare(i1[1], i2[1]) : Integer.compare(i1[0], i2[0]));
        for(int[] i: arr) {
            System.out.print(Arrays.toString(i)+" ");
        }
        System.out.println();
        int max=0;
        int[] dp=new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            dp[i]=arr[i][1];
            for(int j=0; j<i; j++) {
                if(arr[j][1]<=arr[i][1]) {
                    dp[i]=Math.max(dp[i], arr[i][1]+dp[j]);
                }
            }
            max=Math.max(max, dp[i]);
        }
        for(int i: dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return max;
    }
    
    public static void main(String[] args) {
        BestTeamWithNoConflicts b=new BestTeamWithNoConflicts();
        System.out.println(b.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(b.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
        System.out.println(b.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
        System.out.println(b.bestTeamScore(new int[]{1,1,1,1,1,1,1,1,1,1}, new int[]{811,364,124,873,790,656,581,446,885,134}));
    }
}
