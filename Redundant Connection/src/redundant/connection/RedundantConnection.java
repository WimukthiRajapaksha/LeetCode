/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redundant.connection;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class RedundantConnection {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------OPTIMAL -> O(N), O(N)-------------
    int[] ret;
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length];
        for(int i=0; i<edges.length; i++) {
            parent[i]=i;
        }
        for(int[] e: edges) {
            union(e[0]-1, e[1]-1, parent);
        }
        return ret;
    }
    
    private void union(int i, int j, int[] parent) {
        int parentI=findParent(i, parent);
        int parentJ=findParent(j, parent);
        if(parentI==parentJ) ret=new int[]{i+1, j+1};
        parent[parentJ]=parentI;
    }
    
    private int findParent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=findParent(parent[i], parent);
        return parent[i];
    }
    
    public static void main(String[] args) {
        RedundantConnection r=new RedundantConnection();
        System.out.println(Arrays.toString(r.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}})));
        System.out.println(Arrays.toString(r.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }
}
