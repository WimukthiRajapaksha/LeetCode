/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best.time.to.buy.and.sell.stock.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * @param args the command line arguments
     */
    
//    public int maxProfit(int[] prices) {
//        int profit=0;
//        int i=1;
//        while(i<prices.length) {
//            if(prices[i-1]<prices[i]) {
//                profit+=prices[i]-prices[i-1];
//            }
//            i++;
//        }
//        System.out.println(profit);
//        return profit;
//    }
    
    public int maxProfit(int[] prices) {
        int profit=0;
        int i=1;
        while(i<prices.length) {
            if(prices[i-1]<=prices[i]) {
                while(i<prices.length && prices[i-1]<prices[i]) {
                    profit+=prices[i]-prices[i-1];
                    i++;
                }
            } else {
                while(i<prices.length && prices[i-1]>=prices[i]) i++;
            }
        }
        System.out.println(profit);
        return profit;
    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b=new BestTimeToBuyAndSellStockII();
        b.maxProfit(new int[]{7,1,5,3,6,4});
        b.maxProfit(new int[]{1,2,3,4,5});
        b.maxProfit(new int[]{7,6,4,3,1});
    }
}
