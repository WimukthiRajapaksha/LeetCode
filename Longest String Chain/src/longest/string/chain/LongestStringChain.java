/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longest.string.chain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class LongestStringChain {

    /**
     * @param args the command line arguments
     */
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2)->s2.length()-s1.length());
        System.out.println(Arrays.toString(words));
        Set<String> set=new HashSet<>();
        for(String w: words) set.add(w);
        int max=0;
        Map<String, Integer> map=new HashMap<>();
        for(String w: words) {
            int val=dfs(set, map, w);
            max=Math.max(max, val);
        }
        return max;
    }
    
    private int dfs(Set<String> set, Map<String, Integer> map, String selected) {
        if(map.containsKey(selected)) return map.get(selected);
        StringBuffer sb=new StringBuffer(selected);
        int max=0;
        for(int i=0; i<selected.length(); i++) {
            char c=selected.charAt(i);
            sb.deleteCharAt(i);
            if(set.contains(sb.toString())) {
                set.remove(sb.toString());
                max=Math.max(max, dfs(set, map, sb.toString()));
                set.add(sb.toString());
            }
            sb.insert(i, c);
        }
        map.put(selected, max+1);
        return max+1;
    }
    
    public static void main(String[] args) {
        LongestStringChain l=new LongestStringChain();
        System.out.println(l.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(l.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
