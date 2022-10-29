/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diameter.of.binary.tree;

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

public class DiameterOfBinaryTree {

    /**
     * @param args the command line arguments
     */
    
    int m=0;
    public int diameterOfBinaryTree(TreeNode root) {
        back(root);
        return m;
    }
    
    private int back(TreeNode root) {
        if(root==null) return 0;
        int l=back(root.left);
        int r=back(root.right);
        if(l+r>m) {
            m=l+r;
        }
        return Math.max(l, r)+1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
