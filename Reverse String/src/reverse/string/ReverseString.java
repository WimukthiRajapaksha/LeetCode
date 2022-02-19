/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.string;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    
//    public void reverseString(char[] s) {
//        char c;
//        for(int i=0; i<s.length/2; i++) {
//            c=s[i];
//            s[i]=s[s.length-1-i];
//            s[s.length-1-i]=c;
//        }
//        for(char cc: s) {
//            System.out.print(cc+" ");
//        }
//        System.out.println();
//    }
    
    
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j) {
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        ReverseString r=new ReverseString();
        r.reverseString(new char[]{'H','a','n','n','a','h'});
        r.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
