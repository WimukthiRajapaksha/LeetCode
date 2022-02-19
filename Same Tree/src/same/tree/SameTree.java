/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package same.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class SameTree {

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
    
//    ---------------------------ITERATIVE -> ONE STACKS------------------------
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        if (p!=null) s1.add(p);
        if (q!=null) s1.add(q);
        while(!s1.isEmpty()) {
            TreeNode t1 = s1.pop();
            TreeNode t2 = s1.pop();
            if (t1==null && t2==null) {
                continue;
            } else if (t1!=null && t2!=null) {
                if (t1.val!=t2.val) {
                    return false;
                }
            } else {
                return false;
            }
            s1.add(t1.left);
            s1.add(t2.left);
            s1.add(t1.right);
            s1.add(t2.right);
        }
        return true;
    }
    
//    ----------------------------RECURSIVE-------------------------------------
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p==q) {
//            return true;
//        } else if ((p==null || q==null) || (p.val!=q.val)) {
//            return false;
//        } else {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//    }
    
    
//    ---------------------------ITERATIVE -> TWO STACKS------------------------
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Stack<TreeNode> s1 = new Stack<>();
//        Stack<TreeNode> s2 = new Stack<>();
//        if (p!=null) s1.add(p);
//        if (q!=null) s2.add(q);
//        while(!s1.isEmpty() && !s2.isEmpty()) {
//            TreeNode t1 = s1.pop();
//            TreeNode t2 = s2.pop();
//            if (t1==null && t2==null) {
//                continue;
//            } else if (t1!=null && t2!=null) {
//                if (t1.val!=t2.val) {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//            s1.add(t1.left);
//            s1.add(t1.right);
//            s2.add(t2.left);
//            s2.add(t2.right);
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        SameTree t = new SameTree();
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode t2 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(t.isSameTree(t1, t2));
    }
}
