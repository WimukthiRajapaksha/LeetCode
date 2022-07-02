/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.level.order.traversal.ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreeLevelOrderTraversalII {

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
    
    
//    -----------------------ALTERNATE -> OPTIMAL -> BFS------------------------
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> l=new ArrayList<>();
            while(size>0) {
                TreeNode temp=queue.poll();
                l.add(temp.val);
                if(temp.left!=null) {
                    queue.offer(temp.left);
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            list.add(0, l);
        }
        return list;
    }
    
    
    
//    ----------------------ALTERNATE -> OPTIMAL -> DFS----------------
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        traverse(root, list, 0);
//        for(int i=0; i<list.size()/2; i++) {
//            List<Integer> temp=list.get(i);
//            list.set(i, list.get(list.size()-1-i));
//            list.set(list.size()-1-i, temp);
//        }
//        return list;
//    }
//    
//    private void traverse(TreeNode node, List<List<Integer>> list, int l) {
//        if(node==null) return;
//        if(l==list.size()) list.add(new ArrayList<>());
//        traverse(node.left, list, l+1);
//        list.get(l).add(node.val);
//        traverse(node.right, list, l+1);
//    }
    
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL---------------
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        traverse(root, list, 0);
//        System.out.println(list);
//        return list;
//    }
//    
//    private void traverse(TreeNode node, List<List<Integer>> list, int l) {
//        if(node==null) return;
//        System.out.println(list);
//        if(l==list.size()) list.add(0, new ArrayList<>());
//        traverse(node.left, list, l+1);
//        traverse(node.right, list, l+1);
//        list.get(list.size()-l-1).add(node.val);
//    }
    
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII b=new BinaryTreeLevelOrderTraversalII();
        b.levelOrderBottom(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(5), new TreeNode(10))));
    }
}
