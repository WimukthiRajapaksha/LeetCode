/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package out.of.boundary.paths;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class OutOfBoundaryPaths {

    /**
     * @param args the command line arguments
     */
    
//    --------------------OPTIMAL -> O(mnN) -> O(mn)-------------
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove==0) return 0;
        int[][] dp=new int[m][n];
        dp[startRow][startColumn]=1;
        int count=0;
        int dev=1000000007;
        for(int mm=1; mm<=maxMove; mm++) {
            int[][] arr=new int[m][n];
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(i==0) count = (count+dp[i][j])%dev;
                    if(j==0) count = (count+dp[i][j])%dev;
                    if(i==m-1) count = (count+dp[i][j])%dev;
                    if(j==n-1) count = (count+dp[i][j])%dev;
                    int t=(((i>0 ? dp[i-1][j] : 0)%dev+
                            (j>0 ? dp[i][j-1] : 0)%dev)%dev+
                            ((i<m-1 ? dp[i+1][j] : 0)%dev+
                            (j<n-1 ? dp[i][j+1] : 0)%dev)%dev)%dev;
                    arr[i][j]=t;
                }
            }
            dp=arr;
        }
        return count;
    }
    
    
    
//    --------------------OPTIMAL -> O(mnN) -> O(mnN)-------------
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        if(maxMove==0) return 0;
//        return find(m, n, maxMove, startRow, startColumn, new Integer[m][n][maxMove+1]);
//    }
//    
//    private int find(int m, int n, int maxMove, int startRow, int startColumn, Integer[][][] memo) {
//        if(startColumn==-1 || startRow==-1 || startRow==m || startColumn==n) return 1;
//        else if(maxMove==0) return 0;
//        else if(memo[startRow][startColumn][maxMove]!=null) return memo[startRow][startColumn][maxMove];
//        int t=((find(m, n, maxMove-1, startRow-1, startColumn, memo)+
//                find(m, n, maxMove-1, startRow, startColumn-1, memo))%1000000007+
//                (find(m, n, maxMove-1, startRow+1, startColumn, memo)+
//                find(m, n, maxMove-1, startRow, startColumn+1, memo))%1000000007)%1000000007;
//        memo[startRow][startColumn][maxMove]=t;
//        return t;
//    }
    
    
    
//    --------------------ALTERNATE -> NOT OPTIMAL -> O(4^N) -> O(N)-------------
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
////        System.out.println(m+" "+n+" "+maxMove+" "+startRow+" "+startColumn);
//        if(startColumn==-1 || startRow==-1 || startRow==m || startColumn==n) return 1;
//        if(maxMove==0) return 0;
//        return findPaths(m, n, maxMove-1, startRow-1, startColumn)%1000000007+
//                findPaths(m, n, maxMove-1, startRow, startColumn-1)%1000000007+
//                findPaths(m, n, maxMove-1, startRow+1, startColumn)%1000000007+
//                findPaths(m, n, maxMove-1, startRow, startColumn+1)%1000000007;
//    }
    
    
    
    
    public static void main(String[] args) {
        OutOfBoundaryPaths o=new OutOfBoundaryPaths();
        System.out.println(o.findPaths(2, 2, 2, 0, 0));
        System.out.println(o.findPaths(1, 3, 3, 0, 1));
        System.out.println(o.findPaths(8, 7, 16, 1, 5));
        System.out.println(o.findPaths(5, 5, 1, 2, 2));        
        System.out.println(o.findPaths(8, 50, 23, 5, 26));
    }
}
