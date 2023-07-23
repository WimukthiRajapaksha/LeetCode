/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.square.numbers;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfSquareNumbers {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> O(SQRT(C)*LOG(C)), O(1)------------------
//    public boolean judgeSquareSum(int c) {
//        for(long i=0; i*i<=c; i++) {
//            long j=c-(i*i);
//            if(bs(0, j, j)) return true;
//        }
//        return false;
//    }
//    
//    public boolean bs(long l, long r, long t) {
//        while(l<=r) {
//            long m=l+(r-l)/2;
//            if(m*m==t) return true;
//            else if(m*m<t) {
//                l=m+1;
//            } else {
//                r=m-1;
//            }
//        }
//        return false;
//    }
    
    
    
//    ----------------------OPTIMAL -> O(C^2), O(1)------------------
    public boolean judgeSquareSum(int c) {
        int i=0;
        int j=(int)Math.sqrt(c);
        while(i<=j) {
            long a = (i*(long)i)+(j*(long)j);
            if(a==c) {
                return true;
            }
            while(i<=j && a>c) {
                j--;
                a = (i*(long)i)+(j*(long)j);
            }
            while(i<=j && a<c) {
                i++;
                a = (i*(long)i)+(j*(long)j);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SumOfSquareNumbers s=new SumOfSquareNumbers();
        System.out.println(s.judgeSquareSum(5));
        System.out.println(s.judgeSquareSum(3));
        System.out.println(s.judgeSquareSum(32));
        System.out.println(s.judgeSquareSum(0));
        System.out.println(s.judgeSquareSum(1));
        System.out.println(s.judgeSquareSum(2147483646));
    }
}
