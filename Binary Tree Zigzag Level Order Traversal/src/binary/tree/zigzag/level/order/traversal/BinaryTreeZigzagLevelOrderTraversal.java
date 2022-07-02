/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.tree.zigzag.level.order.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
    
//    ------------------------OPTIMAL -> LEVEL ORDER AND WHILE ADDING AT THE RELEVANT INDEX-------------------------
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> nodes=new LinkedList<>();
//        if(root==null) return nodes;
//        inOrderTraversal(root, nodes, 0);
//        System.out.println(nodes);
//        return nodes;
//    }
//    
//    private void inOrderTraversal(TreeNode node, List<List<Integer>> list, int i) {
//        if(node==null) return;
//        if(list.size()==i) {
//            list.add(new LinkedList<>());
//        }
//        inOrderTraversal(node.left, list, i+1);
//        if(i%2==0) {
//            list.get(i).add(node.val);
//        } else {
//            list.get(i).add(0, node.val);
//        }
//        inOrderTraversal(node.right, list, i+1);
//    }
    
    
    
//    ------------------------OPTIMAL -> LEVEL ORDER AND THEN SHIFT-------------------------
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        if(root==null) return list;
//        List<List<Integer>> nodes=new ArrayList<>();
//        inOrderTraversal(root, nodes, 0);
//        for(int i=0; i<nodes.size(); i++) {
//            List<Integer> temp=new ArrayList<>();
//            if(i%2==1) {
//                for(int j=nodes.get(i).size()-1; j>=0; j--) {
//                    temp.add(nodes.get(i).get(j));
//                }
//                list.add(temp);
//            } else {
//                list.add(nodes.get(i));
//            }
//        }
//        System.out.println(list);
//        return list;
//    }
//    
//    private void inOrderTraversal(TreeNode node, List<List<Integer>> list, int i) {
//        if(node==null) return;
//        if(list.size()==i) {
//            list.add(new ArrayList<>());
//        }
//        inOrderTraversal(node.left, list, i+1);
//        list.get(i).add(node.val);
//        inOrderTraversal(node.right, list, i+1);
//        
//    }
    
    
//    ------------------------OPTIMAL -> USING A LINKED LIST-------------------------
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        LinkedList<TreeNode> track=new LinkedList<>();
        track.add(root);
        boolean isDFront=false;
        int size=1;
        int nextSize=0;
        while(!track.isEmpty()) {
            List<Integer> addList=new ArrayList<>();
            System.out.println(track);
            if(isDFront) {
                while(size>0) {
                    System.out.println(track.size());
                    TreeNode temp = track.removeFirst();
                    addList.add(temp.val);
                    if(temp.right!=null) {
                        track.addLast(temp.right);
                        nextSize++;
                    }
                    if(temp.left!=null) {
                        track.addLast(temp.left);
                        nextSize++;
                    }
                    size--;
                }
            } else {
                while(size>0) {
                    TreeNode temp = track.removeLast();
                    addList.add(temp.val);
                    if(temp.left!=null) {
                        track.addFirst(temp.left);
                        nextSize++;
                    }
                    if(temp.right!=null) {
                        track.addFirst(temp.right);
                        nextSize++;
                    }
                    size--;
                }
            }
            list.add(addList);
            size=nextSize;
            nextSize=0;
            isDFront=!isDFront;
        }
        System.out.println(list);
        return list;
    }
    
    
//    ------------------------ALTERNATE -> NOT OPTIMAL -> USING TWO STACKS-------------------------
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        if(root==null) return list;
//        Stack<TreeNode> stack=new Stack<>();
//        Stack<TreeNode> secondStack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty() || !secondStack.isEmpty()) {
//            List<Integer> tempList=new ArrayList<>();
//            if(!stack.isEmpty()) {
//                while(!stack.isEmpty()) {
//                    TreeNode temp=stack.pop();
//                    tempList.add(temp.val);
//                    if(temp.left!=null) secondStack.push(temp.left);
//                    if(temp.right!=null) secondStack.push(temp.right);
//                }
//            } else {
//                while(!secondStack.isEmpty()) {
//                    TreeNode temp=secondStack.pop();
//                    tempList.add(temp.val);
//                    if(temp.right!=null) stack.push(temp.right);
//                    if(temp.left!=null) stack.push(temp.left);
//                }
//            }
//            list.add(tempList);
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal b=new BinaryTreeZigzagLevelOrderTraversal();
        b.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        b.zigzagLevelOrder(new TreeNode(1));
    }
}
