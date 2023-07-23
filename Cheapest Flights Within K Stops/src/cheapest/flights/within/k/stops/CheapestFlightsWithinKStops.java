/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheapest.flights.within.k.stops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class CheapestFlightsWithinKStops {

    /**
     * @param args the command line arguments
     */
    
//    -----------------DIJKSTRA ALGORITHM -> GIVES TLE -> O(N+EK.LOG(EK)) , O(N+EK)----------------
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Map<Integer, List<int[]>> adj=new HashMap<>();
//        for(int[] flight: flights) {
//            adj.putIfAbsent(flight[0], new ArrayList<>());
//            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
//        }
//        PriorityQueue<int[]> queue=new PriorityQueue<>((o1,o2)->Integer.compare(o1[0], o2[0]));
//        queue.offer(new int[]{0, src, k+1}); // dist_from_src_node, node, number_of_stops_from_src_node
//        while(!queue.isEmpty()) {
//            int[] temp=queue.poll();
//            int dist=temp[0];
//            int node=temp[1];
//            int step=temp[2];
//            if(node==dst) return dist;
//            if(step>0 && adj.containsKey(node)) {
//                for(int[] a: adj.get(node)) {
//                    queue.offer(new int[]{dist+a[1], a[0], step-1});
//                }
//            }
//        }
//        return -1;
//    }
    
    
    
//    -----------------DIJKSTRA ALGORITHM -> GIVES TLE -> O(N+EK.LOG(EK)) , O(N+EK)----------------
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj=new HashMap<>();
        for(int[] flight: flights) {
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        int[] distance=new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0, src, 0}); // dist_from_src_node, node, number_of_stops_from_src_node
        while(!queue.isEmpty()) {
            int[] temp=queue.poll();
            int dist=temp[0];
            int node=temp[1];
            int step=temp[2];
            if(step>=k+1 || node==dst || !adj.containsKey(node)) continue;
            for(int[] a: adj.get(node)) {
                queue.offer(new int[]{dist+a[1], a[0], step+1});
                distance[a[0]]=Math.min(distance[a[0]], dist+a[1]);
            }
        }
        return distance[dst]==Integer.MAX_VALUE ? -1 : distance[dst];
    }
    
    
    
    
    
    
//    ---------------BELLMAN FORD -> O((N+E)K), O(N)--------------------
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int[] distance=new int[n];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[src]=0;
//        for(int i=0; i<=k; i++) {
//            int[] temp=Arrays.copyOf(distance, n);
//            for(int[] flight: flights) {
//                if(distance[flight[0]]!=Integer.MAX_VALUE) {
//                    temp[flight[1]]=Math.min(temp[flight[1]], distance[flight[0]]+flight[2]);
//                }
//            }
//            distance=temp;
//        }
//        return distance[dst]==Integer.MAX_VALUE ? -1 : distance[dst];
//    }
    
    
    
    
//    -----------------------BFS -> O(N+EK), O(N+EK)-------------------
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        Map<Integer, List<int[]>> adj=new HashMap<>();
//        for(int[] f: flights) {
//            adj.putIfAbsent(f[0], new ArrayList<>());
//            adj.get(f[0]).add(new int[]{f[1], f[2]});
//        }
//        int[] dist=new int[n];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Queue<int[]> queue=new LinkedList<>();
//        queue.offer(new int[]{src, 0});
//        while(k-->=0 && !queue.isEmpty()) {
//            int size=queue.size();
//            while(size-->0) {
//                int[] temp=queue.poll();
//                int node=temp[0];
//                int distance=temp[1];
//                if(!adj.containsKey(node)) continue;
//                for(int[] i: adj.get(node)) {
//                    int neighbor=i[0];
//                    int price=i[1];
//                    if(price+distance>=dist[neighbor]) continue;
//                    dist[neighbor]=price+distance;
//                    queue.offer(new int[]{neighbor, dist[neighbor]});
//                }
//            }
//        }
//        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
//    }
    
    public static void main(String[] args) {
        CheapestFlightsWithinKStops c=new CheapestFlightsWithinKStops();
        System.out.println(c.findCheapestPrice(4, new int[][]{
            {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
        System.out.println(c.findCheapestPrice(3, new int[][]{
            {0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(c.findCheapestPrice(3, new int[][]{
            {0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
    }
}
