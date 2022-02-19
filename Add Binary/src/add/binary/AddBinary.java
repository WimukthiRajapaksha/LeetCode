/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add.binary;

/**
 *
 * @author wimukthirajapaksha
 */
public class AddBinary {

    /**
     * @param args the command line arguments
     */
    
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder s=new StringBuilder();
        int rema=0;
        while(i>=0 || j>=0 || rema>0) {
            rema+= (i>=0) ? a.charAt(i--)-'0' : 0;
            rema+= (j>=0) ? b.charAt(j--)-'0' : 0;
            s.append(rema%2);
            rema/=2;
        }
        return s.reverse().toString();
    }
    
    
//    ---------------ALTERNATE -> NOT OPTIMAL--------------------------
//    public String addBinary(String a, String b) {
//        for (int i=1; i<=Math.max(a.length(), b.length()); i++) {
//            if (a.length()<i) {
//                a=0+a;
//            }
//            if (b.length()<i) {
//                b=0+b;
//            }
//        }
////        System.out.println(a+" "+b);
//        String s="";
//        int rema=0;
////        System.out.println("----");
//        for (int i=a.length()-1; i>=0; i--) {
//            int val = Integer.parseInt(String.valueOf(a.charAt(i)))+Integer.parseInt(String.valueOf(b.charAt(i)))+rema;
//            s=(val%2)+s;
//            rema=val/2;
////            System.out.println(Integer.parseInt(String.valueOf(a.charAt(i)))+" "+Integer.parseInt(String.valueOf(b.charAt(i)))+" "+rema);
//        }
//        if (rema>0) {
//            s=rema+s;
//        }
//        System.out.println(s);
//        return "";
//    }
    
    public static void main(String[] args) {
//        System.out.println('0'+'1'-2*48);
//        System.out.println('1'+'2'-2*48);
        AddBinary a = new AddBinary();
        a.addBinary("1111", "1111");
//        a.addBinary("11", "1");
//        a.addBinary("110101", "1");
    }
}
