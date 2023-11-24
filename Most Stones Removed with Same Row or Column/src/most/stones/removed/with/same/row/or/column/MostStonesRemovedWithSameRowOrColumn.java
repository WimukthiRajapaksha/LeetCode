/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package most.stones.removed.with.same.row.or.column;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class MostStonesRemovedWithSameRowOrColumn {

    /**
     * @param args the command line arguments
     */
    
//    ------------------OPTIMAL -> UNION FIND -> O(N) -> O(N)--------------
    public int removeStones(int[][] stones) {
        int x=0;
        int y=0;
        for(int[] s: stones) {
            x=Math.max(x, s[0]);
            y=Math.max(y, s[1]);
        }
        int[] parent=new int[x+y+2];
        boolean[] hasAny=new boolean[x+y+2];
        for(int i=0; i<parent.length; i++) {
            parent[i]=i;
        }
        for(int i=0; i<stones.length; i++) {
            hasAny[stones[i][0]]=true;
            hasAny[stones[i][1]+x+1]=true;
            union(stones[i][0], stones[i][1]+x+1, parent);
        }
        int count=0;
        for(int i=0; i<parent.length; i++) {
            if(parent[i]==i && hasAny[i]) count++;
        }
        return stones.length-count;
    }
    
    public void union(int i, int j, int[] parent) {
        int parentI=findParent(i, parent);
        int parentJ=findParent(j, parent);
        if(parentI==parentJ) return;
        parent[parentJ]=parentI;
    }
    
    public int findParent(int i, int[] parent) {
        if(i==parent[i]) return i;
        parent[i]=findParent(parent[i], parent);
        return parent[i];
    }
    
    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m=new MostStonesRemovedWithSameRowOrColumn();
        System.out.println(m.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0}}));
    }
}
