/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all.ancestors.of.a.node.in.a.directed.acyclic.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class AllAncestorsOfANodeInADirectedAcyclicGraph {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> TOPOLOGICAL SORTING -> O(V+E) -> O(V)---------
//    public List<List<Integer>> getAncestors(int n, int[][] edges) {
//        List<Integer>[] graph=new ArrayList[n];
//        boolean[][] ancestors=new boolean[n][n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        int[] indegree=new int[n];
//        for(int[] e: edges) {
//            graph[e[0]].add(e[1]);
//            indegree[e[1]]++;
//        }
//        Queue<Integer> queue=new LinkedList<>();
//        for(int i=0; i<n; i++) {
//            if(indegree[i]==0) queue.offer(i);
//        }
//        while(!queue.isEmpty()) {
//            int temp=queue.poll();
//            for(int i: graph[temp]) {
//                indegree[i]--;
//                if(indegree[i]==0) {
//                    queue.offer(i);
//                }
//                ancestors[i][temp]=true;
//                for(int j=0; j<ancestors[temp].length; j++) {
//                    if(ancestors[temp][j]) {
//                        ancestors[i][j]=true;
//                    }
//                }
//            }
//        }
//        List<List<Integer>> ret=new ArrayList<>();
//        for(int i=0; i<n; i++) {
//            ret.add(new ArrayList<>());
//        }
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(ancestors[i][j]) {
//                    ret.get(i).add(j);
//                }
//            }
//        }
//        return ret;
//    }
    
    
    
//    ---------OPTIMAL -> DFS -> O(V+E) -> O(V)-----------
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph=new ArrayList[n];
        List<List<Integer>> ret=new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
            ret.add(new ArrayList<>());
        }
        for(int[] e: edges) {
            graph[e[1]].add(e[0]);
        }
        boolean[] visited=new boolean[n];
        boolean[][] ancestors=new boolean[n][n];
        for(int i=0; i<n; i++) {
            dfs(graph, visited, i, ancestors);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(ancestors[i][j] && i!=j) {
                    ret.get(i).add(j);
                }
            }
        }
        return ret;
    }
    
    private void dfs(List<Integer>[] graph, boolean[] visited, int i, boolean[][] ret) {
        if(visited[i]) return;
        visited[i]=true;
        for(int j: graph[i]) {
            dfs(graph, visited, j, ret);
            for(int k=0; k<ret.length; k++) {
                if(ret[j][k]) {
                    ret[i][k]=true;
                }
            }
        }
        ret[i][i]=true;
    }
    
    public static void main(String[] args) {
        AllAncestorsOfANodeInADirectedAcyclicGraph a=new AllAncestorsOfANodeInADirectedAcyclicGraph();
        System.out.println(a.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
        System.out.println(a.getAncestors(5, new int[][]{{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}));
    }
}
