/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.sorted.array.to.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConvertSortedArrayToBinarySearchTree {

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
    
    public int height(TreeNode node) {
        if (node==null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right))+1;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return node(nums, 0, nums.length-1);
    }
    
    public TreeNode node(int[] nums, int start, int end) {
        System.out.println(start+" "+end+" "+((start+end)/2)+" "+nums[(start+end)/2]);
        if (start>end) {
            return null;
        }
        return new TreeNode(nums[(start+end)/2], node(nums, start, ((start+end)/2)-1), node(nums, ((start+end)/2)+1, end));
    }
    
    
//    ---------------------ALTERNATE - ITERATIVE METHOD-------------------------
//    private class Node {
//        TreeNode item;
//        int left;
//        int right;
//
//        public Node(TreeNode item, int left, int right) {
//            this.item = item;
//            this.left = left;
//            this.right = right;
//        }
//    }
//    
//    public TreeNode sortedArrayToBST(int[] nums) {
//        Queue<Node> queue=new LinkedList<>();
//        TreeNode node = new TreeNode(nums[(nums.length-1)/2]);
//        queue.add(new Node(node, 0, nums.length-1));
//        
//        while(!queue.isEmpty()) {
//            Node temp = queue.poll();
//            int mid = (temp.left+temp.right)/2;
//            if (temp.left<mid) {
//                temp.item.left = new TreeNode(nums[(temp.left+mid-1)/2]);
//                queue.add(new Node(temp.item.left,  temp.left, mid-1));
//            }
//            if (temp.right>mid) {
//                temp.item.right = new TreeNode(nums[(mid+1+temp.right)/2]);
//                queue.add(new Node(temp.item.right, mid+1, temp.right));
//            }
//        }
//        return node;
//    }
    
    public void print(TreeNode node) {
        if (node==null) {
            return;
        }
        print(node.left);
        System.out.print(node.val+" ");
        print(node.right);
    }
    
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
//        TreeNode node = c.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        TreeNode node = c.sortedArrayToBST(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13});
        System.out.println(node.val+" ----"+" "+node.left.val+" "+node.right.val);
        c.print(node);
    }
}
