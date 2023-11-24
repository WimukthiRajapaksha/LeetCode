/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.the.number.of.complete.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountTheNumberOfCompleteComponents {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------OPTIMAL -> O(V+E), O(V+E)-----------
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
        int[] edgeCount=new int[n];
        int[] nodeCounts=new int[n];
        for(int i=0; i<n; i++) {
            nodeCounts[i]=1;
        }
        for(int[] e: edges) {
            findUnion(e[0], e[1], edgeCount, parent, nodeCounts);
        }
        int answer=0;
        for(int i=0; i<n; i++) {
            if(parent[i]==i && nodeCounts[i]*(nodeCounts[i]-1)/2==edgeCount[i]) {
                answer++;
            }
        }
        return answer;
    }
    
    private int findParent(int a, int[] parent) {
        if(a==parent[a]) return a;
        parent[a]=findParent(parent[a], parent);
        return parent[a];
    }
    
    private void findUnion(int a, int b, int[] edgesCount, int[] parent, int[] nodeCount) {
        int parentA = findParent(a, parent);
        int parentB = findParent(b, parent);
        edgesCount[parentA]++;
        if(parentA!=parentB) {
            parent[parentB]=parentA;
            edgesCount[parentA]+=edgesCount[parentB];
            nodeCount[parentA]+=nodeCount[parentB];
        }
    }
    
    
    
//    ----------OPTIMAL -> O(V+E), O(V+E)-----------
//    int depth=0;
//    public int countCompleteComponents(int n, int[][] edges) {
//        Map<Integer, List<Integer>> graph=new HashMap<>();
//        for(int i=0; i<n; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        int[] counts=new int[n];
//        for(int[] e: edges) {
//            graph.get(e[0]).add(e[1]);
//            graph.get(e[1]).add(e[0]);
//            counts[e[0]]++;
//            counts[e[1]]++;
//        }
//        int cou=0;
//        boolean[] visited=new boolean[n];
//        for(int i=0; i<n; i++) {
//            depth=0;
//            if(!visited[i] && dfs(graph, counts, i, visited)) {
//                cou++;
//            }
//        }
//        return cou;
//    }
//    
//    private boolean dfs(Map<Integer, List<Integer>> graph, int[] count, int curr, boolean[] visited) {
//        if(visited[curr]) return true;
//        visited[curr]=true;
//        depth++;
//        boolean ret=true;
//        for(int j: graph.get(curr)) {
//            if(!dfs(graph, count, j, visited)) { // we need to complete traversal and update visited[]
//                ret=false;
//            }
//        }
//        if(count[curr]!=depth-1) return false;
//        return ret;
//    }
    
    public static void main(String[] args) {
        CountTheNumberOfCompleteComponents c=new CountTheNumberOfCompleteComponents();
        System.out.println(c.countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4}}));
        System.out.println(c.countCompleteComponents(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}));
        System.out.println(c.countCompleteComponents(16, new int[][]{{9,15},{4,9},{0,4},{3,4},{8,9},{6,4},{12,15},{13,8},{3,13},{9,6},{2,5},{2,10},{2,11},{2,7},{2,14},{5,10},{5,11},{5,7},{5,14},{10,11},{10,7},{10,14},{11,7},{11,14},{7,14}}));
    }
}
