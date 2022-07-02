/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.binary.search.trees.ii;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniqueBinarySearchTreesII {

    /**
     * @param args the command line arguments
     */
    
    public class TreeNode {
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
    
    public List<TreeNode> generateTrees(int n) {
        return backtrack(1, n);
    }
    
    private List<TreeNode> backtrack(int min, int max) {
        List<TreeNode> ret=new ArrayList<>();
        if(min>max) {
            ret.add(null);
            return ret;
        } else if(min==max) {
            ret.add(new TreeNode(min));
            return ret;
        }
        for(int i=min; i<=max; i++) {
            List<TreeNode> l=backtrack(min, i-1);
            List<TreeNode> r=backtrack(i+1, max);
            for(TreeNode lv: l) {
                for(TreeNode rv: r) {
                    TreeNode curr=new TreeNode(i, lv, rv);
                    ret.add(curr);
                }
            }
        }
        return ret;
    }
    
    private void print(TreeNode t) {
        if(t==null) return;
        System.out.print(t.val+" ");
        print(t.left);
        print(t.right);
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTreesII u=new UniqueBinarySearchTreesII();
        List<TreeNode> t=u.generateTrees(4);
        for(TreeNode tt: t) {
            u.print(tt);
            System.out.println();
        }
    }
}
