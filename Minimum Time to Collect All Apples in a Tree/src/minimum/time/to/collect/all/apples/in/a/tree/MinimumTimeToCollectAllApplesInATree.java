/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.time.to.collect.all.apples.in.a.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumTimeToCollectAllApplesInATree {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL -> O(N), O(N)------------------------
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited=new boolean[n];
        visited[0]=true;
        return Math.max(dfs(graph, 0, visited, hasApple)-2,0);
    }
    
    private int dfs(List<Integer>[] graph, int i, boolean[] visited, List<Boolean> hasApple) {
        int c=0;
        for(int j: graph[i]) {
            if(visited[j]) continue;
            visited[j]=true;
            c+=dfs(graph, j, visited, hasApple);
        }
        if(c>0 || hasApple.get(i)) {
            return c+2;
        }
        return c;
    }
    
    public static void main(String[] args) {
        MinimumTimeToCollectAllApplesInATree m=new MinimumTimeToCollectAllApplesInATree();
        System.out.println(m.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,true,false,true,true,false)));
        System.out.println(m.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,true,false,false,true,false)));
        System.out.println(m.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,false,false,false,false,false)));
    }
}
