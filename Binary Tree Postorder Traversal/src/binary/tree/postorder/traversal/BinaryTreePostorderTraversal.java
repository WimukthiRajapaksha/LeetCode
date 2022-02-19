/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.postorder.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreePostorderTraversal {

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
    
//    -------------------------ALTERNATE -> USING LINKEDLIST & STACK------------------
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root==null) {
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.addFirst(n.val);
            if (n.left!=null) {
                stack.push(n.left);
            }
            if (n.right!=null) {
                stack.push(n.right);
            }
        }
        return list;
    }
    
//    -------------------------ALTERNATE -> USING LINKEDLIST & STACK------------------
//    public List<Integer> postorderTraversal(TreeNode root) {
//        LinkedList<Integer> list = new LinkedList<>();
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode n=root;
//        while(!stack.isEmpty() || n!=null) {
//            if (n!=null) {
//                stack.push(n);
//                list.addFirst(n.val);
//                n=n.right;
//            } else {
//                n=stack.pop();
//                n=n.left;
//            }
//        }
//        return list;
//    }
    
//    ------------------------ALTERNATE -> ITERATIVE USING TWO STACKS----------------------
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root==null) {
//            return list;
//        }
//        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
//        stack1.push(root);
//        while(!stack1.isEmpty()) {
//            TreeNode n = stack1.pop();
//            stack2.push(n);
//            if (n.left!=null) stack1.push(n.left);
//            if (n.right!=null) stack1.push(n.right);
//        }
//        while(!stack2.isEmpty()) {
//            list.add(stack2.pop().val);
//        }
//        return list;
//    }
    
    
//    ------------------------ALTERNATE -> ITERATIVE USING ONE STACK------------------------
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root==null) {
//            return list;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        TreeNode pre=null;
//        while(!stack.isEmpty()) {
//            TreeNode n = stack.peek();
//            if ((n.right!=null && pre==n.right) || (n.left!=null && n.right==null && pre==n.left) || (n.left==null && n.right==null)) {
//                pre = stack.pop();
//                list.add(pre.val);
//                continue;
//            }
//            if (n.right!=null) stack.push(n.right);
//            if (n.left!=null) stack.push(n.left);
//        }
//        System.out.println(list);
//        return list;
//    }
    
//    ---------------------------ALTERNATE -> RECURSIVE-------------------------
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        post(root, list);
//        return list;
//    }
//    
//    public void post(TreeNode n, List<Integer> l) {
//        if (n==null) {
//            return;
//        }
//        post(n.left, l);
//        post(n.right, l);
//        l.add(n.val);
//    }
    
    public static void main(String[] args) {
        BinaryTreePostorderTraversal b=new BinaryTreePostorderTraversal();
        b.postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
        
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(7);
        result.addFirst(9);
        System.out.println(result);
    }
}
