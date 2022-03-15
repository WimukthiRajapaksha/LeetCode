/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class Permutations {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, int[] nums, int j) {
        if(j==nums.length) {
            List<Integer> l=new ArrayList<>();
            for(int i: nums) {
                l.add(i);
            }
            list.add(l);
            return;
        }
        for(int i=j; i<nums.length; i++) {
            swap(nums, i, j);
            backtrack(list, nums, j+1);
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int t=num[i];
        num[i]=num[j];
        num[j]=t;
    }
    
    
    
//    ------------------------NOT OPTIMAL-------------------------------
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list=new ArrayList<>();
//        List<Integer> set=new ArrayList<>();
//        for(int i=0; i<nums.length; i++) {
//            set.add(nums[i]);
//        }
//        backtrack(list, set, new ArrayList<>(), nums);
//        return list;
//    }
//    
//    private void backtrack(List<List<Integer>> list, List<Integer> set, List<Integer> l, int[] nums) {
//        if(set.isEmpty()) {
//            list.add(new ArrayList<>(l));
//            return;
//        }
//        int s=set.size();
//        for(int i=0; i<s; i++) {
//            int t=set.remove(i);
//            l.add(t);
//            backtrack(list, set, l, nums);
//            set.add(t);
//            l.remove(l.size()-1);
//        }
//    }
    
    public static void main(String[] args) {
        Permutations p=new Permutations();
        System.out.println(p.permute(new int[]{5,6,7}));
        System.out.println(p.permute(new int[]{0,1}));
        System.out.println(p.permute(new int[]{1}));
    }
}
