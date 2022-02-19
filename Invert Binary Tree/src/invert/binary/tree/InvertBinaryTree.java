/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invert.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class InvertBinaryTree {

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
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode t=queue.poll();
            TreeNode tr=t.right;
            t.right=t.left;
            t.left=tr;
            if(t.left!=null) queue.add(t.left);
            if(t.right!=null) queue.add(t.right);
        }
        return root;
    }
    
//    public TreeNode invertTree(TreeNode root) {
//        if(root==null || (root.left==null && root.right==null)) {
//            return root;
//        }
//        TreeNode t=root.right;
//        root.right=invertTree(root.left);
//        root.left=invertTree(t);
//        return root;
//    }
    
    public void print(TreeNode n) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()) {
            TreeNode t=q.poll();
            System.out.println(t.val);
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
    }
    
    public static void main(String[] args) {
        InvertBinaryTree i=new InvertBinaryTree();
        TreeNode n=i.invertTree(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7))));
        i.print(n);
    }
}
