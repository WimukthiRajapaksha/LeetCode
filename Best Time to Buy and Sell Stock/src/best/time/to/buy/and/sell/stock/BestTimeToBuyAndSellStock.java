/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package best.time.to.buy.and.sell.stock;

/**
 *
 * @author wimukthirajapaksha
 */
public class BestTimeToBuyAndSellStock {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------KADANE'S ALGORITHM--------------------
    public int maxProfit(int[] prices) {
        int maxDiff=0;
        int curr=0;
        for (int i=1; i<prices.length; i++) {
            curr=Math.max(0, curr+=prices[i]-prices[i-1]);
            maxDiff = Math.max(maxDiff, curr);
        }
        System.out.println(maxDiff);
        return maxDiff;
    }
    
//    -------------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public int maxProfit(int[] prices) {
//        int min=prices[0];
//        int ret=0;
//        for (int i: prices) {
//            if (min>i) {
//                min=i;
//            } else if (ret<i-min) {
//                ret=i-min;
//            }
//        }
//        System.out.println(ret);
//        return ret;
//    }
    
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        b.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
