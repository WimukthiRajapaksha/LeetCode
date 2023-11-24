/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.unreachable.pairs.of.nodes.in.an.undirected.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    /**
     * @param args the command line arguments
     */
    
    public long countPairs(int n, int[][] edges) {
        if(edges.length==0) {
            return n*(long)(n-1)/2;
        }
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] e: edges) {
            union(e[0], e[1], parent, rank);
        }
        long count=0;
        long prev=0;
        for(int i=0; i<n; i++) {
            if(parent[i]==i) {
                count+=(prev*rank[parent[i]]);
                prev+=rank[parent[i]];
            }
        }
        return count;
    }
    
    private void union(int i, int j, int[] parent, int[] rank) {
        int parentI=parent(i, parent);
        int parentJ=parent(j, parent);
        if(parentI!=parentJ) {
            if(rank[parentI]>=rank[parentJ]) {
                parent[parentJ]=parentI;
                rank[parentI]+=rank[parentJ];
            } else {
                parent[parentI]=parentJ;
                rank[parentJ]+=rank[parentI];
            }
        }
    }
    
    private int parent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=parent(parent[i], parent);
        return parent[i];
    }
    
    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph c=new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        System.out.println(c.countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
        System.out.println(c.countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
        System.out.println(c.countPairs(100000, new int[][]{}));
    }
}

0
14
4999950000