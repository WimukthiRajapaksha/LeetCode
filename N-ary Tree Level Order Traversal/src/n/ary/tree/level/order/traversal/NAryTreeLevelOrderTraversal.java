/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.ary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class NAryTreeLevelOrderTraversal {

    /**
     * @param args the command line arguments
     */
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    
//    ------------------OPTIMAL -> BFS---------------------
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> l=new ArrayList<>();
            while(size>0) {
                Node n=queue.poll();
                l.add(n.val);
                for(Node c: n.children) {
                    if(c!=null) queue.offer(c);
                }
                size--;
            }
            list.add(l);
        }
        return list;
    }
    
    
//    ----------------------OPTIMAL -> DFS---------------------
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> list=new ArrayList<>();
//        help(list, root, 0);
//        return list;
//    }
//    
//    private void help(List<List<Integer>> list, Node n, int l) {
//        if(n==null) return;
//        if(list.size()==l) {
//            list.add(new ArrayList<>());
//        }
//        list.get(l).add(n.val);
//        for(Node no: n.children) {
//            help(list, no, l+1);
//        }
//    }
    
    public static void main(String[] args) {
        NAryTreeLevelOrderTraversal n=new NAryTreeLevelOrderTraversal();
    }
}
