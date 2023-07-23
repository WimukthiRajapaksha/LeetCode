/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.all.possible.routes;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountAllPossibleRoutes {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------RECURSIVE -> OPTIMAL -> O(N^2* FUEL), O(N*FUEL)------------
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp=new int[locations.length][fuel+1];
        for(int[] i: dp) {
            for(int j=0; j<i.length; j++) {
                i[j]=-1;
            }
        }
        return dfs(locations, start, finish, fuel, dp);
    }
    
    private int dfs(int[] locations, int start, int finish, int fuel, int[][] dp) {
        if(fuel<0) return 0;
        if(dp[start][fuel]!=-1) return dp[start][fuel];
        int count= (start==finish) ? 1 : 0;
        for(int i=0; i<locations.length; i++) {
            if(i!=start) {
                count=(count+dfs(locations, i, finish, fuel-Math.abs(locations[start]-locations[i]), dp))%1000_000_007;
            }
        }
        dp[start][fuel]=count;
        return count;
    }
    
    
//    ---------------OPTIMAL -> ITERATIVE -> O(N^2*FUEL), O(N*FUEL)--------------
//    public int countRoutes(int[] locations, int start, int finish, int fuel) {
//        int[][] dp=new int[locations.length][fuel+1];
//        Arrays.fill(dp[finish], 1);
//        for(int i=0; i<=fuel; i++) {
//            for(int j=0; j<locations.length; j++) {
//                for(int k=0; k<locations.length; k++) {
//                    if(k==j) continue;
//                    if(Math.abs(locations[j]-locations[k])<=i) {
//                        dp[j][i]=(dp[j][i]+dp[k][i-Math.abs(locations[j]-locations[k])])%1000_000_007;
//                    }
//                }
//            }
//        }
//        return dp[start][fuel];
//    }
    
    public static void main(String[] args) {
        CountAllPossibleRoutes c=new CountAllPossibleRoutes();
        System.out.println(c.countRoutes(new int[]{2,3,6,8,4}, 1, 3, 5));
        System.out.println(c.countRoutes(new int[]{4,3,1}, 1, 0, 6));
        System.out.println(c.countRoutes(new int[]{5,2,1}, 0, 2, 3));
    }
}
