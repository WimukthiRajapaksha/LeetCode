/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimum.flips.to.make.a.or.b.equal.to.c;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimumFlipsToMakeAORBEqualToC {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> O(N), O(1)-----------------
//    public int minFlips(int a, int b, int c) {
//        int mask=1<<30;
//        int val=0;
//        int count=0;
//        while(mask>0) {
//            if((val|mask)<=c) {
//                val|=mask;
//                if((a&mask)==0 && (b&mask)==0) {                    
//                    count++;
//                }
//            } else {
//                if((a&mask)!=0) {
//                    count++;
//                }
//                if((b&mask)!=0) count++;
//            }
//            mask>>>=1;
//        }
//        return count;
//    }
    
    
    
    
//    ---------------OPTIMAL -> O(N), O(1)-------------
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(c>0 || a>0 || b>0) {
            if((c&1)==1) {
                if((a&1)==0 && (b&1)==0) {
                    count++;
                }
            } else {
                count+= (a&1) + (b&1);
            }
            c>>>=1;
            b>>>=1;
            a>>>=1;
        }
        return count;
    }
    
    
    
//    -------------- OPTIMAL -> O(N), O(1)--------------------
//    public int minFlips(int a, int b, int c) {
//        return Integer.bitCount((a|b)^c)+Integer.bitCount((a&b)&((a|b)^c));
//    }
    
    
//    -------------- OPTIMAL -> O(N), O(1)--------------------
//    public int minFlips(int a, int b, int c) {
//        return Integer.bitCount(c^=(a|b))+Integer.bitCount((a&b)&c);
//    }
    
    public static void main(String[] args) {
        MinimumFlipsToMakeAORBEqualToC m=new MinimumFlipsToMakeAORBEqualToC();
        System.out.println(m.minFlips(2, 6, 5));
        System.out.println(m.minFlips(4, 2, 7));
        System.out.println(m.minFlips(1, 2, 3));
    }
}

001
010

011