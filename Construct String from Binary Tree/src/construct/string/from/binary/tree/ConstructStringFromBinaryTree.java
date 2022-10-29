/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construct.string.from.binary.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConstructStringFromBinaryTree {

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
    
    
//    ---------------OPTIMAL -> O(N), O(N)----------------
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        Set<TreeNode> visited=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) {
            TreeNode temp=stack.peek();
            if(visited.contains(temp)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(temp);
                sb.append("(").append(temp.val);
                if(temp.left==null && temp.right!=null) {
                    sb.append("()");
                }
                if(temp.right!=null) {
                    stack.push(temp.right);
                }
                if(temp.left!=null) {
                    stack.push(temp.left);
                }
            }
        }
        return sb.substring(1, sb.length()-1);
    }
    
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------
//    public String tree2str(TreeNode root) {
//        StringBuffer sb=new StringBuffer();
//        help(root, sb);
//        return sb.toString().substring(1, sb.length()-1);
//    }
//    
//    private void help(TreeNode node, StringBuffer sb) {
//        if(node==null) return;
//        sb.append("(");
//        sb.append(node.val);
//        if(node.left!=null) {
//            help(node.left, sb);
//        } else if(node.right!=null) {
//            sb.append("()");
//        }
//        help(node.right, sb);
//        sb.append(")");
//    }
    
    
//    -------------ALTERNATE -> NOT OPTIMAL AS USING STRING DIRECTLY-----------
//    public String tree2str(TreeNode root) {
//        if(root==null) return "";
//        if(root.left==null && root.right==null) {
//            return String.valueOf(root.val);
//        } else if(root.right==null) {
//            return root.val+"("+tree2str(root.left)+")";
//        } 
//        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
//    }
    
    
    
    public static void main(String[] args) {
        ConstructStringFromBinaryTree c=new ConstructStringFromBinaryTree();
        System.out.println(c.tree2str(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
    }
}
