/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplify.path;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author wimukthirajapaksha
 */
public class SimplifyPath {

    /**
     * @param args the command line arguments
     */
    
//    ----------------OPTIMAL -> STACK------------------------
    public String simplifyPath(String path) {
        String[] pa=path.split("/");
        int i=0;
        Stack<String> stack=new Stack<>();
        while(i<pa.length) {
            if(pa[i].isEmpty() || pa[i].equals(".")) {
                i++;
                continue;
            } else if(pa[i].equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(pa[i]);
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(String s: stack) {
            sb.append("/").append(s);
        }
        if(sb.length()==0) {
            return "/";
        }
        return sb.toString();
    }
    
    
//    ----------------ALTERNATE -> OPTIMAL -> STACK------------------------
//    public String simplifyPath(String path) {
//        String[] pa=path.split("/");
//        int i=0;
//        Stack<String> stack=new Stack<>();
//        while(i<pa.length) {
//            if(pa[i].isEmpty() || pa[i].equals(".")) {
//                i++;
//                continue;
//            } else if(pa[i].equals("..")) {
//                if (!stack.isEmpty()) stack.pop();
//            } else {
//                stack.push(pa[i]);
//            }
//            i++;
//        }
//        StringBuilder sb=new StringBuilder();
//        while(!stack.isEmpty()) {
//            sb.insert(0, "/"+stack.pop());
//        }
//        if(sb.length()==0) {
//            return "/";
//        }
//        return sb.toString();
//    }
    
    
    
//    ----------------ALTERNATE -> OPTIMAL -> LINKED LIST------------------------
//    public String simplifyPath(String path) {
//        String[] pa=path.split("/");
//        int i=0;
//        LinkedList<String> ll=new LinkedList<>();
//        while(i<pa.length) {
//            if(pa[i].equals("") || pa[i].equals(".")) {
//            } else if(ll.isEmpty() && !pa[i].equals("..")) {
//                ll.push(pa[i]);
//            } else if(pa[i].equals("..")) {
//                if (!ll.isEmpty()) ll.pop();
//            } else {
//                ll.push(pa[i]);
//            }
//            i++;
//        }
//        System.out.println(ll);
//        StringBuilder sb=new StringBuilder();
//        sb.append("/");
//        while(!ll.isEmpty()) {
//            sb.append(ll.remove(ll.size()-1)).append("/");
//        }
//        if(sb.length()==1) {
//            return sb.toString();
//        }
//        return sb.deleteCharAt(sb.length()-1).toString();
//    }
    
    public static void main(String[] args) {
        SimplifyPath s=new SimplifyPath();
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/a/./b/./c/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
    }
}
