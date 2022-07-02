/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populating.next.right.pointers.in.each.node;

/**
 *
 * @author wimukthirajapaksha
 */
public class PopulatingNextRightPointersInEachNode {

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
    
//    -----------------ALTERNATE -> ITERATIVE----------------------
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Node curr=root;
//        while(curr!=null && curr.left!=null) {
//            Node temp=curr;
//            while(temp!=null) {
//                temp.left.next=temp.right;
//                if(temp.next!=null) temp.right.next=temp.next.left;
//                temp=temp.next;
//            }
//            curr=curr.left;
//        }
//        return root;
//    }
    
    
//    -----------------ALTERNATE -> ITERATIVE----------------------
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Node curr=root;
//        while(curr!=null && curr.left!=null) {
//            Node temp=curr;
//            Node prev=null;
//            while(temp!=null) {
//                if(prev!=null) prev.next=temp.left;
//                temp.left.next=temp.right;
//                prev=temp.right;
//                temp=temp.next;
//            }
//            curr=curr.left;
//        }
//        return root;
//    }
    
    
    
    
//    -----------------ALTERNATE -> RECURSIVE----------------------
//    public Node connect(Node root) {
//        if(root==null) return root;
//        connect(root.left);
//        connect(root.right);
//        root.next=null;
//        Node tempLeft=root.left;
//        Node tempRight=root.right;
//        while(tempLeft!=null && tempRight!=null) {
//            tempLeft.next=tempRight;
//            tempLeft=tempLeft.right;
//            tempRight=tempRight.left;
//        }
//        return root;
//    }
    
    
    
    public Node connect(Node root) {
        if(root==null || root.left==null) return root;
        root.left.next=root.right;
        if(root.next!=null) root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
    
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode p=new PopulatingNextRightPointersInEachNode();
        Node n=new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);
//        Node n=new Node(1, new Node(2), new Node(3), null);
        p.connect(n);
        while(n!=null) {
            System.out.print(n.val+" ");
            Node temp=n;
            while(temp.next!=null) {
                temp=temp.next;
                System.out.print(temp.val+" ");
            }
            n=n.left;
            System.out.println();
        }
    }
}
