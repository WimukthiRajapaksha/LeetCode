/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best.time.to.buy.and.sell.stock.with.cooldown;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * @param args the command line arguments
     */
        
//    public int maxProfit(int[] prices) {
//        if(prices.length==1) return 0;
//        int f=0;
//        int s=0;
//        for(int i=1; i<prices.length; i++) {
//            if(prices[i-1]<prices[i]) {
//                f=s;
//                s+=prices[i]-prices[i-1];
//            } else {
//                int t=s;
//                s=f;
//                f=t;
//            }
//        }
//        return Math.max(f, s);
//    }
    
    
//    ---------OPTIMAL -> O(N), O(N)---------------
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        int[] s0=new int[prices.length];
        int[] s1=new int[prices.length];
        int[] s2=new int[prices.length];
        s0[0]=0;
        s1[0]=-prices[0];
        s2[0]=Integer.MIN_VALUE;
        for(int i=1; i<prices.length; i++) {
            s0[i]=Math.max(s0[i-1], s2[i-1]);
            s1[i]=Math.max(s1[i-1], s0[i-1]-prices[i]);
            s2[i]=s1[i-1]+prices[i];
        }
        return Math.max(s0[s0.length-1], s2[s2.length-1]);
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b=new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(b.maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(b.maxProfit(new int[]{1}));
        System.out.println(b.maxProfit(new int[]{4,3,2,1}));
        System.out.println(b.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(b.maxProfit(new int[]{1,2,3,4,0,1,0,8}));
    }
}
