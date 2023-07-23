/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.absolute.difference.in.bst;

import java.util.ArrayList;
import java.util.List;

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

public class MinimumAbsoluteDifferenceInBST {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(N), O(1)------------------------
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        int min=Integer.MAX_VALUE;
        TreeNode pre=null;
        while(root!=null) {
            if(root.left==null) {
                if(pre!=null) {
                    min=Math.min(min, root.val-pre.val);
                }
                pre=root;
                root=root.right;
            } else {
                TreeNode temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==root) {
                    if(pre!=null) {
                        min=Math.min(min, root.val-pre.val);
                    }
                    pre=root;
                    temp.right=null;
                    root=root.right;
                } else {
                    temp.right=root;
                    root=root.left;
                }
            }
        }
        return min;
    }
    
    
//    -------------------OPTIMAL -> O(N), O(H)------------------------
//    int min=Integer.MAX_VALUE;
//    TreeNode prev=null;
//    
//    public int getMinimumDifference(TreeNode root) {
//        if(root==null) return min;
//        getMinimumDifference(root.left);
//        
//        if(prev!=null) {
//            min=Math.min(min, Math.abs(prev.val-root.val));
//        }
//        prev=root;
//        
//        getMinimumDifference(root.right);
//        return min;
//    }
    
    
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST m=new MinimumAbsoluteDifferenceInBST();
        System.out.println(m.getMinimumDifference(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
    }
}
