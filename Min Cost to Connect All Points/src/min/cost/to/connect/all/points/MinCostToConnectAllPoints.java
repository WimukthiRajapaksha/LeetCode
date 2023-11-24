/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package min.cost.to.connect.all.points;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinCostToConnectAllPoints {

    /**
     * @param args the command line arguments
     */
    
    
    
//    ------------OPTIMAL -> KRUSKAL'S ALGORITHM -> O(N^2), O(N^2)--------------
//    class UnionFind {
//        int[] parent;
//        
//        public UnionFind(int n) {
//            parent=new int[n];
//            reset();
//        }
//        
//        private void reset() {
//            for(int i=0; i<parent.length; i++) {
//                parent[i]=i;
//            }
//        }
//        
//        private int find(int i) {
//            if(i!=parent[i]) parent[i]=find(parent[i]);
//            return parent[i];
//        }
//        
//        private boolean union(int i, int j) {
//            int ii=find(i);
//            int jj=find(j);
//            if(ii==jj) return false;
//            parent[ii]=jj;
//            return true;
//        }
//    }
//    
//    public int minCostConnectPoints(int[][] points) {
//        int[][] edges=new int[points.length*(points.length-1)/2][3];
//        int place=0;
//        for(int i=0; i<points.length; i++) {
//            for(int j=i+1; j<points.length; j++) {
//                edges[place++]=new int[]{i, j, manhattanDistance(points[i], points[j])};
//            }
//        }
//        Arrays.sort(edges, (e0, e1)->Integer.compare(e0[2], e1[2]));
//        return minimumSpanningTree(edges, points.length);
//    }
//    
//    private int minimumSpanningTree(int[][] edges, int n) {
//        int cost=0;
//        UnionFind unionFind=new UnionFind(n);
//        for(int[] e: edges) {
//            if(unionFind.find(e[0])!=unionFind.find(e[1])) {
//                unionFind.union(e[0], e[1]);
//                cost+=e[2];
//            }
//        }
//        return cost;
//    }
//    
//    private int manhattanDistance(int[] i, int[] j) {
//        return Math.abs(i[0]-j[0])+Math.abs(i[1]-j[1]);
//    }
    
    
    
    
//    -------------OPTIMAL -> PRIM'S ALGORITHM -> O(N^2), O(N)-----------
    public int minCostConnectPoints(int[][] points) {
        int[] distance=new int[points.length];
        for(int i=0; i<points.length; i++) {
            distance[i]=manhattanDistance(points, 0, i);
        }
        boolean[] visited=new boolean[points.length];
        visited[0]=true;
        int visitedCount=1;
        int cost=0;
        while(visitedCount<points.length) {
            int next=-1;
            for(int i=0; i<distance.length; i++) {
                if(!visited[i] && (next==-1 || distance[next]>=distance[i])) next=i;
            }
            visited[next]=true;
            cost+=distance[next];
            for(int i=0; i<points.length; i++) {
                if(!visited[i]) {
                    distance[i]=Math.min(distance[i], manhattanDistance(points, next, i));
                }
            }
            visitedCount++;
        }
        return cost;
    }
    
    private int manhattanDistance(int[][] points, int i, int j) {
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
    
    public static void main(String[] args) {
        MinCostToConnectAllPoints m=new MinCostToConnectAllPoints();
        System.out.println(m.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        System.out.println(m.minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));
        System.out.println(m.minCostConnectPoints(new int[][]{{-1000000,-1000000},{1000000,1000000}}));
    }
}
