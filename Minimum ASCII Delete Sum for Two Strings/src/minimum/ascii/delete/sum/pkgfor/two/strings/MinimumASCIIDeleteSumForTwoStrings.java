/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.ascii.delete.sum.pkgfor.two.strings;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumASCIIDeleteSumForTwoStrings {

    /**
     * @param args the command line arguments
     */
    
//    ------------OPTIMAL -> O(M*N) -> O(M*N)--------------
//    public int minimumDeleteSum(String s1, String s2) {
//        int[][] dp=new int[s2.length()+1][s1.length()+1];
//        for(int i=0; i<s1.length(); i++) {
//            dp[0][i+1]=dp[0][i]+s1.charAt(i);
//        }
//        for(int i=0; i<s2.length(); i++) {
//            dp[i+1][0]=dp[i][0]+s2.charAt(i);
//        }
//        for(int i=0; i<s2.length(); i++) {
//            for(int j=0; j<s1.length(); j++) {
//                if(s2.charAt(i)==s1.charAt(j)) {
//                    dp[i+1][j+1]=dp[i][j];
//                } else {
//                    dp[i+1][j+1]=Math.min(dp[i+1][j]+s1.charAt(j), dp[i][j+1]+s2.charAt(i));
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
//    ------------OPTIMAL -> O(M*N) -> O(M)--------------
    public int minimumDeleteSum(String s1, String s2) {
        int[] dp=new int[s1.length()+1];
        for(int i=0; i<s1.length(); i++) {
            dp[i+1]=dp[i]+s1.charAt(i);
        }
        for(int i=0; i<s2.length(); i++) {
            int prev=dp[0];
            dp[0]=dp[0]+s2.charAt(i);
            for(int j=0; j<s1.length(); j++) {
                int temp=dp[j+1];
                if(s2.charAt(i)!=s1.charAt(j)) {
                    dp[j+1]=Math.min(dp[j]+s1.charAt(j), dp[j+1]+s2.charAt(i));
                } else {
                    dp[j+1]=prev;
                }
                prev=temp;
            }
        }
        return dp[dp.length-1];
    }
    
    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings m=new MinimumASCIIDeleteSumForTwoStrings();
        System.out.println(m.minimumDeleteSum("sea", "eat"));
        System.out.println(m.minimumDeleteSum("delete", "leet"));
    }
}
