/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.subsequence;

/**
 *
 * @author wimukthirajapaksha
 */
public class IsSubsequence {

    /**
     * @param args the command line arguments
     */
    
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0; i<s.length(); i++) {
            j=t.indexOf(s.charAt(i), j)+1;
            if(j==0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsSubsequence i=new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
    }
}
