/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.duplicate.letters;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveDuplicateLetters {

    /**
     * @param args the command line arguments
     */
    
    public String removeDuplicateLetters(String s) {
        boolean[] arr=new boolean[26];
        for(char c: s.toCharArray()) {
            arr[c-'a']=true;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]) {
                sb.append(((char)(i+'a')));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        RemoveDuplicateLetters r=new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters("bcabc"));
        System.out.println(r.removeDuplicateLetters("cbacdcbc"));
    }
}
