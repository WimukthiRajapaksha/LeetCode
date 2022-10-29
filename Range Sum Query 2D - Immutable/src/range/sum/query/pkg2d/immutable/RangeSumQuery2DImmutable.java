/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package range.sum.query.pkg2d.immutable;

/**
 *
 * @author wimukthirajapaksha
 */

class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        dp=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                dp[i+1][j+1]=dp[i+1][j]+dp[i][j+1]-dp[i][j]+matrix[i][j];
            }
        }
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
    }
}



//class NumMatrix {
//    int[][] dp;
//    public NumMatrix(int[][] matrix) {
//        dp=new int[matrix.length+1][matrix[0].length+1];
//        for(int i=0; i<matrix.length; i++) {
//            for(int j=0; j<matrix[i].length; j++) {
//                dp[i+1][j+1]=dp[i+1][j]+matrix[i][j];
//            }
//        }
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//    
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int s=0;
//        for(int i=row1; i<=row2; i++) {
//            s+=dp[i+1][col2+1]-dp[i+1][col1];
//        }
//        return s;
//    }
//}

public class RangeSumQuery2DImmutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumMatrix n=new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
        System.out.println(n.sumRegion(2, 1, 4, 3));
        System.out.println(n.sumRegion(1, 1, 2, 2));
        System.out.println(n.sumRegion(1, 2, 2, 4));
    }
    
}
