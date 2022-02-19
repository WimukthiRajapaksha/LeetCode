/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid.perfect.square;

/**
 *
 * @author wimukthirajapaksha
 */
public class ValidPerfectSquare {

    /**
     * @param args the command line arguments
     */
    
//    --------------NOT OPTIMAL -> NEW LEARNING----------------
//    public boolean isPerfectSquare(int n) {
//        int m=0;
//        for(int i=1; m<n; i+=2) {
//            m+=i;
//            if(m==n) return true;
//        }
//        return false;
//    }
    
    
//    --------------OPTIMAL -> NEWTON'S METHOD -> IMPRESSIVE----------------
//    public boolean isPerfectSquare(int n) {
//        long r=n;
//        while(r*r>n) {
//            r=(r+(n/r))>>1;
//        }
//        return r*r==n;
//    }
    
    
//    --------------OPTIMAL -> BITWISE OPERATION -> IMPRESSIVE----------------
    public boolean isPerfectSquare(int n) {
        long root=0;
        int bit=1<<15;
        while(bit>0) {
            root|=bit;
            if(root*root>n) {
                root^=bit;
            }
            bit>>>=1;
//            System.out.println(root+" "+bit);
        }
        return root*root==n;
    }
    
    
    
//    --------------OPTIMAL -> BINARY SEARCH -> ITERATIVE----------------
//    public boolean isPerfectSquare(int n) {
//        int i=1, j=n;
//        long m;
//        while(i<=j) {
//            m=i+(j-i)/2;
//            if(m*m==n) return true;
//            else if(m*m>n) j=(int)m-1;
//            else i=(int)m+1;
//        }
//        return false;
//    }
    
    
    
//    --------------OPTIMAL -> BINARY SEARCH -> RECURSIVE----------------
//    public boolean isPerfectSquare(int num) {
//        return bi(num, 1, num);
//    }
//    
//    private boolean bi(int n, int i, int j) {
//        if(i>j) return false;
//        long m=i+(j-i)/2;
//        if(m*m==n) return true;
//        if(m*m>n) {
//            return bi(n, i, (int)m-1);
//        } else {
//            return bi(n, (int)m+1, j);
//        }
//    }
    
    public static void main(String[] args) {
        ValidPerfectSquare v=new ValidPerfectSquare();
        System.out.println(v.isPerfectSquare(16));
        System.out.println(v.isPerfectSquare(15));
        System.out.println(v.isPerfectSquare(1));
    }
}
