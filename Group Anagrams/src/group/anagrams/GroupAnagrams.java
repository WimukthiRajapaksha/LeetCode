/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String s: strs) {
            char[] arr=new char[26];
            for(char c: s.toCharArray()) {
                arr[c-'a']++;
            }
            String tempStr=new String(arr);
            map.putIfAbsent(tempStr, new ArrayList<>());
            map.get(tempStr).add(s);
        }
        List<List<String>> li=new ArrayList<>();
        for(String key: map.keySet()) {
            li.add(map.get(key));
        }
        System.out.println(li);
        return li;
    }
    
    
    
//    -------------------ALTERNATE -> NOT OPTIMAL-----------------------
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map=new HashMap<>();
//        for(String s: strs) {
//            char[] t=s.toCharArray();
//            Arrays.sort(t);
//            String temp=new String(t);
//            map.putIfAbsent(temp, new ArrayList<>());
//            map.get(temp).add(s);
//        }
//        List<List<String>> li=new ArrayList<>();
//        for(String key: map.keySet()) {
//            li.add(map.get(key));
//        }
//        System.out.println(li);
//        return li;
//    }
    

    
//    -------------------ALTERNATE -> NOT OPTIMAL-----------------------
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map=new HashMap<>();
//        for(String s: strs) {
//            int[] arr=new int[26];
//            for(char c: s.toCharArray()) {
//                arr[c-'a']++;
//            }
//            StringBuffer sb = new StringBuffer();
//            for(int i: arr) {
//                sb.append(i).append("-");
//            }
//            if(map.containsKey(sb.toString())) {
//                map.get(sb.toString()).add(s);
//            } else {
//                List<String> l=new ArrayList<>();
//                l.add(s);
//                map.put(sb.toString(), l);
//            }
//        }
//        List<List<String>> li=new ArrayList<>();
//        for(Map.Entry<String, List<String>> en: map.entrySet()) {
//            li.add(en.getValue());
//        }
//        return li;
//    }
    
    public static void main(String[] args) {
        GroupAnagrams g=new GroupAnagrams();
        g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        g.groupAnagrams(new String[]{""});
        g.groupAnagrams(new String[]{"a"});
        g.groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
        g.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }
}
