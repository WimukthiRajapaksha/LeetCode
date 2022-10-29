/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package additive.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class AdditiveNumber {

    /**
     * @param args the command line arguments
     */
    
    public boolean isAdditiveNumber(String num) {
        return back(num, 0, 0, 0, 0);
    }
    
    private boolean back(String s, int i, long sum, long pre, int len) {
        if(i==s.length()) return len>2;
        long curr=0l;
        for(int j=i; j<s.length(); j++) {
            if(j-i>0 && s.charAt(i)=='0') break;
            curr=(curr*10)+(s.charAt(j)-'0');
            if(len>=2) {
                if(sum<curr) {
                    break;
                } else if(sum>curr) {
                    continue;
                }
            }
            if(back(s, j+1, curr+pre, curr, len+1)) {
                return true;
            }
        }
        return false;
    }
    
    
//    -----------------------ALTERNATE-------------------------
//    public boolean isAdditiveNumber(String num) {
//        for(int i=1; i<num.length() && i<18; i++) {
//            if(num.charAt(0)=='0' && i>1) break;
//            for(int j=i+1; j<num.length() && j-i<18; j++) {
//                if(num.charAt(i)=='0' && j-i>1) continue;
//                if(back(num, j, Long.valueOf(num.substring(0, i)), Long.valueOf(num.substring(i, j)))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    private boolean back(String s, int i, long fir, long sec) {
//        if(i==s.length()) {
//            return true;
//        }
//        
//        for(int j=i+1; j<=s.length() && j-i<18; j++) {
//            if(s.charAt(i)=='0' && j-i>1) continue;
//            if(fir+sec==Long.valueOf(s.substring(i, j))) {
//                return back(s, j, sec, Long.valueOf(s.substring(i, j)));
//            }
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        AdditiveNumber a=new AdditiveNumber();
        System.out.println(a.isAdditiveNumber("000"));
        System.out.println(a.isAdditiveNumber("101"));
        System.out.println(a.isAdditiveNumber("1203"));
        System.out.println(a.isAdditiveNumber("112358"));
        System.out.println(a.isAdditiveNumber("1991001"));
        System.out.println(a.isAdditiveNumber("199100199"));
        System.out.println(a.isAdditiveNumber("19910019919910019919910019919910019"));
    }
}
