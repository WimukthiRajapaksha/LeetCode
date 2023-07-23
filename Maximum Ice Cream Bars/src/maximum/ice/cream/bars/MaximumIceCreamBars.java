/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.ice.cream.bars;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumIceCreamBars {

    /**
     * @param args the command line arguments
     */
    
    public int maxIceCream(int[] costs, int coins) {
        int max=0;
        for(int i: costs) {
            max=Math.max(max, i);
        }
        int[] arr=new int[max+1];
        for(int i: costs) {
            arr[i]++;
        }
        int count=0;
        for(int i=0; i<arr.length; i++) {
            if(i>coins) return count;
            if(arr[i]>0) {
                count+=Math.min(arr[i], coins/i);
                coins-=Math.min(coins, i*arr[i]);
            }
        }
        return count;
    }
    
    
//    public int maxIceCream(int[] costs, int coins) {
//        Arrays.sort(costs);
//        int count=0;
//        for(int i: costs) {
//            if(i>coins) {
//                return count;
//            }
//            coins-=i;
//            count++;
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        MaximumIceCreamBars m=new MaximumIceCreamBars();
        System.out.println(m.maxIceCream(new int[]{1,3,2,4,1}, 7));
        System.out.println(m.maxIceCream(new int[]{10,6,8,7,7,8}, 5));
        System.out.println(m.maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }
}
