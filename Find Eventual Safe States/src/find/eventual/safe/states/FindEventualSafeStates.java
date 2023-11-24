/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.eventual.safe.states;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindEventualSafeStates {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL -> DFS -> WITH COLORING -> O(V+E) -> O(E) -------------
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ret=new ArrayList<>();
        int[] color=new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(dfs(graph, i, color)) {
                ret.add(i);
            }
        }
        return ret;
    }
    
    private boolean dfs(int[][] graph, int i, int[] color) {
        if(color[i]!=0) return color[i]==1;
        color[i]=2;
        for(int j: graph[i]) {
            if(!dfs(graph, j, color)) return false;
        }
        color[i]=1;
        return true;
    }
    
    
////    -------------OPTIMAL -> DFS -> O(V+E) -> O(V) -------------
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        boolean[] visited=new boolean[graph.length];
//        List<Integer> ret=new ArrayList<>();
//        Boolean[] isValid=new Boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            if(dfs(graph, visited, i, isValid)) {
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
//    
//    private boolean dfs(int[][] graph, boolean[] visited, int i, Boolean[] isValid) {
//        if(isValid[i]!=null) return isValid[i];
//        if(visited[i]) return false;
//        visited[i]=true;
//        boolean valid=true;
//        for(int j: graph[i]) {
//            valid &= dfs(graph, visited, j, isValid);
//        }
//        isValid[i]=valid;
//        return valid;
//    }
    
//    ----------------OPTIMAL -> BFS -> TOPOLOGICAL SORT -> KHAN'S ALGORITHM -> O(V+E) -> O(V+E) ---------
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        List<Integer> ret=new ArrayList<>();
//        boolean[][] adjGraph=new boolean[graph.length][graph.length];
//        int[] indegree=new int[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            for(int j: graph[i]) {
//                adjGraph[j][i]=true;
//                indegree[i]++;
//            }
//        }
//        
//        Queue<Integer> queue=new LinkedList<>();
//        for(int i=0; i<graph.length; i++) {
//            if(indegree[i]==0) {
//                queue.offer(i);
//            }
//        }
//        boolean[] isSafe=new boolean[graph.length];
//        while(!queue.isEmpty()) {
//            int temp=queue.poll();
//            isSafe[temp]=true;
//            for(int i=0; i<adjGraph[temp].length; i++) {
//                if(adjGraph[temp][i] && temp!=i) {
//                    indegree[i]--;
//                    if(indegree[i]==0) {
//                        queue.offer(i);
//                    }
//                }
//            }
//        }
//        for(int i=0; i<graph.length; i++) {
//            if(isSafe[i]) {
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        FindEventualSafeStates f=new FindEventualSafeStates();
        System.out.println(f.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println(f.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));
    }
}
