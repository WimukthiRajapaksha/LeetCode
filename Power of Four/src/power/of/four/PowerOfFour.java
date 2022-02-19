/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.of.four;

/**
 *
 * @author wimukthirajapaksha
 */
public class PowerOfFour {

    /**
     * @param args the command line arguments
     */
    
//    -------------------ALTERNATE -> OPTIMAL-----------------------
//    public boolean isPowerOfFour(int n) {
//        if(n==1) return true;
//        if(n<=0 || n%4!=0) return false;
//        return isPowerOfFour(n/4);
//    }
    
    
//    -------------------ALTERNATE -> OPTIMAL-----------------------
//    public boolean isPowerOfFour(int n) {
//        if(n<=0) return false;
//        while(true) {
//            if (n==1) {
//                return true;
//            } else if((n&3)==0) {
//                n=(n>>>2);
//            } else {
//                return false;
//            }
//        }
//    }
    
    
    public boolean isPowerOfFour(int n) {
        return (n>0 && (n&(n-1))==0 && (n&0xaaaaaaaa)==0);
    }
    
    public static void main(String[] args) {
        PowerOfFour p=new PowerOfFour();
        System.out.println(p.isPowerOfFour(4));
        System.out.println(p.isPowerOfFour(16));
    }
    
}
