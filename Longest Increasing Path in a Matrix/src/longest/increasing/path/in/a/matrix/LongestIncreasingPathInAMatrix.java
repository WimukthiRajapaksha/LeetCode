/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.increasing.path.in.a.matrix;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestIncreasingPathInAMatrix {

    /**
     * @param args the command line arguments
     */
    
//    ------------------OPTIMAL -> O(M*N), O(M*N)-------------
    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        int[][] paths=new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                max=Math.max(max, dfs(matrix, paths, i, j));
                for(int[] t: paths) {
                    System.out.println(Arrays.toString(t));
                }
                System.out.println();
            }
        }
        
        return max+1;
    }
    
    private int dfs(int[][] m, int[][] p, int i, int j) {
        System.out.println(i+" "+j);
        if(p[i][j]>0) return p[i][j];
        int max=0;
        for(int[] d: directions) {
            if(i+d[0]>=0 && j+d[1]>=0 && i+d[0]<m.length && j+d[1]<m[0].length && m[i][j]>m[i+d[0]][j+d[1]]) {
                max=Math.max(max, dfs(m, p, i+d[0], j+d[1])+1);
            }
        }
        p[i][j]=max;
        return max;
    }
    
    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix l=new LongestIncreasingPathInAMatrix();
        System.out.println(l.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
