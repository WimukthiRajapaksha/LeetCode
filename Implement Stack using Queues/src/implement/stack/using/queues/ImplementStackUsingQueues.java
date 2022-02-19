/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement.stack.using.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class ImplementStackUsingQueues {

    /**
     * @param args the command line arguments
     */
    
    static class MyStack {
        Queue<Integer> stack;
        public MyStack() {
            this.stack=new LinkedList<>();
        }

        public void push(int x) {
            stack.offer(x);
            for(int i=0; i<stack.size()-1; i++) {
                stack.offer(stack.remove());
            }
        }

        public int pop() {
            return stack.poll();
        }

        public int top() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
    
    
//    -------------------------ALTERNATE -> USING TWO QUEUES-----------------------
//    static class MyStack {
//        Queue<Integer> first;
//        Queue<Integer> second;
//        int c;
//        public MyStack() {
//            this.first=new LinkedList<>();
//            this.second=new LinkedList<>();
//            this.c=0;
//        }
//
//        public void push(int x) {
//            first.offer(x);
//            while(!second.isEmpty()) {
//                first.offer(second.poll());
//                c++;
//            }
//            while(!first.isEmpty()) {
//                second.offer(first.poll());
//            }
//        }
//
//        public int pop() {
//            return second.poll();
//        }
//
//        public int top() {
//            return second.peek();
//        }
//
//        public boolean empty() {
//            return second.isEmpty();
//        }
//    }
    
    
//    -------------------------ALTERNATE -> USING THREE QUEUES-----------------------
//    static class MyStack {
//        Queue<Integer> first;
//        Queue<Integer> second;
//        Queue<Integer> third;
//        public MyStack() {
//            this.first=new LinkedList<>();
//            this.second=new LinkedList<>();
//            this.third=new LinkedList<>();
//        }
//
//        public void push(int x) {
//            first.offer(x);
//            while(!third.isEmpty()) {
//                second.offer(third.poll());
//            }
//            third.offer(first.poll());
//            while(!second.isEmpty()) {
//                third.offer(second.poll());
//            }
//        }
//
//        public int pop() {
//            return third.poll();
//        }
//
//        public int top() {
//            return third.peek();
//        }
//
//        public boolean empty() {
//            return third.isEmpty();
//        }
//    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
