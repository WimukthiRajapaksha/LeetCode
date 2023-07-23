/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.increasing.paths.in.a.grid;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfIncreasingPathsInAGrid {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> O(M*N), O(M*N)----------------------
//    int max=1000000007;
//    public int countPaths(int[][] grid) {
//        int count=0;
//        int[][] possibilities=new int[grid.length][grid[0].length];
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                count=((count%max)+(dfs(grid, possibilities, i, j, 0)%max)%max);
//            }
//        }
//        return count;
//    }
//    
//    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//    private int dfs(int[][] grid, int[][] possibilities, int i, int j, int prev) {
//        if(i<0 || j<0 || i==grid.length || j==grid[0].length) return 0;
//        if(prev>=grid[i][j]) return 0;
//        if(possibilities[i][j]>0) return possibilities[i][j];
//        int count=0;
//        for(int[] d: dir) {
//            count=((count%max)+(dfs(grid, possibilities, i+d[0], j+d[1], grid[i][j])%max))%max;
//        }
//        possibilities[i][j]=(count+1)%max;
//        return possibilities[i][j];
//    }
    
    
    
//    ---------------OPTIMAL -> O(M*N), O(M*N)----------------------
    int max=1_000_000_007;
    public int countPaths(int[][] grid) {
        int count=0;
        int[][] possibilities=new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                count=(count+dfs(grid, possibilities, i, j, 0))%max;
            }
        }
        return count;
    }
    
    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    private int dfs(int[][] grid, int[][] possibilities, int i, int j, int prev) {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length) return 0;
        if(prev>=grid[i][j]) return 0;
        if(possibilities[i][j]>0) return possibilities[i][j];
        int count=1;
        for(int[] d: dir) {
            count=(count+dfs(grid, possibilities, i+d[0], j+d[1], grid[i][j]))%max;
        }
        possibilities[i][j]=count;
        return possibilities[i][j];
    }
    
    
    public static void main(String[] args) {
        NumberOfIncreasingPathsInAGrid n=new NumberOfIncreasingPathsInAGrid();
        System.out.println(n.countPaths(new int[][]{{1,1},{3,4}}));
        System.out.println();
        System.out.println(n.countPaths(new int[][]{{1},{2}}));
    }
}
