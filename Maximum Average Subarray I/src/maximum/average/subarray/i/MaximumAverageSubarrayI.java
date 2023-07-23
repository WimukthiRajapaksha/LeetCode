/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.average.subarray.i;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumAverageSubarrayI {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(N), O(1)--------------
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0; i<k; i++) {
            sum+=nums[i];
        }
        double maxSum=sum;
        for(int i=k; i<nums.length; i++) {
            sum+=nums[i]-nums[i-k];
            if(maxSum<sum) {
                maxSum=sum;
            }
        }
        return maxSum/k;
    }
    
    public static void main(String[] args) {
        MaximumAverageSubarrayI m=new MaximumAverageSubarrayI();
        System.out.println(m.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(m.findMaxAverage(new int[]{5}, 1));
    }
}
