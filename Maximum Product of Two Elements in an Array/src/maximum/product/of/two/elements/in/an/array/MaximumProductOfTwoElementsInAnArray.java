/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.product.of.two.elements.in.an.array;

import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumProductOfTwoElementsInAnArray {

    /**
     * @param args the command line arguments
     */
    
    public int maxProduct(int[] nums) {
        int f=0;
        int s=0;
        for (int i: nums) {
            if(f<=i) {
                s=f;
                f=i;
            } else if (s<i) s=i;
        }
        System.out.println((f-1)*(s-1));
        return (f-1)*(s-1);
    }
    
    public static void main(String[] args) {
        MaximumProductOfTwoElementsInAnArray m=new MaximumProductOfTwoElementsInAnArray();
        m.maxProduct(new int[]{1,5,4,5});
    }
}
