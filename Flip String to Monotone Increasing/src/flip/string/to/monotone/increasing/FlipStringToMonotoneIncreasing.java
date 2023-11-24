/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flip.string.to.monotone.increasing;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class FlipStringToMonotoneIncreasing {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------ALTERNATE -> O(2^N), O(N)--------------
//    public int minFlipsMonoIncr(String s) {
//        int[][] dp=new int[s.length()][2];
//        return Math.min(dfs(s, 0, false, dp), dfs(s, 0, true, dp));
//    }
//    
//    private int dfs(String s, int i, boolean currZero, int[][] dp) {
//        if(i==s.length()) return 0;
//        if(dp[i][currZero ? 0 : 1]!=0) return dp[i][currZero ? 0 : 1];
//        int curr=0;
//        if(currZero) {
//            if(s.charAt(i)!='0') {
//                curr++;                
//            }
//        } else {
//            if(s.charAt(i)=='0') {
//                curr++;
//            }
//        }
//        int one=dfs(s, i+1, false, dp)+curr;
//        dp[i][1]=one;
//        if(currZero) {
//            int zero=dfs(s, i+1, true, dp)+curr;
//            dp[i][0]=zero;
//            return Math.min(one, zero);
//        }
//        return one;
//    }
    
    
    
//    -----OPTIMAL -> O(N), O(1)-----------
    public int minFlipsMonoIncr(String s) {
        int result=0;
        int onesCount=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1') {
                onesCount++;
            } else {
                result=Math.min(result+1, onesCount);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing f=new FlipStringToMonotoneIncreasing();
        System.out.println(f.minFlipsMonoIncr("00110"));
        System.out.println(f.minFlipsMonoIncr("010110"));
        System.out.println(f.minFlipsMonoIncr("00011000"));
    }
}
