/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package where.will.the.ball.fall;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class WhereWillTheBallFall {

    /**
     * @param args the command line arguments
     */
    
    
//    -------OPTIMAL -> O(MN), O(M)-----------
//    public int[] findBall(int[][] grid) {
//        int[] ret=new int[grid[0].length];
//        for(int i=0; i<grid[0].length; i++) {
//            ret[i]=help(grid, 0, i);
//        }
//        System.out.println(Arrays.toString(ret));
//        return ret;
//    }
//    
//    private int help(int[][] grid, int i, int j) {
//        if(j<0 || j>=grid[0].length) return -1;
//        if(i==grid.length) return j;
//        if(isValid(i, j, grid)) {
//            if(grid[i][j]==1 && isValid(i, j+1, grid) && grid[i][j+1]==1) {
//                return help(grid, i+1, j+1);
//            }
//            if(grid[i][j]==-1 && isValid(i, j-1, grid) && grid[i][j-1]==-1) {
//                return help(grid, i+1, j-1);
//            }
//        }
//        return -1;
//    }
//    
//    private boolean isValid(int i, int j, int[][] grid) {
//        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length);
//    }
    
    
//    -------OPTIMAL -> O(MN), O(1)-----------
    public int[] findBall(int[][] grid) {
        int[] res=new int[grid[0].length];
        for(int i=0; i<res.length; i++) {
            int curr=i;
            for(int j=0; j<grid.length; j++) {
                int next=curr+grid[j][curr];
                if(next<0 || next>=grid[0].length || grid[j][curr]!=grid[j][next]) {
                    curr=-1;
                    break;
                }
                curr=next;
            }
            res[i]=curr;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    
    public static void main(String[] args) {
        WhereWillTheBallFall w=new WhereWillTheBallFall();
        System.out.println(w.findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}}));
        System.out.println(w.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}}));
    }
}
