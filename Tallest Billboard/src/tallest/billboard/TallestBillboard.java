/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallest.billboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class TallestBillboard {

    /**
     * @param args the command line arguments
     */
        
//    ----------- BEAUTIFUL -> O(3^(N/2)), O(3^(N/2))-------------
//    public int tallestBillboard(int[] rods) {
//        Map<Integer, Integer> first=help(rods, 0, rods.length/2);
//        Map<Integer, Integer> second=help(rods, rods.length/2, rods.length);
//        int answer=0;
//        for(int i: first.keySet()) {
//            if(second.containsKey(-i)) {
//                answer=Math.max(answer, first.get(i)+second.get(-i));
//            }
//        }
//        return answer;
//    }
//    
//    private Map<Integer, Integer> help(int[] rods, int left, int right) {
//        Set<Pair<Integer,Integer>> set=new HashSet<>();
//        set.add(new Pair(0, 0));
//        for(int i=left; i<right; i++) {
//            int r=rods[i];
//            Set<Pair<Integer, Integer>> newSet=new HashSet<>();
//            for(Pair<Integer, Integer> p: set) {
//                newSet.add(new Pair(p.getKey()+r, p.getValue()));
//                newSet.add(new Pair(p.getKey(), p.getValue()+r));
//            }
//            set.addAll(newSet);
//        }
//        Map<Integer, Integer> dp=new HashMap<>();
//        for(Pair<Integer, Integer> p: set) {
//            int le=p.getKey();
//            int ri=p.getValue();
//            dp.put(le-ri, Math.max(dp.getOrDefault(le-ri, 0), le));
//        }
//        return dp;
//    }
    
    
    
//    ------------OPTIMAL -> O(M*N), O(M*N)------------
//    public int tallestBillboard(int[] rods) {
//        Map<Integer, Integer> dp=new HashMap<>();
//        dp.put(0, 0);
//        for(int r: rods) {
//            Map<Integer, Integer> newDp=new HashMap<>(dp);
//            for(int i: dp.keySet()) {
//                int diff=i;
//                int taller=dp.get(i);
//                int shorter=taller-diff;
//                
//                int newTaller=newDp.getOrDefault(diff+r, 0);
//                newDp.put(diff+r, Math.max(newTaller, taller+r));
//                
//                int newDiff=Math.abs(diff-r);
//                int newTallerS=Math.max(shorter+r, taller);
//                newDp.put(newDiff, Math.max(newTallerS, newDp.getOrDefault(newDiff, 0)));
//            }
//            dp=newDp;
//        }
//        return dp.get(0);
//    }
    
    
//    ------------CHECK LATER -> O(M*N), O(M*N)------------
    public int tallestBillboard(int[] rods) {
        int sum=0;
        for(int i: rods) {
            sum+=i;
        }
        int[][] dp=new int[rods.length+1][sum+1];
        for(int i=1; i<=rods.length; i++) {
            for(int j=0; j<=sum; j++) {
                if(dp[i-1][j]<j) {
                    continue;
                }
                dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
                int k=j+rods[i-1];
                dp[i][k]=Math.max(dp[i][k], dp[i-1][j]+rods[i-1]);
                k=Math.abs(j-rods[i-1]);
                dp[i][k]=Math.max(dp[i][k], dp[i-1][j]+rods[i-1]);
            }
        }
        return dp[dp.length-1][0]/2;
    }
    
    public static void main(String[] args) {
        TallestBillboard t=new TallestBillboard();
        System.out.println(t.tallestBillboard(new int[]{1,2,3,6}));
        System.out.println(t.tallestBillboard(new int[]{1,2,3,4,5,6}));
        System.out.println(t.tallestBillboard(new int[]{1,2}));
    }
}
