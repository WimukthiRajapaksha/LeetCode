/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decode.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author wimukthirajapaksha
 */
public class DecodeString {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------------
//    public String decodeString(String s) {
//        Stack<Integer> count=new Stack<>();
//        Stack<String> chunks=new Stack<>();
//        int index=0;
//        StringBuilder sb=new StringBuilder();
//        
//        while(index<s.length()) {
//            if(Character.isDigit(s.charAt(index))) {
//                int num=0;
//                while(Character.isDigit(s.charAt(index))) {
//                    num=(num*10)+s.charAt(index++)-'0';
//                }
//                count.push(num);
//            } else if(s.charAt(index)=='[') {
//                chunks.push(sb.toString());
//                sb.setLength(0);
//                index++;
//            } else if(s.charAt(index)==']') {
//                StringBuilder temp=new StringBuilder(chunks.pop());
//                for(int i=0; i<count.peek(); i++) {
//                    temp.append(sb.toString());
//                }
//                count.pop();
//                sb.setLength(0);
//                sb.append(temp.toString());
//                index++;
//            } else {
//                sb.append(s.charAt(index));
//                index++;
//            }
//        }
//        return sb.toString();
//    }
    
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------------
//    public String decodeString(String s) {
//        Stack<Integer> count=new Stack<>();
//        Stack<String> chunks=new Stack<>();
//        int index=0;
//        StringBuilder sb=new StringBuilder();
//        int num=0;
//        
//        while(index<s.length()) {
//            if(Character.isDigit(s.charAt(index))) {
//                num=(num*10)+s.charAt(index)-'0';
//            } else if(s.charAt(index)=='[') {
//                chunks.push(sb.toString());
//                count.push(num);
//                num=0;
//                sb.setLength(0);
//            } else if(s.charAt(index)==']') {
//                StringBuilder temp=new StringBuilder(chunks.pop());
//                for(int i=0; i<count.peek(); i++) {
//                    temp.append(sb.toString());
//                }
//                count.pop();
//                sb.setLength(0);
//                sb.append(temp.toString());
//            } else {
//                sb.append(s.charAt(index));
//            }
//            index++;
//        }
//        return sb.toString();
//    }
    
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------------
//    int index=0;
//    public String decodeString(String s) {
//        StringBuilder sb=new StringBuilder();
//        
//        while(index<s.length() && s.charAt(index)!=']') {
//            if(Character.isLetter(s.charAt(index))) {
//                sb.append(s.charAt(index++));
//            } else {
//                int num=0;
//                while(index<s.length() && Character.isDigit(s.charAt(index))) {
//                    num=(num*10)+s.charAt(index++)-'0';
//                }
//                index++;
//                String decode=decodeString(s);
//                index++;
//                for(int i=0; i<num; i++) {
//                    sb.append(decode);
//                }
//            }
//        }
//        return sb.toString();
//    }
    
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------------
    int idx = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(idx<s.length() && s.charAt(idx)!=']'){
            if(Character.isLetter(s.charAt(idx))){
                sb.append(s.charAt(idx));
                idx++;
            }else{
                int num = 0;
                while(idx<s.length() && Character.isDigit(s.charAt(idx))){
                    num = num*10 + s.charAt(idx)-'0';
                    idx++;
                }
                idx++;
                String decoded_string = decodeString(s);
                idx++;
                while(num-->0) {
                    sb.append(decoded_string);
                }
            }
        }
        return sb.toString();
    }
    
    
    
//    -----------------OPTIMAL -> O(N), O(N)------------------
//    public String decodeString(String s) {
//        Queue<Character> queue = new LinkedList<>();
//        for (char c : s.toCharArray()) queue.offer(c);
//        return helper(queue);
//    }
//    
//    public String helper(Queue<Character> q) {
//        StringBuilder sb=new StringBuilder();
//        int num=0;
//        while(!q.isEmpty()) {
//            char c=q.poll();
//            if(Character.isDigit(c)) {
//                num=(10*num)+c-'0';
//            } else if(c=='[') {
//                String temp=helper(q);
//                num++;
//                while(num-->1) {
//                    sb.append(temp);
//                }
//            } else if(c==']') break;
//            else sb.append(c);
//        }
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        DecodeString d=new DecodeString();
        System.out.println(d.decodeString("3[a]2[bc]"));
        d.idx=0;
        System.out.println(d.decodeString("3[a2[c]]"));
        d.idx=0;
        System.out.println(d.decodeString("2[abc]3[cd]ef"));
    }
}
