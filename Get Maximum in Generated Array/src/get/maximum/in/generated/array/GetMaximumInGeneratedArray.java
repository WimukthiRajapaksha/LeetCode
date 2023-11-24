/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package get.maximum.in.generated.array;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class GetMaximumInGeneratedArray {

    /**
     * @param args the command line arguments
     */
    
    public int getMaximumGenerated(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] nums=new int[n+1];
        nums[1]=1;
        int max=0;
        for(int i=2; i<nums.length; i++) {
            nums[i]=nums[i/2]+(nums[(i/2)+1]*(i%2));
            max=Math.max(max, nums[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        GetMaximumInGeneratedArray g=new GetMaximumInGeneratedArray();
        System.out.println(g.getMaximumGenerated(100));
    }
}
