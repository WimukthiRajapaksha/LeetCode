/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.mode.in.binary.search.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindModeInBinarySearchTree {

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
    
//    ------------------------MORIS INORDER TRAVERSAL -> NICE, BUT TRAVERSING TWISE-----------------
    private int modeCount=0;
    private int currentCount=0;
    private int maxCount=0;
    private int currentVal=0;
    
    private int[] modes;
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes=new int[modeCount];
        modeCount=0;
        currentCount=0;
        inorder(root);
        return modes;
    }
    
    private void inorder(TreeNode root) {
        while(root!=null) {
            if(root.left==null) {
                handleValue(root.val);
                root=root.right;
            } else {
                TreeNode temp=root.left;
                while(temp.right!=null && temp.right!=root) {
                    temp=temp.right;
                }
                if(temp.right==null) {
                    temp.right=root;
                    root=root.left;
                } else {
                    temp.right=null;
                    handleValue(root.val);
                    root=root.right;
                }
            }
        }
    }
    
    private void handleValue(int val) {
        if(val!=currentVal) {
            currentVal=val;
            currentCount=0;
        }
        currentCount++;
        if(currentCount>maxCount) {
            modeCount=1;
            maxCount=currentCount;
        } else if(currentCount==maxCount) {
            if(modes!=null) {
                modes[modeCount]=currentVal;
            }
            modeCount++;
        }
    }
    
    
//    -----------------------ALTERNATE -> OPTIMAL-------------------------
//    TreeNode pre=new TreeNode(-1000000);
//    int currentCount=0;
//    int maxCount=0;
//    
//    public int[] findMode(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        traverse(root, list);
//        int[] arr=new int[list.size()];
//        for(int i=0; i<list.size(); i++) {
//            arr[i]=list.get(i);
//        }
//        System.out.println(list);
//        return arr;
//    }
//    
//    private void traverse(TreeNode root, List<Integer> list) {
//        if(root==null) return;
//        traverse(root.left, list);
//        if(pre.val==root.val) {
//            currentCount++;
//        } else {
//            currentCount=1;
//        }
//        if(currentCount>maxCount) {
//            maxCount=currentCount;
//            list.clear();
//            list.add(root.val);
//        } else if(currentCount==maxCount) {
//            list.add(root.val);
//        }
//        
//        pre=root;
//        traverse(root.right, list);
//    }
    
    
    
//    --------------------------ALTERNATE -> NOT OPTIMAL-----------------------
//    public int[] findMode(TreeNode root) {
//        Map<Integer, Integer> map=new HashMap<>();
//        mode(root, map);
//        List<Integer> list=new ArrayList<>();
//        int m=0;
//        for(int k: map.keySet()) {
//            if(m==map.get(k)) {
//                list.add(k);
//            } else if(m<map.get(k)) {
//                list=new ArrayList<>();
//                list.add(k);
//                m=map.get(k);
//            }
//        }
//        int[] ret=new int[list.size()];
//        System.out.println(list);
//        for(int i=0; i<list.size(); i++) {
//            ret[i]=list.get(i);
//        }
//        return ret;
//    }
//    
//    private void mode(TreeNode root, Map<Integer, Integer> map) {
//        if(root==null) return;
//        map.put(root.val, map.getOrDefault(root.val, 0)+1);
//        mode(root.left, map);
//        mode(root.right, map);
//    }
    
    public static void main(String[] args) {
        FindModeInBinarySearchTree f=new FindModeInBinarySearchTree();
        f.findMode(new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)));
    }
}
