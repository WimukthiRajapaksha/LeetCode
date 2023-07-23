/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class WordLadder {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(M^2*N), O(M^2*N)--------------------
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> words=new HashSet<>(wordList);
        Set<String> begin=new HashSet<>();
        Set<String> end=new HashSet<>();
        Set<String> visited=new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        int count=1;
        while(!begin.isEmpty() && !end.isEmpty()) {
            if(begin.size()>end.size()) {
                Set<String> beg=begin;
                begin=end;
                end=beg;
            }
            Set<String> temp=new HashSet<>();
            for(String s: begin) {
                char[] arr=s.toCharArray();
                for(int i=0; i<s.length(); i++) {
                    for(char c='a'; c<='z'; c++) {
                        char t=arr[i];
                        arr[i]=c;
                        String news=new String(arr);
                        if(end.contains(news)) return count+1;
                        if(!visited.contains(news) && words.contains(news)) {
                            temp.add(news);
                            visited.add(news);
                        }
                        arr[i]=t;
                    }
                }
            }
            begin=temp;
            count++;
        }
        return 0;
    }
    
    
    
//    -------------------OPTIMAL -> O(M^2*N), O(M^2*N)--------------------
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {        
//        if(!wordList.contains(endWord)) return 0;
//        Set<String> words=new HashSet<>(wordList);
//        Set<String> taken=new HashSet<>();
//        taken.add(beginWord);
//        Queue<String> q=new LinkedList<>();
//        q.offer(beginWord);
//        int count=1;
//        while(!q.isEmpty()) {
//            for(int k=q.size()-1; k>=0; k--) {
//                String temp=q.poll();
//                if(temp.equals(endWord)) return count;
//                for(int i=0; i<temp.length(); i++) {
//                    for(char j='a'; j<='z'; j++) {
//                        char[] arr=temp.toCharArray();
//                        arr[i]=j;
//                        String newS=new String(arr);
//                        if(words.contains(newS) && !taken.contains(newS)) {
//                            q.offer(newS);
//                            taken.add(newS);
//                        }
//                    }
//                }
//            }
//            count++;
//        }
//        return 0;
//    }
    
    
//    -------------------OPTIMAL -> O(M^2*N), O(M^2*N)--------------------
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord)) {
//            return 0;
//        }
//        List<String> words=new ArrayList<>(new HashSet<>(wordList));
//        boolean[] visited=new boolean[words.size()];
//        Queue<String> queue=new LinkedList<>();
//        queue.offer(beginWord);
//        int count=1;
//        while(!queue.isEmpty()) {
//            for(int j=queue.size(); j>0; j--) {
//                String temp=queue.poll();
//                if(temp.equals(endWord)) return count;
//                for(int i=0; i<words.size(); i++) {
//                    if(!visited[i] && isValid(words.get(i), temp)) {
//                        queue.offer(words.get(i));
//                        visited[i]=true;
//                    }
//                }
//            }
//            count++;
//        }
//        return 0;
//    }
//    
//    private boolean isValid(String f, String s) {
//        int c=0;
//        for(int i=0; i<f.length(); i++) {
//            if(f.charAt(i)!=s.charAt(i)) c++;
//            if(c>=2) return false;
//        }
//        if(c==1) return true;
//        return false;
//    }
    
    public static void main(String[] args) {
        WordLadder w=new WordLadder();
        System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(w.ladderLength("leet", "code", Arrays.asList("lest","leet","lose","code","lode","robe","lost")));
        System.out.println(w.ladderLength("ymain", "oecij", Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain")));
    }
}
