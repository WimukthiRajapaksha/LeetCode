/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.path.sum;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumPathSum {

    /**
     * @param args the command line arguments
     */   
    
//    ----------------OPTIMAL -> RECURSIVE------------------------
    public int minPathSum(int[][] grid) {
        return min(grid, grid.length-1, grid[0].length-1, new int[grid.length][grid[0].length]);
    }
    
    public int min(int[][] grid, int i, int j, int[][] minGrid) {
        if(minGrid[i][j]>0) return minGrid[i][j];
        if(i==0 && j==0) return grid[0][0];
        else if(i==0) minGrid[i][j] = grid[0][j] + min(grid, 0, j-1, minGrid);
        else if(j==0) minGrid[i][j] = grid[i][0] + min(grid, i-1, 0, minGrid);
        else minGrid[i][j] = grid[i][j] + Math.min(min(grid, i-1, j, minGrid), min(grid, i, j-1, minGrid));
        return minGrid[i][j];
    }
    
    
    
//    ----------------ALTERNATE -> OPTIMAL -> DP------------------------
//    public int minPathSum(int[][] grid) {
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(i==0 && j==0) continue;
//                else if(i==0) grid[i][j]+=grid[i][j-1];
//                else if(j==0) grid[i][j]+=grid[i-1][j];
//                else grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
//            }
//        }
//        return grid[grid.length-1][grid[0].length-1];
//    }
    
    
    public static void main(String[] args) {
        MinimumPathSum m=new MinimumPathSum();
        System.out.println(m.minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
        System.out.println(m.minPathSum(new int[][]{{1,2,3}, {4,5,6}}));
    }
}
