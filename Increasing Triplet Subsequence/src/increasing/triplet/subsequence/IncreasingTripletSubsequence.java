/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package increasing.triplet.subsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class IncreasingTripletSubsequence {

    /**
     * @param args the command line arguments
     */
    
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i: nums) {
            if(i<=first) {
                first=i;
            } else if(i<=second) {
                second=i;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        IncreasingTripletSubsequence i=new IncreasingTripletSubsequence();
        System.out.println(i.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(i.increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(i.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println(i.increasingTriplet(new int[]{0,4,1,-1,2}));
        System.out.println(i.increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
