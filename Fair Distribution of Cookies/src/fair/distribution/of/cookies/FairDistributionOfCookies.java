/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fair.distribution.of.cookies;

/**
 *
 * @author wimukthirajapaksha
 */
public class FairDistributionOfCookies {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------OPTIMAL -> BACKTRACKING -> O(K^N), O(K+N)------------
    public int distributeCookies(int[] cookies, int k) {
        return dp(cookies, 0, new int[k]);
    }
    
    private int dp(int[] cookies, int i, int[] arr) {
        if(i==cookies.length) {
            int temp=Integer.MIN_VALUE;
            for(int j: arr) {
                temp=Math.max(temp, j);
            }
            return temp;
        }
        int val=Integer.MAX_VALUE;
        for(int j=0; j<arr.length; j++) {
            arr[j]+=cookies[i];
            val=Math.min(val, dp(cookies, i+1, arr));
            arr[j]-=cookies[i];
        }
        return val;
    }
    
    
//    ------------OPTIMAL -> BACKTRACKING -> O(K^N), O(K+N)------------
//    int val=Integer.MAX_VALUE;
//    public int distributeCookies(int[] cookies, int k) {
//        dp(cookies, 0, new int[k]);
//        return val;
//    }
//    
//    private void dp(int[] cookies, int i, int[] arr) {
//        if(i==cookies.length) {
//            int temp=Integer.MIN_VALUE;
//            for(int j: arr) {
//                temp=Math.max(temp, j);
//            }
//            val=Math.min(temp, val);
//            return;
//        }
//        for(int j=0; j<arr.length; j++) {
//            arr[j]+=cookies[i];
//            dp(cookies, i+1, arr);
//            arr[j]-=cookies[i];
//        }
//    }
    
    public static void main(String[] args) {
        FairDistributionOfCookies f=new FairDistributionOfCookies();
        System.out.println(f.distributeCookies(new int[]{8,15,10,20,8}, 2));
        System.out.println(f.distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3));
    }
}
