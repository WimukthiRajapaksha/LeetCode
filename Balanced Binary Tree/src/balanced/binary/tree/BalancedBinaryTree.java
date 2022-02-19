/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanced.binary.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BalancedBinaryTree {

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
    
    public int balance(TreeNode node) {
        if (node==null) {
            return 0;
        }
        int left = balance(node.left);
        int right = balance(node.right);
        if (left==-1 || right==-1 || Math.abs(left-right)>1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return balance(root)!=-1;
    }

    
//    --------------------ALTERNATE - ITERATIVE---------------------------------
//    public boolean isBalanced(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Map<TreeNode, Integer> map = new HashMap<>();
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if ((node.left==null || (node.left!=null && map.containsKey(node.left))) && (node.right==null || (node.right!=null && map.containsKey(node.right)))) {
//                int right = (node.right==null) ? 0 : map.get(node.right);
//                int left = (node.left==null) ? 0 : map.get(node.left);
//                if (Math.abs(right-left)>1) {
//                    return false;
//                } else {
//                    map.put(node, Math.max(right, left)+1);
//                }
//            } else {
//                if (node.left!=null && !map.containsKey(node.left)) {
//                    stack.push(node);
//                    stack.push(node.left);
//                } else {
//                    stack.push(node);
//                    stack.push(node.right);
//                }
//            }
//        }
//        return true;
//    }
    
    
//    --------------------ALTERNATE - RECURSIVE - NOT OPTIMAL AS HEIGHT IS RECALCULATED FOR EACH----------------
//    public int height(TreeNode node) {
//        if(node==null) {
//            return 0;
//        }
//        return Math.max(height(node.left), height(node.right))+1;
//    }
//    
//    public boolean isBalanced(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left)-height(root.right))<=1);
//    }
    
    public static void main(String[] args) {
        BalancedBinaryTree b = new BalancedBinaryTree();
        boolean v = b.isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        System.out.println(v);
        v = b.isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2)));
        System.out.println(v);
        
        v = b.isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null)));
        System.out.println(v);
    }
}
