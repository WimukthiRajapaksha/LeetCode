/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqrt.x;

/**
 *
 * @author wimukthirajapaksha
 */
public class SqrtX {

    /**
     * @param args the command line arguments
     */
    
    public int mySqrt(int x) {
        int i=1;
        int j=x;
        while(i<=j) {
            long mid = ((long)i+j)/2;
            if (mid*mid==x) {
                return (int)mid;
            } else if (mid*mid<x) {
                i=(int)mid+1;
            } else {
                j=(int)mid-1;
            }
        }
        System.out.println(j);
        return j;
    }
    
//    --------------------ALTERNATE -> RECURSIVE--------------
//    public int mySqrt(int x) {
//        return binSea(x, 1, x);
//    }
//    
//    public int binSea(int x, int i, int j) {
//        long mid = ((long)i+j)/2;
//        if (i>j) {
//            return (int)j;
//        }
//        if ((long)mid*mid==x) {
//            return (int)mid;
//        } else if ((long)mid*mid>x) {
//            return binSea(x, i, (int)mid-1);
//        } else {
//            return binSea(x, (int)mid+1, j);
//        }
//    }
    
    public static void main(String[] args) {
        SqrtX s = new SqrtX();
//        s.mySqrt(4);
//        s.mySqrt(16);
//        s.mySqrt(15);
//        s.mySqrt(1);
//        s.mySqrt(2147395599);
        System.out.println(s.mySqrt(2147483647));
    }
}
