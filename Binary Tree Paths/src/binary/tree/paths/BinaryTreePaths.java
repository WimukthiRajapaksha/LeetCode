/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreePaths {

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
    
    
//    -------------------------ALTERNATE -> NOT OPTIMAL---------------------
//    public static class Node {
//        TreeNode node;
//        String path;
//
//        public Node(TreeNode node, String path) {
//            this.node = node;
//            this.path = path;
//        }
//    }
//     
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list=new ArrayList<>();
//        Stack<Node> stack=new Stack<>();
//        stack.push(new Node(root, root.val+""));
//        while(!stack.isEmpty()) {
//            Node t=stack.pop();
//            if(t.node.left==null && t.node.right==null) {
//                list.add(t.path);
//            } else {
//                if(t.node.left!=null) {
//                    stack.push(new Node(t.node.left, t.path+"->"+t.node.left.val));
//                }
//                if(t.node.right!=null) {
//                    stack.push(new Node(t.node.right, t.path+"->"+t.node.right.val));
//                }
//            }
//        }
//        System.out.println(list);
//        return list;
//    }
    
    
    
//    ----------------------ALTERNATE -> OPTIMAL------------------------------
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list=new ArrayList<>();
//        if(root==null) return list;
//        
//        dfs(root, new StringBuffer(), list);
//        System.out.println(list);
//        return list;
//    }
//    
//    public void dfs(TreeNode t, StringBuffer s, List<String> l) {
//        if(t==null) return;
//        int len=s.length();
//        s.append(t.val);
//        if(t.left==null && t.right==null) {
//            l.add(s.toString());
//        } else {
//            s.append("->");
//            dfs(t.left, s, l);
//            dfs(t.right, s, l);
//        }
//        s.setLength(len);
//    }
    
    
    
//    ----------------------ALTERNATE -> OPTIMAL------------------------------
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list=new ArrayList<>();
//        if(root!=null) dfs(root, "", list);
//        System.out.println(list);
//        return list;
//    }
//    
//    public void dfs(TreeNode t, String s, List<String> l) {
//        if(t==null) {
//            return;
//        }
//        if(t.left==null && t.right==null) l.add(s+t.val);
//        dfs(t.left, s+t.val+"->", l);
//        dfs(t.right, s+t.val+"->", l);
//    }
    
    
//    ----------------------ALTERNATE -> OPTIMAL------------------------------
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list=new ArrayList<>();
//        if(root==null) return list;
//        String curr=String.valueOf(root.val);
//        if(root.left==null && root.right==null) {
//            list.add(curr);
//            return list;
//        }
//        
//        if(root.left!=null) {
//            dfs(root.left, curr, list);
//        }
//        if(root.right!=null) {
//            dfs(root.right, curr, list);
//        }
//        return list;
//    }
//    
//    public void dfs(TreeNode t, String s, List<String> l) {
//        s+="->"+t.val;
//        if(t.left==null && t.right==null) {
//            l.add(s);
//            return;
//        }
//        if(t.left!=null) {
//            dfs(t.left, s, l);
//        }
//        if(t.right!=null) {
//            dfs(t.right, s, l);
//        }
//    }
    
    
    
//    ------------------------ALTERNATE -> ITERATIVE---------------------------
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        Stack<String> stackString=new Stack<>();
        stack.push(root);
        stackString.push(String.valueOf(root.val));
        while(!stack.isEmpty()) {
            TreeNode n=stack.pop();
            String s=stackString.pop();
            if(n.left==null && n.right==null) {
                list.add(s);
                continue;
            }
            if(n.left!=null) {
                stack.push(n.left);
                stackString.push(s+"->"+n.left.val);
            }
            if(n.right!=null) {
                stack.push(n.right);
                stackString.push(s+"->"+n.right.val);
            }
        }
        System.out.println(list);
        return list;
    }
    
    public static void main(String[] args) {
        BinaryTreePaths b=new BinaryTreePaths();
        b.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3)));
        b.binaryTreePaths(new TreeNode(1));
        StringBuffer sb=new StringBuffer();
        sb.append("abcdef");
        sb.setLength(2);
        System.out.println(sb.toString());
    }
}
