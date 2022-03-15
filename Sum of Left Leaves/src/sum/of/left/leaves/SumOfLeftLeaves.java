/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.left.leaves;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfLeftLeaves {

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
    
//    --------------------------OPTIMAL -> ITERATIVE -> DFS--------------------
//    public int sumOfLeftLeaves(TreeNode root) {
//        Stack<TreeNode> s=new Stack<>();
//        s.add(root);
//        int r=0;
//        while(!s.isEmpty()) {
//            TreeNode t=s.pop();
//            if(t==null) continue;
//            if(t.left!=null && t.left.left==null && t.left.right==null) {
//                r+=t.left.val;
//            } else {
//                s.add(t.left);
//            }
//            s.add(t.right);
//        }
//        return r;
//    }
    
    
    
//    --------------------------OPTIMAL -> ITERATIVE -> BFS--------------------
//    public int sumOfLeftLeaves(TreeNode root) {
//        Queue<TreeNode> q=new LinkedList<>();
//        q.add(root);
//        int s=0;
//        while(!q.isEmpty()) {
//            TreeNode t=q.poll();
//            if(t==null) continue;
//            if(t.left!=null && t.left.left==null && t.left.right==null) {
//                s+=t.left.val;
//            } else {
//                q.add(t.left);
//            }
//            q.add(t.right);
//        }
//        return s;
//    }
    
    
    
//    --------------------------OPTIMAL -> RECURSIVE--------------------
//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root==null) return 0;
//        int v=sumOfLeftLeaves(root.right);
//        v+=(root.left!=null && root.left.left==null && root.left.right==null) ? root.left.val : sumOfLeftLeaves(root.left);
//        return v;
//    }
    
    
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return (root.left!=null && root.left.left==null && root.left.right==null) ? sumOfLeftLeaves(root.right)+root.left.val : sumOfLeftLeaves(root.right)+sumOfLeftLeaves(root.left);
    }
    
    public static void main(String[] args) {
        SumOfLeftLeaves s=new SumOfLeftLeaves();
        System.out.println(s.sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(
                s.sumOfLeftLeaves(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)))
        );
    }
}
