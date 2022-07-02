/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.in.a.binary.search.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class SearchInABinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        }
        while(root!=null) {
            if(root.val==val) return root;
            else if(root.val<val) root=root.right;
            else root=root.left;
        }
        return null;
    }
    
    
    
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root==null) {
//            return null;
//        }
//        if(val==root.val) {
//            return root;
//        } else if(val<root.val) {
//            return searchBST(root.left, val);
//        }
//        return searchBST(root.right, val);
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
