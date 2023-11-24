/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.graph.bipartite;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class IsGraphBipartite {

    /**
     * @param args the command line arguments
     */
    
//    --------OPTIMAL -> BFS -> O(V+E) -> O(V)--------------
//    public boolean isBipartite(int[][] graph) {
//        Boolean[] color=new Boolean[graph.length];
//        boolean[] visited=new boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            if(!bfs(graph, i, visited, color)) {
//                return false;
//            }
//        }
//        return true;
//    }
//    
//    private boolean bfs(int[][] graph, int i, boolean[] visited, Boolean[] color) {
//        if(visited[i]) return true;
//        Queue<Integer> pq=new LinkedList<>();
//        pq.offer(i);
//        color[i]=true;
//        while(!pq.isEmpty()) {
//            int t=pq.poll();
//            for(int j: graph[t]) {
//                if(color[j]!=null && !(color[t]^color[j])) {
//                    return false;
//                }
//                if(!visited[j]) {
//                    visited[j]=true;
//                    pq.offer(j);
//                    color[j]= !color[t];
//                }
//            }
//        }
//        return true;
//    }
    
    
//    --------------OPTIMAL -> DFS -> O(V+E) -> O(V)-----------
//    public boolean isBipartite(int[][] graph) {
//        Boolean[] color=new Boolean[graph.length];
//        boolean[] visited=new boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            if(color[i]==null) {
//                color[i]=true;
//                if(!dfs(graph, i, visited, color)) {
//                    return false;
//                }
//            }
//            
//        }
//        return true;
//    }
//    
//    private boolean dfs(int[][] graph, int i, boolean[] visited, Boolean[] color) {
//        if(visited[i]) return true;
//        visited[i]=true;
//        for(int j: graph[i]) {
//            if(color[j]!=null && !(color[i]^color[j])) {
//                return false;
//            }
//            if(!visited[j]) {
//                color[j]= !color[i];
//                if(!dfs(graph, j, visited, color)) return false;
//            }
//        }
//        return true;
//    }
    
    
    
//    --------------OPTIMAL -> DFS -> O(V+E) -> O(V)-----------
    public boolean isBipartite(int[][] graph) {
        Boolean[] color=new Boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(color[i]==null && !dfs(graph, i, true, color)) {
                return false;
            }
            
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int i, boolean prev, Boolean[] color) {
        if(color[i]!=null) return prev!=color[i];
        color[i]=prev;
        for(int j: graph[i]) {
            if(color[j]!=null && color[i]==color[j]) {
                return false;
            }
            if(color[j]==null) {
                if(!dfs(graph, j, !prev, color)) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsGraphBipartite i=new IsGraphBipartite();
        System.out.println(i.isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
        System.out.println(i.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }
}
