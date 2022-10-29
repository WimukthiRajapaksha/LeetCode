/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.good.nodes.in.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountGoodNodesInBinaryTree {

    static class TreeNode {
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
    
//    ----------------------------OPTIMAL -> DFS--------------------------------
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int max) {
        if(root==null) return 0;
        int c = dfs(root.left, Math.max(root.val, max))+dfs(root.right, Math.max(root.val, max));
        return root.val>=max ? c+1 : c;
    }
    
    
    
//    ----------------------------OPTIMAL -> DFS--------------------------------
//    public int goodNodes(TreeNode root) {
//        if(root==null) return 0;
//        return dfs(root, root.val);
//    }
//    
//    private int dfs(TreeNode root, int max) {
//        if(root==null) return 0;
//        int c = root.val>=max ? 1 : 0;
//        c+=dfs(root.left, Math.max(root.val, max))+dfs(root.right, Math.max(root.val, max));
//        return c;
//    }
    
    
    
    
    
////    ----------------------------OPTIMAL -> BFS--------------------------------
//    class Node {
//        TreeNode node;
//        int max;
//
//        public Node(TreeNode node, int max) {
//            this.node = node;
//            this.max = max;
//        }
//    }
//    
//    public int goodNodes(TreeNode root) {
//        if(root==null) return 0;
//        Queue<Node> queue=new LinkedList<>();
//        queue.offer(new Node(root, root.val));
//        int count=0;
//        while(!queue.isEmpty()) {
//            Node temp=queue.poll();
//            if(temp.node.val>=temp.max) {
//                count++;
//            }
//            if(temp.node.right != null) {
//                queue.offer(new Node(temp.node.right, Math.max(temp.node.val, temp.max)));
//            }
//            if(temp.node.left != null) {
//                queue.offer(new Node(temp.node.left, Math.max(temp.node.val, temp.max)));
//            }
//        }
//        return count;
//    }
    
    public static void main(String[] args) {
        CountGoodNodesInBinaryTree c=new CountGoodNodesInBinaryTree();
        System.out.println(c.goodNodes(new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)))));
    }
}
