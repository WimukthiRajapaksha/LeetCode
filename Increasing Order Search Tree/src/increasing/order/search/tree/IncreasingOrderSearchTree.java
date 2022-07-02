/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package increasing.order.search.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class IncreasingOrderSearchTree {

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
    
    TreeNode curr=null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp=new TreeNode();
        curr=temp;
        inorder(root);
        return temp.right;
    }
    
    private void inorder(TreeNode node) {
        if(node==null) return;
        inorder(node.left);
        node.left=null;
        curr.right=node;
        curr=node;
        inorder(node.right);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
