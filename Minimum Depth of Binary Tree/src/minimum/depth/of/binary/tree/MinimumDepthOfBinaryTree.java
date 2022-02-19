/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.depth.of.binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumDepthOfBinaryTree {

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
    
//    ----------------------ITERATIVE -> REMOVE ALL THE NODES IN SAME LEVEL IN ONE ITERATION AND CALCULATE HEIGHT-----------
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int hei=1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left==null && node.right==null) {
                    System.out.println(hei);
                    return hei;
                } 
                if (node.left!=null) {
                    queue.offer(node.left);
                } 
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            hei++;
        }
        return hei;
    }
    
//    ------------ALTERNATE - USING QUEUE WITH TREENODE, CALCULATE WIDTH MATHEMATICALLY--------------
//    public int minDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth=1;
//        int preWidth=1;
//        int nextWidth=0;
//        while(queue.peek().left!=null || queue.peek().right!=null) {
//            TreeNode pair = queue.poll();
//            preWidth--;
//            if (pair.left!=null) {
//                queue.offer(pair.left);
//                nextWidth++;
//            }
//            if (pair.right!=null) {
//                queue.offer(pair.right);
//                nextWidth++;
//            }
//            if (preWidth==0) {
//                preWidth=nextWidth;
//                nextWidth=0;
//                depth++;
//            }
//        }
//        return depth;
//    }
    
//    --------------------ALTERNATE - ITERATIVE - USING QUEUE WITH PAIR---------
//    public int minDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        }
//        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        queue.offer(new Pair<>(root, 1));
//        while(queue.peek().getKey().left!=null || queue.peek().getKey().right!=null) {
//            Pair<TreeNode, Integer> pair = queue.poll();
//            if (pair.getKey().left!=null) {
//                queue.offer(new Pair<>(pair.getKey().left, pair.getValue()+1));
//            }
//            if (pair.getKey().right!=null) {
//                queue.offer(new Pair<>(pair.getKey().right, pair.getValue()+1));
//            }
//        }
//        System.out.println(queue.peek().getValue());
//        return queue.peek().getValue();
//    }
    
//    -----------------ALTERNATE - RECURSIVE APPROACH - NOT OPTIMAL-------------
//    public int minDepth(TreeNode root) {
//        if (root==null) return 0;
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//        return (left==0 || right==0)? left+right+1 : Math.min(left, right)+1;
//    }
    
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
        m.minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        m.minDepth(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))))));
    }
}
