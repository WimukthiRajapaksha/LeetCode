/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.critical.and.pseudo.critical.edges.in.minimum.spanning.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

    /**
     * @param args the command line arguments
     */
    
    class UnionFind {
        int[] parents;
        int count;
        
        public UnionFind(int n) {
            parents=new int[n];
            reset();
        }
        
        private void reset() {
            for(int i=0; i<parents.length; i++) {
                parents[i]=i;
            }
            count=parents.length;
        }
        
        public int find(int i) {
            int pare=parents[i];
            if(pare==i) return i;
            int root=find(pare);
            parents[i]=root;
            return root;
        }
        
        public boolean union(int i, int j) {
            int first=find(i);
            int second=find(j);
            if(first!=second) {
                count--;
                parents[first]=second;
                return true;
            }
            return false;
        }
    }
    
    
//    ------OPTIMAL -> O(E*LOGE), O(V)----------
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ret=new ArrayList<>();
        ret.add(new ArrayList<>());
        ret.add(new ArrayList<>());
        Map<int[], Integer> originalIndexes=new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            originalIndexes.put(edges[i], i);
        }
        Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));
        int mstCost=buildMST(edges, n, null, null);
        for(int i=0; i<edges.length; i++) {
            int[] edge=edges[i];
            int index=originalIndexes.get(edge);
            int withoutCost=buildMST(edges, n, edge, null);
            if(withoutCost>mstCost) {
                ret.get(0).add(index);
            } else {
                int withCost=buildMST(edges, n, null, edge);
                if(withCost==mstCost) {
                    ret.get(1).add(index);
                }
            }
        }
        return ret;
    }
    
    private int buildMST(int[][] edges, int n, int[] skip, int[] pick) {
        UnionFind unionFind=new UnionFind(n);
        int cost=0;
        if(pick!=null) {
            unionFind.union(pick[0], pick[1]);
            cost+=pick[2];
        }
        for(int[] edge: edges) {
            if(skip!=edge && unionFind.union(edge[0], edge[1])) {
                cost+=edge[2];
            }
        }
        return (unionFind.count==1) ? cost : Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree f=new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree();
        System.out.println(f.findCriticalAndPseudoCriticalEdges(5, new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}}));
    }
}
