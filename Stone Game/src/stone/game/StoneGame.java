/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stone.game;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class StoneGame {

    /**
     * @param args the command line arguments
     */
    
//    ---------OPTIMAL -> O(1) -> O(1)--------------
//    public boolean stoneGame(int[] piles) {
//        return true;
//    }
    
    
//    --------------OPTIMAL -> DP -> O(N^2) -> O(N^2)---------------
//    public boolean stoneGame(int[] piles) {
//        return find(piles, 0, piles.length-1, new HashMap<>(), true)>0;
//    }
//    
//    private int find(int[] piles, int l, int r, Map<String, Integer> mem, boolean isAlice) {
//        if(l>r) return 0;
//        StringBuffer sb=new StringBuffer();
//        sb.append(l).append('~').append(r).append('~').append(isAlice);
//        if(mem.containsKey(sb.toString())) return mem.get(sb.toString());
//        if(isAlice) {
//            int val1=find(piles, l+1, r, mem, !isAlice)+piles[l];
//            int val2=find(piles, l, r-1, mem, !isAlice)+piles[r];
//            int max=Math.max(val1, val2);
//            mem.put(sb.toString(), max);
//            return max;
//        } else {
//            int val1=find(piles, l+1, r, mem, !isAlice)-piles[l];
//            int val2=find(piles, l, r-1, mem, !isAlice)-piles[r];
//            int min=Math.min(val1, val2);
//            mem.put(sb.toString(), min);
//            return min;
//        }
//    }
    
    
//    --------------OPTIMAL -> DP -> O(N^2) -> O(N^2)---------------
    public boolean stoneGame(int[] piles) {
        return find(piles, 0, piles.length-1, new int[piles.length][piles.length][2], true)>0;
    }
    
    private int find(int[] piles, int l, int r, int[][][] mem, boolean isAlice) {
        if(l>r) return 0;
        if(mem[l][r][isAlice ? 0 : 1]!=0) return mem[l][r][isAlice ? 0 : 1];
        if(isAlice) {
            int val1=find(piles, l+1, r, mem, !isAlice)+piles[l];
            int val2=find(piles, l, r-1, mem, !isAlice)+piles[r];
            int max=Math.max(val1, val2);
            mem[l][r][0]=max;
            return max;
        } else {
            int val1=find(piles, l+1, r, mem, !isAlice)-piles[l];
            int val2=find(piles, l, r-1, mem, !isAlice)-piles[r];
            int min=Math.min(val1, val2);
            mem[l][r][1]=min;
            return min;
        }
    }
    
    public static void main(String[] args) {
        StoneGame s=new StoneGame();
        System.out.println(s.stoneGame(new int[]{5,3,4,5}));
        System.out.println(s.stoneGame(new int[]{3,7,2,3}));
        System.out.println(s.stoneGame(new int[]{3,2,10,4}));
        System.out.println(s.stoneGame(new int[]{1,4,10,8,3,2,4,1}));
    }
}
