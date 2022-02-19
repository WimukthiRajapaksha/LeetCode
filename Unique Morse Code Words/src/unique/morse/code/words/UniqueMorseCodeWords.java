/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unique.morse.code.words;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wimukthirajapaksha
 */
public class UniqueMorseCodeWords {

    /**
     * @param args the command line arguments
     */
    
    String[] arr=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set=new HashSet<>();
        for (String w: words) {
            StringBuilder sb=new StringBuilder();
            for (int i=0; i<w.length(); i++) {
                sb.append(arr[w.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
        return set.size();
    }
    
    public static void main(String[] args) {
        UniqueMorseCodeWords u=new UniqueMorseCodeWords();
        u.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"});
        u.uniqueMorseRepresentations(new String[]{"a"});
    }
    
}
