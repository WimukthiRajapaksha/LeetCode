/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.champion.ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindChampionII {

    /**
     * @param args the command line arguments
     */
    
    public int findChampion(int n, int[][] edges) {
        int[] outdegree=new int[n];
        for(int[] e: edges) {
            outdegree[e[1]]++;
        }
        int val=-1;
        for(int i=0; i<n; i++) {
            if(outdegree[i]==0) {
                if(val>=0) return -1;
                val=i;
            }
        }
        return val;
    }
    
    public static void main(String[] args) {
        FindChampionII f=new FindChampionII();
        System.out.println(f.findChampion(3, new int[][]{{0,1},{1,2}}));
        System.out.println(f.findChampion(4, new int[][]{{0,2},{1,3},{1,2}}));
    }
}
