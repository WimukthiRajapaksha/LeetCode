/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truncate.sentence;

/**
 *
 * @author wimukthirajapaksha
 */
public class TruncateSentence {

    /**
     * @param args the command line arguments
     */
    
    public String truncateSentence(String s, int k) {
        int i=0;
        for (; i<s.length(); i++) {
            if(s.charAt(i)==' ') {
                k--;
                if (k==0) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
    
    public static void main(String[] args) {
        TruncateSentence t=new TruncateSentence();
        System.out.println(t.truncateSentence("Hello how are you Contestant", 5));
    }
}
