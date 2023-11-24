/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reachable.nodes.with.restrictions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReachableNodesWithRestrictions {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------OPTIMAL -> O(V+E) -> O(V+E)--------------
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        Set<Integer> restric=new HashSet<>();
        for(int i: restricted) restric.add(i);
        int val=dfs(graph, 0, restric);
        System.out.println(restric);
        return val;
    }
    
    private int dfs(List<Integer>[] graph, int i, Set<Integer> restricted) {
        if(restricted.contains(i)) return 0;
        int sum=1;
        restricted.add(i);
        for(int j: graph[i]) {
            sum+=dfs(graph, j, restricted);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        ReachableNodesWithRestrictions r=new ReachableNodesWithRestrictions();
        System.out.println(r.reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
    }
}
