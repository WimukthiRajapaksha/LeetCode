/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knight.probability.in.chessboard;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class KnightProbabilityInChessboard {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> TOP-DOWN -> O(K*N^2), O(K*N^2)-------------
//    public double knightProbability(int n, int k, int row, int column) {
//        double[][][] visi=new double[n][n][k+1];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                for(int kk=1; kk<=k; kk++) {
//                    visi[i][j][kk]=-1;
//                }
//            }
//        }
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                visi[i][j][0]=1;
//            }
//        }
//        return dfs(visi, row, column, k);
//    }
//    
//    int[][] dir=new int[][]{{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
//    private double dfs(double[][][] visited, int i, int j, int k) {
//        if(i<0 || j<0 || i>=visited.length || j>=visited.length) return 0;
//        if(visited[i][j][k]!=-1) return visited[i][j][k];
//        if(k==0) return visited[i][j][k];
//        double count=0;
//        for(int[] d: dir) {
//            count+=dfs(visited, d[0]+i, d[1]+j, k-1);
//        }
//        visited[i][j][k]=count/8.0;
//        return visited[i][j][k];
//    }
    
    
//    ----------------OPTIMAL -> TOP-DOWN -> O(K*N^2), O(K*N^2)-------------
//    public double knightProbability(int n, int k, int row, int column) {
//        Double[][][] visi=new Double[n][n][k+1];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                visi[i][j][0]=1d;
//            }
//        }
//        return dfs(visi, row, column, k);
//    }
//    
//    int[][] dir=new int[][]{{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
//    private double dfs(Double[][][] visited, int i, int j, int k) {
//        if(i<0 || j<0 || i>=visited.length || j>=visited.length) return 0;
//        if(visited[i][j][k]!=null) return visited[i][j][k];
//        if(k==0) return visited[i][j][k];
//        double count=0;
//        for(int[] d: dir) {
//            count+=dfs(visited, d[0]+i, d[1]+j, k-1);
//        }
//        visited[i][j][k]=count/8.0;
//        return visited[i][j][k];
//    }
    
    
//    ----------------OPTIMAL -> TOP-DOWN -> O(K*N^2), O(K*N^2)-------------
//    public double knightProbability(int n, int k, int row, int column) {
//        double[][][] visi=new double[n][n][k+1];
//        return dfs(visi, row, column, k);
//    }
//    
//    int[][] dir=new int[][]{{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
//    private double dfs(double[][][] visited, int i, int j, int k) {
//        if(i<0 || j<0 || i>=visited.length || j>=visited.length) return 0;
//        if(visited[i][j][k]!=0) return visited[i][j][k];
//        if(k==0) return 1;
//        double count=0;
//        for(int[] d: dir) {
//            count+=dfs(visited, d[0]+i, d[1]+j, k-1);
//        }
//        visited[i][j][k]=count/8.0;
//        return visited[i][j][k];
//    }
    
    
    
//    ------------------OPTIMAL -> BOTTOM-UP -> NICE -> O(K*N^2), O(N^2)-----------------
    public double knightProbability(int n, int k, int row, int column) {
        double[][] prev=new double[n][n];
        double[][] curr=new double[n][n];
        int[][] dir=new int[][]{{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1}};
        prev[row][column]=1;
        for(int i=0; i<k; i++) {
            for(int a=0; a<n; a++) {
                for(int b=0; b<n; b++) {
                    curr[a][b]=0;
                    for(int[] d: dir) {
                        int preI=a+d[0];
                        int preJ=b+d[1];
                        if(preI>=0 && preJ>=0 && preI<n && preJ<n) {
                            curr[a][b]+=prev[preI][preJ]/8;
                        }
                    }
                }
            }
            double[][] temp=prev;
            prev=curr;
            curr=temp;
        }
        double sum=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sum+=prev[i][j];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        KnightProbabilityInChessboard k=new KnightProbabilityInChessboard();
        System.out.println(k.knightProbability(3, 2, 0, 0));
        System.out.println(k.knightProbability(8, 30, 6, 4));
    }
}
