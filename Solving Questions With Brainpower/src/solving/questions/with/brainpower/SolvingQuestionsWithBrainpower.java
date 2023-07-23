/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solving.questions.with.brainpower;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class SolvingQuestionsWithBrainpower {

    /**
     * @param args the command line arguments
     */
    
    public long mostPoints(int[][] questions) {
        int[][] dp=new int[questions.length][questions.length];
        int max=0;
        for(int i=0; i<questions.length; i++) {
            dp[i][i]=questions[i][0];
            max=Math.max(max, dp[i][i]);
            for(int j=i+questions[i][1]+1; j<questions.length; j++) {
                dp[i][j]=Math.max(dp[i][j], dp[i][i]+questions[j][0]);
                max=Math.max(max, dp[i][j]);
            }
        }
        for(int[] i: dp) {
            System.out.println(Arrays.toString(i));
        }
        return max;
    }
    
    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower s=new SolvingQuestionsWithBrainpower();
        System.out.println(s.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
        System.out.println(s.mostPoints(new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}}));
        System.out.println(s.mostPoints(new int[][]{{1,1},{2,2}}));
        System.out.println(s.mostPoints(new int[][]{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}}));
    }
}

3,4,4,2

  0,0,0,0
0 3
0 3 4
0 3 4 4
0 5 6 6 2