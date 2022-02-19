/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.good.pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfGoodPairs {

    /**
     * @param args the command line arguments
     */
    
    public int numIdenticalPairs(int[] nums) {
        int[] freq=new int[10];
        for (int i: nums) {
            freq[i]++;
        }
        int sum=0;
        for (int i: freq) {
            sum+=i*(i-1)/2;
        }
        System.out.println(sum);
        return sum;
    }
    
//    public int numIdenticalPairs(int[] nums) {
//        int sum=0;
//        for (int i=0; i<nums.length-1; i++) {
//            for (int j=i+1; j<nums.length; j++) {
//                if (nums[i]==nums[j]) {
//                    sum++;
//                }
//            }
//        }
//        System.out.println(sum);
//        return sum;
//    }
    
    public static void main(String[] args) {
        NumberOfGoodPairs n=new NumberOfGoodPairs();
        n.numIdenticalPairs(new int[]{1,2,3,1,1,3});
    }
}
