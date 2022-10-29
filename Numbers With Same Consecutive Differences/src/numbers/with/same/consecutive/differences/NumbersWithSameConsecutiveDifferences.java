/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.with.same.consecutive.differences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumbersWithSameConsecutiveDifferences {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> DFS----------------------------
//    public int[] numsSameConsecDiff(int n, int k) {
//        if(n==1) {
//            return new int[]{1,2,3,4,5,6,7,8,9};
//        }
//        List<Integer> res=new ArrayList<>();
//        for(int i=1; i<10; i++) {
//            dfs(n-1, k, i, res);
//        }
//        int[] retArr=new int[res.size()];
//        for(int i=0; i<res.size(); i++) {
//            retArr[i]=res.get(i);
//        }
//        return retArr;
//    }
//    
//    private void dfs(int n, int k, int v, List<Integer> list) {
//        if(n==0) {
//            list.add(v);
//            return;
//        }
//        int rem=v%10;
//        if(rem+k<10) dfs(n-1, k, (v*10)+rem+k, list);
//        if(k!=0 && rem-k>=0) dfs(n-1, k, (v*10)+rem-k, list);
//    }
    
    
    
//    -------------------OPTIMAL -> BFS----------------------------
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1; i<=9; i++) {
            list.add(i);
        }
        List<Integer> l=back(k, n-1, list);
        int[] ret=new int[l.size()];
        for(int i=0; i<ret.length; i++) {
            ret[i]=l.get(i);
        }
        return ret;
    }
    
    private List<Integer> back(int k, int n, List<Integer> val) {
        if(n==0) return val;
        List<Integer> ret=new ArrayList<>();
        for(int v: val) {
            if(v%10>=k) {
                int t=(v*10)+((v%10)-k);
                ret.add(t);
            }
            if(k!=0 && 9>=(v%10)+k) {
                int t=(v*10)+((v%10)+k);
                ret.add(t);
            }
        }
        return back(k, n-1, ret);
    }
    
    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences n=new NumbersWithSameConsecutiveDifferences();
        System.out.println(Arrays.toString(n.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(2, 1)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(2, 0)));
    }
}
