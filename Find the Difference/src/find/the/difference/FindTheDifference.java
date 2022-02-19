/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.the.difference;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindTheDifference {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL-------------------------
    public char findTheDifference(String s, String t) {
        int i=0;
        for(char c: s.toCharArray()) i^=c;
        for(char c: t.toCharArray()) i^=c;
        return (char)i;
    }
    
    
    
//    -----------------------OPTIMAL-------------------------
//    public char findTheDifference(String s, String t) {
//        int v=0;
//        for(int i=0; i<s.length(); i++) {
//            v+=t.charAt(i)-s.charAt(i);
//        }
//        return (char)(t.charAt(t.length()-1)+v);
//    }
    
    
//    -----------------------ALTERNATE -> NOT OPTIMAL-------------------------
//    public char findTheDifference(String s, String t) {
//        int[] l=new int[26];
//        for(char c: s.toCharArray()) {
//            l[c-'a']++;
//        }
//        for(char c: t.toCharArray()) {
//            if(--l[c-'a']<0) return c;
//        }
//        return ' ';
//    }
    
    public static void main(String[] args) {
        FindTheDifference f=new FindTheDifference();
        System.out.println(f.findTheDifference("abcd", "abcde"));
    }
}
