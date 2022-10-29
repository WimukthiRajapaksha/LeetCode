/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowest.common.ancestor.of.a.binary.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * @param args the command line arguments
     */
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
//    ----------------OPTIMAL -> O(N) -> O(N)------------------------
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null || root==p || root==q) return root;
//        TreeNode left=lowestCommonAncestor(root.left, p, q);
//        TreeNode right=lowestCommonAncestor(root.right, p, q);
//        if(left==null) return right;
//        if(right==null) return left;
//        return root;
//    }
    
    
//    ----------------OPTIMAL -> O(N) -> O(N)------------------------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
    
    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree l=new LowestCommonAncestorOfABinaryTree();
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(5);
        node.right=new TreeNode(1);
        node.left.left=new TreeNode(6);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(7);
        node.left.right.right=new TreeNode(4);
        node.right.left=new TreeNode(0);
        node.right.right=new TreeNode(8);
        System.out.println(l.lowestCommonAncestor(node, node.left, node.right.right).val);
        System.out.println(l.lowestCommonAncestor(node, node.left, node.left.right.right).val);
        
        TreeNode n=new TreeNode(1);
        n.left=new TreeNode(2);
        System.out.println(l.lowestCommonAncestor(n, n, n.left).val);
    }
}
