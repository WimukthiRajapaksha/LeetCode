/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest.path.to.get.all.keys;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class ShortestPathToGetAllKeys {

    /**
     * @param args the command line arguments
     */
    
    public int shortestPathAllKeys(String[] grid) {
        int keys=0;
        int[] start=new int[2];
        boolean[][] visited=new boolean[grid.length][grid[0].length()];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length(); j++) {
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='z') keys++;
                if(grid[i].charAt(j)=='@') {
                    start[0]=i;
                    start[1]=j;
                }
                if(grid[i].charAt(j)=='#') {
                    visited[i][j]=true;
                }
            }
        }
        for(boolean[] v: visited) {
            System.out.println(Arrays.toString(v));
        }
        return dfs(grid, visited, 0, 0, start[0], start[1], keys);
    }
    
    int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int dfs(String[] grid, boolean[][] visited, int keys, int locks, int i, int j, int kc) {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length() || visited[i][j]) return -1;
        System.out.print(i+" "+j+" ");
        if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='z') {
            locks|=(1<<(grid[i].charAt(j)-'a'));
            kc--;
            if(kc==0) {
                System.out.println(1);
                return 1;
            }
        }
        if(grid[i].charAt(j)>='A' && grid[i].charAt(j)<='Z') {
            int temp=grid[i].charAt(j)-'A';
            if((locks & (1<<temp)) == 0) {
                System.out.println(-1);
                return -1;
            }
            kc--;
        }
        int val=Integer.MAX_VALUE;
        visited[i][j]=true;
        for(int[] d: dir) {
            int temp=dfs(grid, visited, keys, locks, i+d[0], j+d[1], kc);
            if(temp>0) {
                val=Math.min(val, temp);
            }
//            System.out.println(val);
        }
        visited[i][j]=false;
        System.out.println(val==Integer.MAX_VALUE ? -1 : val+1);
        return val==Integer.MAX_VALUE ? -1 : val+1;
    }
    
    public static void main(String[] args) {
        ShortestPathToGetAllKeys s=new ShortestPathToGetAllKeys();
        System.out.println(s.shortestPathAllKeys(new String[]{"@.a..","###.#","b.A.B"}));
        System.out.println(s.shortestPathAllKeys(new String[]{"@..aA","..B#.","....b"}));
        System.out.println(s.shortestPathAllKeys(new String[]{"@Aa"}));
    }
}
