/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detect.capital;

/**
 *
 * @author wimukthirajapaksha
 */
public class DetectCapital {

    /**
     * @param args the command line arguments
     */
    
//    --------------ALTERNATE -> NOT OPTIMAL----------------
//    public boolean detectCapitalUse(String word) {
//        return word.matches("[A-Z]*|.[a-z]*");
//    }
    
    
//    --------------ALTERNATE -> OPTIMAL------------------
    public boolean detectCapitalUse(String word) {
        if(word.length()<=1) return true;
        if(word.charAt(word.length()-1)>=97) { // simple
            for(int i=word.length()-1; i>=1; i--) {
                if(word.charAt(i)<97) return false;
            }
            return true;
        } else { // capital
            for(int i=word.length()-1; i>=0; i--) {
                if(word.charAt(i)>=97) return false;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        DetectCapital d=new DetectCapital();
        System.out.println(d.detectCapitalUse("USA"));
        System.out.println(d.detectCapitalUse("leetcode"));
        System.out.println(d.detectCapitalUse("Google"));
        System.out.println(d.detectCapitalUse("FlaG"));
    }
}
