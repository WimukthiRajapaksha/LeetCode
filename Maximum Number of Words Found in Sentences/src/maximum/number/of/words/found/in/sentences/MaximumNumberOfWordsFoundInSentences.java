/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.number.of.words.found.in.sentences;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumNumberOfWordsFoundInSentences {

    /**
     * @param args the command line arguments
     */
    
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for (String s: sentences) {
            int co=0;
            for (int i=0; i<s.length(); i++) {
                co+=(s.charAt(i)==' ') ? 1:0;
            }
            if (max<co+1) {
                max=co+1;
            }
        }
        System.out.println(max);
        return max;
    }
    
    public static void main(String[] args) {
        MaximumNumberOfWordsFoundInSentences m=new MaximumNumberOfWordsFoundInSentences();
//        m.mostWordsFound(new String[]{"sadfnada"});
        m.mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
    }
}
