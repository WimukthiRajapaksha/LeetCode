/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.pkgbreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class WordBreak {

    /**
     * @param args the command line arguments
     */
    
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root=buildTrie(wordDict);
        return search(root, s, 0, new Boolean[s.length()]);
    }
    
    private boolean search(TrieNode node, String s, int i, Boolean[] che) {
        if(s.length()==i) return true;
        if(che[i]!=null) return che[i];
        boolean ret=false;
        TrieNode temp=node;
        for(int j=i; j<s.length(); j++) {
            if(temp.list[s.charAt(j)-'a']==null) break;
            temp=temp.list[s.charAt(j)-'a'];
            if(temp.terminal) {
                ret |= search(node, s, j+1, che);
            }
        }
        che[i]=ret;
        return ret;
    }
    
    public TrieNode buildTrie(List<String> list) {
        TrieNode root=new TrieNode();
        for(String s: list) {
            TrieNode temp=root;
            for(char c: s.toCharArray()) {
                if(temp.list[c-'a']==null) {
                    temp.list[c-'a']=new TrieNode();
                }
                temp=temp.list[c-'a'];
            }
            temp.terminal=true;
        }
        return root;
    }
    
    public static class TrieNode {
        boolean terminal;
        TrieNode[] list=new TrieNode[26];
    }

        
    
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return backtrack(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
//    }
//    
//    private boolean backtrack(String s, Set<String> set, int i, Boolean[] visited) {
//        if(s.length()==i) return true;
//        else if(visited[i]!=null) return visited[i];
//        for(int j=i+1; j<=s.length(); j++) {
//            if(set.contains(s.substring(i, j)) && backtrack(s, set, j, visited)) {
//                visited[i]=true;
//                return true;
//            }
//        }
//        visited[i]=false;
//        return false;
//    }

    
    
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>(wordDict);
//        boolean[] arr = new boolean[s.length()+1];
//        arr[arr.length-1]=true;
//        for(int i=s.length()-1; i>=0; i--) {
//            for(int j=i+1; j<=s.length(); j++) {
//                arr[i]=arr[j] && set.contains(s.substring(i, j));
//                if(arr[i]) break;
//            }
//        }
//        return arr[0];
//    }
    
    
    
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>(wordDict);
//        boolean[] arr = new boolean[s.length()+1];
//        arr[0]=true;
//        for(int i=1; i<=s.length(); i++) {
//            for(int j=0; j<i; j++) {
//                if(arr[j] && set.contains(s.substring(j, i))) {
//                    arr[i]=true;
//                    break;
//                }
//            }
//        }
//        return arr[arr.length-1];
//    }
    
    
    
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>(wordDict);
//        Map<String, Boolean> map = new HashMap<>();
//        return backtrack(s, set, map);
//    }
//    
//    private boolean backtrack(String s, Set<String> set, Map<String, Boolean> map) {
//        if(map.containsKey(s)) {
//            return map.get(s);
//        }
//        if(s.length()==0) return true;
//        for(int i=1; i<=s.length(); i++) {
//            if(set.contains(s.substring(0, i)) && backtrack(s.substring(i), set, map)) {
//                map.put(s, true);
//                return true;
//            }
//        }
//        map.put(s, false);
//        return false;
//    }
    
    public static void main(String[] args) {
        WordBreak w=new WordBreak();
        List<String> l=new ArrayList<>();
        l.add("apple");
        l.add("pen");
        System.out.println(w.wordBreak("applepenapple", l));
        
        l.clear();
        l.add("cats");
        l.add("dog");
        l.add("sand");
        l.add("and");
        l.add("cat");
        System.out.println(w.wordBreak("catsandog", l));
        
        
        l.clear();
        l.add("a");
        l.add("b");
        l.add("bbb");
        l.add("bbbb");
        System.out.println(w.wordBreak("bb", l));
    }
}
