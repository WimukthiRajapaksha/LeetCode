/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.of.two;

/**
 *
 * @author wimukthirajapaksha
 */
public class PowerOfTwo {

    /**
     * @param args the command line arguments
     */
    
    public boolean isPowerOfTwo(int n) {
        return ((n>0) && (n&(n-1))==0);
    }
    
//    ------------------------ALTERNATE------------------------
//    public boolean isPowerOfTwo(int n) {
//        while(n>0) {
//            if((n&1)==1) return (n>>>1==0);
//            n=n>>>1;
//        }
//        return false;
//    }
    
    public static void main(String[] args) {
        PowerOfTwo p=new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(31));
    }
    
}
