/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.complete.tree.nodes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountCompleteTreeNodes {

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
    
    
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=heightLeft(root);
        if(left==heightRight(root)) {
            return (1<<left)-1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    private int heightLeft(TreeNode node) {
        if(node==null) return 0;
        return heightLeft(node.left)+1;
    }
    
    private int heightRight(TreeNode node) {
        if(node==null) return 0;
        return heightRight(node.right)+1;
    }
    
    public static void main(String[] args) {
        CountCompleteTreeNodes c=new CountCompleteTreeNodes();
        System.out.println(c.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
        System.out.println(c.countNodes(null));
    }
}
