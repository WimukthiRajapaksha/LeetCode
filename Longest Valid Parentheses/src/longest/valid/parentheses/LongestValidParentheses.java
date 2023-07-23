/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.valid.parentheses;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestValidParentheses {

    /**
     * @param args the command line arguments
     */

//    -------------------OPTIMAL -> O(N), O(1)--------------
    public int longestValidParentheses(String s) {
        int left=0;
        int right=0;
        int max=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                left++;
            } else {
                right++;
            }
            if(left==right) {
                max=Math.max(max, 2*right);
            } else if(right>left) {
                right=left=0;
            }
        }
        right=left=0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)==')') {
                right++;
            } else {
                left++;
            }
            if(left==right) {
                max=Math.max(max, 2*right);
            } else if(left>=right) {
                right=left=0;
            }
        }
        return max;
    }
    
    
    
    
//    -------------------OPTIMAL -> O(N), O(N)--------------
//    public int longestValidParentheses(String s) {
//        int max=0;
//        Stack<Integer> stack=new Stack<>();
//        stack.push(-1);
//        for(int i=0; i<s.length(); i++) {
//            if(s.charAt(i)=='(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if(stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    max=Math.max(max, i-stack.peek());
//                }
//            }
//        }
//        return max;
//    }
    
    
    
//    -------------------OPTIMAL, DP -> O(N), O(N)--------------
//    public int longestValidParentheses(String s) {
//        int[] dp=new int[s.length()];
//        int max=0;
//        for(int i=1; i<dp.length; i++) {
//            if(s.charAt(i)==')' && s.charAt(i-1)=='(') {
//                dp[i]=(i>=2) ? dp[i-2]+2 : 2;
//            } else if(s.charAt(i)==')' && i-1-dp[i-1]>=0 && s.charAt(i-1-dp[i-1])=='(') {
//                if(i-dp[i-1]>=2) {
//                    dp[i]=dp[i-1]+dp[i-1-dp[i-1]-1]+2;
//                } else {
//                    dp[i]=dp[i-1]+2;
//                }
//            }
//            max=Math.max(max, dp[i]);
//        }
//        return max;
//    }
    
    
    
//    -------------------OPTIMAL, DP, REFACTORED -> O(N), O(N)--------------
//    public int longestValidParentheses(String s) {
//        int[] dp=new int[s.length()+2];
//        int max=0;
//        for(int i=1; i<s.length(); i++) {
//            if(s.charAt(i)==')' && s.charAt(i-1)=='(') {
//                dp[i+2]=dp[i]+2;
//            } else if(s.charAt(i)==')' && i-1-dp[i+1]>=0 && s.charAt(i-1-dp[i+1])=='(') {
//                dp[i+2]=dp[i+1]+dp[i-dp[i+1]]+2;
//            }
//            max=Math.max(max, dp[i+2]);
//        }
//        return max;
//    }
    
    
    
//    -------------------NOT OPTIMAL -> O(N^3), O(N)--------------
//    public int longestValidParentheses(String s) {
//        int max=0;
//        for(int i=0; i<s.length(); i++) {
//            for(int j=i+2; j<=s.length(); j+=2) {
//                if(isValid(s.substring(i,j)) && j-i>max) {
//                    max=j-i;
//                }
//            }
//        }
//        return max;
//    }
//    
//    private boolean isValid(String s) {
//        Stack<Character> stack=new Stack<>();
//        for(int i=0; i<s.length(); i++) {
//            if(s.charAt(i)=='(') {
//                stack.push('(');
//            } else if(!stack.isEmpty() && stack.peek()=='(') {
//                stack.pop();
//            } else {
//                return false;
//            }
//        }
//        return stack.isEmpty();
//    }
    
    public static void main(String[] args) {
        LongestValidParentheses l=new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(()"));
        System.out.println(l.longestValidParentheses(")()())"));
        System.out.println(l.longestValidParentheses(""));
    }
}
