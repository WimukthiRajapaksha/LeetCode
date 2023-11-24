/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partition.array.pkgfor.maximum.sum;

/**
 *
 * @author wimukthirajapaksha
 */
public class PartitionArrayForMaximumSum {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------OPTIMAL -> O(NK), O(N)---------------
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        return help(arr, k, 0, dp);
    }
    
    private int help(int[] arr, int k, int index, int[] dp) {
        if(index>=arr.length) return 0;
        if(dp[index]!=0) return dp[index];
        int sum=0;
        int max=0;
        for(int i=index; i<Math.min(arr.length, index+k); i++) {
            max=Math.max(max, arr[i]);
            sum=Math.max(sum, (max*(i-index+1))+help(arr, k, i+1, dp));
        }
        dp[index]=sum;
        return sum;
    }

    public static void main(String[] args) {
        PartitionArrayForMaximumSum p=new PartitionArrayForMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
}
