/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugly.number.ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class UglyNumberII {

    /**
     * @param args the command line arguments
     */
    
    public int nthUglyNumber(int n) {
        int[] nums=new int[n];
        nums[0]=1;
        int p2=0;
        int p3=0;
        int p5=0;
        for(int i=1; i<n; i++) {
            nums[i]=Math.min(Math.min(nums[p2]*2, nums[p3]*3), nums[p5]*5);
            if(nums[i]%2==0) p2++;
            if(nums[i]%3==0) p3++;
            if(nums[i]%5==0) p5++;
        }
        return nums[n-1];
    }
    
    public static void main(String[] args) {
        UglyNumberII u=new UglyNumberII();
        System.out.println(u.nthUglyNumber(10));
    }
}
