/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class Subsets {

    /**
     * @param args the command line arguments
     */
    
//    -----------------BEAUTIFUL -> DOUBLE BACKTRACKING--------------------
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtracking(List<List<Integer>> list, List<Integer> l, int[] nums, int i) {
        if(i==nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        backtracking(list, l, nums, i+1);
        l.remove(l.size()-1);
        backtracking(list, l, nums, i+1);
    }
    
    
    
//   -------------------OPTIMAL -> BACKTRACKING---------------------
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list=new ArrayList<>();
//        backtracking(list, new ArrayList<>(), nums, 0);
//        return list;
//    }
//    
//    private void backtracking(List<List<Integer>> list, List<Integer> l, int[] nums, int i) {
//        list.add(new ArrayList<>(l));
//        for(int j=i; j<nums.length; j++) {
//            l.add(nums[j]);
//            backtracking(list, l, nums, j+1);
//            l.remove(l.size()-1);
//        }
//    }
    
    
    
    
//    ----------------------ALTERNATE -> WITHOUT BACKTRACKING -> BIT MANIPULATION---------------------
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list=new ArrayList<>();
//        for(int i=0; i<Math.pow(2, nums.length); i++) {
//            List<Integer> l=new ArrayList<>();
//            for(int j=0; j<nums.length; j++) {
//                if((i&(1<<j))!=0) {
//                    l.add(nums[j]);
//                }
//            }
//            list.add(l);
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        Subsets s=new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
        System.out.println(s.subsets(new int[]{0}));
    }
}
