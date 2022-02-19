/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.preorder.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreePreorderTraversal {

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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n!=null) {
                list.add(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }
        return list;
    }
    
//    ------------------------ALTERNATE -> RECURSIVE----------------------------
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preOrder(root);
//        return list;
//    }
//    
//    public void preOrder(TreeNode node) {
//        if (node==null) {
//            return;
//        }
//        list.add(node.val);
//        preOrder(node.left);
//        preOrder(node.right);
//    }
    
    public static void main(String[] args) {
        
    }
}
