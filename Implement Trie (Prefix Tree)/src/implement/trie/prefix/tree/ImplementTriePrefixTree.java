/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.trie.prefix.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class ImplementTriePrefixTree {

    /**
     * @param args the command line arguments
     */
    
    class Trie {
        class TrieNode {
            private TrieNode[] arr;
            private boolean end;

            public TrieNode() {
                this.arr=new TrieNode[26];
            }
            
            public TrieNode getNode(char c) {
                return this.arr[c-'a'];
            }
            
            public TrieNode addNode(char c) {
                if(this.arr[c-'a']!=null) return this.arr[c-'a'];
                this.arr[c-'a']=new TrieNode();
                return this.arr[c-'a'];
            }
            
            public void setEnd() {
                this.end=true;
            }
            
            public boolean isEnd() {
                return this.end;
            }
        }
        
        TrieNode root;
        public Trie() {
            root=new TrieNode();
        }

        public void insert(String word) {
            TrieNode current=root;
            for(char c: word.toCharArray()) {
                current=current.addNode(c);
            }
            current.setEnd();
        }

        public boolean search(String word) {
            TrieNode current=root;
            for(char c: word.toCharArray()) {
                current=current.getNode(c);
                if(current==null) return false;
            }
            return current.isEnd();
        }

        public boolean startsWith(String prefix) {
            TrieNode current=root;
            for(char c: prefix.toCharArray()) {
                current=current.getNode(c);
                if(current==null) return false;
            }
            return true;
        }
    }
    
    
//    --------------------ALTERNATE -> OPTIMAL----------------
//    class Trie {
//        class TrieNode {
//            TrieNode[] arr=new TrieNode[26];
//            boolean end;
//        }
//        
//        TrieNode root;
//        public Trie() {
//            root=new TrieNode();
//        }
//
//        public void insert(String word) {
//            TrieNode current=root;
//            for(char c: word.toCharArray()) {
//                if(current.arr[c-'a']==null) {
//                    current.arr[c-'a']=new TrieNode();
//                }
//                current=current.arr[c-'a'];
//            }
//            current.end=true;
//        }
//
//        public boolean search(String word) {
//            TrieNode current=root;
//            for(char c: word.toCharArray()) {
//                if(current.arr[c-'a']==null) return false;
//                current=current.arr[c-'a'];
//            }
//            return current.end;
//        }
//
//        public boolean startsWith(String prefix) {
//            TrieNode current=root;
//            for(char c: prefix.toCharArray()) {
//                if(current.arr[c-'a']==null) return false;
//                current=current.arr[c-'a'];
//            }
//            return true;
//        }
//    }
    
    public static void main(String[] args) {
    }
}
