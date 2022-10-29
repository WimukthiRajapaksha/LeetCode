/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwise.and.of.numbers.range;

/**
 *
 * @author wimukthirajapaksha
 */
public class BitwiseANDOfNumbersRange {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> ITERATIVE---------------------
    public int rangeBitwiseAnd(int left, int right) {
        if(left==0) return 0;
        int t=0;
        while(left!=right) {
            left>>>=1;
            right>>>=1;
            t++;
        }
        return left<<t;
    }
    
    
//    ----------------------OPTIMAL -> RECURSIVE---------------------
//    public int rangeBitwiseAnd(int left, int right) {
//        if(left==right) return left;
//        return (rangeBitwiseAnd(left>>>1, right>>>1)<<1);
//    }
    
    public static void main(String[] args) {
        BitwiseANDOfNumbersRange b=new BitwiseANDOfNumbersRange();
        System.out.println(b.rangeBitwiseAnd(5, 7));
        System.out.println(b.rangeBitwiseAnd(0, 0));
        System.out.println(b.rangeBitwiseAnd(1, 2147483647));
    }
}
