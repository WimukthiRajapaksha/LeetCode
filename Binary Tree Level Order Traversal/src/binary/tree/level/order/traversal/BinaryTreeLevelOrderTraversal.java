/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreeLevelOrderTraversal {

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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> list, int level) {
        if(root==null) return;
        if(list.size()==level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        
        traverse(root.left, list, level+1);
        traverse(root.right, list, level+1);
    }
    
    
    
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        if(root==null) return list;
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int size=queue.size();
//            List<Integer> tempList=new ArrayList<>();
//            for(int i=0; i<size; i++) {
//                TreeNode temp=queue.poll();
//                tempList.add(temp.val);
//                if(temp.left!=null) {
//                    queue.offer(temp.left);
//                }
//                if(temp.right!=null) {
//                    queue.offer(temp.right);
//                }
//            }
//            list.add(new ArrayList<>(tempList));
//        }
//        System.out.println(list);
//        return list;
//    }
    
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b=new BinaryTreeLevelOrderTraversal();
        b.levelOrder(new TreeNode(3, new TreeNode(9, new TreeNode(1), new TreeNode(2, new TreeNode(44), null)), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(0), new TreeNode(3, new TreeNode(1), null)))));
        b.levelOrder(null);
        b.levelOrder(new TreeNode(4));
    }
}
