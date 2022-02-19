/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.of.three;

/**
 *
 * @author wimukthirajapaksha
 */
public class PowerOfThree {

    /**
     * @param args the command line arguments
     */
    
//    ----------------ALTERNATE -> OPTIMAL----------------
//    public boolean isPowerOfThree(int n) {
//        if(n<=0) return false;
//        if(n==1) return true;
//        else if(n%3==0) return isPowerOfThree(n/3);
//        else return false;
//    }
    
    
    
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        if((n&1)==0) return false;
        while(n%3==0 && n>1) {
            n=n/3;
        }
        return (n==1);
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-------------
//    public boolean isPowerOfThree(int n) {
//        return (n>0 && Math.pow(3, 19)%n==0);
//    }
    
    public static void main(String[] args) {
        PowerOfThree p=new PowerOfThree();
        System.out.println(p.isPowerOfThree(45));
        System.out.println(p.isPowerOfThree(81));
        System.out.println(Math.pow(3, 19));
    }
    
}
