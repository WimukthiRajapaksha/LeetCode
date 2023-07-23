/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.amount.of.time.to.fill.cups;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumAmountOfTimeToFillCups {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N), O(1)-------------
//    public int fillCups(int[] amount) {
//        Arrays.sort(amount);
//        if(amount[0]+amount[1]>amount[2]) {
//            return amount[2]+(amount[0]+amount[1]-amount[2]+1)/2;
//        }
//        return amount[2];
//    }
    
    
    
//    --------------OPTIMAL -> O(N), O(1)-------------
    public int fillCups(int[] amount) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i: amount) {
            sum+=i;
            if(i>max) max=i;
        }
        return Math.max((sum+1)/2,max);
    }
    
    public static void main(String[] args) {
        MinimumAmountOfTimeToFillCups m=new MinimumAmountOfTimeToFillCups();
        System.out.println(m.fillCups(new int[]{1,4,2}));
        System.out.println(m.fillCups(new int[]{5,4,4}));
    }
}