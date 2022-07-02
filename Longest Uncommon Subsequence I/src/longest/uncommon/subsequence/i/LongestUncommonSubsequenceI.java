/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.uncommon.subsequence.i;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestUncommonSubsequenceI {

    /**
     * @param args the command line arguments
     */
    
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        if(a.length()!=b.length()) return Math.max(a.length(), b.length());
        return a.length();
    }
    
    public static void main(String[] args) {
        LongestUncommonSubsequenceI l=new LongestUncommonSubsequenceI();
        System.out.println(l.findLUSlength("aaac", "bbbc"));
        System.out.println(l.findLUSlength("aba", "cdc"));
        System.out.println(l.findLUSlength("aaa", "bbb"));
        System.out.println(l.findLUSlength("aaa", "aaa"));
        System.out.println(l.findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
    }
}
