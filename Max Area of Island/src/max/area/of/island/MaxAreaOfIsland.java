/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.area.of.island;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaxAreaOfIsland {

    /**
     * @param args the command line arguments
     */
    
    int[][] directions={{-1,0},{0,-1},{1,0},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    int t=bfs(grid, i, j);
                    if(t>max){
                        max=t;
                    }
                }
            }
        }
        return max;
    }
    
    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i, j});
        int c=0;
        while(!queue.isEmpty()) {
            System.out.print(queue.size()+" ");
            int[] temp=queue.poll();
            grid[temp[0]][temp[1]]=0;
            c++;
            for(int p=0; p<directions.length; p++) {
                int x=temp[0]+directions[p][0];
                int y=temp[1]+directions[p][1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) {
                    continue;
                }
                grid[x][y]=0;
                queue.offer(new int[]{x,y});
            }
        }
        System.out.println();
        return c;
    }
    
    
    
//    public int maxAreaOfIsland(int[][] grid) {
//        int max=0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                if(grid[i][j]==1) {
//                    int t=dfs(grid, i, j);
//                    if(t>max){
//                        max=t;
//                    }
//                }
//            }
//        }
//        return max;
//    }
//    
//    private int dfs(int[][] grid, int i, int j) {
//        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
//        grid[i][j]=0;
//        return dfs(grid, i-1, j)+dfs(grid, i, j-1)+dfs(grid, i+1, j)+dfs(grid, i, j+1)+1;
//    }
    
    public static void main(String[] args) {
        MaxAreaOfIsland m=new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
        System.out.println(m.maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
        System.out.println(m.maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
    }
}