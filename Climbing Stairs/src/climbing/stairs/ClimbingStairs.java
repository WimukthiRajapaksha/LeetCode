/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climbing.stairs;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class ClimbingStairs {

    /**
     * @param args the command line arguments
     */
    
    
    
    public int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        int[] list = new int[n+1];
        list[1]=1;
        list[2]=2;
        for (int i=3; i<=n; i++) {
            list[i]=list[i-1]+list[i-2];
        }
        System.out.println(list[n]);
        return list[n];
        
//        -----------------------------ALTERNATE-----------------------
//        int first = 1;
//        int second = 1;
//        for (int i=2; i<=n; i++) {
//            int temp = second;
//            second = first+second;
//            first = temp;
//        }
//        System.out.println(second);
//        return second;
    }
    
//    -----------------------------------ALTERNATE -> NOT OPTIMAL----------------------------------
//    public int cal(int n, int i, int j) {
//        BigInteger temp = new BigInteger("1");
//        for(int k=Math.max(i, j)+1; k<=n; k++) {
//            temp = temp.multiply(new BigInteger(String.valueOf(k)));
//        }
//        for (int k=2; k<=Math.min(i, j); k++) {
//            temp = temp.divide(new BigInteger(String.valueOf(k)));
//        }
//        // System.out.println("temp "+temp.intValue()+" "+n+" "+i+" "+j);
//        return temp.intValue();
//    }
//    
//    public int climbStairs(int n) {
//        int twos=0;
//        int sum=0;
//        while(n-twos>=0) {
//            sum+=cal(n, Math.max(1, n-twos), Math.max(1, twos));
//            twos++;
//            n--;
//            System.out.println(sum);
//        }
//        System.out.println(sum);
//        return sum;
//    }
    
    public static void main(String[] args) {
        ClimbingStairs cli = new ClimbingStairs();
//        cli.climbStairs(3);
//        cli.climbStairs(7);
//        cli.climbStairs(2);
//        cli.climbStairs(35);
//        cli.climbStairs(44);
        cli.climbStairs(6);
    }
}
