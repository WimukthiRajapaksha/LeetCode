/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.city.with.the.smallest.number.of.neighbors.at.a.threshold.distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------OPTIMAL -> FLOYD-WARSHALL'S -> O(N^3) -> O(N^2)--------------
//    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        int[][] graph=new int[n][n];
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n; j++) {
//                if(i!=j) graph[i][j]=distanceThreshold*2;
//            }
//        }
//        
//        for(int[] e: edges) {
//            graph[e[0]][e[1]]=e[2];
//            graph[e[1]][e[0]]=e[2];
//        }
//        for(int k=0; k<n; k++) {
//            for(int i=0; i<n; i++) {
//                for(int j=0; j<n; j++) {
//                    graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
//                }
//            }
//        }
//        int place=0;
//        int min=Integer.MAX_VALUE;
//        for(int i=0; i<n; i++) {
//            int count=0;
//            for(int j=0; j<n; j++) {
//                if(i!=j && graph[i][j]<=distanceThreshold) {
//                    count++;
//                }
//            }
//            if(count<=min) {
//                min=count;
//                place=i;
//            }
//        }
//        return place;
//    }
    
    
//    ----------------OPTIMAL -> DIJKSTRA -> O(N^3) -> O(N)----------
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        
        for(int[] e: edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int place=0;
        int count=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int val=dijkistra(graph, i, distanceThreshold);
            if(val<=count) {
                count=val;
                place=i;
            }
        }
        return place;
    }
    
    private int dijkistra(List<int[]>[] graph, int i, int thre) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
        int[] distance=new int[graph.length];
        Arrays.fill(distance, 1000000);
        pq.offer(new int[]{i, 0});
        while(!pq.isEmpty()) {
            int[] temp=pq.poll();
            for(int[] j: graph[temp[0]]) {
                if(j[1]+temp[1]<=distance[j[0]]) {
                    pq.offer(new int[]{j[0], j[1]+temp[1]});
                    distance[j[0]]=j[1]+temp[1];
                }
            }
        }
        distance[i]=0;
        int count=0;
        for(int j=0; j<distance.length; j++) {
            if(thre>=distance[j]) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance f=new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();
        System.out.println(f.findTheCity(4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
        System.out.println(f.findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
        System.out.println(f.findTheCity(6, new int[][]{{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, 20));
    }
}
