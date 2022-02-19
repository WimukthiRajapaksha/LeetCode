/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.inorder.traversal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreeInorderTraversal {

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
    
    public List<Integer> inorderTraversal(TreeNode root) {
//        ----------------------ALTERNATES--------------------------
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> list = new ArrayList<>();
//        TreeNode current=root;
//        while(!stack.isEmpty() || current!=null) {
//            while(current!=null) {
//                stack.push(current);
//                current=current.left;
//            }
//            current = stack.pop();
//            current=current.right;
//            list.add(current.val);
//        }
//        return list;
        
        


        List<Integer> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        TreeNode current = root;
        TreeNode temp;
        while(current != null) {
            if (current.left==null) {
                list.add(current.val);
                current = current.right;
            } else {
                temp = current.left;
                while(temp.right!=null && temp.right!=current) {
                    temp=temp.right;
                }
                if (temp.right==null) {
                    temp.right=current;
                    current=current.left;
                } else {
                    temp.right=null;
                    list.add(current.val);
                    current=current.right;
                }
            }
        }
        return list;
    }
    
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//        while(!stack.isEmpty() || current != null) {
//            if (current == null) {
//                TreeNode temp = stack.pop();
//                list.add(temp.val);
//                current = temp.right;
//            } else {
//                stack.push(current);
//                current=current.left;
//            }
//        }
//        return list;
//    }
    
//    ------------------------RECURSIVE -> MORE MEMORY USAGE------------------------
//    public void print(TreeNode node, List<Integer> list) {
//        if (node == null) {
//            return;
//        }
//        print(node.left, list);
//        list.add(node.val);
//        print(node.right, list);
//    }
//    
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> a = new ArrayList<>();
//        print(root, a);
//        return a;
//    }
    
    public static void main(String[] args) {
        
    }
}
