/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flatten.binary.tree.to.linked.list;

/**
 *
 * @author wimukthirajapaksha
 */
public class FlattenBinaryTreeToLinkedList {

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
    
    private TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
    
//    --------------------ALTERNATE -> OPTIMAL----------------------
//    public void flatten(TreeNode root) {
//        if(root==null) return;
//        System.out.print(root.val);
//        TreeNode left=root.left;
//        TreeNode right=root.right;
//        if(left!=null) System.out.print(" "+left.val);
//        if(right!=null) System.out.print(" "+right.val);
//        System.out.println();
//        if(left==null) {
//            flatten(root.right);
//            return;
//        }
//        while(left.right!=null) {
//            left=left.right;
//        }
//        left.right=right;
//        root.right=root.left;
//        root.left=null;
//        flatten(root.right);
//    }
    
    private void print(TreeNode n) {
        if(n==null) return;
        System.out.print(n.val+" ");
        print(n.left);
        print(n.right);
    }
    
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList f=new FlattenBinaryTreeToLinkedList();
        TreeNode n=new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        f.flatten(n);
        f.print(n);
    }
}
