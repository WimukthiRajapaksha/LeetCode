/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.zigzag.path.in.a.binary.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestZigZagPathInABinaryTree {

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
    
//    int length=0;
//    public int longestZigZag(TreeNode root) {
//        if(root==null) return 0;
//        Map<TreeNode, int[]> map=new HashMap<>();
//        help(root, false, map);
//        help(root, true, map);
//        return length-1;
//    }
//    
//    private int help(TreeNode node, boolean isLeft, Map<TreeNode, int[]> map) {
//        if(node==null) return 0;
//        if(map.containsKey(node) && map.get(node)[isLeft ? 0 : 1]!=0) return map.get(node)[isLeft ? 0 : 1];
//        int val=0;
//        if(isLeft) {
//            val=help(node.right, !isLeft, map)+1;
//            map.putIfAbsent(node, new int[2]);
//            map.get(node)[0]=val;
//            help(node, false, map);
//        } else {
//            val=help(node.left, !isLeft, map)+1;
//            map.putIfAbsent(node, new int[2]);
//            map.get(node)[1]=val;
//            help(node, true, map);
//        }        
//        length=Math.max(length, val);
//        return val;
//    }
    
    int length=0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        dfs(root, true, 1);
        dfs(root, false, 1);
        return length-1;
    }
    
    private void dfs(TreeNode node, boolean isLeft, int l) {
        if(node==null) {
            return;
        }
        length=Math.max(length, l);
        if(isLeft) {
            dfs(node.left, !isLeft, l+1);
            dfs(node.right, isLeft, 1);
        } else {
            dfs(node.right, !isLeft, l+1);
            dfs(node.left, isLeft, 1);
        }
    }
    
    public static void main(String[] args) {
        LongestZigZagPathInABinaryTree l=new LongestZigZagPathInABinaryTree();
        System.out.println(l.longestZigZag(
                new TreeNode(
                        1, 
                        null, 
                        new TreeNode(
                                1, 
                                new TreeNode(1), 
                                new TreeNode(
                                        1, 
                                        new TreeNode(
                                                1, 
                                                null, 
                                                new TreeNode(
                                                        1, 
                                                        null, 
                                                        new TreeNode(1)
                                                )
                                        ), 
                                        new TreeNode(1)
                                )
                        )
                )
        ));
//        System.out.println(l.longestZigZag(new TreeNode(1)));
    }
}
