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
    
    
    
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        int[] dp=new int[prices.length];
        for(int i=1; i<prices.length; i++) {
            if(prices[i-1]<prices[i]) {
                dp[i]=dp[i-1]+prices[i]-prices[i-1];
            } else {
                if(i>2) dp[i]=dp[i-2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[dp.length-1], dp[dp.length-2]);
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
