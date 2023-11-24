/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loud.and.rich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LoudAndRich {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------OPTIMAL -> DFS -> O(V+E) = O(N^2) -> O(V+E) = O(N^2)--------------
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int i=0; i<quiet.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<richer.length; i++) {
            graph.get(richer[i][1]).add(richer[i][0]);
        }
        int[] minQuit=new int[quiet.length];
        Arrays.fill(minQuit, -1);
        for(int i=0; i<quiet.length; i++) {
            dfs(graph, i, minQuit, quiet);
        }
        return minQuit;
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int i, int[] minQuit, int[] quit) {
        if(minQuit[i]!=-1) return minQuit[i];
        int val=i;
        for(int j: graph.get(i)) {
            int temp=dfs(graph, j, minQuit, quit);
            if(quit[val]>quit[temp]) {
                val=temp;
            }
        }
        minQuit[i]=val;
        return val;
    }
    
    public static void main(String[] args) {
        LoudAndRich l=new LoudAndRich();
        System.out.println(Arrays.toString(l.loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0})));
    }
}
