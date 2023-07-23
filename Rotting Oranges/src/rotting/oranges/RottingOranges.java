/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotting.oranges;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class RottingOranges {

    /**
     * @param args the command line arguments
     */
    
//    public int orangesRotting(int[][] grid) {
//        int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//        Set<int[]> set=new HashSet<>();
//        int v=help(grid, directions, set);
//        if(v==-1) return -1;
//        if(v==0) return 0;
//        return v-1;
//    }
//    
//    public int help(int[][] grid, int[][] directions, Set<int[]> set) {
//        int ones=0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(grid[i][j]==2) {
//                    set.add(new int[]{i,j});
//                    grid[i][j]=0;
//                } else if(grid[i][j]==1) {
//                    ones++;
//                }
//            }
//        }
//        if(set.isEmpty()) {
//            if(ones==0) return 0;
//            return -1;
//        }
//        for(int[] t: set) {
//            for(int[] d: directions) {
//                if(d[0]+t[0]>=0 && d[0]+t[0]<grid.length && 
//                        d[1]+t[1]>=0 && d[1]+t[1]<grid[0].length &&
//                        grid[d[0]+t[0]][d[1]+t[1]]==1) {
//                    grid[d[0]+t[0]][d[1]+t[1]]=2;
//                }
//            }
//        }
//        set.clear();
//        int t = help(grid, directions, set);
//        if(t==-1) return -1;
//        return t+1;
//    }
    
    
    
//    public int orangesRotting(int[][] grid) {
//        int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//        Queue<int[]> queue=new LinkedList<>();
//        int time=help(grid, directions, queue);
//        if(time==-1) return -1;
//        else if(time==0) return 0;
//        return time-1;
//    }
//    
//    public int help(int[][] grid, int[][] directions, Queue<int[]> queue) {
//        int onesCount=0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[i].length; j++) {
//                if(grid[i][j]==2) {
//                    queue.offer(new int[]{i,j});
//                    grid[i][j]=0;
//                } else if(grid[i][j]==1) {
//                    onesCount++;
//                }
//            }
//        }
//        if(queue.isEmpty()) {
//            if(onesCount==0) return 0;
//            return -1;
//        }
//        while(!queue.isEmpty()) {
//            int[] tempPosition=queue.poll();
//            for(int[] d: directions) {
//                if(d[0]+tempPosition[0]>=0 && d[0]+tempPosition[0]<grid.length && 
//                        d[1]+tempPosition[1]>=0 && d[1]+tempPosition[1]<grid[0].length &&
//                        grid[d[0]+tempPosition[0]][d[1]+tempPosition[1]]==1) {
//                    grid[d[0]+tempPosition[0]][d[1]+tempPosition[1]]=2;
//                }
//            }
//        }
//        int returningValue = help(grid, directions, queue);
//        if(returningValue==-1) return -1;
//        return returningValue+1;
//    }
    
    
    
    
    public int orangesRotting(int[][] grid) {
        int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> queue=new LinkedList<>();
        int onesCount=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]==2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j]==1) {
                    onesCount++;
                }
            }
        }
        if(onesCount==0) return 0;
        int time=0;
        while(!queue.isEmpty()) {
            int s=queue.size();
            time++;
            while(s-->0) {
                int[] temp=queue.poll();
                for(int[] d: directions) {
                    if(d[0]+temp[0]>=0 && d[0]+temp[0]<grid.length &&
                            d[1]+temp[1]>=0 && d[1]+temp[1]<grid[0].length &&
                            grid[d[0]+temp[0]][d[1]+temp[1]]==1) {
                        queue.offer(new int[]{d[0]+temp[0], d[1]+temp[1]});
                        grid[d[0]+temp[0]][d[1]+temp[1]]=2;
                        onesCount--;
                    }
                }
            }
        }
        if(onesCount>0) return -1;
        else return time-1;
    }
    
    
    public static void main(String[] args) {
        RottingOranges r=new RottingOranges();
        System.out.println(r.orangesRotting(new int[][]{
            {2,1,1},
            {1,1,0},
            {0,1,1}
        }));
        
        System.out.println(r.orangesRotting(new int[][]{
            {2,1,1},
            {0,1,1},
            {1,0,1}
        }));
        
        System.out.println(r.orangesRotting(new int[][]{
            {0,2}
        }));
        
        System.out.println(r.orangesRotting(new int[][]{
            {0}
        }));
    }
}
