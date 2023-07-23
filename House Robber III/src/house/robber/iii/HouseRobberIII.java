/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house.robber.iii;

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

public class HouseRobberIII {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------NOT OPTIMAL -> O(2^H), O(N)----------------------
//    public int rob(TreeNode root) {
//        if(root==null) return 0;
//        int val=root.val;
//        val+=(root.left==null) ? 0 : rob(root.left.left) + rob(root.left.right);
//        val+=(root.right==null) ? 0 : rob(root.right.left) + rob(root.right.right);
//        return Math.max(val,rob(root.left)+rob(root.right));
//    }
    
    
    
    
//    -----------------OPTIMAL -> O(N), O(H)--------------------
    public int rob(TreeNode root) {
        if(root==null) return 0;
        int[] temp=sum(root);
        return Math.max(temp[0], temp[1]);
    }
    
    public int[] sum(TreeNode root) {
        if(root==null) {
            return new int[2];
        }
        int[] left=sum(root.left);
        int[] right=sum(root.right);
        return new int[]{root.val+left[1]+right[1], Math.max(left[0], left[1])+Math.max(right[0], right[1])};
    }
    
    public static void main(String[] args) {
        HouseRobberIII h=new HouseRobberIII();
        System.out.println(h.rob(
                new TreeNode(3,
                    new TreeNode(4, new TreeNode(1), new TreeNode(3)), 
                    new TreeNode(5, null, new TreeNode(1))
                )
        ));
        
        System.out.println(h.rob(
                new TreeNode(4, new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), null)
        ));
    }
}
