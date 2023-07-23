/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class WordSearchII {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------NOT OPTIMAL -> O(M*N*WORDS.LENGTH*MIN(4^MAX_WORD_LENGTH), M*N)), O(WORDS.LENGTH*MAX_WORD_LENGTH)-----------------
//    int[][] dir=new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> ret=new ArrayList<>();
//        for(String k: words) {
//            boolean found=false;
//            for(int i=0; i<board.length; i++) {
//                for(int j=0; j<board[i].length; j++) {
//                    if(backtrack(board, i, j, k, 0)) {
//                        ret.add(k);
//                        found=true;
//                        break;
//                    }
//                }
//                if(found) break;
//            }
//        }
//        return ret;
//    }
    
    
    
    
//    -----------------OPTIMAL -> O(M*N*MIN(4^MAX_WORD_LENGTH), M*N)), O(WORDS.LENGTH*MAX_WORD_LENGTH)-----------------
//    class Trie {
//        Trie[] arr;
//        boolean isEnd;
//        String word;
//
//        public Trie() {
//            arr=new Trie[26];
//            isEnd=false;
//        }
//    }
//    
//    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//    public List<String> findWords(char[][] board, String[] words) {
//        Set<String> ret=new HashSet<>();
//        Trie root=new Trie();
//        for(String w: words) {
//            help(root, w, 0);
//        }
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[i].length; j++) {
//                backtrack(root, board, i, j, ret);
//            }
//        }
//        return new ArrayList<>(ret);
//    }
//    
//    private void help(Trie root, String s, int i) {
//        if(i==s.length()) {
//            root.isEnd=true;
//            root.word=s;
//            return;
//        }
//        if(root.arr[s.charAt(i)-'a']==null) {
//            root.arr[s.charAt(i)-'a']=new Trie();
//        }
//        Trie temp=root.arr[s.charAt(i)-'a'];
//        help(temp, s, i+1);
//    }
//    
//    private void backtrack(Trie root, char[][] board, int i, int j, Set<String> ret) {
//        char c=board[i][j];
//        if(c=='#' || root.arr[c-'a']==null) return;
//        if(root.arr[c-'a'].isEnd) {
//            ret.add(root.arr[c-'a'].word);
//            root.arr[c-'a'].isEnd = false;
//        }
//        board[i][j]='#';
//        for(int[] d: dir) {
//            if(i+d[0]>=0 && i+d[0]<board.length && j+d[1]>=0 && j+d[1]<board[0].length) {
//                backtrack(root.arr[c-'a'], board, i+d[0], j+d[1], ret);
//            }
//        }
//        board[i][j]=c;
//    }
    
    
    
    
//    -----------------OPTIMAL -> O(M*N*MIN(4^MAX_WORD_LENGTH), M*N)), O(WORDS.LENGTH*MAX_WORD_LENGTH)-----------------
//    class Trie {
//        Trie[] arr;
//        String word;
//
//        public Trie() {
//            arr=new Trie[26];
//        }
//        
//        public void addWord(String s) {
//            Trie temp=this;
//            for(char c: s.toCharArray()) {
//                if(temp.arr[c-'a']==null) {
//                    temp.arr[c-'a']=new Trie();
//                }
//                temp=temp.arr[c-'a'];
//            }
//            temp.word=s;
//        }
//    }
//    
//    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> ret=new ArrayList<>();
//        Trie root=new Trie();
//        
//        
//        for(String w: words) {
//            root.addWord(w);
//        }
////        System.out.println(root);
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[i].length; j++) {
//                backtrack(root, board, i, j, ret);
//            }
//        }
//        return new ArrayList<>(ret);
//    }
//    
//    private void backtrack(Trie root, char[][] board, int i, int j, List<String> ret) {
//        char c=board[i][j];
//        if(c=='#' || root.arr[c-'a']==null) return;
//        if(root.arr[c-'a'].word!=null) {
//            ret.add(root.arr[c-'a'].word);
//            root.arr[c-'a'].word = null;
//        }
//        board[i][j]='#';
//        for(int[] d: dir) {
//            if(i+d[0]>=0 && i+d[0]<board.length && j+d[1]>=0 && j+d[1]<board[0].length) {
//                backtrack(root.arr[c-'a'], board, i+d[0], j+d[1], ret);
//            }
//        }
//        board[i][j]=c;
//    }
    
    
    
//    -----------------OPTIMAL -> O(M*N*MIN(4^MAX_WORD_LENGTH), M*N)), O(WORDS.LENGTH*MAX_WORD_LENGTH)-----------------
    class Trie {
        Trie[] arr;
        int index;

        public Trie() {
            arr=new Trie[26];
            index=-1;
        }
        
        public void addWord(String s, int index) {
            Trie temp=this;
            for(char c: s.toCharArray()) {
                if(temp.arr[c-'a']==null) {
                    temp.arr[c-'a']=new Trie();
                }
                temp=temp.arr[c-'a'];
            }
            temp.index=index;
        }
    }
    
    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret=new ArrayList<>();
        Trie root=new Trie();
        
        for(int i=0; i<words.length; i++) {
            root.addWord(words[i], i);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                backtrack(root, board, i, j, ret, words);
            }
        }
        return new ArrayList<>(ret);
    }
    
    private void backtrack(Trie root, char[][] board, int i, int j, List<String> ret, String[] words) {
        char c=board[i][j];
        if(c=='#' || root.arr[c-'a']==null) return;
        if(root.arr[c-'a'].index!=-1) {
            ret.add(words[root.arr[c-'a'].index]);
            root.arr[c-'a'].index = -1;
        }
        board[i][j]='#';
        for(int[] d: dir) {
            if(i+d[0]>=0 && i+d[0]<board.length && j+d[1]>=0 && j+d[1]<board[0].length) {
                backtrack(root.arr[c-'a'], board, i+d[0], j+d[1], ret, words);
            }
        }
        board[i][j]=c;
    }
    
    public static void main(String[] args) {
        WordSearchII w=new WordSearchII();
        System.out.println(w.findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, 
                new String[]{"oath","pea","eat","rain"}));
        System.out.println(w.findWords(
                new char[][]{{'o','a','t','h'}}, 
                new String[]{"oath","pea","eat","rain"}));
        System.out.println(w.findWords(
                new char[][]{{'o'}}, 
                new String[]{"o"}));
    }
}
