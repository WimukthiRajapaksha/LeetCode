/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.parentheses;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidParentheses {

    /**
     * @param args the command line arguments
     */
    
    public boolean isValid(String s) {
        if (s.length()==0) {
            return true;
        }
        if (s.length()%2!=0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && map.get(stack.peek()).equals(c)) {
                stack.pop();
            } else {
                if (!map.containsKey(c)) {
                    return false;
                }
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
//    ----------------------ALTERNATE -> STACK IS NOT USED HERE; BUT HAVE ASKED TO USE STACK IN THE PROBLEM-------------
//    public boolean isValid(String s) {
//        if (s.length() == 0 || s.length()%2!=0) {
//            return false;
//        }
//        char[] arr = new char[s.length()];
//        int t=0;
//        for (char c: s.toCharArray()) {
//            if (t==0) {
//                arr[t++]=c;
//            } else if (c=='('||c=='['||c=='{') {
//                arr[t++]=c;
//            } else if ((arr[t-1]=='('&&c==')') || (arr[t-1]=='['&&c==']') || (arr[t-1]=='{'&&c=='}')) {
//                t--;
//            } else {
//                return false;
//            }
//        }
//        return t==0;
//    }
    
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
//        long start1 = System.nanoTime();
        System.out.println(v.isValid("()[}{}"));
//        long start2 = System.nanoTime();
//        for (int i=0; i<20; i++) {
            System.out.println(v.isValid("()[]{}"));
//        }
//        long start3 = System.nanoTime();
////        System.out.println(start2-start1);
//        System.out.println((start3-start2)/10);
    }
}
