/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildcard.matching;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class WildcardMatching {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> O(M*N), O(M*N)--------------
    public boolean isMatch(String s, String p) {
        int sIndex=0;
        int pIndex=0;
        int matchingIndex=0;
        int starIndex=-1;
        while(sIndex<s.length()) {
            if(pIndex<p.length() && (p.charAt(pIndex)=='?' || s.charAt(sIndex)==p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            } else if(pIndex<p.length() && p.charAt(pIndex)=='*') {
                starIndex=pIndex;
                matchingIndex=sIndex;
                pIndex++;
            } else if(starIndex!=-1) {
                pIndex=starIndex+1;
                matchingIndex++;
                sIndex=matchingIndex;
            } else {
                return false;
            }
        }
        while(pIndex<p.length() && p.charAt(pIndex)=='*') {
            pIndex++;
        }
        return pIndex==p.length();
    }
    
    
//    ---------------OPTIMAL -> O(M*N), O(M*N)--------------
//    public boolean isMatch(String s, String p) {
//        boolean[] dp=new boolean[p.length()+1];
//        dp[0]=true;
//        for(int i=1; i<dp.length; i++) {
//            if(p.charAt(i-1)=='*') {
//                dp[i]=dp[Math.max(i-1,0)];
//            }
//        }
//        for(int i=1; i<=s.length(); i++) {
//            boolean pre=dp[0];
//            dp[0]=false;
//            for(int j=1; j<dp.length; j++) {
//                boolean curr=dp[j];
//                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?') {
//                    dp[j]=pre;
//                } else if(p.charAt(j-1)=='*') {
//                    dp[j]|=dp[j-1];
//                } else {
//                    dp[j]=false;
//                }
//                pre=curr;
//            }
//        }
//        return dp[dp.length-1];
//    }
    
    
//    ---------------OPTIMAL -> O(M*N), O(M*N)--------------
//    public boolean isMatch(String s, String p) {
//        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
//        dp[0][0]=true;
//        for(int i=1; i<dp[0].length; i++) {
//            if(p.charAt(i-1)=='*') {
//                dp[0][i]=dp[0][Math.max(i-1,0)];
//            }
//        }
//        for(int i=1; i<dp.length; i++) {
//            for(int j=1; j<dp[i].length; j++) {
//                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?') {
//                    dp[i][j]=dp[i-1][j-1];
//                } else if(p.charAt(j-1)=='*') {
//                    dp[i][j]=dp[i][j-1] | dp[i-1][j];
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    public static void main(String[] args) {
        WildcardMatching w=new WildcardMatching();
        System.out.println(w.isMatch("aa", "a"));
        System.out.println(w.isMatch("aa", "*"));
        System.out.println(w.isMatch("cb", "?a"));
        System.out.println(w.isMatch("mississippi", "mis*is*p*?"));
    }
}
