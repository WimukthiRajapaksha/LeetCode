/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate.binary.search.tree;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidateBinarySearchTree {

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
    
//    --------------------ALTERNATE -> MORRIS INORDER TRAVERSAL------------------
//    public boolean isValidBST(TreeNode root) {
//        TreeNode prev=null;
//        while(root!=null) {
//            if(prev==null) {
//                System.out.println("null "+root.val);
//            } else {
//                System.out.println(prev.val+" "+root.val);
//            }
//            if(root.left==null) {
//                if(!validate(root, prev)) return false;
//                prev=root;
//                root=root.right;
//            } else {
//                TreeNode temp=root.left;
//                while(temp.right!=null && temp.right!=root) {
//                    temp=temp.right;
//                }
//                if(temp.right==null) {
//                    temp.right=root;
//                    root=root.left;
//                } else {
//                    if (!validate(root, prev)) return false;
//                    prev=root;
//                    temp.right=null;
//                    root=root.right;
//                }
//            }
//        }
//        return true;
//    }
//    
//    private boolean validate(TreeNode root, TreeNode prev) {
//        return (prev==null || prev.val<root.val);
//    }
    
    
//    --------------------OPTIMAL -> RECURSIVE------------------------
//    public boolean isValidBST(TreeNode root) {
//        return traverse(root, null, null);
//    }
//    
//    private boolean traverse(TreeNode t, Integer min, Integer max) {
//        if(t==null) return true;
//        if ((min==null || min<t.val) && (max==null || t.val<max)) {
//            return traverse(t.left, min, t.val) && traverse(t.right, t.val, max);
//        }
//        return false;
//    }
    
    
    
//    -----------------OPTIMAL -> ITERATIVE-------------------
    TreeNode prev=null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return isValid;
    }
    
    private void traverse(TreeNode t) {
        if(t==null) return;
        traverse(t.left);
        if(prev!=null && t.val<=prev.val) {
            isValid &= false;
        }
        prev=t;
        traverse(t.right);
    }
    
    public static void main(String[] args) {
        ValidateBinarySearchTree v=new ValidateBinarySearchTree();
        System.out.println(v.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }
}
