/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generate.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class GenerateParentheses {

    /**
     * @param args the command line arguments
     */
    
//    --------------------ITERATIVE--------------------
    public List<String> generateParenthesis(int n) {
        Set<String> set=new HashSet<>();
        set.add("()");
        if(n==1) return new ArrayList<>(set);
        for(int i=2; i<=n; i++) {
            Set<String> tempSet=new HashSet<>();
            for(String s: set) {
                for(int j=0; j<s.length(); j++) {
                    StringBuilder sb=new StringBuilder(s);
                    sb.insert(j, "()");
                    tempSet.add(sb.toString());
                }
            }
            set.clear();
            set.addAll(tempSet);
        }
        return new ArrayList<>(set);
    }
    
    
    
    
//    --------------------OPTIMAL--------------------
//    public List<String> generateParenthesis(int n) {
//        List<String> l=new ArrayList<>();
//        para(l, n, n, new StringBuilder());
//        System.out.println(l);
//        return l;
//    }
//    
//    private void para(List<String> l, int open, int close, StringBuilder sb) {
//        if(open<0 || close<0) return;
//        if(open==0 && close==0) {
//            l.add(sb.toString());
//            return;
//        }
//        para(l, open-1, close, sb.append("("));
//        sb.deleteCharAt(sb.length()-1);
//        if(open<close) {
//            para(l, open, close-1, sb.append(")"));
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
    
    
//    --------------------OPTIMAL--------------------
//    public List<String> generateParenthesis(int n) {
//        List<String> l=new ArrayList<>();
//        para(l, n, n, new StringBuilder());
//        System.out.println(l);
//        return l;
//    }
//    
//    private void para(List<String> l, int open, int close, StringBuilder sb) {
//        if(open<0 || close<0) return;
//        if(open==0 && close==0) {
//            l.add(sb.toString());
//            return;
//        }
//        int le=sb.length();
//        para(l, open-1, close, sb.append("("));
//        sb.setLength(le);
//        if(open<close) {
//            para(l, open, close-1, sb.append(")"));
//            sb.setLength(le);
//        }
//    }
    
    
//    --------------------OPTIMAL--------------------
//    public List<String> generateParenthesis(int n) {
//        List<String> l=new ArrayList<>();
//        para(l, n, n, "");
//        System.out.println(l);
//        return l;
//    }
//    
//    private void para(List<String> l, int open, int close, String s) {
//        if(open<0 || close<0) return;
//        if(open==0 && close==0) {
//            l.add(s);
//            return;
//        }
//        para(l, open-1, close, s+"(");
//        if(open<close) {
//            para(l, open, close-1, s+")");
//        }
//    }
    
    public static void main(String[] args) {
        GenerateParentheses g=new GenerateParentheses();
//        g.generateParenthesis(2);
        g.generateParenthesis(3);
//        g.generateParenthesis(4);
    }
}