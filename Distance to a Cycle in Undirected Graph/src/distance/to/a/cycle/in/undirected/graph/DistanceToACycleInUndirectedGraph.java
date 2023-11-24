/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance.to.a.cycle.in.undirected.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class DistanceToACycleInUndirectedGraph {

    /**
     * @param args the command line arguments
     */
    
    public int[] smallestPath(int n, int[][] edges) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] cycle=new boolean[n];
        for(int i=0; i<n; i++) {
            if(cycle(graph, cycle, i, new ArrayList<>(), cycle)) {
                System.out.println(true);
                break;
            }
        }
        System.out.println(Arrays.toString(cycle));
        return new int[]{};
    }
    
    private boolean cycle(List<Integer>[] graph, boolean[] visited, int i, List<Integer> cycle, boolean[] cyclePoints) {
        if(visited[i]) {
            System.out.println(cycle);
            boolean found=false;
            for(int j=0; j<cycle.size(); j++) {
                if(cycle.get(j)==i) {
                    found=true;
                }
                if(found) {
                    cyclePoints[j]=true;
                }
            }
            return true;
        }
        visited[i]=true;
        cycle.add(i);
        for(int j: graph[i]) {
            if(cycle(graph, visited, j, cycle, cyclePoints)) {
                return true;
            }
        }
        visited[i]=false;
        cycle.remove(cycle.size()-1);
        return false;
    }
    
    public static void main(String[] args) {
        DistanceToACycleInUndirectedGraph d=new DistanceToACycleInUndirectedGraph();
        System.out.println(Arrays.toString(d.smallestPath(7, new int[][]{{1,2},{2,3},{3,4},{4,1},{0,1},{5,2},{6,5}})));
        System.out.println(Arrays.toString(d.smallestPath(7, new int[][]{{1,2},{2,3},{4,1},{0,1},{5,2},{6,5}})));
    }
}
