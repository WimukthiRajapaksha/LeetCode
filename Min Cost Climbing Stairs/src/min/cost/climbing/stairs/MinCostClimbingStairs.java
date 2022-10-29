/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package min.cost.climbing.stairs;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinCostClimbingStairs {

    /**
     * @param args the command line arguments
     */
    
    public int minCostClimbingStairs(int[] cost) {
        int f=cost[0];
        int s=cost[1];
        for(int i=2; i<cost.length; i++) {
            int t=cost[i]+Math.min(f, s);
            f=s;
            s=t;
        }
        return Math.min(f,s);
    }
    
    
//    public int minCostClimbingStairs(int[] cost) {
//        for(int i=2; i<cost.length; i++) {
//            cost[i]+=Math.min(cost[i-1], cost[i-2]);
//        }
//        return Math.min(cost[cost.length-1], cost[cost.length-2]);
//    }
    
    public static void main(String[] args) {
        MinCostClimbingStairs m=new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(m.minCostClimbingStairs(new int[]{1,100}));
    }
}
