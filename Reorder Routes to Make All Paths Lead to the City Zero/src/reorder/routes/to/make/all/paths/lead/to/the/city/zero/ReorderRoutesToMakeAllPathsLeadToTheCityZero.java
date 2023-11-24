/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reorder.routes.to.make.all.paths.lead.to.the.city.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(N), O(N)-------------
    int count=0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> graph=new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] i: connections) {
            graph.get(i[0]).add(Arrays.asList(i[1], 1));
            graph.get(i[1]).add(Arrays.asList(i[0], 0));
        }
        System.out.println(graph);
        help(graph, 0, -1);
        return count;
    }
    
    private void help(Map<Integer, List<List<Integer>>> graph, int current, int parent) {
        for(List<Integer> i: graph.get(current)) {
            if(parent==i.get(0)) continue;
            count+=i.get(1);
            help(graph, i.get(0), current);
        }
    }
    
    
//    ------------OPTIMAL -> O(N), O(N)-----------
//    int count=0;
//    public int minReorder(int n, int[][] connections) {
//        Map<Integer, List<Integer>> graph=new HashMap<>();
//        for(int i=0; i<=n; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        for(int[] i: connections) {
//            graph.get(i[0]+1).add(i[1]+1);
//            graph.get(i[1]+1).add(-i[0]-1);
//        }
//        System.out.println(graph);
//        help(graph, 1, new boolean[n+1]);
//        return count;
//    }
//    
//    private void help(Map<Integer, List<Integer>> graph, int i, boolean[] visited) {
//        if(visited[i]) return;
//        System.out.println(i);
//        visited[i]=true;
//        for(int j: graph.get(i)) {
//            if(j>0 && !visited[j]) count++;
//            help(graph, Math.abs(j), visited);
//        }
//    }
    
    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero r=new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
//        System.out.println(r.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
        System.out.println(r.minReorder(5, new int[][]{{1,0},{1,2},{3,2},{3,4}}));
    }
}
