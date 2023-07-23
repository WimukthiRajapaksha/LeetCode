/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verify.preorder.serialization.of.a.binary.tree;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class VerifyPreorderSerializationOfABinaryTree {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> BEAUTIFUL -> O(N), O(N)---------------------
    public boolean isValidSerialization(String preorder) {
        String[] arr=preorder.split(",");
        int count=1;
        for(String s: arr) {
            if(--count<0) return false;
            if(!s.equals("#")) count+=2;
        }
        return count==0;
    }
    
    
//    ----------------OPTIMAL -> O(N), O(N)---------------------
//    public boolean isValidSerialization(String preorder) {
//        String[] arr=preorder.split(",");
//        Stack<String> stack=new Stack<>();
//        int i=0;
//        stack.push(arr[i++]);
//        while(i<arr.length && !stack.isEmpty()) {
//            while(!stack.isEmpty() && stack.peek().equals("#") && arr[i].equals("#")) {
//                stack.pop();
//                if(stack.isEmpty()) return false;
//                stack.pop();
//            }
//            stack.push(arr[i++]);
//        }
//        return stack.size()==1 && stack.peek().equals("#");
//    }
    
    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v=new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(v.isValidSerialization("1,#"));
        System.out.println(v.isValidSerialization("9,#,#,1"));
        System.out.println(v.isValidSerialization("9,#,#"));
        System.out.println(v.isValidSerialization("9,#,#"));
    }
}
