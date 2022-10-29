/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package different.ways.to.add.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class DifferentWaysToAddParentheses {

    /**
     * @param args the command line arguments
     */
    
//    ------------------------OPTIMAL-------------------------
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo=new HashMap<>();
        return dfs(memo, 0, expression.length()-1, expression);
    }
    
    private List<Integer> dfs(Map<String, List<Integer>> memo, int l, int r, String exp) {
        List<Integer> list=new ArrayList<>();
        if(l>r) return list;
        for(int i=l; i<=r; i++) {
            if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*') {
                List<Integer> left=dfs(memo, l, i-1, exp);
                List<Integer> right=dfs(memo, i+1, r, exp);
                for(int le: left) {
                    for(int ri: right) {
                        if(exp.charAt(i)=='+') {
                            list.add(le+ri);
                        } else if(exp.charAt(i)=='-') {
                            list.add(le-ri);
                        } else {
                            list.add(le*ri);
                        }
                    }
                }
            }
        }
        if(list.isEmpty()) {
            list.add(Integer.valueOf(exp.substring(l, r+1)));
        }
        memo.put(exp.substring(l, r+1), list);
        return list;
    }
    
    
    
//    ------------------------OPTIMAL-------------------------
//    Map<String, List<Integer>> memo=new HashMap<>();
//    public List<Integer> diffWaysToCompute(String expression) {
//        if(memo.containsKey(expression)) return memo.get(expression);
//        List<Integer> list=new ArrayList<>();
//        for(int i=0; i<expression.length(); i++) {
//            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*') {
//                List<Integer> left=diffWaysToCompute(expression.substring(0, i));
//                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
//                for(int l: left) {
//                    for(int r: right) {
//                        if(expression.charAt(i)=='+') {
//                            list.add(l+r);
//                        } else if(expression.charAt(i)=='-') {
//                            list.add(l-r);
//                        } else {
//                            list.add(l*r);
//                        }
//                    }
//                }
//            }
//        }
//        if(list.isEmpty()) {
//            list.add(Integer.valueOf(expression));
//        }
//        memo.put(expression, list);
//        return list;
//    }
    
    public static void main(String[] args) {
        DifferentWaysToAddParentheses d=new DifferentWaysToAddParentheses();
        System.out.println(d.diffWaysToCompute("102*331-4*555"));
        System.out.println(d.diffWaysToCompute("2-1-1"));
        System.out.println(d.diffWaysToCompute("2*3-4*5"));
    }
}
