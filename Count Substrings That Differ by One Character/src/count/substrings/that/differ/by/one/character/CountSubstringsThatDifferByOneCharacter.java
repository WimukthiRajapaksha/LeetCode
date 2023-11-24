/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.substrings.that.differ.by.one.character;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountSubstringsThatDifferByOneCharacter {

    /**
     * @param args the command line arguments
     */
    
    public int countSubstrings(String s, String t) {
        int count=0;
        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<t.length(); j++) {
                int tempI=i;
                int tempJ=j;
                while(tempI<s.length() && tempJ<t.length() && s.charAt(tempI)==t.charAt(tempJ)) {
                    tempI++;
                    tempJ++;
                }
                if(tempI<s.length() && tempJ<t.length() && s.charAt(tempI)!=t.charAt(tempJ)) count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        CountSubstringsThatDifferByOneCharacter c=new CountSubstringsThatDifferByOneCharacter();
        System.out.println(c.countSubstrings("aba", "baba"));
        System.out.println(c.countSubstrings("ab", "bb"));
        System.out.println(c.countSubstrings("aba", "baba"));
    }
}
