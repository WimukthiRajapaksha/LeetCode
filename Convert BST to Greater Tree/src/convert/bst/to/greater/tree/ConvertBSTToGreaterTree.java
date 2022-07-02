/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.bst.to.greater.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConvertBSTToGreaterTree {

    /**
     * @param args the command line arguments
     */
    
    public class TreeNode {
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
    
    
//    ----------------------ALTERNATE -> ITERATIVE -> OPTIMAL--------------------
    public TreeNode convertBST(TreeNode root) {
        TreeNode head=root;
        int sum=0;
        while(root!=null) {
            if(root.right==null) {
                sum+=root.val;
                root.val=sum;
                root=root.left;
            } else {
                TreeNode temp=root.right;
                while(temp.left!=null && temp.left!=root) {
                    temp=temp.left;
                }
                if(temp.left==null) {
                    temp.left=root;
                    root=root.right;
                } else {
                    temp.left=null;
                    sum+=root.val;
                    root.val=sum;
                    root=root.left;
                }
            }
        }
        return head;
    }
    
    
    
//    ----------------------ALTERNATE -> RECURSIVE -> OPTIMAL--------------------
//    public TreeNode convertBST(TreeNode root) {
//        inorder(root, 0);
//        return root;
//    }
//    
//    private int inorder(TreeNode root, int v) {
//        if(root==null) return v;
//        int val=inorder(root.right, v);
//        root.val+=val;
//        return inorder(root.left, root.val);
//    }
    
    
    
    
//    ----------------------ALTERNATE -> RECURSIVE -> OPTIMAL -> but using a global variable is not good always (if using threads) --------------------
//    int sum=0;
//    public TreeNode convertBST(TreeNode root) {
//        if(root==null) return null;
//        convertBST(root.right);
//        sum+=root.val;
//        root.val=sum;
//        convertBST(root.left);
//        return root;
//    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
