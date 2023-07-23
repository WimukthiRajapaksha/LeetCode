/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.maximum.path.sum;

import java.util.Map;

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

public class BinaryTreeMaximumPathSum {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL -> O(N), O(N)---------------
    static int glob=-10000;
    public int maxPathSum(TreeNode root) {
        glob=-10000;
        dfs(root);
        return glob;
    }
    
    public int dfs(TreeNode root) {
        if(root==null) return 0;
        int leftDfs=Math.max(0, dfs(root.left));
        int rightDfs=Math.max(0, dfs(root.right));
        
        glob=Math.max(glob, root.val+leftDfs+rightDfs);
        return Math.max(leftDfs, rightDfs)+root.val;
    }
    
    
//    ---------------------OPTIMAL -> O(N), O(N)---------------
//    static int glob=-10000;
//    public int maxPathSum(TreeNode root) {
//        glob=-10000;
//        dfs(root);
//        return glob;
//    }
//    
//    public int dfs(TreeNode root) {
//        if(root==null) return -10000;
//        int leftDfs=dfs(root.left);
//        int rightDfs=dfs(root.right);
//        int left=(leftDfs<0) ? 0: leftDfs;
//        int right=(rightDfs<0) ? 0: rightDfs;
//        int ret=root.val;
//        if(left<=right) {
//            ret+=right;
//        } else {
//            ret+=left;
//        }
//        glob=Math.max(glob, root.val+left+right);
//        return ret;
//    }
    
    
    
//    ---------------------OPTIMAL -> O(N), O(N)---------------
//    static int glob=-10000;
//    public int maxPathSum(TreeNode root) {
//        glob=-10000;
//        dfs(root);
//        return glob;
//    }
//    
//    public void dfs(TreeNode root) {
//        if(root==null) return;
//        dfs(root.left);
//        dfs(root.right);
//        int left=(root.left==null || root.left.val<0) ? 0: root.left.val;
//        int right=(root.right==null || root.right.val<0) ? 0: root.right.val;
//        int temp=root.val+left+right;
//        if(left<=right) {
//            root.val+=right;
//        } else {
//            root.val+=left;
//        }
//        glob=Math.max(root.val, Math.max(glob, temp));
//    }
    
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum b=new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(b.maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(b.maxPathSum(new TreeNode(-3)));
    }
}
