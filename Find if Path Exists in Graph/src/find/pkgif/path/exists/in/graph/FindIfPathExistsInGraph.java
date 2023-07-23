/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.pkgif.path.exists.in.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindIfPathExistsInGraph {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------------OPTIMAL - DFS -> O(M+N), O(M+N)------------------------
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] i: edges) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        return dfs(graph, source, destination, new boolean[n]);
    }

    private boolean dfs(List<List<Integer>> list, int s, int d, boolean[] visited) {
        if(visited[s]) return false;
        if(s==d) return true;
        visited[s]=true;
        for(int i: list.get(s)) {
            if(dfs(list, i, d, visited)) return true;
        }
        return false;
    }
    
    
    
//    -------------------------OPTIMAL - BFS -> O(M+N), O(M+N)------------------------
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        if(source==destination) return true;
//        if(edges.length==0) return false;
//        List<Integer>[] graph=new ArrayList[n];
//        for(int[] e: edges) {
//            if(graph[e[0]]==null) {
//                graph[e[0]]=new ArrayList<>();
//            }
//            if(graph[e[1]]==null) {
//                graph[e[1]]=new ArrayList<>();
//            }
//            graph[e[0]].add(e[1]);
//            graph[e[1]].add(e[0]);
//        }
//        for(List<Integer> g: graph) {
//            System.out.println(g);
//        }
//        Queue<Integer> queue=new LinkedList<>();
//        boolean[] visited=new boolean[n];
//        queue.offer(source);
//        visited[source]=true;
//        while(!queue.isEmpty()) {
//            int temp=queue.poll();
//            for(int i: graph[temp]) {
//                if(i==destination) return true;
//                if(!visited[i]) {
//                    queue.offer(i);
//                    visited[i]=true;
//                }
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        FindIfPathExistsInGraph f=new FindIfPathExistsInGraph();
        System.out.println(f.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(f.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }
}
