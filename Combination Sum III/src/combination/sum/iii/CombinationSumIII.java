/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination.sum.iii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CombinationSumIII {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, n, k, new ArrayList<>(), 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, int n, int k, List<Integer> l, int v) {
        if(n==0) {
            if(k==0) {
                list.add(new ArrayList<>(l));
            }
            return;
        }
        if(n>k*(19-k)/2) {
            return;
        }
        for(int i=v+1; i<10; i++) {
            l.add(i);
            backtrack(list, n-i, k-1, l, i);
            l.remove(l.size()-1);
        }
    }
    
    
    
    
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        List<List<Integer>> list=new ArrayList<>();
//        backtrack(list, n, k, new HashSet<>(), 0);
//        return list;
//    }
//    
//    private void backtrack(List<List<Integer>> list, int n, int k, Set<Integer> used, int v) {
//        if(n==0) {
//            if(k==0) {
//                list.add(new ArrayList<>(used));
//            }
//            return;
//        }
//        if(n>k*(19-k)/2) {
//            return;
//        }
//        for(int i=v+1; i<10; i++) {
//            if(!used.contains(i)) {
//                used.add(i);
//                backtrack(list, n-i, k-1, used, i);
//                used.remove(i);
//            }
//        }
//    }
    
    public static void main(String[] args) {
        CombinationSumIII c=new CombinationSumIII();
        System.out.println(c.combinationSum3(3, 9));
        System.out.println(c.combinationSum3(3, 7));
        System.out.println(c.combinationSum3(4, 1));
    }
}
