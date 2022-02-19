/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.anagram;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidAnagram {

    /**
     * @param args the command line arguments
     */
    
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] l=new int[26];
        for(char i: s.toCharArray()) l[i-'a']++;
        for(char i: t.toCharArray()) l[i-'a']--;
        for(int i: l) if(i!=0) return false;
        return true;
    }
    
    
//    -------------------------ALTERNATE------------------------
//    public boolean isAnagram(String s, String t) {
//        if(s.length()!=t.length()) return false;
//        int[] l=new int[26];
//        for(char i: s.toCharArray()) l[i-'a']++;
//        for(int i: t.toCharArray()) if(--l[i-'a']<0) return false;
//        return true;
//    }
    
    
//    -------------------------ALTERNATE------------------------
//    public boolean isAnagram(String s, String t) {
//        if(s.length()!=t.length()) return false;
//        int[] l=new int[26];
//        for(int i=0; i<s.length(); i++) l[s.charAt(i)-'a']++;
//        for(int i=0; i<s.length(); i++) if(--l[t.charAt(i)-'a']<0) return false;
//        return true;
//    }
    
    public static void main(String[] args) {
        ValidAnagram v=new ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nsgaram"));
    }
}
