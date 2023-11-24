/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.score.of.a.path.between.two.cities;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumScoreOfAPathBetweenTwoCities {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------OPTIMAL -> UNION FIND -> O(E*LOG V) -> O(V)--------
    public int minScore(int n, int[][] roads) {
        int[] parent=new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
        int[] rank=new int[n];
        for(int i=0; i<n; i++) {
            rank[i]=Integer.MAX_VALUE;
        }
        for(int[] r: roads) {
            union(r[0]-1, r[1]-1, parent, rank, r[2]);
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(rank));
        return rank[parent(0, parent)];
    }
    
    private int parent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=parent(parent[i], parent);
        return parent[i];
    }
    
    private void union(int i, int j, int[] parent, int[] rank, int w) {
        int parentI=parent(i, parent);
        int parentJ=parent(j, parent);
        if(rank[parentI]<=rank[parentJ]) {
            parent[parentJ]=parentI;
            rank[parentI]=Math.min(rank[parentI], w);
        } else {
            parent[parentI]=parentJ;
            rank[parentJ]=Math.min(rank[parentJ], w);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
