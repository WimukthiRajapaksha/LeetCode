/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determine.pkgif.two.strings.are.close;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> O(N*LOG(N)), O(1)-------------------
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        int[] map1=new int[26];
        int[] map2=new int[26];
        for(int i=0; i<word1.length(); i++) {
            map1[word1.charAt(i)-'a']++;
            map2[word2.charAt(i)-'a']++;
        }
        for(int i=0; i<map1.length; i++) {
            if((map1[i]==0) ^ (map2[i]==0)) {
                return false;
            }
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        return Arrays.equals(map1, map2);
    }
    
    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose d=new DetermineIfTwoStringsAreClose();
        System.out.println(d.closeStrings("abc", "bca"));
        System.out.println(d.closeStrings("a", "aa"));
        System.out.println(d.closeStrings("cabbba", "abbccc"));
        System.out.println(d.closeStrings("aabbcccddd", "abccccdddd"));
    }
}
