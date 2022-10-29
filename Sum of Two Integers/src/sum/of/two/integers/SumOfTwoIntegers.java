/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.of.two.integers;

/**
 *
 * @author wimukthirajapaksha
 */
public class SumOfTwoIntegers {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------------OPTIMAL-----------------
    public int getSum(int a, int b) {
        return (b==0) ? a : getSum(a^b, (a&b)<<1);
    }
    
    
    
//    -------------------OPTIMAL---------------------
//    public int getSum(int a, int b) {
//        int c=0;
//        while(b!=0) {
//            c=a&b;
//            a=a^b;
//            b=c<<1;
//        }
//        return a;
//    }
    
    
    
//    -----------------JUST A SIMPLE SOLUTION----------------------
//    public int getSum(int a, int b) {
//        if(a>b) {
//            return sum(b, a, 0);
//        }
//        return sum(a, b, 0);
//    }
//    
//    private int sum(int a, int b, int c) {
//        if(a==0 && b==0 && c==0) return 0;
//        int tempSum = (a&1) ^ (b&1) ^ (c&1);
//        if((a&1)==1 && (b&1)==1) {
//            c=1;
//        } else if((b&1)==1 && (c&1)==1) {
//            c=1;
//        } else if((a&1)==1 && (c&1)==1) {
//            c=1;
//        } else {
//            c=0;
//        }
//        return (sum(a>>>1, b>>>1, c)<<1)|tempSum;
//    }
    
    public static void main(String[] args) {
        SumOfTwoIntegers s=new SumOfTwoIntegers();
        System.out.println(s.getSum(1, 2));
        System.out.println(s.getSum(-2, -3));
        System.out.println(s.getSum(12, 29));
        System.out.println(s.getSum(0, -1));
        System.out.println(s.getSum(-20, 5));
    }
}
