/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.segments.in.a.string;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOfSegmentsInAString {

    /**
     * @param args the command line arguments
     */
    
    public int countSegments(String s) {
        int i=0;
        int c=0;
        while(i<s.length()) {
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' ')) {
                c++;
            }
            i++;
        }
        return c;
    }
    
    
    
//    -------------------OPTIMAL------------------
//    public int countSegments(String s) {
//        int i=0;
//        int c=0;
//        while(i<s.length()) {
//            if(i>0 && s.charAt(i-1)!=' ' && s.charAt(i)==' ') {
//                c++;
//            }
//            i++;
//        }
//        return (i>0 && (s.charAt(i-1)) != ' ') ? c+1 : c;
//    }
    
    
    
//    -------------------OPTIMAL-------------------
//    public int countSegments(String s) {
//        int e=s.length()-1;
//        int b=0;
//        while(b<=e) {
//            if(s.charAt(b)==' ') b++;
//            else break;
//        }
//        if(b>e || (b==e && s.charAt(b)==' ')) return 0;
//        int c = (b==0) ? 1 : 0;
//        while(b<=e) {
//            if(b>0 && s.charAt(b)!=' ' && s.charAt(b-1)==' ') {
//                c++;
//            }
//            b++;
//        }
//        return c;
//    }
    
    public static void main(String[] args) {
        NumberOfSegmentsInAString n=new NumberOfSegmentsInAString();
        System.out.println(n.countSegments("  Hello, my name is John  "));
        System.out.println(n.countSegments(" "));
        System.out.println(n.countSegments(""));
        System.out.println(n.countSegments("a"));
        System.out.println(n.countSegments("Of all the gin joints in all the towns in all the world,   "));
    }
}
