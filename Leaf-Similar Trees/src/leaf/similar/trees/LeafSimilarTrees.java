/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leaf.similar.trees;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */

class TreeNode {
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

    @Override
    public String toString() {
        return val+" ";
    }
}

public class LeafSimilarTrees {

    /**
     * @param args the command line arguments
     */
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(traverse(s1)!=traverse(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    
    private int traverse(Stack<TreeNode> s) {
        while(!s.isEmpty()) {
            TreeNode temp=s.pop();
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
            if(temp.left==null && temp.right==null) return temp.val;
        }
        return -1;
    }
    
    
    
//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        List<TreeNode> lf=new ArrayList<>();
//        List<TreeNode> ls=new ArrayList<>();
//        traverse(root1, lf);
//        traverse(root2, ls);
//        System.out.println(lf);
//        System.out.println(ls);
//        if(lf.size()!=ls.size()) return false;
//        for(int i=0; i<lf.size(); i++) {
//            if(lf.get(i).val!=ls.get(i).val) return false;
//        }
//        return true;
//    }
//    
//    private void traverse(TreeNode root, List<TreeNode> l) {
//        if(root==null) return;
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()) {
//            TreeNode temp=stack.pop();
//            if(temp.left==null && temp.right==null) {
//                l.add(temp);
//            }
//            if(temp.right!=null) stack.push(temp.right);
//            if(temp.left!=null) stack.push(temp.left);
//        }
//    }
    
    
//    ----------------------OPTIMAL -> O(T1+T2), O(T1+T2)---------------------
//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        List<TreeNode> lf=new ArrayList<>();
//        List<TreeNode> ls=new ArrayList<>();
//        traverse(root1, lf);
//        traverse(root2, ls);
//        System.out.println(lf);
//        System.out.println(ls);
//        if(lf.size()!=ls.size()) return false;
//        for(int i=0; i<lf.size(); i++) {
//            if(lf.get(i).val!=ls.get(i).val) return false;
//        }
//        return true;
//    }
//    
//    private void traverse(TreeNode root, List<TreeNode> l) {
//        if(root==null) return;
//        traverse(root.left, l);
//        if(root.left==null && root.right==null) {
//            l.add(root);
//            return;
//        }
//        traverse(root.right, l);
//    }
    
    public static void main(String[] args) {
        LeafSimilarTrees l=new LeafSimilarTrees();
        System.out.println(l.leafSimilar(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)), 
                new TreeNode(5, new TreeNode(2), new TreeNode(3))
        ));
    }
}
