/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.of.pkg1.bits;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberOf1Bits {

    /**
     * @param args the command line arguments
     */
    
    public int hammingWeight(int n) {
        System.out.println(Integer.toBinaryString(n));
        n = (n & (0x55555555)) + ((n >> 1) & (0x55555555));
        System.out.println(Integer.toBinaryString(n));
        n = (n & (0x33333333)) + ((n >> 2) & (0x33333333));
        System.out.println(Integer.toBinaryString(n));
        n = (n & (0x0f0f0f0f)) + ((n >> 4) & (0x0f0f0f0f));
        System.out.println(Integer.toBinaryString(n));
        n = (n & (0x00ff00ff)) + ((n >> 8) & (0x00ff00ff));
        System.out.println(Integer.toBinaryString(n));
        n = (n & (0x0000ffff)) + ((n >> 16) & (0x0000ffff));
        System.out.println(Integer.toBinaryString(n));
        return n;
    }
    
    
//    public int hammingWeight(int n) {
//        int c=0;
//        while(n!=0) {
//            n=(n&n-1);
//            c++;
//        }
//        return c;
//    }
    
    
//    -----------------------RECURSIVE--------------------------
//    public int hammingWeight(int n) {
//        if(n==0) {
//            return 0;
//        }
//        return (n&1)+hammingWeight(n>>>1);
//    }
    
    
//    -----------------------ITERATIVE---------------------------
//    public int hammingWeight(int n) {
//        int c=0;
//        int d=1;
//        for (int i=0; i<32; i++) {
//            if ((n&1)==1) c++;
//            n>>=1;
//        }
//        System.out.println(c);
//        return c;
//    }
    
    public static void main(String[] args) {
        NumberOf1Bits n=new NumberOf1Bits();
        System.out.println(n.hammingWeight(2147483645));
    }
    
}
