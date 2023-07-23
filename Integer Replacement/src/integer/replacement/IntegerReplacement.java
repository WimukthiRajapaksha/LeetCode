/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integer.replacement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class IntegerReplacement {

    /**
     * @param args the command line arguments
     */
    
//    ------------NOT OPTIMAL -> O(N), O(N)----------------
//    public int integerReplacement(int n) {
//        int[] dp=new int[n+1];
//        for(int i=2; i<dp.length; i++) {
//            if(i%2==0) {
//                dp[i]=dp[i/2]+1;
//            } else {
//                dp[i]=Math.min(dp[i-1], dp[(i+1)/2]+1)+1;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[dp.length-1];
//    }
    
    
//    ------------NOT OPTIMAL -> O(N), O(N)----------------
//    public int integerReplacement(int n) {
//        int[] dp=new int[n+1];
//        Arrays.fill(dp, -1);
//        dp[0]=0;
//        dp[1]=0;
////        System.out.println(Arrays.toString(dp));
//        return dfs(dp, n);
//    }
//    
//    private int dfs(int[] dp, int i) {
//        if(dp[i]!=-1) return dp[i];
//        if(i%2==0) {
//            dp[i]=dfs(dp, i/2)+1;
//        } else {
//            dp[i]=Math.min(dfs(dp, i-1), dfs(dp, (i+1)/2)+1)+1;
//        }
//        return dp[i];
//    }
    
    
//    ------------NOT OPTIMAL -> O(N), O(N)----------------
//    public int integerReplacement(int n) {
//        Queue<Long> q=new LinkedList<>();
//        Set<Long> seen=new HashSet<>();
//        q.offer((long)n);
//        int depth=0;
//        while(!q.isEmpty()) {
//            int s=q.size();
//            while(s>0) {
//                long temp=q.poll();
//                if(temp==1) return depth;
//                if(temp%2==0) {
//                    if(!seen.contains(temp/2)) q.offer(temp/2);
//                } else {
//                    if(!seen.contains(temp+1)) q.offer(temp+1);
//                    if(!seen.contains(temp-1)) q.offer(temp-1);
//                }
//                s--;
//            }
//            depth++;
//        }
//        return depth;
//    }
    
    
//    ------------OPTIMAL -> O(N), O(1)----------------
//    public int integerReplacement(int n) {
//        int depth=0;
//        while(n!=1) {
//            if((n&1)==0) {
//                n>>>=1;
//            } else if(n==3 || ((n>>>1)&1)==0) {
//                n--;
//            } else {
//                n++;
//            }
//            depth++;
//        }
//        return depth;
//    }
    
    
//    ------------OPTIMAL -> O(N), O(1)----------------
    public int integerReplacement(int n) {
        int depth=0;
        while(n!=1) {
            if((n&1)==0) {
                n>>>=1;
            } else if(n==3 || (n&3)==1) {
                n--;
            } else {
                n++;
            }
            depth++;
        }
        return depth;
    }
    
    public static void main(String[] args) {
        IntegerReplacement i=new IntegerReplacement();
        System.out.println(i.integerReplacement(8));
        System.out.println(i.integerReplacement(7));
        System.out.println(i.integerReplacement(4));
        System.out.println(i.integerReplacement(75437892));
        System.out.println(i.integerReplacement(100000000));
    }
}
