/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.nice.substring;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestNiceSubstring {

    /**
     * @param args the command line arguments
     */
    
    public String longestNiceSubstring(String s) {
        int[] arr=new int[128];
        for(char c: s.toCharArray()) {
            arr[c]++;
        }
        int prev=0;
        int len=0;
        String ret="";
        for(int i=0; i<s.length(); i++) {
            
        }
        return ret;
    }
    
    public static void main(String[] args) {
        LongestNiceSubstring l=new LongestNiceSubstring();
        System.out.println(l.longestNiceSubstring("YazaAay"));
    }
}
