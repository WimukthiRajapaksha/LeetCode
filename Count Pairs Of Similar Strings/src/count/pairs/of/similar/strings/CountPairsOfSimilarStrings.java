/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.pairs.of.similar.strings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountPairsOfSimilarStrings {

    /**
     * @param args the command line arguments
     */
    
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map=new HashMap<>();
        for(String s: words) {
            int t=0;
            for(char c: s.toCharArray()) {
                t=t|(1<<(c-'a'));
            }
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        int count=0;
        for(int i: map.values()) {
            count+=(i*(i-1)/2);
        }
        return count;
    }
    
    public static void main(String[] args) {
        CountPairsOfSimilarStrings c=new CountPairsOfSimilarStrings();
        System.out.println(c.similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));
        System.out.println(c.similarPairs(new String[]{"aabb","ab","ba"}));
        System.out.println(c.similarPairs(new String[]{"nba","cba","dba"}));
    }
}
