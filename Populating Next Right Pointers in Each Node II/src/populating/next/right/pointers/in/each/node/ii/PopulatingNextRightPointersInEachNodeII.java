/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populating.next.right.pointers.in.each.node.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * @param args the command line arguments
     */
    
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left!=null) {
            if(root.right!=null) root.left.next=root.right;
            else root.left.next=findNext(root.next);
        }
        if(root.right!=null) {
            root.right.next=findNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    
    public Node findNext(Node node) {
        while(node!=null) {
            if(node.left!=null) return node.left;
            if(node.right!=null) return node.right;
            node=node.next;
        }
        return null;
    }
    
    
//    public Node connect(Node root) {
//        Node current=root;
//        while(current!=null) {
//            Node dummy=new Node();
//            Node temp=dummy;
//            while(current!=null) {
//                if(current.left!=null) {
//                    temp.next=current.left;
//                    temp=temp.next;
//                }
//                if(current.right!=null) {
//                    temp.next=current.right;
//                    temp=temp.next;
//                }
//                current=current.next;
//            }
//            current=dummy.next;
//        }
//        return root;
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
