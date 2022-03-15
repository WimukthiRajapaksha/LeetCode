/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arranging.coins;

/**
 *
 * @author wimukthirajapaksha
 */
public class ArrangingCoins {

    /**
     * @param args the command line arguments
     */
    
//    ---------------ALTERNATE -> NOT OPTIMAL--------------
//    public int arrangeCoins(int n) {
//        int i=1;
//        long t=0;
//        while(n>t) {
//            t+=i;
//            i++;
//        }
//        return n==t ? i-1 : i-2;
//    }
    
    
//    ---------------OPTIMAL -> ITERATIVE-----------------
//    public int arrangeCoins(int n) {
//        long i=1;
//        long j=n;
//        long m;
//        long x;
//        while(i<=j) {
//            m=(i+j)/2;
//            x=(1+m)*m/2;
//            if(x==n) {
//                return (int)m;
//            } else if(x>n) {
//                j=m-1;
//            } else {
//                i=m+1;
//            }
//        }
//        return (int)j;
//    }
    
    
//    ---------------OPTIMAL -> RECURSIVE-----------------
//    public int arrangeCoins(int n) {
//        return bin(1, n, n);
//    }
//    
//    private int bin(long i, long j, int n) {
//        if(i>j) return (int)j;
//        long m=i+(j-i)/2;
//        long t=(1+m)*m/2;
//        if(t==n) {
//            return (int)m;
//        } else if(t>n) {
//            return bin(i, m-1, n);
//        } else {
//            return bin(m+1, j, n);
//        }
//    }
    
    
//    ---------------OPTIMAL -> BIT MASKING ;)-----------------
    public int arrangeCoins(int n) {
        int mask=1<<15;
        long res=0;
        while(mask!=0) {
            res=res|mask;
            long t=res*(res+1)/2;
            if(t>n) {
                res^=mask;
            } 
            mask>>>=1;
        }
        return (int)res;
    }
    
    
    public static void main(String[] args) {
        ArrangingCoins a=new ArrangingCoins();
        System.out.println(a.arrangeCoins(8));
        System.out.println(a.arrangeCoins(25));
        System.out.println(a.arrangeCoins(2147483647));
        System.out.println(a.arrangeCoins(3));
        System.out.println(a.arrangeCoins(1804289383));
    }
}
