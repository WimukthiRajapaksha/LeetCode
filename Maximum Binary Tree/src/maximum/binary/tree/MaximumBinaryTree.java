/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.binary.tree;

import java.util.Deque;
import java.util.LinkedList;
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
        return this.left+" "+this.val+" "+this.right;
    }
}

public class MaximumBinaryTree {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------------OPTIMAL -> O(N), O(N)--------------
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        for(int i: nums) {
            TreeNode curr=new TreeNode(i);
            while(!linkedList.isEmpty() && linkedList.getLast().val<curr.val) {
                curr.left=linkedList.removeLast();
            }
            if(!linkedList.isEmpty()) {
                linkedList.getLast().right=curr;
            }
            linkedList.add(curr);
        }
        return linkedList.removeFirst();
    }
    
    
    
    
//    --------------------OPTIMAL -> O(N), O(N)--------------
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if(nums.length==0) return null;
//        Stack<TreeNode> stack=new Stack<>();
//        for(int i: nums) {
//            TreeNode curr=new TreeNode(i);
//            while(!stack.isEmpty() && stack.peek().val<curr.val) {
//                curr.left=stack.pop();
//            }
//            if(!stack.isEmpty()) {
//                stack.peek().right=curr;
//            }
//            stack.push(curr);
//        }
//        return stack.remove(0);
//    }
    
    
    
    
//    --------------------GOOD SOLUTION -> O(N^2), O(N^2) -> AVG O(NLOGN), O(NLOGN)--------------
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if(nums.length==0) return null;
//        Stack<TreeNode> stack=new Stack<>();
//        for(int i: nums) {
//            TreeNode curr=new TreeNode(i);
//            while(!stack.isEmpty() && stack.peek().val<curr.val) {
//                curr.left=stack.pop();
//            }
//            if(!stack.isEmpty()) {
//                stack.peek().right=curr;
//            }
//            stack.push(curr);
//        }
//        return stack.remove(0);
//    }
//    
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return dfs(nums, 0, nums.length-1);
//    }
//    
//    private TreeNode dfs(int[] nums, int l, int r) {
//        if(l>r) return null;
//        int m=l;
//        for(int i=l; i<r; i++) {
//            if(nums[m]<nums[i]) {
//                m=i;
//            }
//        }
//        return new TreeNode(nums[m], dfs(nums, l, m-1), dfs(nums, m+1, r));
//    }
    
    private void print(TreeNode n) {
        if(n==null) return;
        print(n.left);
        System.out.print(" "+n.val+" ");
        print(n.right);
    }
    
    public static void main(String[] args) {
        MaximumBinaryTree m=new MaximumBinaryTree();
        m.print(m.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }
}
