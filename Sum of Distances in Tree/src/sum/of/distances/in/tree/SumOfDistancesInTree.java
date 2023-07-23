/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.distances.in.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfDistancesInTree {

    /**
     * @param args the command line arguments
     */
    
    int[] subNodes;
    int[] sumDist;
    List<Integer>[] graph;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        subNodes=new int[n];
        sumDist=new int[n];
        graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        dfsFromRoot(graph, 0, -1);
        dfsForEachNode(0, -1);
        return sumDist;
    }
    
    private void dfsFromRoot(List<Integer>[] graph, int root, int parent) {
        for(int i: graph[root]) {
            if(parent==i) continue;
            dfsFromRoot(graph, i, root);
            subNodes[root]+=subNodes[i];
            sumDist[root]+=sumDist[i]+subNodes[i];
        }
        subNodes[root]++;
    }
    
    private void dfsForEachNode(int root, int prev) {
        for(int g: graph[root]) {
            if(prev==g) continue;
            sumDist[g]=sumDist[root]-subNodes[g]+(sumDist.length-subNodes[g]);
            dfsForEachNode(g, root);
        }
    }
    
    public static void main(String[] args) {
        SumOfDistancesInTree s=new SumOfDistancesInTree();
        System.out.println(s.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}}));
    }
}
