/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetric.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class SymmetricTree {

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
    
    public boolean symme(TreeNode t1, TreeNode t2) {
        if (t1==null || t2==null) {
            return t1==t2;
        } else if (t1.val==t2.val) {
            return symme(t1.left, t2.right) && symme(t1.right, t2.left);
        } else {
            return false;
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        return root==null || symme(root.left, root.right);
    }
    
    
    
//    ----------------------------ALTERNATE -> ITERATIVE------------------------
//    public boolean isSymmetric(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root.left);
//        stack.add(root.right);
//        while(!stack.isEmpty()) {
//            TreeNode n1 = stack.pop();
//            TreeNode n2 = stack.pop();
//            if (n1==n2) {
//                continue;
//            } else if ((n1==null || n2==null) || (n1.val != n2.val)) {
//                return false;
//            } else {
//                stack.add(n1.left);
//                stack.add(n2.right);
//                stack.add(n1.right);
//                stack.add(n2.left);
//            }
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
    }
}
