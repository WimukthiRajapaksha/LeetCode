/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialize.and.deserialize.binary.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) { 
        val = x; 
        this.left=left;
        this.right=right;
    }
}

class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder sb) {
        if(node==null) {
            sb.append("x,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue=new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return help(queue);
    }
    
    private TreeNode help(Queue<String> q) {
        String s=q.poll();
        if(s.equals("x")) return null;
        TreeNode temp=new TreeNode(Integer.valueOf(s));
        temp.left=help(q);
        temp.right=help(q);
        return temp;
    }
    

//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root==null) return "x,";
//        return root.val+","+serialize(root.left)+serialize(root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        Queue<String> queue=new LinkedList<>();
//        queue.addAll(Arrays.asList(data.split(",")));
//        return help(queue);
//    }
//    
//    private TreeNode help(Queue<String> q) {
//        String s=q.poll();
//        if(s.equals("x")) return null;
//        TreeNode temp=new TreeNode(Integer.valueOf(s));
//        temp.left=help(q);
//        temp.right=help(q);
//        return temp;
//    }
    
    
    public void print(TreeNode node) {
        if(node==null) return;
        print(node.left);
        System.out.print(node.val+" ");
        print(node.right);
    }
}

public class SerializeAndDeserializeBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Codec c=new Codec();
        String s=c.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        c.print(c.deserialize(s));
    }
}
