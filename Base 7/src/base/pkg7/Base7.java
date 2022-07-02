/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.pkg7;

/**
 *
 * @author wimukthirajapaksha
 */
public class Base7 {

    /**
     * @param args the command line arguments
     */
    
    public String convertToBase7(int num) {
        if(num<0) return "-"+convertToBase7(-num);
        if(num<7) return Integer.toString(num);
        return convertToBase7(num/7)+Integer.toString(num%7);
    }
    
    
//    public String convertToBase7(int num) {
//        if(num==0) return "0";
//        StringBuilder sb=new StringBuilder();
//        if(num<0) {
//            calc(-num, sb);
//            sb.append("-");
//        } else {
//            calc(num, sb);
//        }
//        System.out.println(sb.reverse().toString());
//        return sb.reverse().toString();
//    }
//    
//    private void calc(int n, StringBuilder sb) {
//        if(n==0) {
//            return;
//        }
//        sb.append(n%7);
//        calc(n/7, sb);
//    }
    
    public static void main(String[] args) {
        Base7 b=new Base7();
        System.out.println(b.convertToBase7(100));
        System.out.println(b.convertToBase7(-7));
    }
}
