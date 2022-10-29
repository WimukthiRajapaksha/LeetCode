/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfIslands {

    /**
     * @param args the command line arguments
     */
    
//    --------------------OPTIMAL -> BFS-----------------------
    public int numIslands(char[][] grid) {
        int c=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]=='1') {
                    c++;
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()) {
                        int[] t=q.poll();
                        if(t[0]<0 || t[0]==grid.length || t[1]<0 || t[1]==grid[0].length || grid[t[0]][t[1]]=='0') {
                            continue;
                        }
                        grid[t[0]][t[1]]='0';
                        q.offer(new int[]{t[0]-1, t[1]});
                        q.offer(new int[]{t[0]+1, t[1]});
                        q.offer(new int[]{t[0], t[1]-1});
                        q.offer(new int[]{t[0], t[1]+1});
                    }
                }
            }
        }
        return c;
    }
    
    
    
//    --------------------OPTIMAL -> DFS-----------------------
//    public int numIslands(char[][] grid) {
//        int c=0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(grid[i][j]=='1') {
//                    c++;
//                    island(grid, i, j);
//                }
//            }
//        }
//        return c;
//    }
//    
//    private void island(char[][] grid, int i, int j) {
//        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]=='0') {
//            return;
//        }
//        grid[i][j]='0';
//        island(grid, i-1, j);
//        island(grid, i+1, j);
//        island(grid, i, j-1);
//        island(grid, i, j+1);
//    }
    
    public static void main(String[] args) {
        NumberOfIslands n=new NumberOfIslands();
        System.out.println(n.numIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
        System.out.println(n.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }
}
