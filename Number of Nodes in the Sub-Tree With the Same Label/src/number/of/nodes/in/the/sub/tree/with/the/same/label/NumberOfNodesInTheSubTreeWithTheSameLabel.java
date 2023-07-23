/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.nodes.in.the.sub.tree.with.the.same.label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    /**
     * @param args the command line arguments
     */
    
//    public class Node {
//        int i;
//        char c;
//        char[] arr;
//        List<Node> child;
//
//        public Node(char c, int i) {
//            this.i=i;
//            this.c = c;
//            this.arr = new char[26];
//            this.child = new ArrayList<>();
//        }    
//
//        @Override
//        public String toString() {
//            return i+" "+c+" "+Arrays.toString(arr);
//        }
//    }
//    
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        List<Integer>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] e: edges) {
//            graph[e[0]].add(e[1]);
//            graph[e[1]].add(e[0]);
//        }
//        for(List<Integer> g: graph) {
//            System.out.println(g);
//        }
//        boolean[] visited=new boolean[n];
//        visited[0]=true;
//        Node root=generate(graph, visited, 0, labels);
//        System.out.println(root);
//        int[] ret=new int[n];
//        calc(root, ret);
//        return ret;
//    }
//    
//    private void calc(Node node, int[] count) {
//        count[node.i]=node.arr[node.c-'a'];
//        for(Node n: node.child) {
//            calc(n, count);
//        }
//    }
//    
//    private Node generate(List<Integer>[] graph, boolean[] visited, int i, String s) {
//        Node node=new Node(s.charAt(i), i);
//        for(int j: graph[i]) {
//            if(visited[j]) continue;
//            visited[j]=true;
//            node.child.add(generate(graph, visited, j, s));
//        }
//        node.arr[s.charAt(i)-'a']++;
//        for(Node n: node.child) {
//            for(int j=0; j<n.arr.length; j++) {
//                node.arr[j]+=n.arr[j];
//            }
//        }
//        System.out.println(node);
//        return node;
//    }
    
    
//    public class Node {
//        int i;
//        int[] arr;
//        List<Node> child;
//
//        public Node(int i) {
//            this.i=i;
//            this.arr = new int[26];
//            this.child = new ArrayList<>();
//        }    
//
//        @Override
//        public String toString() {
//            return i+" "+Arrays.toString(arr);
//        }
//    }
//    
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        List<Integer>[] graph=new ArrayList[n];
//        for(int i=0; i<n; i++) {
//            graph[i]=new ArrayList<>();
//        }
//        for(int[] e: edges) {
//            graph[e[0]].add(e[1]);
//            graph[e[1]].add(e[0]);
//        }
//        for(List<Integer> g: graph) {
//            System.out.println(g);
//        }
//        boolean[] visited=new boolean[n];
//        visited[0]=true;
//        Node root=generate(graph, visited, 0, labels);
//        int[] ret=new int[n];
//        calc(root, ret, labels);
//        return ret;
//    }
//    
//    private void calc(Node node, int[] count, String s) {
//        count[node.i]=node.arr[s.charAt(node.i)-'a'];
//        for(Node n: node.child) {
//            calc(n, count, s);
//        }
//    }
//    
//    private Node generate(List<Integer>[] graph, boolean[] visited, int i, String s) {
//        Node node=new Node(i);
//        for(int j: graph[i]) {
//            if(visited[j]) continue;
//            visited[j]=true;
//            node.child.add(generate(graph, visited, j, s));
//        }
//        node.arr[s.charAt(i)-'a']++;
//        for(Node n: node.child) {
//            for(int j=0; j<n.arr.length; j++) {
//                node.arr[j]+=n.arr[j];
//            }
//        }
//        System.out.println(node);
//        return node;
//    }
    
    
    
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for(List<Integer> g: graph) {
            System.out.println(g);
        }
        boolean[] visited=new boolean[n];
        visited[0]=true;
        int[] answer=new int[n];
        int[] nothing=generate(graph, visited, 0, labels, answer);
        return answer;
    }
    
    private int[] generate(List<Integer>[] graph, boolean[] visited, int i, String s, int[] answer) {
        int[] ret=new int[26];
        ret[s.charAt(i)-'a']++;
        for(int j: graph[i]) {
            if(visited[j]) continue;
            visited[j]=true;
            int[] temp=generate(graph, visited, j, s, answer);
            for(int k=0; k<temp.length; k++) {
                ret[k]+=temp[k];
            }
        }
        answer[i]=ret[s.charAt(i)-'a'];
        return ret;
    }
    
    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithTheSameLabel n=new NumberOfNodesInTheSubTreeWithTheSameLabel();
        System.out.println(Arrays.toString(n.countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd")));
    }
}
