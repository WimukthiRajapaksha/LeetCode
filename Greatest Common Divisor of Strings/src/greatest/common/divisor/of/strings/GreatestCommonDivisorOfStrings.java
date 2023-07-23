/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greatest.common.divisor.of.strings;

/**
 *
 * @author wimukthirajapaksha
 */
public class GreatestCommonDivisorOfStrings {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------OPTIMAL -> O(M+N), O(M+N)----------------
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int val=gcd(str1.length(), str2.length());
        return str1.substring(0, val);
    }
    
    public int gcd(int i, int j) {
        if(j==0) return i;
        return gcd(j, i%j);
    }
    
    
    
//    ----------------- ALTERNATE -----------------
//    public String gcdOfStrings(String str1, String str2) {
//        if(str1.length()<str2.length()) {
//            return gcdOfStrings(str2, str1);
//        }
//        for(int i=str2.length(); i>0; i--) {
//            if(isdiv(str1, str2.substring(0, i)) && isdiv(str2, str2.substring(0, i))) {
//                return str2.substring(0, i);
//            }
//        }
//        return "";
//    }
//    
//    private boolean isdiv(String s1, String s2) {
//        if(s1.length()%s2.length()!=0) return false;
//        for(int i=0; i<s1.length(); i+=s2.length()) {
//            if(!s1.substring(i, i+s2.length()).equals(s2)) return false;
//        }
//        return true;
//    }
    
    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings g=new GreatestCommonDivisorOfStrings();
        System.out.println(g.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(g.gcdOfStrings("LEET", "CODE"));
        System.out.println(g.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}
