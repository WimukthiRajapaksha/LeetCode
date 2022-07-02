/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsets.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class SubsetsII {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 0, nums);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> l, int i, int[] nums) {
        list.add(new ArrayList<>(l));
        int j=i;
        while(j<nums.length) {
            if(j!=i && nums[j]==nums[j-1]) {
                while(j<nums.length && nums[j]==nums[j-1]) {
                    j++;
                }
                continue;
            }
            l.add(nums[j]);
            backtrack(list, l, j+1, nums);
            l.remove(l.size()-1);
            j++;
        }
    }
    
    public static void main(String[] args) {
        SubsetsII s=new SubsetsII();
        s.subsetsWithDup(new int[]{1,2,2});
    }
}
