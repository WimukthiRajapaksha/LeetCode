/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recover.binary.search.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class RecoverBinarySearchTree {

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
    
//    -----------------OPTIMAL -> MORRIS TRAVERSAL---------------
    public void recoverTree(TreeNode root) {
        TreeNode first=null;
        TreeNode second=null;
        TreeNode pre=null;
        TreeNode temp=null;
        while(root!=null) {
            if(root.left==null) {
                if(pre!=null && pre.val>root.val) {
                    if(first==null) first=pre;
                    second=root;
                }
                pre=root;
                root=root.right;
            } else {
                temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==root) {
                    if(pre!=null && pre.val>root.val) {
                        if(first==null) first=pre;
                        second=root;
                    }
                    pre=root;
                    System.out.println(root.val);
                    temp.right=null;
                    root=root.right;
                } else {
                    temp.right=root;
                    root=root.left;
                }
            }
        }
        
        int tempVal=first.val;
        first.val=second.val;
        second.val=tempVal;
    }
    
    
    
//    --------------------------------ALTERNATE -> OPTIMAL -> NOT SPACE OPTIMAL AS DISCRIBED IN FOLLOW UP----------------------
//    TreeNode first=null;
//    TreeNode second=null;
//    TreeNode temp=new TreeNode(Integer.MIN_VALUE);
//    
//    public void recoverTree(TreeNode root) {
//        preOrder(root);
//        int val=first.val;
//        first.val=second.val;
//        second.val=val;
//    }
//    
//    private void preOrder(TreeNode root) {
//        if(root==null) return;
//        preOrder(root.left);
//        if(temp.val>root.val) {
//            if(first==null) first=temp;
//            second=root;
//        }
//        temp=root;
//        preOrder(root.right);
//    }
    
    private void print(TreeNode t) {
        if(t==null) return;
        print(t.left);
        System.out.print(t.val+" ");
        print(t.right);
    }
    
    public static void main(String[] args) {
        RecoverBinarySearchTree r=new RecoverBinarySearchTree();
        TreeNode t=new TreeNode(5, new TreeNode(3, new TreeNode(-2147483648), new TreeNode(2)), new TreeNode(9));
        r.recoverTree(t);
        r.print(t);
    }
}
