/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.numbers.with.unique.digits;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountNumbersWithUniqueDigits {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> O(N), O(1)-----------------
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int res=10;
        int unique=9;
        int available=9;
        while(--n>0 && available>0) {
            unique=unique*available;
            res+=unique;
            available--;
        }
        return res;
    }
    

//    ----------------OPTIMAL -> O(N), O(1)-----------------
//    public int countNumbersWithUniqueDigits(int n) {
//        if(n==0) return 1;
//        int[] dp=new int[11];
//        for(int i=0; i<dp.length; i++) {
//            dp[i]=i;
//        }
//        int zero=9;
//        int count=10;
//        for(int i=1; i<n; i++) {
//            int prev=dp[0];
//            for(int j=i; j<dp.length; j++) {
//                int curr=dp[j];
//                dp[j]=prev*j;
//                prev=curr;
//            }
//            count+=dp[dp.length-1]-zero;            
//            zero=zero*(9-i);
//        }
//        return count;
//    }
    
    
    
//    ----------------OPTIMAL -> O(N), O(N)-----------------
//    public int countNumbersWithUniqueDigits(int n) {
//        if(n==0) return 0;
//        int[][] dp=new int[n+1][11];
//        for(int i=0; i<dp[0].length; i++) {
//            dp[0][i]=i;
//            dp[1][i]=i;
//        }
//        int zero=9;
//        int count=10;
//        for(int i=2; i<dp.length; i++) {
//            for(int j=i; j<dp[0].length; j++) {
//                dp[i][j]=dp[i-1][j-1]*j;
//            }
//            count+=dp[i][dp[0].length-1]-zero;
//            zero=zero*(10-i);
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits c=new CountNumbersWithUniqueDigits();
        System.out.println(c.countNumbersWithUniqueDigits(0));
        System.out.println(c.countNumbersWithUniqueDigits(1));
        System.out.println(c.countNumbersWithUniqueDigits(2));
        System.out.println(c.countNumbersWithUniqueDigits(3));
        System.out.println(c.countNumbersWithUniqueDigits(4));
        System.out.println(c.countNumbersWithUniqueDigits(5));
        System.out.println(c.countNumbersWithUniqueDigits(6));
        System.out.println(c.countNumbersWithUniqueDigits(7));
        System.out.println(c.countNumbersWithUniqueDigits(8));
        System.out.println(c.countNumbersWithUniqueDigits(9));
        System.out.println(c.countNumbersWithUniqueDigits(10));
    }
}
