/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluate.reverse.polish.notation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 *
 * @author wimukthirajapaksha
 */
public class EvaluateReversePolishNotation {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> NOT USING STACK, USING ARRAY---------------------
//    public int evalRPN(String[] tokens) {
//        int[] arr=new int[tokens.length];
//        int position=0;
//        for(String s: tokens) {
//            if(s.equals("+")) {
//                arr[position-2]=arr[position-2]+arr[position-1];
//                position--;
//            } else if(s.equals("-")) {
//                arr[position-2]=arr[position-2]-arr[position-1];
//                position--;
//            } else if(s.equals("*")) {
//                arr[position-2]=arr[position-2]*arr[position-1];
//                position--;
//            } else if(s.equals("/")) {
//                arr[position-2]=arr[position-2]/arr[position-1];
//                position--;
//            } else {
//                arr[position++]=Integer.valueOf(s);
//            }
//        }
//        return arr[0];
//    }
    
    
//    ----------------------OPTIMAL -> USING STACK---------------------
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s: tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if(s.equals("-")) {
                stack.push(-stack.pop()+stack.pop());
            } else if(s.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if(s.equals("/")) {
                int v=stack.pop();
                stack.push(stack.pop()/v);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
    
    
//    -------------------ALTERNATE -> MAP WITH BI-FUNCTION----------------------
//    public int evalRPN(String[] tokens) {
//        Map<String, BiFunction<Integer, Integer, Integer>> map=new HashMap<>();
//        map.put("+", (a, b)->a+b);
//        map.put("-", (a, b)->a-b);
//        map.put("*", (a, b)->a*b);
//        map.put("/", (a, b)->a/b);
//        
//        Stack<Integer> stack=new Stack<>();
//        for(String s: tokens) {
//            if("+-*/".contains(s)) {
//                int v=stack.pop();
//                stack.push(map.get(s).apply(stack.pop(), v));
//            } else {
//                stack.push(Integer.valueOf(s));
//            }
//        }
//        return stack.pop();
//    }
    
    public static void main(String[] args) {
        EvaluateReversePolishNotation e=new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
