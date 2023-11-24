/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.delay.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

/**
 *
 * @author wimukthirajapaksha
 */
public class NetworkDelayTime {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> DIJKSTRA -> O(E+V*LOG V) -> O(V+E)-----------
//    public int networkDelayTime(int[][] times, int n, int k) {
//        List<int[]>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] t: times) {
//            graph[t[0]-1].add(new int[]{t[1]-1, t[2]});
//        }
//        return dijkstra(graph, k-1);
//    }
//    
//    private int dijkstra(List<int[]>[] graph, int i) {
//        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[0], o2[0]));
//        pq.offer(new int[]{i, 0});
//        int[] distance=new int[graph.length];
//        for(int j=0; j<graph.length; j++) {
//            distance[j]=Integer.MAX_VALUE;
//        }
//        distance[i]=0;
//        while(!pq.isEmpty()) {
//            int[] temp=pq.poll();
//            for(int[] j: graph[temp[0]]) {
//                if(temp[1]+j[1]<distance[j[0]]) {
//                    distance[j[0]]=temp[1]+j[1];
//                    pq.offer(new int[]{j[0], distance[j[0]]});
//                }
//            }
//        }
//        int max=0;
//        for(int j=0; j<distance.length; j++) {
//            if(max==Integer.MAX_VALUE) return -1;
//            max=Math.max(max, distance[j]);
//        }
//        return max;
//    }
    
    
    
//    ---------OPTIMAL -> BELLMAN FORD -> O(V*E) -> O(V)----------
    public int networkDelayTime(int[][] times, int n, int k) {
        return bellmanFord(times, k-1, n);
    }
    
    private int bellmanFord(int[][] edges, int s, int n) {
        int[] distance=new int[n];
        for(int i=0; i<distance.length; i++) {
            distance[i]=100000;
        }
        distance[s]=0;
        System.out.println(Arrays.toString(distance));
        for(int i=0; i<n-1; i++) {
            boolean hasChanged=false;
            for(int j=0; j<edges.length; j++) {
                int source=edges[j][0]-1;
                int destination=edges[j][1]-1;
                int weight=edges[j][2];
                if(distance[destination]>distance[source]+weight) {
                    distance[destination]=distance[source]+weight;
                    hasChanged=true;
                }
            }
            if(!hasChanged) break;
        }
        System.out.println(Arrays.toString(distance));
        int max=0;
        for(int i: distance) {
            if(i==100000) return -1;
            max=Math.max(max, i);
        }
        BiFunction<Integer, Integer, Integer> bi=new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer t, Integer u) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return max;
    }
    
    public static void main(String[] args) {
        NetworkDelayTime n=new NetworkDelayTime();
        System.out.println(n.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        System.out.println(n.networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
        System.out.println(n.networkDelayTime(new int[][]{{1,2,1},{2,1,3}}, 2, 2));
    }
}
