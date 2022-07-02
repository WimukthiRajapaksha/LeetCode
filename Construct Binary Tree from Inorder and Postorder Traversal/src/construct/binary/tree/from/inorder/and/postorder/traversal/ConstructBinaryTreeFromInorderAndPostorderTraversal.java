/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construct.binary.tree.from.inorder.and.postorder.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
    
    int postIndex=0;
    Map<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postIndex=postorder.length-1;
        return generate(inorder, postorder, 0, inorder.length-1);
    }
    
    private TreeNode generate(int[] inOrder, int[] postOrder, int start, int end) {
        if(start>end) return null;
        int val=postOrder[postIndex--];
        TreeNode node=new TreeNode(val);
        node.right=generate(inOrder, postOrder, map.get(val)+1, end);
        node.left=generate(inOrder, postOrder, start, map.get(val)-1);
        return node;
    }
    
    public static void main(String[] args) {
        
    }
}
