/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeated.substring.pattern;

/**
 *
 * @author wimukthirajapaksha
 */
public class RepeatedSubstringPattern {

    /**
     * @param args the command line arguments
     */
    
//    -----------------OPTIMAL -> KMP -> COMPLEX--------------------
    public boolean repeatedSubstringPattern(String s) {
        int[] kmp=new int[s.length()+1];
        int i=0;
        int j=1;
        while(j<s.length()) {
            if(s.charAt(i)==s.charAt(j)) {
                kmp[++j]=++i;
            } else if(i==0) j++;
            else {
                i=kmp[i];
            }
        }
        return kmp[s.length()] != 0 && (kmp[s.length()]%(s.length()-kmp[s.length()])==0);
    }
    
    
//    -----------------NOT OPTIMAL--------------------
//    public boolean repeatedSubstringPattern(String s) {
//        StringBuilder ss = new StringBuilder(s).append(s);
//        return ss.toString().substring(1, ss.toString().length()-1).contains(s);
//    }
    
    
//    -----------------OPTIMAL--------------------
//    public boolean repeatedSubstringPattern(String s) {
//        for(int i=s.length()/2; i>0; i--) {
//            if(s.length()%i==0) {
//                if(s.charAt(i-1)!=s.charAt(s.length()-1)) continue;
//                int t=s.length()/i;
//                String sub=s.substring(0, i);
//                for(int j=0; j<t; j++) {
//                    if(!s.substring(i*j, (i*j)+i).equals(sub)) {
//                        break;
//                    }
//                    if(j==t-1) return true;
//                }
//            }
//        }
//        return false;
//    }
    
    
//    -----------------OPTIMAL--------------------
//    public boolean repeatedSubstringPattern(String s) {
//        for(int i=s.length()/2; i>0; i--) {
//            if(s.length()%i==0) {
//                StringBuilder sb=new StringBuilder();
//                String temp=s.substring(0, i);
//                while(sb.length()<s.length()) {
//                    sb.append(temp);
//                }
//                if(s.equals(sb.toString())) return true;
//            }
//        }
//        return false;
//    }
    
    
    public static void main(String[] args) {
        RepeatedSubstringPattern r=new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(r.repeatedSubstringPattern("aba"));
        System.out.println(r.repeatedSubstringPattern("abab"));
    }
}
