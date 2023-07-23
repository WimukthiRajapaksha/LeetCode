/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.absolute.file.path;

import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestAbsoluteFilePath {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(N), O(N)-------------------
    public int lengthLongestPath(String input) {
        int maxLength=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(String inp: input.split("\n")) {
            int tabCount=inp.lastIndexOf("\t")+1;
            while(stack.size()>tabCount+1) {
                stack.pop();
            }
            int len=stack.peek()+inp.length()-tabCount+1;
            stack.push(len);
            if(inp.contains(".")) {
                maxLength=Math.max(maxLength, len-1);
            }
        }
        return maxLength;
    }
    
    
//    --------------OPTIMAL -> O(N), O(N)-------------------
//    public int lengthLongestPath(String input) {
//        int maxLength=0;
//        int[] pathLength=new int[input.length()+1];
//        for(String inp: input.split("\n")) {
//            int tabCount=inp.lastIndexOf("\t")+1;
//            if(inp.contains(".")) {
//                maxLength=Math.max(maxLength, pathLength[tabCount]+inp.length()-tabCount);
//            } else {
//                pathLength[tabCount+1]=pathLength[tabCount]+inp.length()-tabCount+1;
//            }
//        }
//        return maxLength;
//    }
    
    
    
//    --------------OPTIMAL -> O(N), O(N)-------------------
//    public int lengthLongestPath(String input) {
//        int maxLength=0;
//        int[] pathLength=new int[input.length()+1];
//        for(String inp: input.split("\n")) {
//            int initialLength=inp.length();
//            inp=inp.replaceAll("\t", "");
//            int tabCount=initialLength-inp.length();
//            if(inp.contains(".")) {
//                maxLength=Math.max(maxLength, pathLength[tabCount]+inp.length());
//            } else {
//                pathLength[tabCount+1]=pathLength[tabCount]+inp.length()+1;
//            }
//        }
//        return maxLength;
//    }
    
    
    
//    --------------OPTIMAL -> O(N), O(N)-------------------
//    public int lengthLongestPath(String input) {
//        Stack<String> stack=new Stack<>();
//        Stack<Integer> stackIn=new Stack<>();
//        stackIn.push(0);
//        int l=0;
//        int max=0;
//        int r=0;
//        while(r<=input.length()) {
//            if(r==input.length() || input.charAt(r)=='\n') {
//                stack.push(input.substring(l, r));
//                if(stackIn.size()>1) {
//                    stackIn.push(stackIn.peek()+r-l+1);
//                } else {
//                    stackIn.push(stackIn.peek()+r-l);
//                }
//                System.out.println(stack);
//                System.out.println(stackIn);
//                if(r>4 && input.substring(r-4, r).equals(".ext")) {
//                    System.out.println("---");
//                    max=Math.max(max, stackIn.peek());
//                }                
//                r++;
//                int tempC=0;
//                while(r<input.length() && input.charAt(r)=='\t') {
//                    r++;
//                    tempC++;
//                }
//                l=r;
//                while(stack.size()>tempC) {
//                    stack.pop();
//                    stackIn.pop();
//                }
//            } else {
//                r++;
//            }
//            System.out.println(stack+" "+l+" "+r);
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        LongestAbsoluteFilePath l=new LongestAbsoluteFilePath();
//        System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
//        System.out.println(l.lengthLongestPath("a"));
        System.out.println(l.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }    
}
