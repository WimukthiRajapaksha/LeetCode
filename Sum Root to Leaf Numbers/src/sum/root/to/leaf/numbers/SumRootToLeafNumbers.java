/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.root.to.leaf.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumRootToLeafNumbers {

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
    
    public int sumNumbers(TreeNode root) {
        int sum=0;
        int curr=0;
        while(root!=null) {
            if(root.left==null) {
                if (root.right==null) sum+=(curr*10)+root.val;
                root=root.right;
            } else {
                TreeNode temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==null) {
                    temp.right=root;
                    root=root.left;
                } else {
                    temp.right=null;
                    root=root.right;
                }
            }
        }
    }
    
    
    
    
//    public int sumNumbers(TreeNode root) {
//        return paths(root, 0);
//    }
//    
//    private int paths(TreeNode root, int tempSum) {
//        if(root==null) {
//            return 0;
//        }
//        tempSum=(tempSum*10)+root.val;
//        if(root.left==null && root.right==null) {
//            return tempSum;
//        }
//        return paths(root.left, tempSum) + paths(root.right, tempSum);
//    }
    
    public static void main(String[] args) {
        SumRootToLeafNumbers s=new SumRootToLeafNumbers();
        System.out.println(s.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}
