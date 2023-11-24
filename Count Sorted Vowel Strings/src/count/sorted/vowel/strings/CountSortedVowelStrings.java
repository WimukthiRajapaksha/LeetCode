/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.sorted.vowel.strings;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountSortedVowelStrings {

    /**
     * @param args the command line arguments
     */
    
    
//    --------OPTIMAL -> TOP-DOWN -> O(NK), O(NK)----------
//    public int countVowelStrings(int n) {
//        return count(n, 0, new int[n+1][5]);
//    }
//    
//    char[] arr=new char[]{'a','e','i','o','u'};
//    private int count(int n, int pre, int[][] mem) {
//        if(mem[n][pre]!=0) return mem[n][pre];
//        if(n==0) return 1;
//        int count=0;
//        for(int i=pre; i<arr.length; i++) {
//            count+=count(n-1, i, mem);
//        }
//        mem[n][pre]=count;
//        return count;
//    }
    
    
//    --------OPTIMAL -> BOTTOM-UP -> O(NK), O(NK)----------
//    public int countVowelStrings(int n) {
//        int[][] dp=new int[n+1][6];
//        for(int i=1; i<dp.length; i++) {
//            for(int j=1; j<6; j++) {
//                dp[i][j]=dp[i][j-1]+(i>1 ? dp[i-1][j] : 1);
//            }
//        }
//        return dp[dp.length-1][5];
//    }
    
    
//    --------OPTIMAL -> BOTTOM-UP -> O(NK), O(K)----------
    public int countVowelStrings(int n) {
        int[] dp=new int[]{0,1,1,1,1,1};
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<6; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[5];
    }
    
    public static void main(String[] args) {
        CountSortedVowelStrings c=new CountSortedVowelStrings();
        System.out.println(c.countVowelStrings(1));
        System.out.println(c.countVowelStrings(2));
        System.out.println(c.countVowelStrings(33));
    }
}
