/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decode.ways;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class DecodeWays {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------------OPTIMAL------------------------
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] arr=new int[s.length()+1];
        arr[arr.length-1]=1;
        arr[arr.length-2]= (s.charAt(s.length()-1)=='0') ? 0 : 1;
        for(int i=s.length()-2; i>=0; i--) {
            if(s.charAt(i)=='0') {
                arr[i]=0;
                continue;
            }
            arr[i]=arr[i+1];
            if(Integer.valueOf(s.substring(i, i+2))<=26) {
                arr[i]+=arr[i+2];
            }
        }
        System.out.println(arr[0]);
        return arr[0];
    }
    
    
//    --------------------NOT CORRECT -> BACKTRACKING -> NOT OPTIMAL -> TAKES MORE TIME------------------
//    public int numDecodings(String s) {
//        List<List<String>> list=new ArrayList<>();
//        backtrack(list, 0, s, new ArrayList<>());
//        System.out.println(list.size());
//        return 0;
//    }
//    
//    private void backtrack(List<List<String>> list, int i, String s, List<String> l) {
//        if(i==s.length()) {
//            list.add(new ArrayList<>(l));
//            return;
//        }
//        if(s.charAt(i)=='0') {
//            return;
//        }
//        for(int j=0; j<2 && i+j<s.length(); j++) {
//            if(Integer.valueOf(s.substring(i, i+j+1))>26) return;
//            l.add(s.substring(i, i+j+1));
//            backtrack(list, i+j+1, s, l);
//            l.remove(l.size()-1);
//        }
//    }
    
    
    
//    --------------------NOT CORRECT -> BACKTRACKING -> NOT OPTIMAL -> TAKES MORE TIME------------------
//    public int numDecodings(String s) {
//        Map<String, Integer> map=new HashMap<>();
//        int v=backtrack(s, map);
//        System.out.println(v);
//        return 0;
//    }
//    
//    private int backtrack(String s, Map<String, Integer> map) {
//        if(s.length()==0) {
//            map.put("", 1);
//            return 1;
//        }
//        if(s.charAt(0)=='0') {
//            map.put(s, 0);
//            return 0;
//        }
//        int val=0;
//        if(!map.containsKey(s.substring(1))) {
//            val=backtrack(s.substring(1), map);
//        } else {
//            val=map.get(s.substring(1));
//        }
//        if(s.length()>=2 && Integer.valueOf(s.substring(0, 2))<=26 && !map.containsKey(s.substring(2))) {
//            val+=backtrack(s.substring(2), map);
//        } else if(s.length()>=2 && map.containsKey(s.substring(2))) {
//            val+=map.get(s.substring(2));
//        }
//        map.put(s, val);
//        return val;
//    }
    
    public static void main(String[] args) {
        DecodeWays d=new DecodeWays();
//        d.numDecodings("226");
//        d.numDecodings("06");
//        d.numDecodings("12");
        d.numDecodings("2101");
        d.numDecodings("2452435232452");
        d.numDecodings("10");
        d.numDecodings("111111111111111111111111111111111111111111111");
//        d.numDecodings("111111111141111111111111111116111111111911111");
//        d.numDecodings("123456789123456789123456789123456789123456789123456789");
    }
}
