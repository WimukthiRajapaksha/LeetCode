/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clone.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class CloneGraph {

    /**
     * @param args the command line arguments
     */
    
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node, Node> map=new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node temp=queue.poll();
            for(Node n: temp.neighbors) {
                if(!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.offer(n);
                }
                map.get(temp).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
    
    
    
    
    
//    public Node cloneGraph(Node node) {
//        Map<Node, Node> map=new HashMap<>();
//        dfs(node, map);
//        return map.get(node);
//    }
//    
//    private void dfs(Node node, Map<Node, Node> map) {
//        if(node==null) return;
//        if(map.containsKey(node)) {
//            return;
//        }
//        map.put(node, new Node(node.val));
//        for(Node n: node.neighbors) {
//            dfs(n, map);
//            map.get(node).neighbors.add(map.get(n));
//        }
//    }
    
    
    
    
    
//    public Node cloneGraph(Node node) {
//        Map<Node, Node> map=new HashMap<>();
//        return dfs(node, map);
//    }
//    
//    private Node dfs(Node node, Map<Node, Node> map) {
//        if(node==null) return null;
//        if(map.containsKey(node)) {
//            return map.get(node);
//        }
//        Node temp=new Node(node.val);
//        map.put(node, temp);
//        for(Node n: node.neighbors) {
//            temp.neighbors.add(dfs(n, map));
//        }
//        return temp;
//    }
    
    public static void main(String[] args) {
        CloneGraph c=new CloneGraph();
    }
}
