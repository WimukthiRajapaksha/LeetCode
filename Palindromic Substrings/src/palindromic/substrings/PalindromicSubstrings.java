/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromic.substrings;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class PalindromicSubstrings {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------------GOOD SOLUTION -> O(N^2), O(1)-----------------------
//    public int countSubstrings(String s) {
//        int count=0;
//        for(int i=0; i<s.length(); i++) {
//            count+=count(i, i, s);
//            count+=count(i-1, i, s);
//        }
//        return count;
//    }
//    
//    public int count(int i, int j, String s) {
//        int c=0;
//        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
//            i--;
//            j++;
//            c++;
//        }
//        return c;
//    }
    
    
    
//    -----------------------OPTIMAL -> Manacher's Algorithm -> O(N), O(N)-----------------------
    public int countSubstrings(String s) {
        int lengthNew=(2*s.length())+3;
        char[] arr=new char[lengthNew];
        arr[0]='@';
        arr[lengthNew-1]='$';
        int i=1;
        for(char c: s.toCharArray()) {
            arr[i++]='#';
            arr[i++]=c;
        }
        arr[i]='#';
        
        int maxRight=0;
        int center=0;
        int[] vals=new int[lengthNew];
        for(i=1; i<lengthNew-1; i++) {
            if(i<maxRight) {
                vals[i]=Math.min(maxRight-i, vals[2*center-i]);
            }
            while(arr[i+vals[i]+1]==arr[i-vals[i]-1]) {
                vals[i]++;
            }
            if(i+vals[i]>maxRight) {
                center=i;
                maxRight=i+vals[i];
            }
        }
        
        int count=0;
        for(i=2; i<lengthNew-2; i++) {
            count+=(vals[i]+1)/2;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(vals));
        return count;
    }
    
    public static void main(String[] args) {
        PalindromicSubstrings p=new PalindromicSubstrings();
        System.out.println(p.countSubstrings("abc"));
        System.out.println(p.countSubstrings("aaa"));
        System.out.println(p.countSubstrings("ababacdc"));
    }
}
