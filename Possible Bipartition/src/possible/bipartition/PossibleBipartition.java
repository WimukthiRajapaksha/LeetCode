/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possible.bipartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class PossibleBipartition {

    /**
     * @param args the command line arguments
     */
    
//    ------------------------OPTIMAL - BFS -> O(N+E), O(N+E)----------------
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n==1) return true;
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] i: dislikes) {
            graph[i[0]-1].add(i[1]-1);
            graph[i[1]-1].add(i[0]-1);
        }
        Boolean[] color=new Boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(color[i]==null) {
                color[i]=true;
                q.offer(i);
                while(!q.isEmpty()) {
                    int temp=q.poll();
                    for(int j: graph[temp]) {
                        if(color[j]!=null) {
                            if(color[j]==color[temp]) return false;
                            continue;
                        }
                        color[j]=!color[temp];
                        q.offer(j);
                    }
                }
            }
        }
        return true;
    }
    
    
//    ------------------------OPTIMAL - DFS -> O(N+E), O(N+E)----------------
//    public boolean possibleBipartition(int n, int[][] dislikes) {
//        if(n==1) return true;
//        Boolean[] arr=new Boolean[n];
//        List<Integer>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] i: dislikes) {
//            graph[i[0]-1].add(i[1]-1);
//            graph[i[1]-1].add(i[0]-1);
//        }
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i]==null) {
//                if(!dfs(graph, i, arr, true)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    
//    private boolean dfs(List<Integer>[] graph, int i, Boolean[] bag, boolean prev) {
//        if(bag[i]!=null) {
//            return (bag[i]!=prev);
//        }
//        bag[i]=!prev;
//        for(int j: graph[i]) {
//            if(!dfs(graph, j, bag, !prev)) {
//                return false;
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        PossibleBipartition p=new PossibleBipartition();
        System.out.println(
            p.possibleBipartition(5, 
                    new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}
            ));
        
        System.out.println(
            p.possibleBipartition(4, 
                    new int[][]{{1,2},{1,3},{2,4}}
            ));
    }
}
