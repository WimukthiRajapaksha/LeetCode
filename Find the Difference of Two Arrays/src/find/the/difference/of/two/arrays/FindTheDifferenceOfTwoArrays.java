/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.difference.of.two.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheDifferenceOfTwoArrays {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL -> O(M+N), O(MAX(M, N))------------
//    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        return Arrays.asList(helper(nums2, nums1), helper(nums1, nums2));
//    }
//    
//    private List<Integer> helper(int[] nums1, int[] nums2) {
//        Set<Integer> set=new HashSet<>();
//        for(int i: nums1) {
//            set.add(i);
//        }
//        Set<Integer> second=new HashSet<>();
//        for(int i: nums2) {
//            if(!set.contains(i)) {
//                second.add(i);
//            }
//        }
//        return new ArrayList<>(second);
//    }
    
    
//    ---------------OPTIMAL -> O(M+N), O(1)------------
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(helper(nums2, nums1), helper(nums1, nums2));
    }
    
    private List<Integer> helper(int[] nums1, int[] nums2) {
        boolean[] present=new boolean[2001];
        for(int i: nums1) {
            present[i+1000]=true;
        }
        List<Integer> ret=new ArrayList<>();
        for(int i: nums2) {
            if(!present[i+1000]) {
                ret.add(i);
                present[i+1000]=true;
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays f=new FindTheDifferenceOfTwoArrays();
        System.out.println(f.findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(f.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
