/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination.sum.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CombinationSumII {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, 0, target, candidates, new ArrayList<>());
        return list;
    }
    
    
    private void backtrack(List<List<Integer>> list, int index, int target, int[] candidates, List<Integer> current) {
        if(target<0) {
            return;
        } else if(target==0) {
            list.add(new ArrayList<>(current));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(i==index || candidates[i]!=candidates[i-1]) {
                if(candidates[i]>target) break;
                current.add(candidates[i]);
                backtrack(list, i+1, target-candidates[i], candidates, current);
                current.remove(current.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        CombinationSumII c=new CombinationSumII();
        System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(c.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
