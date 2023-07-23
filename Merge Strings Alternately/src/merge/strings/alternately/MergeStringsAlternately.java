/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.strings.alternately;

/**
 *
 * @author wimukthirajapaksha
 */
public class MergeStringsAlternately {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(MAX(M, N)), O(1)---------------
//    public String mergeAlternately(String word1, String word2) {
//        int i=0;
//        int j=0;
//        StringBuffer sb=new StringBuffer();
//        while(sb.length()<word1.length()+word2.length()) {
//            if(i<word1.length()) {
//                sb.append(word1.charAt(i));
//                i++;
//            }
//            if(j<word2.length()) {
//                sb.append(word2.charAt(j));
//                j++;
//            }
//        }
//        return sb.toString();
//    }
    
    
//    --------------OPTIMAL -> O(MAX(M, N)), O(1)---------------
//    public String mergeAlternately(String word1, String word2) {
//        int i=0;
//        int j=0;
//        StringBuffer sb=new StringBuffer();
//        while(i<word1.length() && j<word2.length()) {
//            sb.append(word1.charAt(i));
//            i++;
//            sb.append(word2.charAt(j));
//            j++;
//        }
//        sb.append(word1.substring(i));
//        sb.append(word2.substring(j));
//        return sb.toString();
//    }
    
    
    
//    --------------OPTIMAL -> O(MAX(M, N)), O(1)---------------
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        StringBuffer sb=new StringBuffer();
        while(i<word1.length() || i<word2.length()) {
            if(i<word1.length()) {
                sb.append(word1.charAt(i));
            }
            if(i<word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        MergeStringsAlternately m=new MergeStringsAlternately();
        System.out.println(m.mergeAlternately("abc", "pqr"));
        System.out.println(m.mergeAlternately("ab", "pqrs"));
        System.out.println(m.mergeAlternately("abcd", "pq"));
        System.out.println(m.mergeAlternately("g", "pqr"));
        System.out.println(m.mergeAlternately("pqr", "g"));
    }
    
}
