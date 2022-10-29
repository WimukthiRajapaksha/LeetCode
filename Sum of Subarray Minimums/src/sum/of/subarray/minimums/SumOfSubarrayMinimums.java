/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.subarray.minimums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfSubarrayMinimums {

    /**
     * @param args the command line arguments
     */
    
//    no optimal solution yet
    
    public int sumSubarrayMins(int[] arr) {
        int[] dp=new int[arr.length];
        long s=0;
        for(int i=0; i<arr.length; i++) {
            dp[i]=arr[i];
            s+=dp[i];
            for(int j=i+1; j<arr.length; j++) {
                dp[i]=Math.min(arr[j], dp[i]);
                s+=dp[i];
            }
        }
        return (int)(s%1000000007);
    }
    
//    public int sumSubarrayMins(int[] arr) {
//        int t=0;
//        for(int i=0; i<arr.length; i++) {
//            for(int j=i; j<arr.length; j++) {
//                arr[i]=Math.min(arr[i], arr[j]);
//                t=(t+arr[i])%1000000007;
//            }
//        }
//        return t;
//    }
    
    
//    public int sumSubarrayMins(int[] arr) {
//        List<Integer> list=new ArrayList<>();
//        for(int i=0; i<arr.length; i++) {
//            int t=arr[i];
//            for(int j=i; j<arr.length; j++) {
//                t=Math.min(t, arr[j]);
//                list.add(t);
//            }
//        }
//        int v=0;
//        for(int i: list) {
//            v=(v+i)%1000000007;
//        }
//        return v;
//    }
    
    public static void main(String[] args) {
        SumOfSubarrayMinimums s=new SumOfSubarrayMinimums();
        System.out.println(s.sumSubarrayMins(new int[]{3,1,2,4}));
        System.out.println(s.sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}
