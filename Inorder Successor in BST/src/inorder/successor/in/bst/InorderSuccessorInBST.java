/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inorder.successor.in.bst;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

//448 · Inorder Successor in BST

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InorderSuccessorInBST {

    /**
     * @param args the command line arguments
     */
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;
        TreeNode successor=null;
        while(root!=null) {
            if(root.val>p.val) {
                successor=root;
                root=root.left;
            } else {
                root=root.right;
            }
        }
        return successor;
    }
    
    
//    ------------------OPTIMAL-----------------------
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if(root==null) return null;
//        if(root.val<=p.val) {
//            return inorderSuccessor(root.right, p);
//        }
//        TreeNode left=inorderSuccessor(root.left, p);
//        if(left==null) return root;
//        return left;
//    }
    
    public static void main(String[] args) {
        InorderSuccessorInBST i=new InorderSuccessorInBST();
        TreeNode n=new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
//        TreeNode n=new TreeNode(0);
        System.out.println(i.inorderSuccessor(n, n).val);
    }
}
