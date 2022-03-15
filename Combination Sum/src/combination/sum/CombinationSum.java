/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CombinationSum {

    /**
     * @param args the command line arguments
     */
    
//    -------------OPTIMAL->NICE APPROACH->REMOVE AT THE END OF LIST----------------
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(target==0 || candidates.length==0) return list;
        List<Integer> li=new ArrayList<>();
        comb(list, candidates, target, 0, li);
        System.out.println(list);
        return new ArrayList<>(list);
    }
    
    private void comb(List<List<Integer>> list, int[] candidates, int target, int currentPosi, List<Integer> temp) {
        if(target==0) {
            list.add(new ArrayList<>(temp));
            return;
        } else if (target<0) {
            return;
        }
        for(int i=currentPosi; i<candidates.length; i++) {
            temp.add(candidates[i]);
            comb(list, candidates, target-candidates[i], i, temp);
            temp.remove(temp.size()-1);
        }
    }
    
    
    
//    ------------------------ALTERNATE->CAN OPTIMIZE----------------------------
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Set<List<Integer>> list=new HashSet<>();
//        List<Integer> li=new ArrayList<>();
//        for(int i=0; i<candidates.length; i++) {
//            comb(list, candidates, target, i, 0, candidates[i], li);
//        }
//        System.out.println(list);
//        return new ArrayList<>(list);
//    }
//    
//    private void comb(Set<List<Integer>> list, int[] candidates, int target, int currentPosi, int totalSum, int currentVal, List<Integer> temp) {
//        if(totalSum+currentVal>target) {
//            return;
//        }
//        List li=new ArrayList<>();
//        li.addAll(temp);
//        li.add(currentVal);
//        if(totalSum+currentVal==target) {
//            list.add(li);
//            return;
//        }
//        for(int i=currentPosi; i<candidates.length; i++) {
//            comb(list, candidates, target, i, totalSum+currentVal, candidates[i], li);
//        }
//    }
    
    public static void main(String[] args) {
        CombinationSum c=new CombinationSum();
        c.combinationSum(new int[]{2,3,6,7}, 7);
    }
    
}
