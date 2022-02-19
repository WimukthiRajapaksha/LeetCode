/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.queue.using.stacks;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class ImplementQueueUsingStacks {

    /**
     * @param args the command line arguments
     */
    
    class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> second;
        public MyQueue() {
            stack=new Stack<>();
            second=new Stack<>();
        }

        public void push(int x) {
            second.push(x);
        }

        public int pop() {
            peek();
            return stack.pop();
        }

        public int peek() {
            if(stack.isEmpty()) {
                while(!second.isEmpty()) {
                    stack.push(second.pop());
                }
            }
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && second.isEmpty();
        }
    }
    
    
//    ---------------------------ALTERNATE----------------------------
//    class MyQueue {
//        Stack<Integer> stack;
//        Stack<Integer> second;
//        public MyQueue() {
//            stack=new Stack<>();
//            second=new Stack<>();
//        }
//
//        public void push(int x) {
//            while(!stack.isEmpty()) {
//                second.push(stack.pop());
//            }
//            stack.push(x);
//            while(!second.isEmpty()) {
//                stack.push(second.pop());
//            }
//        }
//
//        public int pop() {
//            return stack.pop();
//        }
//
//        public int peek() {
//            return stack.peek();
//        }
//
//        public boolean empty() {
//            return stack.isEmpty();
//        }
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
