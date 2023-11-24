/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.time.when.the.network.becomes.idle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class TheTimeWhenTheNetworkBecomesIdle {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------TLE -> BELLMAN - FORD ALGORITHM -> O(V*E) -> O(V)----------
//    public int networkBecomesIdle(int[][] edges, int[] patience) {
//        List<Integer>[] graph=new ArrayList[patience.length];
//        for(int i=0; i<graph.length; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] e: edges) {
//            graph[e[0]].add(e[1]);
//            graph[e[1]].add(e[0]);
//        }
//        int[] distance=new int[patience.length];
//        for(int i=0; i<distance.length; i++) {
//            distance[i]=Integer.MAX_VALUE/2;
//        }
//        distance[0]=0;
//        for(int i=0; i<patience.length-1; i++) {
//            boolean hasChanged=false;
//            for(int j=0; j<edges.length; j++) {
//                if(distance[edges[j][0]]+1<distance[edges[j][1]]) {
//                    distance[edges[j][1]]=distance[edges[j][0]]+1;
//                    hasChanged=true;
//                }
//                if(distance[edges[j][1]]+1<distance[edges[j][0]]) {
//                    distance[edges[j][0]]=distance[edges[j][1]]+1;
//                    hasChanged=true;
//                }
//            }
//            if(!hasChanged) break;
//        }
//        for(int i=0; i<distance.length; i++) {
//            distance[i]*=2;
//        }
//        System.out.println(Arrays.toString(distance));
//        int min=0;
//        for(int i=1; i<patience.length; i++) {
//            int val=(distance[i])+((((distance[i])-1)/patience[i])*patience[i]);
//            min=Math.max(min, val);
//        }
//        return min+1;
//    }
    
    
//    --------OPTIMAL -> DIJKSTRA ALGORITHM -> O(E+V*LOG V) -> O(V)-----------
//    public int networkBecomesIdle(int[][] edges, int[] patience) {
//        List<Integer>[] graph=new ArrayList[patience.length];
//        for(int i=0; i<graph.length; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] e: edges) {
//            graph[e[0]].add(e[1]);
//            graph[e[1]].add(e[0]);
//        }
//        for(List<Integer> g: graph) System.out.println(g);
//        int[] distance=new int[patience.length];
//        for(int i=0; i<distance.length; i++) {
//            distance[i]=Integer.MAX_VALUE;
//        }
//        dijkstra(graph, distance);
//        System.out.println(Arrays.toString(distance));
//        for(int i=0; i<distance.length; i++) {
//            distance[i]*=2;
//        }
//        int min=0;
//        for(int i=1; i<patience.length; i++) {
//            int val=distance[i]+(((distance[i]-1)/patience[i])*patience[i]);
//            min=Math.max(min, val);
//        }
//        return min+1;
//    }
//    
//    private void dijkstra(List<Integer>[] graph, int[] distance) {
//        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1, o2));
//        pq.offer(0);
//        distance[0]=0;
//        while(!pq.isEmpty()) {
//            int t=pq.poll();
//            for(int i: graph[t]) {
//                if(distance[i]>distance[t]+1) {
//                    distance[i]=distance[t]+1;
//                    pq.offer(i);
//                }
//            }
//        }
//    }
    
    
    
//    ------------OPTIMAL -> BFS -> O(V+E) -> O(V)------------
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] graph=new ArrayList[patience.length];
        for(int i=0; i<patience.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for(List<Integer> g: graph) System.out.println(g);
        int[] distance=new int[patience.length];
        Arrays.fill(distance, -1);
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        distance[0]=0;
        while(!queue.isEmpty()) {
            int temp=queue.poll();
            for(int i: graph[temp]) {
                if(distance[i]==-1) {
                    queue.offer(i);
                    distance[i]=distance[temp]+1;
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        for(int i=0; i<distance.length; i++) {
            distance[i]*=2;
        }
        int min=0;
        for(int i=1; i<distance.length; i++) {
            int val=distance[i]+((distance[i]-1)/patience[i])*patience[i];
            min=Math.max(min, val);
        }
        return min+1;
    }
    
    public static void main(String[] args) {
        TheTimeWhenTheNetworkBecomesIdle t=new TheTimeWhenTheNetworkBecomesIdle();
        System.out.println(t.networkBecomesIdle(new int[][]{{0,1},{1,2}}, new int[]{0,2,1}));
        System.out.println(t.networkBecomesIdle(new int[][]{{0,1},{0,2},{1,2}}, new int[]{0,10,10}));
        System.out.println(t.networkBecomesIdle(new int[][]{{5,7},{15,18},{12,6},{5,1},{11,17},{3,9},{6,11},{14,7},{19,13},{13,3},{4,12},{9,15},{2,10},{18,4},{5,14},{17,5},{16,2},{7,1},{0,16},{10,19},{1,8}}, new int[]{0,2,1,1,1,2,2,2,2,1,1,1,2,1,1,1,1,2,1,1}));
        System.out.println(t.networkBecomesIdle(new int[][]{{3,8},{4,13},{0,7},{0,4},{1,8},{14,1},{7,2},{13,10},{9,11},{12,14},{0,6},{2,12},{11,5},{6,9},{10,3}}, new int[]{0,3,2,1,5,1,5,5,3,1,2,2,2,2,1}));
    }
}
