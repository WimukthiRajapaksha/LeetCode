/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reducing.dishes;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReducingDishes {

    /**
     * @param args the command line arguments
     */
    
    
//    --------OPTIMAL -> O(N*LOG N), O(1)---------------
//    public int maxSatisfaction(int[] satisfaction) {
//        Arrays.sort(satisfaction);
//        int sum=0;
//        int tempCount=0;
//        for(int i=satisfaction.length-1; i>=0; i--) {
//            if(sum<sum+tempCount+satisfaction[i]) {
//                sum+=tempCount+satisfaction[i];
//                tempCount+=satisfaction[i];
//            } else {
//                return sum;
//            }
//        }
//        return sum;
//    }
    
    
//    --------OPTIMAL -> O(N*LOG N), O(1)---------------
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum=0;
        int tempCount=0;
        for(int i=satisfaction.length-1; i>=0 && tempCount>=-satisfaction[i]; i--) {
            tempCount+=satisfaction[i];
            sum+=tempCount;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        ReducingDishes r=new ReducingDishes();
        System.out.println(r.maxSatisfaction(new int[]{-1,-8,0,5,-9}));
        System.out.println(r.maxSatisfaction(new int[]{4,3,2}));
        System.out.println(r.maxSatisfaction(new int[]{-1,-4,-5}));
    }
}
