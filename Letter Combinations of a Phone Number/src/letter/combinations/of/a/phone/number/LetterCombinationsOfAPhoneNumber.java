/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * @param args the command line arguments
     */
    
//    String[] map=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    LinkedList<String> list=new LinkedList<>();
//    public List<String> letterCombinations(String digits) {
//        if(digits.length()!=0) cre(digits, 0, "");
//        return list;
//    }
//    
//    public void cre(String s, int i, String cu) {
//        if(cu.length()==s.length()) {
//            list.add(cu);
//            return;
//        }
//        String curr=map[Character.getNumericValue(s.charAt(i))];
//        for(char c: curr.toCharArray()) {
//            cre(s, i+1, cu+c);
//        }
//    }
    
    
    
    String[] map=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    LinkedList<String> list=new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0) cre(digits, 0, new StringBuilder().append(""));
        return list;
    }
    
    public void cre(String s, int i, StringBuilder sb) {
        if(sb.length()==s.length()) {
            list.add(sb.toString());
            return;
        }
        String curr=map[Character.getNumericValue(s.charAt(i))];
        for(char c: curr.toCharArray()) {
            sb.append(c);
            cre(s, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    
    
    
//    public List<String> letterCombinations(String digits) {
//        String[] map=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        LinkedList<String> list=new LinkedList<>();
//        if(digits.length()==0) return list;
//        list.add("");
//        for(int i=0; i<digits.length(); i++) {
//            String v=map[Character.getNumericValue(digits.charAt(i))];
//            while(list.peek().length()==i) {
//                String s=list.poll();
//                for(char c: v.toCharArray()) {
//                    list.offer(s+c);
//                }
//            }
//        }
//        return list;
//    }
    
    
    
//    String[] map=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> list=new LinkedList<>();
//        if(digits.length()!=0) cre(digits, 0, list);
//        return list;
//    }
//    
//    public void cre(String s, int i, Queue<String> l) {
//        if(i==s.length()-1) {
//            String t=map[s.charAt(i)-'0'];
//            for(char c: t.toCharArray()) {
//                l.offer(String.valueOf(c));
//            }
//            return;
//        }
//        cre(s, i+1, l);
//        String u=map[s.charAt(i)-'0'];
//        int size=l.size();
//        while(size>0) {
//            String te=l.poll();
//            for(char c: u.toCharArray()) {
//                l.offer(c+te);
//            }
//            size--;
//        }
//    }
    
    
//    Map<Character, String> map=new HashMap<>();
//    public List<String> letterCombinations(String digits) {
//        List<String> list=new ArrayList<>();
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        if(digits.length()!=0) list=cre(digits, 0);
//        return list;
//    }
//    
//    public List<String> cre(String s, int i) {
//        if(i==s.length()-1) {
//            List<String> l=new ArrayList<>();
//            String t=map.get(s.charAt(i));
//            for(char c: t.toCharArray()) {
//                l.add(String.valueOf(c));
//            }
//            return l;
//        }
//        List<String> t=cre(s, i+1);
//        List<String> ret=new ArrayList<>();
//        String u=map.get(s.charAt(i));
//        for(char c: u.toCharArray()) {
//            for(String te: t) {
//                ret.add(c+te);
//            }
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l=new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("23"));
//        System.out.println(l.letterCombinations(""));
//        System.out.println(l.letterCombinations("2"));
    }
}
