/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path.sum.iii;

import java.util.HashMap;
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
}

public class PathSumIII {

    /**
     * @param args the command line arguments
     */
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL -> O(N^2), O(N)-------------------
//    public int pathSum(TreeNode root, int targetSum) {
//        return dfs(root, targetSum, new ArrayList<>());
//    }
//    
//    public int dfs(TreeNode root, int target, List<Long> list) {
//        if(root==null) return 0;
//        List<Long> newList=new ArrayList<>();
//        newList.add((long)root.val);
//        int c = (root.val==target) ? 1 : 0;
//        for(int i=0; i<list.size(); i++) {
//            if(list.get(i)+root.val==target) c++;
//            newList.add(list.get(i)+root.val);
//        }
//        System.out.println(newList);
//        c+=dfs(root.left, target, newList);
//        c+=dfs(root.right, target, newList);
//        return c;
//    }
    
    
    
//    ------------------ALTERNATE -> NOT OPTIMAL -> O(N^2), O(N)-------------------
//    public int pathSum(TreeNode root, int targetSum) {
//        return dfs(root, targetSum, new ArrayList<>());
//    }
//    
//    public int dfs(TreeNode root, int target, List<Long> list) {
//        if(root==null) return 0;
//        list.add((long)root.val);
//        int c = (root.val==target) ? 1 : 0;
//        for(int i=0; i<list.size()-1; i++) {
//            if(list.get(i)+root.val==target) c++;
//            list.set(i, list.get(i)+root.val);
//        }
//        if(root.left!=null) {
//            c+=dfs(root.left, target, list);
//            list.remove(list.size()-1);
//            for(int i=0; i<list.size(); i++) {
//                list.set(i, list.get(i)-root.left.val);
//            }
//        }
//        if(root.right!=null) {
//            c+=dfs(root.right, target, list);
//            list.remove(list.size()-1);
//            for(int i=0; i<list.size(); i++) {
//                list.set(i, list.get(i)-root.right.val);
//            }
//        }
//        return c;
//    }

    
    
//    ------------------ALTERNATE -> NOT OPTIMAL -> O(N^2), O(N)-------------------
//    public int pathSum(TreeNode root, int targetSum) {
//        if(root==null) return 0;
//        return pathSumFrom(root, (long)targetSum)+pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
//    }
//    
//    public int pathSumFrom(TreeNode root, long target) {
//        System.out.println(target);
//        if(root==null) return 0;
//        return ((long)root.val==target ? 1 : 0) + pathSumFrom(root.left, target-root.val)+pathSumFrom(root.right, target-root.val);
//    }
    
    
    
//    ------------------OPTIMAL -> O(N), O(N)-------------------
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map=new HashMap<>();
        map.put(0l, 1);
        return dfs(root, 0l, targetSum, map);
    }
    
    public int dfs(TreeNode node, long currentSum, int target, Map<Long, Integer> map) {
        if(node==null) return 0;
        currentSum+=node.val;
        int count=map.getOrDefault(currentSum-target, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
        count+=dfs(node.left, currentSum, target, map)+dfs(node.right, currentSum, target, map);
        map.put(currentSum, map.get(currentSum)-1);
        return count;
    }
    
    public static void main(String[] args) {
        PathSumIII p=new PathSumIII();
        TreeNode root=new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), 
                new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(p.pathSum(root, 8));
    }
}
