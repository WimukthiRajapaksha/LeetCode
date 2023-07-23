/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.falling.path.sum;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumFallingPathSum {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(N^2), O(1)---------------
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                matrix[i][j]+=Math.min(matrix[i-1][j], 
                        Math.min(matrix[i-1][Math.max(0, j-1)], matrix[i-1][Math.min(matrix[i].length-1, j+1)]));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<matrix[matrix.length-1].length; i++) {
            min=Math.min(min, matrix[matrix.length-1][i]);
        }
        return min;
    }
    
    
//    -------------------OPTIMAL -> O(N^2), O(N)---------------
//    public int minFallingPathSum(int[][] matrix) {
//        int[] dp=new int[matrix[0].length+2];
//        dp[0]=1000;
//        dp[dp.length-1]=1000;
//        for(int i=0; i<matrix[0].length; i++) {
//            dp[i+1]=matrix[0][i];
//        }
//        
//        for(int i=1; i<matrix.length; i++) {
//            int prev=dp[0];
//            for(int j=0; j<matrix[i].length; j++) {
//                int curr=dp[j+1];
//                dp[j+1]=Math.min(prev, Math.min(dp[j+1], dp[j+2]))+matrix[i][j];
//                prev=curr;
//            }
//            
//        }
//        int min=1000;
//        for(int i: dp) {
//            if(min>i) {
//                min=i;
//            }
//        }
//        return min;
//    }
    
    public static void main(String[] args) {
        MinimumFallingPathSum m=new MinimumFallingPathSum();
        System.out.println(m.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        System.out.println(m.minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
    }
}
