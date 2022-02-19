/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.number.of.pairs.with.absolute.difference.k;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {

    /**
     * @param args the command line arguments
     */
    
    public int countKDifference(int[] nums, int k) {
        int[] arr=new int[101];
        for (int i=0; i<nums.length; i++) {
            arr[nums[i]]++;
        }
        int count=0;
        for (int i=0; i<arr.length-k; i++) {
            count+=(arr[i]*arr[i+k]);
        }
        for (int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println("\n"+count);
        return 0;
    }
    
    public static void main(String[] args) {
        CountNumberOfPairsWithAbsoluteDifferenceK c=new CountNumberOfPairsWithAbsoluteDifferenceK();
        c.countKDifference(new int[]{3,2,1,5,4}, 2);
    }
}
