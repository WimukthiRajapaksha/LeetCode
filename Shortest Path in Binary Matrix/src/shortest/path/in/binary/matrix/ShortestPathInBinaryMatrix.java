/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest.path.in.binary.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class ShortestPathInBinaryMatrix {

    /**
     * @param args the command line arguments
     */    
    
    
//    ------------------OPTIMAL -> BFS -> O(N^2), O(N^2)---------------------
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return -1;
        if(grid.length==1 && grid[0].length==1) {
            return grid[0][0]==0 ? 1 : -1;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0});
        int[][] dir=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int level=1;
        while(!queue.isEmpty()) {
            int n=queue.size();
            while(n>0) {
                int[] temp=queue.poll();
                for(int[] d: dir) {
                    int x=temp[0]+d[0];
                    int y=temp[1]+d[1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==0) {
                        if(x==grid.length-1 && y==grid[0].length-1) return level+1;
                        grid[x][y]=1;
                        queue.offer(new int[]{x, y});
                    }
                }
                n--;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix s=new ShortestPathInBinaryMatrix();
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{
            {0,1,0,0,1,1,0},
            {1,0,0,0,0,0,0},
            {1,0,0,1,1,1,1},
            {0,1,0,0,0,0,0},
            {1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0},
            {1,0,1,0,0,1,0}
        }));
    }
}
