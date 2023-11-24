/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flower.planting.with.no.adjacent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FlowerPlantingWithNoAdjacent {

    /**
     * @param args the command line arguments
     */
    
//    public int[] gardenNoAdj(int n, int[][] paths) {
//        List<Integer>[] graph=generateGraph(paths, n);
//        boolean[] visited=new boolean[n];
//        int[] colors=new int[n];
//        for(int i=0; i<n; i++) {
//            bfs(graph, i, visited, colors);
//        }
//        for(int i=0; i<colors.length; i++) {
//            colors[i]=positions(colors[i]);
//        }
//        return colors;
//    }
//    
//    private List<Integer>[] generateGraph(int[][] paths, int n) {
//        List<Integer>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] p: paths) {
//            graph[p[0]-1].add(p[1]-1);
//            graph[p[1]-1].add(p[0]-1);
//        }
//        return graph;
//    }
//    
//    private void bfs(List<Integer>[] graph, int i, boolean[] visited, int[] color) {
//        if(visited[i]) return;
//        Queue<Integer> queue=new LinkedList<>();
//        queue.offer(i);
//        visited[i]=true;
//        color[i]=1;
//        while(!queue.isEmpty()) {
//            int temp=queue.poll();
//            for(int j: graph[temp]) {
//                if(!visited[j]) {
//                    visited[j]=true;
//                    color(graph, j, color);
//                    queue.offer(j);
//                }
//            }
//        }
//    }
//    
//    private int positions(int val) {
//        if(val==0) return 0;
//        return positions(val>>1)+1;
//    }    
//    
//    private void color(List<Integer>[] graph, int i, int[] color) {
//        int col=15;
//        int temp=0;
//        for(int j: graph[i]) {
//            if(color[j]!=0) {
//                temp|=color[j];
//            }
//        }
//        color[i]=lsb(col^temp);
//    }
//    
//    private int lsb(int val) {
//        if((val&1)==1) {
//            return 1;
//        }
//        return lsb(val>>1)<<1;
//    }
    
    
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph=generateGraph(paths, n);
        int[] colors=new int[n];
        for(int i=0; i<n; i++) {
            help(graph, i, colors);
        }
        return colors;
    }
    
    private List<Integer>[] generateGraph(int[][] paths, int n) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] p: paths) {
            graph[p[0]-1].add(p[1]-1);
            graph[p[1]-1].add(p[0]-1);
        }
        return graph;
    }
    
    private void help(List<Integer>[] graph, int i, int[] color) {
        boolean[] vals=new boolean[5];
        for(int j: graph[i]) {
            if(color[j]!=0) {
                vals[color[j]]=true;
            }
        }
        for(int j=4; j>0; j--) {
            if(!vals[j]) {
                color[i]=j;
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        FlowerPlantingWithNoAdjacent f=new FlowerPlantingWithNoAdjacent();
        System.out.println(Arrays.toString(f.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
        System.out.println(Arrays.toString(f.gardenNoAdj(4, new int[][]{{1,2},{3,4}})));
        System.out.println(Arrays.toString(f.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
        System.out.println(Arrays.toString(f.gardenNoAdj(6, new int[][]{{6,4},{6,1},{3,1},{4,5},{2,1},{5,6},{5,2}})));
    }
}
