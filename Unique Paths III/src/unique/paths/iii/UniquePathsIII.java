/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.paths.iii;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniquePathsIII {

    /**
     * @param args the command line arguments
     */
    
    int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        int obs=0;
        int x=0;
        int y=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j]==-1) {
                    obs++;
                } else if(grid[i][j]==1) {
                    x=i;
                    y=j;
                }
            }
        }
        return help(grid, x, y, (grid.length*grid[0].length)-obs);
    }

    private int help(int[][] grid, int i, int j, int rem) {
        if(grid[i][j]==2) {
            if(rem==1) return 1;
            return 0;
        }
        if(grid[i][j]==-1) return 0;
        int count=0;
        int t=grid[i][j];
        grid[i][j]=-1;
        for(int[] d: dir) {
            if(i+d[0]>=0 && i+d[0]<grid.length && j+d[1]>=0 && j+d[1]<grid[0].length) {
                count+=help(grid, i+d[0], j+d[1], rem-1);
            }
        }
        grid[i][j]=t;
        return count;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
