/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowest.common.ancestor.of.a.binary.search.tree;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
//    --------------------ITERATIVE------------------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val>p.val && root.val>q.val) {
                root=root.left;
            } else if (root.val<p.val && root.val<q.val) {
                root=root.right;
            } else {
                return root;
            }
        }
    }
    
    
//    ----------------------RECURSIVE---------------------
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.val<p.val && root.val<q.val) {
//            return lowestCommonAncestor(root.right, p, q);
//        } else if (root.val>p.val && root.val>q.val) {
//            return lowestCommonAncestor(root.left, p, q);
//        }
//        return root;
//    }
    
    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree l=new LowestCommonAncestorOfABinarySearchTree();
    }
}
