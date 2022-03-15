/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.to.integer.atoi;

/**
 *
 * @author wimukthirajapaksha
 */
public class StringToIntegerAtoi {

    /**
     * @param args the command line arguments
     */
    
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        int b=0;
        while(b<s.length()) {
            if(s.charAt(b)!=' ') break;
            b++;
        }
        if(b==s.length()) return 0;
        int sign=1;
        
        if(s.charAt(b)=='-') {
            sign=-1;
            b++;
        } else if (s.charAt(b)=='+') {
            b++;
        }
        int v=0;
        int d=0;
        while(b<s.length() && Character.isDigit(s.charAt(b))) {
            d=s.charAt(b)-'0';
            if(v>Integer.MAX_VALUE/10 || (v==Integer.MAX_VALUE/10 && d>Integer.MAX_VALUE%10)) {
                return sign>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            v=(v*10)+d;
            b++;
        }
        return sign*v;
    }
    
    
//    -------------------ALTERNATE -> OPTIMAL-----------------------
//    public int myAtoi(String s) {
//        if(s.length()==0) return 0;
//        int b=0;
//        while(b<s.length()) {
//            if(s.charAt(b)!=' ') break;
//            b++;
//        }
//        if(b==s.length()) return 0;
//        int sign=1;
//        
//        if(s.charAt(b)=='-') {
//            sign=-1;
//            b++;
//        } else if (s.charAt(b)=='+') {
//            b++;
//        }
//        int v=0;
//        int d=0;
//        for(int i=b; i<s.length(); i++) {
//            d=s.charAt(i);
//            if(d>='0' && d<='9') {
//                d-='0';
//                if((sign*v>Integer.MAX_VALUE/10 || (sign*v==Integer.MAX_VALUE/10 && sign*d>=Integer.MAX_VALUE%10)) ||
//                        (sign*v<Integer.MIN_VALUE/10 || (sign*v==Integer.MIN_VALUE/10 && sign*d<=Integer.MIN_VALUE%10))
//                        ) {
//                    return sign>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//                }
//                v=(v*10)+d;
//            } else {
//                return sign*v;
//            }
//        }
//        return sign*v;
//    }
    
    
//    -------------------ALTERNATE -> OPTIMAL-----------------------
//    public int myAtoi(String s) {
//        s=s.trim();
//        if(s.length()==0) return 0;
//        int sign=1;
//        int b=0;
//        if(s.charAt(0)=='-') {
//            sign=-1;
//            b=1;
//        } else if (s.charAt(0)=='+') {
//            b=1;
//        }
//        long v=0;
//        int d=0;
//        while(b<s.length() && Character.isDigit(s.charAt(b))) { // while(b<s.length() && s.charAt(b)>='0' && s.charAt(b)<='9') {
//            d=s.charAt(b)-'0';
//            if(v>Integer.MAX_VALUE/10 || (v==Integer.MAX_VALUE/10 && d>Integer.MAX_VALUE%10)) {
//                return sign>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//            v=(v*10)+d;
//            b++;
//        }
//        return sign*(int)v;
//    }
    
    public static void main(String[] args) {
        StringToIntegerAtoi s=new StringToIntegerAtoi();
        System.out.println(s.myAtoi(" -0193 with words"));
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi(" 2147483648")); //2147483647
        System.out.println(s.myAtoi("  -2147483649")); //-2147483648
        System.out.println(s.myAtoi("     "));
        System.out.println(s.myAtoi("-2147483647"));
    }
    
}
