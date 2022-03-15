/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class PermutationsII {

    /**
     * @param args the command line arguments
     */
    
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, visited, nums, new ArrayList<>());
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, boolean[] visit, int[] nums, List<Integer> l) {
        if(l.size()==nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visit[i] || (i>0 && nums[i]==nums[i-1] && !visit[i-1])) continue;
            visit[i]=true;
            l.add(nums[i]);
            backtrack(list, visit, nums, l);
            visit[i]=false;
            l.remove(l.size()-1);
        }
    }
    
    
    
    
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> list=new ArrayList<>();
//        Map<Integer, Integer> map=new HashMap<>();
//        for(int i: nums) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        backtrack(list, map, nums, new ArrayList<>());
//        return list;
//    }
//    
//    private void backtrack(List<List<Integer>> list, Map<Integer, Integer> map, int[] nums, List<Integer> l) {
//        if(l.size()==nums.length) {
//            list.add(new ArrayList<>(l));
//            return;
//        }
//        for(Map.Entry<Integer, Integer> i: map.entrySet()) {
//            int k=i.getKey();
//            int v=i.getValue();
//            if(v==0)
//            map.put(k, v-1);
//            l.add(v);
//            backtrack(list, map, nums, l);
//            map.put(k, map.getOrDefault(k, 0)+1);
//            l.remove(l.size()-1);
//        }
//    }
    
    public static void main(String[] args) {
        PermutationsII p=new PermutationsII();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
        System.out.println(p.permuteUnique(new int[]{1,2,3}));
        System.out.println(p.permuteUnique(new int[]{2,2,1,1}));
        System.out.println(p.permuteUnique(new int[]{0,1,0,0,9}));
    }
}
