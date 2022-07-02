/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path.sum.ii;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class PathSumII {

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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        backtrack(list, new ArrayList<>(), root, targetSum);
        System.out.println(list);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> l, TreeNode node, int t) {
        l.add(node.val);
        if(node.left==null && node.right==null) {
            if(node.val==t) {
                list.add(new ArrayList<>(l));
                l.remove(l.size()-1);
            }
            return;
        }
        if(node.left!=null) backtrack(list, l, node.left, t-node.val);
        if(node.right!=null) backtrack(list, l, node.right, t-node.val);
        l.remove(l.size()-1);
    }
    
    public static void main(String[] args) {
        PathSumII p=new PathSumII();
        p.pathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 4);
    }
}
