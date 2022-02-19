/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.depth.of.binary.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumDepthOfBinaryTree {

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
    
    public int maxDepth(TreeNode root) {
        return (root==null) ? 0 :Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    
//    ----------------------------ALTERNATE -> ITERATIVE, ONLY USING ONE QUEUE------------------------
//    public int maxDepth(TreeNode root) {
//        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        Pair<TreeNode, Integer> pair = new Pair(root, 1);
//        queue.add(pair);
//        int max = Integer.MIN_VALUE;
//        while(!queue.isEmpty()) {
//            Pair<TreeNode, Integer> node = queue.poll();
//            if (node.getKey()!=null) {
//                queue.add(new Pair(node.getKey().left, node.getValue()+1));
//                queue.add(new Pair(node.getKey().right, node.getValue()+1));
//            } else {
//                max = Math.max(max, node.getValue());
//            }
//        }
//        return max-1;
//    }
    
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        System.out.println(m.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
