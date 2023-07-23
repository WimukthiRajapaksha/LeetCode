/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best.time.to.buy.and.sell.stock.with.transaction.fee;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------OPTIMAL -> O(N), O(N)----------------
//    public int maxProfit(int[] prices, int fee) {
//        if(prices.length==1) return 0;
//        int[] free=new int[prices.length];
//        int[] hold=new int[prices.length];
//        hold[0]=-prices[0];
//        for(int i=1; i<prices.length; i++) {
//            free[i]=Math.max(free[i-1], hold[i-1]+prices[i]-fee);
//            hold[i]=Math.max(hold[i-1], free[i-1]-prices[i]);
//        }
//        System.out.println(Arrays.toString(hold));
//        System.out.println(Arrays.toString(free));
//        return free[free.length-1];
//    }
    
    
    
//    ---------OPTIMAL -> O(N), O(1)--------------
    public int maxProfit(int[] prices, int fee) {
        if(prices.length==1) return 0;
        int hold=-prices[0];
        int free=0;
        for(int i=0; i<prices.length; i++) {
            int temp=hold;
            hold=Math.max(hold, free-prices[i]);
            free=Math.max(free, temp+prices[i]-fee);
        }
        return free;
    }
    
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee b=new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(b.maxProfit(new int[]{1,3,2,8,4,9}, 2));
        System.out.println(b.maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }
}
