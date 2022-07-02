/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class Combinations {

    /**
     * @param args the command line arguments
     */
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 0, k, n);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> l, int i, int k, int n) {
        if(k==0) {
            list.add(new ArrayList<>(l));
            return;
        }
        for(int j=i+1; j<=n-k+1; j++) {
            l.add(j);
            backtrack(list, l, j, k-1, n);
            l.remove(l.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Combinations c=new Combinations();
        c.combine(4, 2);
        c.combine(1, 1);
    }
}
