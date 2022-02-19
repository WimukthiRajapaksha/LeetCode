/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check.pkgif.two.string.arrays.are.equivalent;

/**
 *
 * @author wimukthirajapaksha
 */
public class CheckIfTwoStringArraysAreEquivalent {

    /**
     * @param args the command line arguments
     */
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1.length==1 && word2.length==1) {
            return word1[0]==word2[0];
        }
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        for (String s: word1) {
            sb1.append(s);
        }
        for (String s: word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
    
    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent c=new CheckIfTwoStringArraysAreEquivalent();
        System.out.println(c.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }
}
