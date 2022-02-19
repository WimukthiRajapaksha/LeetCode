/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package range.sum.query.immutable;

/**
 *
 * @author wimukthirajapaksha
 */

class NumArray {
    int[] a;
    public NumArray(int[] nums) {
        a=nums;
        for(int i=1; i<nums.length; i++) {
            a[i]+=a[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return (left>0) ? a[right]-a[left-1] : a[right];
    }
}

public class RangeSumQueryImmutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
