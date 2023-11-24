/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximal.network.rank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximalNetworkRank {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> O(N^2), O(N^2)----------
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] graph=new boolean[n][n];
        int[] count=new int[n];
        for(int[] r: roads) {
            graph[r[0]][r[1]]=true;
            graph[r[1]][r[0]]=true;
            count[r[0]]++;
            count[r[1]]++;
        }
        int max=0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp=count[i]+count[j]-(graph[i][j] ? 1 : 0);
                if(max<temp) max=temp;
            }
        }
        return max;
    }
    
    
//    -----------OPTIMAL -> O(N^2), O(N^2)----------
//    public int maximalNetworkRank(int n, int[][] roads) {
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        for(int i=0; i<n; i++) {
//            graph.put(i, new HashSet<>());
//        }
//        for(int[] r: roads) {
//            graph.get(r[0]).add(r[1]);
//            graph.get(r[1]).add(r[0]);
//        }
//        int max=0;
//        for(int i=0; i<n; i++) {
//            for(int j=i+1; j<n; j++) {
//                int count=graph.get(i).size()+graph.get(j).size();
//                if(graph.get(i).contains(j)) {
//                    count--;
//                }
//                if(max<count) max=count;
//            }
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        MaximalNetworkRank m=new MaximalNetworkRank();
        System.out.println(m.maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println(m.maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println(m.maximalNetworkRank(8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}));
    }
}
