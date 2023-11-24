/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.egg.drop;

/**
 *
 * @author wimukthirajapaksha
 */
public class SuperEggDrop {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------WRONG----------
//    public int superEggDrop(int k, int n) {
//        int[][] dp=new int[k+1][n+1];
//        for(int i=0; i<=k; i++) {
//            for(int j=0; j<=n; j++) {
//                dp[i][j]=-1;
//            }
//        }
//        return help(k, n, dp);
//    }
//    
//    private int help(int k, int n, int[][] dp) {
//        if(n==0 || n==1) return n;
//        if(k==1) return n;
//        if(dp[k][n]!=-1) return dp[k][n];
//        int val=Integer.MAX_VALUE;
//        int l=1;
//        int r=n;
//        int temp=0;
//        while(l<=r) {
//            int mid=l+(r-l)/2;
//            int right=help(k-1, mid-1, dp);
//            int left=help(k, n-mid, dp);
//            temp=1+Math.max(left, right);
//            if(left<right) {
//                l=mid+1;
//            } else {
//                r=mid-1;
//            }
//            val=Math.min(val, temp);
//        }
//        dp[k][n]=val;
//        return val;
//    }
    
    
//    -------------OPTIMAL -> O(KN*LOGN), O(KN)-------------
//    public int superEggDrop(int k, int n) {
//        int[][] dp=new int[k+1][n+1];
//        for(int i=0; i<=n; i++) {
//            dp[1][i]=i;
//        }
//        for(int i=1; i<=k; i++) {
//            dp[i][1]=1;
//        }
//        for(int i=2; i<k+1; i++) {
//            for(int j=2; j<n+1; j++) {
//                int l=1;
//                int r=j;
//                int temp=0;
//                int res=Integer.MAX_VALUE;
//                while(l<=r) {
//                    int mid=l+(r-l)/2;
//                    int left=dp[i-1][mid-1];
//                    int right=dp[i][j-mid];
//                    temp=1+Math.max(left, right);
//                    if(left<right) {
//                        l=mid+1;
//                    } else {
//                        r=mid-1;
//                    }
//                    res=Math.min(res, temp);
//                }
//                dp[i][j]=res;
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
    
    
//    ---------OPTIMAL -> O(NK), O(NK) -> DOESN'T UNDERSTAND---------
//    public int superEggDrop(int k, int n) {
//        int[][] dp=new int[n+1][k+1];
//        int m=0;
//        while(dp[m][k]<n) {
//            ++m;
//            for(int i=1; i<=k; i++) {
//                dp[m][i]=1+dp[m-1][i-1]+dp[m-1][i];
//            }
//        }
//        return m;
//    }
    
    
//    ---------OPTIMAL -> O(NK), O(k) -> DOESN'T UNDERSTAND---------
    public int superEggDrop(int k, int n) {
        int[] dp=new int[k+1];
        int m=0;
        for(m=0; dp[k]<n; m++) {
            for(int i=k; i>0; i--) {
                dp[i]+=dp[i-1]+1;
            }
        }
        return m;
    }
    
    public static void main(String[] args) {
        SuperEggDrop s=new SuperEggDrop();
        System.out.println(s.superEggDrop(10, 5));
    }
}
