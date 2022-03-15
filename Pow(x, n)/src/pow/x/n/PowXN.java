/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pow.x.n;

/**
 *
 * @author wimukthirajapaksha
 */
public class PowXN {

    /**
     * @param args the command line arguments
     */
    
//    public double myPow(double x, int n) {
//        long l=n;
//        if(n==0) return 1;
//        else if (n>0) {
//            return power(x, l);
//        }
//        else {
//            return (1/power(x, -1*l));
//        }
//    }
    
    
    
    
//    public double myPow(double x, int n) {
//        if(x==0) return 0;
//        if(n==0) return 1;
//        if (n>0) {
//            return power(x, n-1)*x;
//        }
//        else {
//            return (1/power(x, -1*(n+1)))*(1/x);
//        }
//    }
//    
//    public double power(double x, int n) {
//        if(n==0) return 1;
//        if(n==1) return x;
//        if(n%2==0) {
//            double v=power(x, n/2);
//            return v*v;
//        } else {
//            double v=power(x, n/2);
//            return x*v*v;
//        }
//    }
    
    
    
    
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        else if (n<0) {
            return (1/x)*myPow(1/x, -(n+1));
        }
        return (n%2==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
    
    public static void main(String[] args) {
        PowXN p=new PowXN();
        System.out.println(p.myPow(2.0, 10));
        System.out.println(p.myPow(2.0, -2));
        System.out.println(p.myPow(2.1, 3));
        System.out.println(p.myPow(0.00001, 2147483647));
        System.out.println(p.myPow(1.00000, -2147483648));
        System.out.println(p.myPow(34.00515, -3));
    }
}
