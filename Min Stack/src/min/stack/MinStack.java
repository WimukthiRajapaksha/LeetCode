/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package min.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinStack {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------ALTERNATE -> USING ONE STACK AND MATH CALCULATION------------------------
//    Stack<Long> stack;
//    int min;
//    
//    public MinStack() {
//        stack=new Stack<>();
//        this.min=0;
//    }
//    
//    public void push(int val) {
//        if (stack.isEmpty()) {
//            stack.push(0l);
//            this.min=val;
//        } else {
//            stack.push((long)val-min);
//            if (min>val) {
//                min=val;
//            }
//        }
//    }
//    
//    public void pop() {
//        long val = stack.pop();
//        if (val<0) {
//            this.min = (int)(min-val);
//        }
//    }
//    
//    public int top() {
//        long val=stack.peek();
//        if (val>0) {
//            return (int)(min+val);
//        } else {
//            return min;
//        }
//    }
//    
//    public int getMin() {
//        return min;
//    }
    
    
//    -----------------------ALTERNATE -> USING TWO STACKS, NOT OPTIMAL------------------------
//    Stack<Integer> stack;
//    Stack<Integer> min;
//    
//    public MinStack() {
//        stack=new Stack<>();
//        min=new Stack<>();
//    }
//    
//    public void push(int val) {
//        stack.push(val);
//        if (min.isEmpty() || min.peek()>=val) {
//            min.push(val);
//        }
//    }
//    
//    public void pop() {
//        int val = stack.pop();
//        if (min.peek()==val) {
//            min.pop();
//        }
//    }
//    
//    public int top() {
//        return stack.peek();
//    }
//    
//    public int getMin() {
//        return min.peek();
//    }
    
    
//    -------------------------------EXPECTED ANSWER----------------------------
    static class Node {
        int val;
        int min;
        Node next;

        public Node() {
        }

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    Node node;
    
    public MinStack() {
        node=null;
    }
    
    public void push(int val) {
        if (node==null) {
            node=new Node(val, val);
        } else {
            node=new Node(val, Math.min(node.min, val), node);
        }
    }
    
    public void pop() {
        node=node.next;
    }
    
    public int top() {
        return node.val;
    }
    
    public int getMin() {
        return node.min;
    }
    
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(1);
        m.push(1);
        System.out.println(m.top());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        m.push(1);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.push(1);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
