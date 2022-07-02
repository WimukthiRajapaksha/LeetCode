/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construct.binary.tree.from.preorder.and.inorder.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
    
//    ---------------------------OPTIMAL--------------------
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
    
    
    
    
//    ---------------------------OPTIMAL -> CAN'T UNDERSTAND--------------------
//    int preIndex=0;
//    int inIndex=0;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return createNode(preorder, inorder, 0);
//    }
//    
//    private TreeNode createNode(int[] preOrder, int[] inOrder, int index) {
//        if(preIndex==preOrder.length || index==inOrder[inIndex]) return null;
//        int temp=preOrder[preIndex++];
//        TreeNode node = new TreeNode(temp);
//        node.left=createNode(preOrder, inOrder, temp);
//        inIndex++;
//        node.right=createNode(preOrder, inOrder, index);
//        return node;
//    }
    
    
//    ---------------------------ALTERNATE -> NOT OPTIMAL--------------------
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return createNode(preorder, inorder, 0, 0, inorder.length-1);
//    }
//    
//    private TreeNode createNode(int[] preOrder, int[] inOrder, int preStart, int start, int end) {
//        if(preStart>=preOrder.length || start>end) return null;
//        TreeNode node=new TreeNode(preOrder[preStart]);
//        int index=0;
//        for(int i=start; i<=end; i++) {
//            if(inOrder[i]==preOrder[preStart]) {
//                index = i;
//                break;
//            }
//        }
//        node.left=createNode(preOrder, inOrder, preStart+1, start, index-1);
//        node.right=createNode(preOrder, inOrder, preStart+index-start+1, index+1, end);
//        return new TreeNode();
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
