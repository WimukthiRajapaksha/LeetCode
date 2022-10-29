/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator.ii;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class BasicCalculatorII {

    /**
     * @param args the command line arguments
     */
    
//    --------------OPTIMAL -> O(N) -> O(1)-----------------
    public int calculate(String s) {
        int current=0;
        int previous=0;
        int sum=0;
        char operation='+';
        for(char c: (s+"+").toCharArray()) {
            if(c>='0' && c<='9') {
                current=(current*10)+c-'0';
            }
            if(!(c>='0' && c<='9') && c!=' ') {
                if(operation=='+') {
                    sum+=previous;
                    previous=current;
                } else if(operation=='-') {
                    sum+=previous;
                    previous=-current;
                } else if(operation=='*') {
                    previous=previous*current;
                } else if(operation=='/') {
                    previous=previous/current;
                }
                operation=c;
                current=0;
            }
        }
        return sum+previous;
    }
    
    
//    --------------OPTIMAL -> O(N) -> O(1)-----------------
//    public int calculate(String s) {
//        int current=0;
//        int previous=0;
//        int sum=0;
//        char operation='+';
//        for(int i=0; i<s.length(); i++) {
//            char c=s.charAt(i);
//            if(c>='0' && c<='9') {
//                current=(current*10)+c-'0';
//            }
//            if((!(c>='0' && c<='9') && c!=' ') || i==s.length()-1) {
//                if(operation=='+') {
//                    sum+=previous;
//                    previous=current;
//                } else if(operation=='-') {
//                    sum+=previous;
//                    previous=-current;
//                } else if(operation=='*') {
//                    previous=previous*current;
//                } else if(operation=='/') {
//                    previous=previous/current;
//                }
//                operation=c;
//                current=0;
//            }
//        }
//        return sum+previous;
//    }
    
    
//    --------------OPTIMAL -> O(N) -> O(N)-----------------
//    public int calculate(String s) {
//        Stack<Integer> stack=new Stack<>();
//        int num=0;
//        char operation='+';
//        for(int i=0; i<s.length(); i++) {
//            char c=s.charAt(i);
//            if(c>='0' && c<='9') {
//                num=(num*10)+c-'0';
//            } 
//            if((c!=' ' && !(c>='0' && c<='9')) || i==s.length()-1) {
//                if(operation=='+') {
//                    stack.push(num);
//                } else if(operation=='-') {
//                    stack.push(-num);
//                } else if(operation=='*') {
//                    stack.push(stack.pop()*num);
//                } else {
//                    stack.push(stack.pop()/num);
//                }
//                operation=c;
//                num=0;
//            }
//        }
//        int sum=0;
//        while(!stack.isEmpty()) {
//            sum+=stack.pop();
//        }
//        return sum;
//    }
    
    public static void main(String[] args) {
        BasicCalculatorII b=new BasicCalculatorII();
        System.out.println(b.calculate("3+2*2"));
        System.out.println(b.calculate("  3/2  "));
        System.out.println(b.calculate("   3 + 5 /  2 "));
        System.out.println(b.calculate("3+2*2"));
        System.out.println(b.calculate("1"));
    }
}
