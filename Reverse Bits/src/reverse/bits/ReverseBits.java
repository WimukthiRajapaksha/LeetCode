/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.bits;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseBits {

    /**
     * @param args the command line arguments
     */
    
    public int reverseBits(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        System.out.println(Integer.toBinaryString(n));
        return n;
    }
    
//    -----------------------ALTERNATE -> NOT OPTIMAL----------------------------
//    public int reverseBits(int n) {
//        int res=0;
//        for (int i=0; i<32; i++) {
//            res = (res<<1)+(n&1);
//            n>>=1;
//        }
//        System.out.println(res);
//        return res;
//    }
    
//    -----------------------ALTERNATE -> NOT OPTIMAL----------------------------
//    public int reverseBits(int n) {
//        int res=0;
//        for (int i=0; i<32; i++) {
//            res<<=1;
//            if((n&1)==1) res++;
//            res>>=1;
//        }
//        System.out.println(b);
//        return b;
//    }
    
    public static void main(String[] args) {
        ReverseBits r=new ReverseBits();
        System.out.println(r.reverseBits(43261596));
    }
}
