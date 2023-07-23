/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg132.pattern;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class Pattern {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------------OPTIMAL -> O(N), O(N)----------------------------
    public boolean find132pattern(int[] nums) {
        int second=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i]<second) return true;
            while(!stack.isEmpty() && stack.peek()<nums[i]) {
                second=stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
    
    
    
//    -------------------------OPTIMAL -> O(N), O(N)----------------------------
//    public boolean find132pattern(int[] nums) {
//        int[] min=new int[nums.length];
//        min[0]=nums[0];
//        for(int i=1; i<nums.length; i++) {
//            min[i]=Math.min(min[i-1], nums[i]);
//        }
//        Stack<Integer> stack=new Stack<>();
//        for(int i=nums.length-1; i>=0; i--) {
//            if(nums[i]>min[i]) {
//                while(!stack.isEmpty() && stack.peek()<=min[i]) {
//                    stack.pop();
//                }
//                if(!stack.isEmpty() && stack.peek()<nums[i]) return true;
//                stack.push(nums[i]);
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        Pattern p=new Pattern();
        System.out.println(p.find132pattern(new int[]{1,2,3,4}));
        System.out.println(p.find132pattern(new int[]{3,1,4,2}));
        System.out.println(p.find132pattern(new int[]{-1,3,2,0}));
        System.out.println(p.find132pattern(new int[]{3,5,0,3,4}));
        System.out.println(p.find132pattern(new int[]{1,0,1,-4,-3}));
    }
}
