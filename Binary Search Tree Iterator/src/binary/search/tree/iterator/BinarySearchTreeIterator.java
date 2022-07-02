/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.search.tree.iterator;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

public class BinarySearchTreeIterator {

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
    
    class BSTIterator {
        Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(TreeNode root) {
            fill(root);
        }

        public int next() {
            TreeNode temp=stack.pop();
            fill(temp.right);
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        private void fill(TreeNode node) {
            while(node!=null) {
                stack.push(node);
                node=node.left;
            }
        }
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-----------------
//    class BSTIterator {
//        Stack<TreeNode> stack=new Stack<>();
//        public BSTIterator(TreeNode root) {
//            while(root!=null) {
//                stack.push(root);
//                root=root.left;
//            }            
//        }
//
//        public int next() {
//            TreeNode temp=stack.pop();
//            TreeNode t=temp.right;
//            while(t!=null) {
//                stack.push(t);
//                t=t.left;
//            }
//            return temp.val;
//        }
//
//        public boolean hasNext() {
//            return !stack.isEmpty();
//        }
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
