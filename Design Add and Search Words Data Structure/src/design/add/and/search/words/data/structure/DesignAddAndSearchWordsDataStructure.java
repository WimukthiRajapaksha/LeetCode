/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design.add.and.search.words.data.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class DesignAddAndSearchWordsDataStructure {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL------------------------
    class WordDictionary {
        class Node {
            Node[] array;
            boolean end;

            public Node() {
                this.array = new Node[26];
                this.end = false;
            }
            
            public Node addChar(char c) {
                if(this.array[c-'a']==null) this.array[c-'a']=new Node();
                return this.array[c-'a'];
            }
            
            public Node searchChar(char c) {
                return this.array[c-'a'];
            }
            
            public List<Node> searchDot() {
                List<Node> list=new ArrayList<>();
                for(Node n: this.array) {
                    if(n!=null) list.add(n);
                }
                return list;
            }
            
            public void setEnd() {
                this.end = true;
            }
            
            public boolean isEnd() {
                return this.end;
            }
        }
        
        Node root;
        
        public WordDictionary() {
            root=new Node();
        }

        public void addWord(String word) {
            Node temp=this.root;
            for(char c: word.toCharArray()) {
                temp=temp.addChar(c);
            }
            temp.setEnd();
        }

        public boolean search(String word) {
            return search(root, word, 0);
        }
        
        private boolean search(Node node, String word, int j) {
            if(j==word.length()) return node.isEnd();
            if(word.charAt(j)=='.') {
                List<Node> arr=node.searchDot();
                for(Node n: arr) {
                    if(search(n, word, j+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return (node.searchChar(word.charAt(j))!=null && search(node.array[word.charAt(j)-'a'], word, j+1));
            }
        }
    }
    
    
    
//    ---------------------ALTERNATE -> OPTIMAL------------------------
//    class WordDictionary {
//        class Node {
//            Node[] array;
//            boolean end;
//
//            public Node() {
//                this.array = new Node[26];
//                this.end = false;
//            }
//            
//            public Node addChar(char c) {
//                if(this.array[c-'a']==null) this.array[c-'a']=new Node();
//                return this.array[c-'a'];
//            }
//            
//            public Node searchChar(char c) {
//                return this.array[c-'a'];
//            }
//            
//            public List<Node> searchDot() {
//                List<Node> list=new ArrayList<>();
//                for(Node n: this.array) {
//                    if(n!=null) list.add(n);
//                }
//                return list;
//            }
//            
//            public void setEnd() {
//                this.end = true;
//            }
//            
//            public boolean isEnd() {
//                return this.end;
//            }
//        }
//        
//        Node root;
//        
//        public WordDictionary() {
//            root=new Node();
//        }
//
//        public void addWord(String word) {
//            Node temp=this.root;
//            for(char c: word.toCharArray()) {
//                temp=temp.addChar(c);
//            }
//            temp.setEnd();
//        }
//
//        public boolean search(String word) {
//            return search(root, word, 0);
//        }
//        
//        private boolean search(Node node, String word, int j) {
//            for(int i=j; i<word.length(); i++) {
//                if(word.charAt(i)=='.') {
//                    List<Node> arr=node.searchDot();
//                    for(Node n: arr) {
//                        if(search(n, word, i+1)) {
//                            return true;
//                        }
//                    }
//                    return false;
//                } else {
//                    node=node.searchChar(word.charAt(i));
//                    if(node==null) {
//                        return false;
//                    }
//                }
//            }
//            return node.isEnd();
//        }
//    }
    
    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure.WordDictionary d=new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        d.addWord("a");
        d.addWord("a");
//        System.out.println(d.root);
        System.out.println(d.search("a"));
        System.out.println(d.search("."));
        System.out.println(d.search("aa"));
        System.out.println(d.search("a"));
        System.out.println(d.search(".a"));
        System.out.println(d.search("a."));
    }
}
