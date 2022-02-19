/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path.sum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

/**
 *
 * @author wimukthirajapaksha
 */
public class PathSum {

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
    
//    ------------------ALTERNATE - ITERATIVE -> CHECK THIS LATER, DIDN'T UNDERSTAND THATMUCH-----------------------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre=null;
//        TreeNode curr=root;
//        int sum=0;
//        while(curr!=null || !stack.isEmpty()) {
//            while(curr!=null) {
//                stack.push(curr);
//                sum+=curr.val;
//                curr=curr.left;
//            }
//            curr=stack.peek();
//            if (curr.left==null && curr.right==null && sum==targetSum) {
//                return true;
//            }
//            if (curr.right!=null && pre!=curr.right) {
//                curr=curr.right;
//            } else {
//                pre=curr;
//                stack.pop();
//                sum-=curr.val;
//                curr=null;
//            }
//        }
//        return false;
//    }
    
//    ------------------ALTERNATE - ITERATIVE -> CHANGING NODE VALUE INPLACE AND STORING IN QUEUE-----------------------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.left==null && node.right==null) {
//                if (node.val==targetSum) {
//                    return true;
//                }
//            }
//            if (node.right!=null) {
//                node.right.val+=node.val;
//                queue.offer(node.right);
//            }
//            if (node.left!=null) {
//                node.left.val+=node.val;
//                queue.offer(node.left);
//            }
//        }
//        return false;
//    }
    
//    ------------------ALTERNATE - ITERATIVE -> USING TWO STACKS-----------------------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> stackVal = new Stack<>();
//        stack.push(root);
//        stackVal.push(root.val);
//        while(!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            int val = stackVal.pop();
//            if (node.left==null && node.right==null && val==targetSum) {
//                return true;
//            }
//            if (node.right!=null) {
//                stack.push(node.right);
//                stackVal.push(val+node.right.val);
//            }
//            if (node.left!=null) {
//                stack.push(node.left);
//                stackVal.push(val+node.left.val);
//            }
//        }
//        return false;
//    }
    
//    ------------------ALTERNATE - ITERATIVE-----------------------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        }
//        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//        queue.offer(new Pair<>(root, targetSum-root.val));
//        while(!queue.isEmpty()) {
//            Pair<TreeNode, Integer> node = queue.poll();
//            System.out.println(node.getKey().val+" "+node.getValue());
//            if (node.getValue()==0 && node.getKey().left==null && node.getKey().right==null) {
//                return true;
//            }
//            if (node.getKey().left!=null) {
//                queue.offer(new Pair<>(node.getKey().left, node.getValue()-node.getKey().left.val));
//            }
//            if (node.getKey().right!=null) {
//                queue.offer(new Pair<>(node.getKey().right, node.getValue()-node.getKey().right.val));
//            }
//        }
//        return false;
//    }
    
//    --------------------ALTERNATE - RECURSIVE---------------------------------
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null)  return false;
        if (root.left==null && root.right==null)  return (root.val==targetSum);
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
    
//    ----------------------ALTERNATE - RECURSIVE - DON'T THINK MAKE SENSE THAN PREVIOUS ONE-------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        } 
//        if (root.left==null && root.right==null) {
//            return (root.val==targetSum);
//        }
//        if (root.left!=null && hasPathSum(root.left, targetSum-root.val)) {
//            return true;
//        }
//        if (root.right!=null && hasPathSum(root.right, targetSum-root.val)) {
//            return true;
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        PathSum p = new PathSum();
        boolean ss = p.hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22);
        System.out.println(ss);
//        boolean s = p.hasPathSum(new TreeNode(1, new TreeNode(2), null), 2);
//        System.out.println(s);
    }
}
