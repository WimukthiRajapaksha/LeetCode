/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifying.an.alien.dictionary;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class VerifyingAnAlienDictionary {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(M*N), O(1)------------------
    public boolean isAlienSorted(String[] words, String order) {
        int[] ordering=new int[26];
        for(int i=0; i<order.length(); i++) {
            ordering[order.charAt(i)-'a']=i;
        }
        System.out.println(Arrays.toString(ordering));
        for(int i=0; i<words.length-1; i++) {
            for(int j=0; j<words[i].length(); j++) {
                if(j>=words[i+1].length()) return false;
                if(words[i].charAt(j)!=words[i+1].charAt(j)) {
                    int curr=words[i].charAt(j)-'a';
                    int next=words[i+1].charAt(j)-'a';
                    if(ordering[curr]>ordering[next]) return false;
                    else break;
                }
            }
        }
        return true;
    }
    
    
    
//    -------------------OPTIMAL -> O(M*N), O(1)------------------
//    public boolean isAlienSorted(String[] words, String order) {
//        for(int i=1; i<words.length; i++) {
//            if(!compare(words[i-1], words[i], order)) return false;
//        }
//        return true;
//    }
//    
//    public boolean compare(String s1, String s2, String al) {
//        for(int i=0; i<Math.max(s1.length(), s2.length()); i++) {
//            if(i>=s2.length()) return false;
//            else if(i>=s1.length()) return true;
//            else if(al.indexOf(s1.charAt(i))>al.indexOf(s2.charAt(i))) return false;
//            else if(al.indexOf(s1.charAt(i))<al.indexOf(s2.charAt(i))) return true;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        VerifyingAnAlienDictionary v=new VerifyingAnAlienDictionary();
        System.out.println(v.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(v.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(v.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(v.isAlienSorted(new String[]{"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
