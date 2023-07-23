/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all.possible.full.binary.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */

class TreeNode {
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

//    @Override
//    public String toString() {
//        return left+" "+val+" "+right;
//    }
}

public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0) return new ArrayList<>();
        Map<Integer, List<TreeNode>> map=new HashMap<>();
        map.put(1, Arrays.asList(new TreeNode()));
        for(int i=3; i<=n; i+=2) {
            help(map, 1, i-2);
        }
        return map.get(n);
    }
    
    private void help(Map<Integer, List<TreeNode>> map, int l, int r) {
        if(l<0 || r<0) return;
        map.putIfAbsent(l+r+1, new ArrayList<>());
        for(TreeNode le: map.get(l)) {
            for(TreeNode ri: map.get(r)) {
                TreeNode node=new TreeNode(0, le, ri);
                map.get(l+r+1).add(node);
            }
        }
        help(map, l+2, r-2);
    }
    
    
//    ---------------OPTIMAL -> O(2^(N/2)), O(N*2^(N/2))----------------
//    Map<Integer, List<TreeNode>> map=new HashMap<>();
//    public List<TreeNode> allPossibleFBT(int n) {
//        if(n%2==0) return new ArrayList<>();
//        if(n==1) return Arrays.asList(new TreeNode());
//        if(map.containsKey(n)) return map.get(n);
//        map.put(n, new ArrayList<>());
//        for(int i=1; i<n; i+=2) {
//            List<TreeNode> left=allPossibleFBT(i);
//            List<TreeNode> right=allPossibleFBT(n-i-1);
//            for(TreeNode l: left) {
//                for(TreeNode r: right) {
//                    map.get(n).add(new TreeNode(0, l, r));
//                }
//            }
//        }
//        return map.get(n);
//    }
    
    public static void main(String[] args) {
        AllPossibleFullBinaryTrees a=new AllPossibleFullBinaryTrees();
        System.out.println(a.allPossibleFBT(3));
        System.out.println(a.allPossibleFBT(7));
    }
}
