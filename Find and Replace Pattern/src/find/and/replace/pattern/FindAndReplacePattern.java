/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.and.replace.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindAndReplacePattern {

    /**
     * @param args the command line arguments
     */
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new LinkedList<>();
        for(int i=0; i<words.length; i++) {
            if(words[i].length()!=pattern.length()) {
                continue;
            }
            if(check(pattern, words[i])) {
                list.add(words[i]);
            }
        }
        return list;
    }
    
    private boolean check(String s, String t) {
        int[] fi=new int[26];
        int[] se=new int[26];
        for(int i=0; i<s.length(); i++) {
            if(fi[s.charAt(i)-'a']!=se[t.charAt(i)-'a']) return false;
            fi[s.charAt(i)-'a']=i+1;
            se[t.charAt(i)-'a']=i+1;
        }
        return true;
    }
    
    public static void main(String[] args) {
        FindAndReplacePattern f=new FindAndReplacePattern();
        System.out.println(f.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
