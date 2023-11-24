/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.operations.to.make.network.connected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfOperationsToMakeNetworkConnected {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL -> DFS -> O(M+N), O(N)--------------
//    public int makeConnected(int n, int[][] connections) {
//        if(connections.length<n-1) return -1;
//        Map<Integer, List<Integer>> graph=new HashMap<>();
//        for(int i=0; i<n; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        for(int[] c: connections) {
//            graph.get(c[0]).add(c[1]);
//            graph.get(c[1]).add(c[0]);
//        }
//        boolean[] visited=new boolean[n];
//        int count=0;
//        for(int i=0; i<n; i++) {
//            if(!visited[i]) {
//                dfs(graph, visited, i);
//                count++;
//            }
//        }
//        return count-1;
//    }
//    
//    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
//        if(visited[i]) return;
//        visited[i]=true;
//        for(int j: graph.get(i)) {
//            dfs(graph, visited, j);
//        }
//    }
    
    
    
//    --------------OPTIMAL -> UNION FIND -> O(M*N), O(N)-----------
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] parent=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
        for(int[] c: connections) {
            union(c[0], c[1], parent);
        }
        int count=0;
        for(int i=0; i<n; i++) {
            if(parent[i]==i) {
                count++;
            }
        }
        return count-1;
    }
    
    private void union(int i, int j, int[] parent) {
        int parentI=parent(i, parent);
        int parentJ=parent(j, parent);
        if(parentI!=parentJ) parent[parentJ]=parentI;
    }
    
    private int parent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=parent(parent[i], parent);
        return parent[i];
    }
    
    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected n=new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(n.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(n.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
        System.out.println(n.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
    }
}
