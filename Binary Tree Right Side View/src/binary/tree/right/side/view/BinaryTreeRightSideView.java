/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.right.side.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreeRightSideView {

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
    
    
//    ----------------------OPTIMAL -> RECURSIVE-------------------------
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }
    
    private void dfs(List<Integer> list, TreeNode n, int l) {
        if(n==null) return;
        if(list.size()==l) {
            list.add(n.val);
        }
        dfs(list, n.right, l+1);
        dfs(list, n.left, l+1);
    }
    
    
    
//    ---------------------------OPTIMAL -> ITERATIVE---------------------
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        if(root==null) return list;
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()) {
//            int s=q.size();
//            while(s>0) {
//                TreeNode n=q.poll();
//                if(s==1) {
//                    list.add(n.val);
//                }
//                if(n.left!=null) {
//                    q.offer(n.left);
//                }
//                if(n.right!=null) {
//                    q.offer(n.right);
//                }
//                s--;
//            }
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        
    }
}
