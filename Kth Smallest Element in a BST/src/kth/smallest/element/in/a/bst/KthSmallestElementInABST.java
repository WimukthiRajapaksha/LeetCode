/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kth.smallest.element.in.a.bst;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class KthSmallestElementInABST {

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
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                root=root.left;
            }
            k--;
            root = stack.pop();
            if(k==0) {
                return root.val;
            }
            root=root.right;
        }
        return -1;
    }
    
    
    
//    int kVal=0;
//    public int kthSmallest(TreeNode root, int k) {
//        return inorder(root, k);
//    }
//    
//    private int inorder(TreeNode root, int k) {
//        if(root==null) return 0;
//        int t=inorder(root.left, k);
//        kVal++;
//        if(kVal==k) {
//            return root.val;
//        }
//        t+=inorder(root.right, k);
//        return t;
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
