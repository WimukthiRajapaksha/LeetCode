/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package island.perimeter;

/**
 *
 * @author wimukthirajapaksha
 */
public class IslandPerimeter {

    /**
     * @param args the command line arguments
     */
    
    
    public int islandPerimeter(int[][] grid) {
        int islands=0;
        int neighbours=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]==1) {
                    islands++;
                    if(i<grid.length-1 && grid[i+1][j]==1) neighbours++;
                    if(j<grid[i].length-1 && grid[i][j+1]==1) neighbours++;
                }
            }
        }
        return 4*islands - (2*neighbours);
    }
    
    
    
//    -------------------DFS APPROACH -> BEAUTIFUL----------------
//    public int islandPerimeter(int[][] grid) {
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(grid[i][j]==1) {
//                    return dfs(grid, i, j);
//                }
//            }
//        }
//        return 0;
//    }
//    
//    private int dfs(int[][] grid, int i, int j) {
//        if(i<0 || j<0 || i==grid.length || j==grid[i].length) return 1;
//        if(grid[i][j]==2) return 0;
//        else if(grid[i][j]==0) return 1;
//        grid[i][j]=2;
//        return dfs(grid, i-1, j) + dfs(grid, i, j-1) + dfs(grid, i+1, j) + dfs(grid, i, j+1);
//    }
    
    
//    ------------------ITERATIVE APPROACH-----------------------
//    public int islandPerimeter(int[][] grid) {
//        int count = 0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(grid[i][j]==1) {
//                    if(i==0 || grid[i-1][i]==0) count++;
//                    if(j==0 || grid[i][j-1]==0) count++;
//                    if(i==grid.length-1 || grid[i+1][j]==0) count++;
//                    if(j==grid[i].length-1 || grid[i][j+1]==0) count++;
//                }
//            }
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        IslandPerimeter i=new IslandPerimeter();
        System.out.println(i.islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(i.islandPerimeter(new int[][]{{1}}));
        System.out.println(i.islandPerimeter(new int[][]{{0,1}}));
    }
}
