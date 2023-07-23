/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regular.expression.matching;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class RegularExpressionMatching {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------------OPTIMAL -> O(MN), O(N)--------------------------
    public boolean isMatch(String s, String p) {
        boolean[] dp=new boolean[p.length()+1];
        dp[0]=true;
        for(int j=1; j<dp.length; j++) {
            if(p.charAt(j-1)=='*') {
                dp[j]=dp[j-2];
            } else {
                dp[j]=false;
            }
        }
//        System.out.println(Arrays.toString(dp));
        for(int i=1; i<=s.length(); i++) {
            boolean prev=dp[0];
            dp[0]=false;
            for(int j=1; j<dp.length; j++) {
                boolean curr=dp[j];
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
                    dp[j]=prev;
                } else if(p.charAt(j-1)=='*') {
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') {
                        dp[j]=dp[j] || dp[j-1] || dp[j-2];
                    } else {
                        dp[j]=dp[j-2];
                    }
                } else {
                    dp[j]=false;
                }
                prev=curr;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length-1];
    }
    
    
//    -------------------------OPTIMAL -> O(MN), O(MN)--------------------------
//    public boolean isMatch(String s, String p) {
//        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
//        dp[0][0]=true;
//        for(int j=1; j<dp[0].length; j++) {
//            if(p.charAt(j-1)=='*') {
//                dp[0][j]=dp[0][j-2];
//            }
//        }
//        for(int i=1; i<dp.length; i++) {
//            for(int j=1; j<dp[i].length; j++) {
//                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
//                    dp[i][j]=dp[i-1][j-1];
//                } else if(p.charAt(j-1)=='*') {
//                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') {
//                        dp[i][j]=dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
//                    } else {
//                        dp[i][j]=dp[i][j-2];
//                    }
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    public static void main(String[] args) {
        RegularExpressionMatching r=new RegularExpressionMatching();
        System.out.println(r.isMatch("aa", "a"));
        System.out.println(r.isMatch("aa", "a*"));
        System.out.println(r.isMatch("ab", ".*"));
        
        System.out.println(r.isMatch("a", "."));
        System.out.println(r.isMatch("ab", ".."));
        System.out.println(r.isMatch("aaaabbbbb", "a*"));
        System.out.println(r.isMatch("aaaaaaaaaab", "a*b"));
        System.out.println(r.isMatch("mississippi", "mis*is*p*."));
    }
}
