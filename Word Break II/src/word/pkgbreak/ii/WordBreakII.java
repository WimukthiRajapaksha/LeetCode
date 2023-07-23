/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.pkgbreak.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child=new TrieNode[26];
        isEnd=false;
    }
}

public class WordBreakII {

//    ------------------------------OPTIMAL -> O(2^N), O(2^N); NOT SURE------------------------
    public List<String> wordBreak(String s, List<String> wordDict) {
        return help(s, new HashMap<>(), wordDict);
    }
    
    private List<String> help(String s, Map<String, List<String>> map, List<String> dic) {
        if(map.containsKey(s)) return map.get(s);
        List<String> ret=new ArrayList<>();
        if(s.length()==0) {
            ret.add("");
            return ret;
        }
        for(String d: dic) {
            if(s.indexOf(d)==0) {
                List<String> temp=help(s.substring(d.length()), map, dic);
                for(String t: temp) {
                    ret.add(d+(t.isEmpty() ? "" : " ")+t);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
    
    
    
//    ------------------------------OPTIMAL -> O(N*LEN(WORD)), O(N); NOT SURE------------------------
//    TrieNode root;
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        root=new TrieNode();
//        for(String w: wordDict) {
//            TrieNode t=root;
//            for(char c: w.toCharArray()) {
//                if(t.child[c-'a']==null) t.child[c-'a']=new TrieNode();
//                t=t.child[c-'a'];
//            }
//            t.isEnd=true;
//        }
//        List<String> ret=new ArrayList<>();
//        find(root, s, 0, ret, new StringBuffer());
//        return ret;
//    }
//    
//    private void find(TrieNode trie, String s, int i, List<String> list, StringBuffer sb) {
//        if(i==s.length() || trie.child[s.charAt(i)-'a']==null) {
//            return;
//        }
//        sb.append(s.charAt(i));
//        int len=sb.length();
//        if(trie.child[s.charAt(i)-'a'].isEnd) {
//            if(i+1==s.length()) {
//                list.add(sb.toString());
//            } else {
//                sb.append(" ");
//                find(root, s, i+1, list, sb);
//            }
//        }
//        sb.setLength(len);
//        find(trie.child[s.charAt(i)-'a'], s, i+1, list, sb);
//    }
    
    
    
    
    
    
//    ------------------------------OPTIMAL -> O(2^N), O(2^N); NOT SURE------------------------
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>();
//        set.addAll(wordDict);
//        List<String> ret=new ArrayList<>();
//        help(s, 0, set, ret, new StringBuffer());
//        return ret;
//    }
//    
//    private void help(String s, int i, Set<String> set, List<String> list, StringBuffer sb) {
//        System.out.println(sb.toString());
//        if(i==s.length()) {
//            list.add(sb.substring(1, sb.length()));
//            return;
//        }
//        for(int j=i+1; j<=s.length(); j++) {
//            if(set.contains(s.substring(i, j))) {
//                int len=sb.length();
//                sb.append(" ").append(s.substring(i, j));
//                help(s, j, set, list, sb);
//                sb.setLength(len);
//            }
//        }
//    }
    
    public static void main(String[] args) {
        WordBreakII w=new WordBreakII();
        System.out.println(w.wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"))));
    }
}
