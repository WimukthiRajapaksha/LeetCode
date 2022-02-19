/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.product.difference.between.two.pairs;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    /**
     * @param args the command line arguments
     */
    
    public int maxProductDifference(int[] nums) {
        int a=nums[0];
        int b=nums[0];
        int c=nums[0];
        int d=nums[0];
        for(int i: nums) {
            if (c<i || d<i) {
                c=Math.max(c, d);
                d=i;
            }
            if (b>i || a>i) {
                b=Math.min(b, a);
                a=i;
            }
        }
        return (c*d)-(a*b);
    }
    
    public static void main(String[] args) {
        MaximumProductDifferenceBetweenTwoPairs m=new MaximumProductDifferenceBetweenTwoPairs();
        System.out.println(m.maxProductDifference(new int[]{4,2,5,9,7,4,8}));
        System.out.println(m.maxProductDifference(new int[]{9,9,5,10}));
    }
}
