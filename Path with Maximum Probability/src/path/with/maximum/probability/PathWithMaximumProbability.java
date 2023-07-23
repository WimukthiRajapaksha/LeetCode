/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path.with.maximum.probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class PathWithMaximumProbability {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> DIJKISTRA -> O(M+N*LOGN), O(M+N)---------------------
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//        Map<Integer, List<Pair<Integer, Double>>> graph=new HashMap<>();
//        for(int i=0; i<edges.length; i++) {
//            int u=edges[i][0];
//            int v=edges[i][1];
//            double pathProb=succProb[i];
//            graph.putIfAbsent(u, new ArrayList<>());
//            graph.putIfAbsent(v, new ArrayList<>());
//            graph.get(u).add(new Pair(v, pathProb));
//            graph.get(v).add(new Pair(u, pathProb));
//        }
//        double[] maxProb=new double[n];
//        maxProb[start_node]=1;
//        Queue<Pair<Double, Integer>> pq=new PriorityQueue<>((a, b)->Double.compare(b.getKey(), a.getKey()));
//        pq.offer(new Pair(1.0, start_node));
//        while(!pq.isEmpty()) {
//            Pair<Double, Integer> temp=pq.poll();
//            double currProb=temp.getKey();
//            if(temp.getValue()==end_node) return currProb;
//            for(Pair<Integer, Double> g: graph.getOrDefault(temp.getValue(), new ArrayList<>())) {
//                int nextNode=g.getKey();
//                double prob=g.getValue();
//                if(currProb*prob>maxProb[nextNode]) {
//                    maxProb[nextNode]=currProb*prob;
//                    pq.offer(new Pair(maxProb[nextNode], nextNode));
//                }
//            }
//        }
//        return 0;
//    }
    
    
    
//    ---------------OPTIMAL -> DIJKISTRA -> O(M+N*LOGN), O(M+N)---------------------
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//        List<List<Pair<Integer, Double>>> graph=new ArrayList<>();
//        for(int i=0; i<n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for(int i=0; i<edges.length; i++) {
//            int u=edges[i][0];
//            int v=edges[i][1];
//            double pathProb=succProb[i];
//            graph.get(u).add(new Pair(v, pathProb));
//            graph.get(v).add(new Pair(u, pathProb));
//            
//        }
//        double[] maxProb=new double[n];
//        maxProb[start_node]=1;
//        Queue<Pair<Double, Integer>> pq=new PriorityQueue<>((a, b)->Double.compare(b.getKey(), a.getKey()));
//        pq.offer(new Pair(1.0, start_node));
//        while(!pq.isEmpty()) {
//            Pair<Double, Integer> temp=pq.poll();
//            double currProb=temp.getKey();
//            if(temp.getValue()==end_node) return currProb;
//            for(Pair<Integer, Double> g: graph.get(temp.getValue())) {
//                int nextNode=g.getKey();
//                double prob=g.getValue();
//                if(currProb*prob>maxProb[nextNode]) {
//                    maxProb[nextNode]=currProb*prob;
//                    pq.offer(new Pair(maxProb[nextNode], nextNode));
//                }
//            }
//        }
//        return 0;
//    }
    
    
    
//    ---------------OPTIMAL -> DIJKISTRA -> O(M+N*LOGN), O(M+N)---------------------
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//        List<Pair<Integer, Double>>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int i=0; i<edges.length; i++) {
//            int u=edges[i][0];
//            int v=edges[i][1];
//            double pathProb=succProb[i];
//            graph[u].add(new Pair(v, pathProb));
//            graph[v].add(new Pair(u, pathProb));
//            
//        }
//        double[] maxProb=new double[n];
//        boolean[] visited=new boolean[n];
//        maxProb[start_node]=1;
//        Queue<Pair<Double, Integer>> pq=new PriorityQueue<>((a, b)->Double.compare(b.getKey(), a.getKey()));
//        pq.offer(new Pair(1.0, start_node));
//        while(!pq.isEmpty()) {
//            Pair<Double, Integer> temp=pq.poll();
//            if(visited[temp.getValue()]) continue;
//            double currProb=temp.getKey();
//            visited[temp.getValue()]=true;
//            if(temp.getValue()==end_node) return currProb;
//            for(Pair<Integer, Double> g: graph[temp.getValue()]) {
//                int nextNode=g.getKey();
//                double prob=g.getValue();
//                if(!visited[nextNode] && currProb*prob>maxProb[nextNode]) {
//                    maxProb[nextNode]=currProb*prob;
//                    pq.offer(new Pair(maxProb[nextNode], nextNode));
//                }
//            }
//        }
//        return 0;
//    }
    
    
//    -----------------OPTIMAL -> BELLMAN - FORD -> O(M*N), O(N)-------------------
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProbability=new double[n];
        maxProbability[start_node]=1;
        for(int i=0; i<n-1; i++) {
            boolean updated=false;
            for(int j=0; j<edges.length; j++) {
                int u=edges[j][0];
                int v=edges[j][1];
                if(maxProbability[u]*succProb[j]>maxProbability[v]) {
                    maxProbability[v]=maxProbability[u]*succProb[j];
                    updated=true;
                }
                if(maxProbability[v]*succProb[j]>maxProbability[u]) {
                    maxProbability[u]=maxProbability[v]*succProb[j];
                    updated=true;
                }
            }
            if(!updated) break;
        }
        return maxProbability[end_node];
    }
    
    public static void main(String[] args) {
        PathWithMaximumProbability p=new PathWithMaximumProbability();
        System.out.println(p.maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
    }
}
