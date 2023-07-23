/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detonate.the.maximum.bombs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class DetonateTheMaximumBombs {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> DFS -> O(N^3)=O(V+E), O(N^2)=O(E)-> E=N^2-------------
//    public int maximumDetonation(int[][] bombs) {
//        List<Integer>[] graph=new ArrayList[bombs.length];
//        for(int i=0; i<bombs.length; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int i=0; i<bombs.length; i++) {
//            for(int j=0; j<bombs.length; j++) {
//                if(i==j) continue;
//                long x=bombs[i][0]-bombs[j][0];
//                long y=bombs[i][1]-bombs[j][1];
//                double d=(x*x)+(y*y);
//                if((long)bombs[i][2]*(long)bombs[i][2]>=d) {
//                    graph[i].add(j);
//                }
//            }
//        }
//        int max=0;
//        for(int i=0; i<bombs.length; i++) {
//            max=Math.max(max, dfs(new boolean[bombs.length], i, graph));
//        }
//        return max;
//    }
//    
//    private int dfs(boolean[] visited, int i, List<Integer>[] graph) {
//        if(visited[i]) return 0;
//        visited[i]=true;
//        int max=1;
//        for(int j: graph[i]) {
//            max+=(dfs(visited, j, graph));
//        }
//        return max;
//    }
    
    
    
//    ----------OPTIMAL -> BFS -> O(N^3)=O(V+E), O(N^2)=O(E)-> E=N^2-------------
    public int maximumDetonation(int[][] bombs) {
        List<Integer>[] graph=new ArrayList[bombs.length];
        for(int i=0; i<bombs.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int i=0; i<bombs.length; i++) {
            for(int j=0; j<bombs.length; j++) {
                if(i==j) continue;
                long x=bombs[i][0]-bombs[j][0];
                long y=bombs[i][1]-bombs[j][1];
                double d=(x*x)+(y*y);
                if((long)bombs[i][2]*(long)bombs[i][2]>=d) {
                    graph[i].add(j);
                }
            }
        }
        int max=0;
        for(int i=0; i<bombs.length; i++) {
            max=Math.max(max, bfs(new boolean[bombs.length], i, graph));
        }
        return max;
    }
    
    private int bfs(boolean[] visited, int i, List<Integer>[] graph) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i);
        visited[i]=true;
        int count=1;
        while(!queue.isEmpty()) {
            int t=queue.poll();
            for(int j: graph[t]) {
                if(!visited[j]) {
                    queue.offer(j);
                    visited[j]=true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        DetonateTheMaximumBombs d=new DetonateTheMaximumBombs();
        System.out.println(d.maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
        System.out.println(d.maximumDetonation(new int[][]{{1,1,5},{10,10,5}}));
        System.out.println(d.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
    }
}
