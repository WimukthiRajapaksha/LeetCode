/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package range.sum.of.bst;

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
}

public class RangeSumOfBST {

    /**
     * @param args the command line arguments
     */
    
    
//    ---------------------------OPTIMAL -> O(N), O(H)---------------------
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        if(root==null) return 0;
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        int value=0;
//        while(!stack.isEmpty()) {
//            TreeNode temp=stack.pop();
//            if(low<=temp.val && temp.val<=high) {
//                value+=temp.val;
//            }
//            if(temp.right!=null && temp.val<=high) stack.push(temp.right);
//            if(temp.left!=null && low<=temp.val) stack.push(temp.left);
//        }
//        return value;
//    }
    
    
    
//    --------------------OPTIMAL -> BEAUTIFUL -> O(N), O(H)--------------
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(low>root.val) return rangeSumBST(root.right, low, high);
        else if(root.val>high) return rangeSumBST(root.left, low, high);
        return rangeSumBST(root.left, low, high)+root.val+rangeSumBST(root.right, low, high);
    }
    
    
//    --------------------OPTIMAL -> O(N), O(H)----------------------
//    public int rangeSumBST(TreeNode root, int low, int high) {
//        if(root==null) return 0;
//        if(low<=root.val && root.val<=high) {
//            return rangeSumBST(root.left, low, high)+root.val+rangeSumBST(root.right, low, high);
//        } else if(low>root.val) {
//            return rangeSumBST(root.right, low, high);
//        } else {
//            return rangeSumBST(root.right, low, high);
//        }
//    }
    
    public static void main(String[] args) {
        RangeSumOfBST r=new RangeSumOfBST();
        System.out.println(r.rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18))), 7, 15));
    }
}
