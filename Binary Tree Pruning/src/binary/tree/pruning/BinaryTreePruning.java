/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.pruning;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreePruning {

    /**
     * @param args the command line arguments
     */
    
    public static class TreeNode {
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
    
    
//    -----------------------OPTIMAL-----------------------------
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left==null && root.right==null && root.val==0 ? null : root;
    }
    
    
//    ----------------------OPTIMAL-------------------------
//    public TreeNode pruneTree(TreeNode root) {
//        if(!dfs(root)) {
//            return null;
//        }
//        return root;
//    }
//    
//    private boolean dfs(TreeNode node) {
//        if(node==null) return false;
//        if(!dfs(node.left)) {
//            node.left=null;
//        }
//        if(!dfs(node.right)) {
//            node.right=null;
//        }
//        return node.val==1 | node.left!=null | node.right!=null;
//    }
    
    private void print(TreeNode node) {
        if(node==null) {
//            System.out.print(" - ");
            return;
        }
        System.out.print(node.val+" ");
        print(node.left);
        print(node.right);
    }
    
    public static void main(String[] args) {
        BinaryTreePruning b=new BinaryTreePruning();
        TreeNode n=b.pruneTree(new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(0)), new TreeNode(1, new TreeNode(0), new TreeNode(1))));
        b.print(n);
    }
}
