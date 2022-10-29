/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package average.of.levels.in.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class AverageOfLevelsInBinaryTree {

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
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            double count=0;
            int s=size;
            while(size>0) {
                TreeNode temp=queue.poll();
                if(temp.left!=null) {
                    queue.offer(temp.left);
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                }
                count+=temp.val;
                size--;
            }
            list.add(count/s);
        }
        return list;
    }
    
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        dfs(list, root, 0);
//        System.out.println(list);
//        List<Double> l=new ArrayList<>();
//        for(List<Integer> temp: list) {
//            double s=0;
//            for(int t: temp) {
//                s+=t;
//            }
//            l.add(s/temp.size());
//        }
//        return l;
//    }
//    
//    private void dfs(List<List<Integer>> list, TreeNode root, int l) {
//        if(root==null) return;
//        if(l==list.size()) {
//            list.add(new ArrayList<>());
//        }
//        list.get(l).add(root.val);
//        dfs(list, root.left, l+1);
//        dfs(list, root.right, l+1);
//    }
    
    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree a=new AverageOfLevelsInBinaryTree();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(a.averageOfLevels(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
