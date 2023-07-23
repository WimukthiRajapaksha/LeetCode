/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trapping.rain.water.ii;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class TrappingRainWaterII {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(MN*LOG(MN)), O(MN)-----------------------
    class Cell implements Comparable<Cell> {
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height-o.height;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length==0 || heightMap.length==1 || heightMap[0].length==0 || heightMap[0].length==1) return 0;
        PriorityQueue<Cell> pq=new PriorityQueue<>();
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0; i<m; i++) {
            visited[i][0]=true;
            visited[i][n-1]=true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for(int i=0; i<n; i++) {
            visited[0][i]=true;
            visited[m-1][i]=true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        int ret=0;
        int[][] dir=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        while(!pq.isEmpty()) {
            Cell temp=pq.poll();
            for(int[] d: dir) {
                int x=temp.x+d[0];
                int y=temp.y+d[1];
                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]) {
                    visited[x][y]=true;
                    pq.offer(new Cell(x, y, Math.max(temp.height, heightMap[x][y])));
                    ret+=Math.max(0, temp.height-heightMap[x][y]);
                }
            }
        }
        return ret;
    }
    
    
//    --------------------OPTIMAL -> O(MN*LOG(MN)), O(MN)-----------------------
//    public int trapRainWater(int[][] heightMap) {
//        if(heightMap.length==0 || heightMap.length==1 || heightMap[0].length==0 || heightMap[0].length==1) return 0;
//        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(heightMap[o1[0]][o1[1]], heightMap[o2[0]][o2[1]]));
//        boolean[] visited=new boolean[heightMap.length*heightMap[0].length];
//        for(int i=0; i<heightMap[0].length; i++) {
//            pq.offer(new int[]{0, i});
//            visited[i]=true;
//            pq.offer(new int[]{heightMap.length-1, i});
//            visited[(heightMap.length-1)*(heightMap[0].length)+i]=true;
//        }
//        for(int i=1; i<heightMap.length-1; i++) {
//            pq.offer(new int[]{i, 0});
//            visited[i*heightMap[0].length]=true;
//            pq.offer(new int[]{i, heightMap[0].length-1});
//            visited[(i+1)*heightMap[0].length-1]=true;
//        }
//        int ret=0;
//        int[][] dir=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
//        while(!pq.isEmpty()) {
//            int[] temp=pq.poll();
//            for(int[] d: dir) {
//                int y=temp[0]+d[0];
//                int x=temp[1]+d[1];
//                if(x<0 || x>=heightMap[0].length || y<0 || y>=heightMap.length || visited[(y*heightMap[0].length)+x]) {
//                    continue;
//                }
//                visited[y*heightMap[0].length+x]=true;
//                pq.offer(new int[]{y, x});
//                if(heightMap[y][x]<heightMap[temp[0]][temp[1]]) {
//                    ret+=heightMap[temp[0]][temp[1]]-heightMap[y][x];
//                    heightMap[y][x]=heightMap[temp[0]][temp[1]];
//                }
//            }
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        TrappingRainWaterII t=new TrappingRainWaterII();
        System.out.println(t.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        System.out.println(t.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
        System.out.println(t.trapRainWater(new int[][]{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}}));
        System.out.println(t.trapRainWater(new int[][]{{2,2,2},{2,1,2},{2,1,2},{2,1,2}}));
    }
}
