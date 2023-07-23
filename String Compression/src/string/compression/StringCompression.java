/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.compression;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class StringCompression {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> O(N), O(1)-----------------
//    public int compress(char[] chars) {
//        if(chars.length==1) return 1;
//        int prev=0;
//        int curr=0;
//        for(int i=1; i<=chars.length; i++) {
//            if(i==chars.length || chars[prev]!=chars[i]) {
//                int len=i-prev;
//                chars[curr]=chars[prev];
//                curr++;
//                prev=i;
//                if(len==1) {
//                    continue;
//                }
//                boolean track=false;
//                if(len>=1000) {
//                    chars[curr]=(char)((len/1000)+'0');
//                    len=len%1000;
//                    track=true;
//                    curr++;
//                }
//                if(len>=100 || track) {
//                    chars[curr]=(char)((len/100)+'0');
//                    len=len%100;
//                    track=true;
//                    curr++;
//                }
//                if(len>=10 || track) {
//                    chars[curr]=(char)((len/10)+'0');
//                    len=len%10;
//                    curr++;
//                }
//                chars[curr]= (char)((len)+'0');
//                curr++;
//            }
//        }
//        return curr;
//    }
    
    
    
//    -----------OPTIMAL -> O(N), O(1)-----------------
    public int compress(char[] chars) {
        if(chars.length==1) {
            return 1;
        }
        int i=0;
        int curr=0;
        while(i<chars.length) {
            int groupLength=1;
            while(i+groupLength<chars.length && chars[i+groupLength]==chars[i]) {
                groupLength++;
            }
            chars[curr++]=chars[i];
            if(groupLength>1) {
                for(char c: Integer.toString(groupLength).toCharArray()) {
                    chars[curr++]=c;
                }
            }
            i=i+groupLength;
        }
        return curr;
    }
    
    public static void main(String[] args) {
        StringCompression s=new StringCompression();
        System.out.println(s.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(s.compress(new char[]{'a'}));
        System.out.println(s.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
