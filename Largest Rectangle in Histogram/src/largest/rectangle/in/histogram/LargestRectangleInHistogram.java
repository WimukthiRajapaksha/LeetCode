/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largest.rectangle.in.histogram;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class LargestRectangleInHistogram {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL -> O(N), O(N)------------------------------
//    public int largestRectangleArea(int[] heights) {
//        int[] leftSide=new int[heights.length];
//        int[] rightSide=new int[heights.length];
//        leftSide[0]=-1;
//        rightSide[rightSide.length-1]=heights.length;
//        for(int i=1; i<heights.length; i++) {
//            int t=i-1;
//            while(t>=0 && heights[t]>=heights[i]) {
//                t=leftSide[t];
//            }
//            leftSide[i]=t;
//        }
//        for(int i=heights.length-2; i>=0; i--) {
//            int t=i+1;
//            while(t<heights.length && heights[t]>=heights[i]) {
//                t=rightSide[t];
//            }
//            rightSide[i]=t;
//        }
//        int max=0;
//        for(int i=0; i<heights.length; i++) {
//            max=Math.max(max, heights[i]*(rightSide[i]-leftSide[i]-1));
//        }
//        return max;
//    }
    
    
//    -----------------------OPTIMAL - BEAUTIFUL -> O(N), O(N)------------------------------
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1); // to avoid empty stack issues
        int max=0;
        for(int i=0; i<=heights.length;i++) {
            int curr = (i==heights.length) ? 0 : heights[i]; // trick to do the calculation in one go
            while(stack.peek()!=-1 && curr<heights[stack.peek()]) {
                max=Math.max(max, heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        return max;
    }
    
    
//    -----------------------OPTIMAL -> O(N), O(N)------------------------------
//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack=new Stack<>();
//        int max=0;
//        int i;
//        for(i=0; i<heights.length;) {
//            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]) {
//                stack.push(i++);
//            } else {
//                int top=stack.pop();
//                if(stack.isEmpty()) {
//                    max=Math.max(max, heights[top]*i);
//                } else {
//                    max=Math.max(max, heights[top]*(i-stack.peek()-1));
//                }
//            }
//        }
//        while(!stack.isEmpty()) {
//            int top=stack.pop();
//            if(stack.isEmpty()) {
//                max=Math.max(max, heights[top]*i);
//            } else {
//                max=Math.max(max, heights[top]*(i-stack.peek()-1));
//            }
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        LargestRectangleInHistogram l=new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(l.largestRectangleArea(new int[]{3,6,9,12,8,4,2,1}));
        System.out.println(l.largestRectangleArea(new int[]{2,4}));
        System.out.println(l.largestRectangleArea(new int[]{10,9,8,7,6,5}));
        System.out.println(l.largestRectangleArea(new int[]{4,6,2,4,3,6}));
        System.out.println(l.largestRectangleArea(new int[]{5,4,1,2}));
    }
}
