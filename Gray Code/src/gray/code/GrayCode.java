/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gray.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class GrayCode {

    /**
     * @param args the command line arguments
     */
    
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        backtrack(n, list);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(int n, List<Integer> list) {
        if(n==0) {
            list.add(0);
            return;
        }
        backtrack(n-1, list);
        int size=list.size()-1;
        for(int j=size; j>=0; j--) {
            list.add(list.get(j)+(1<<n-1));
        }
    }
    
    
//    --------------------ALTERNATE -> NOT OPTIMAL-------------------
//    public List<Integer> grayCode(int n) {
//        List<Integer> ret=new ArrayList<>();
//        if(n==1) {
//            ret.add(0);
//            ret.add(1);
//            return ret;
//        }
//        List<Integer> list = grayCode(n-1);
//        for(int j=0; j<list.size(); j++) {
//            ret.add(list.get(j));
//        }
//        for(int j=list.size()-1; j>=0; j--) {
//            ret.add(list.get(j)+(1<<n-1));
//        }
//        System.out.println(ret);
//        return ret;
//    }
    
    
//    --------------------ALTERNATE -> NOT OPTIMAL-------------------
//    public List<Integer> grayCode(int n) {
//        List<String> list = backtrack(n);
//        List<Integer> ret=new ArrayList<>();
//        for(String s: list) {
//            ret.add(Integer.parseInt(s, 2));
//        }
//        System.out.println(ret);
//        return ret;
//    }
//    
//    private List<String> backtrack(int i) {
//        if(i==0) {
//            return Arrays.asList("");
//        }
//        List<String> list = backtrack(i-1);
//        List<String> ret=new ArrayList<>();
//        StringBuilder sb=new StringBuilder();
//        sb.append("0");
//        for(int j=0; j<list.size(); j++) {
//            ret.add(sb.append(list.get(j)).toString());
//            sb.setLength(1);
//        }
//        sb.setLength(0);
//        sb.append("1");
//        for(int j=list.size()-1; j>=0; j--) {
//            ret.add(sb.append(list.get(j)).toString());
//            sb.setLength(1);
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        GrayCode g=new GrayCode();
        g.grayCode(3);
    }
}
