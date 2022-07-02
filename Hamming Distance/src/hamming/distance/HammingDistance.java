/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamming.distance;

/**
 *
 * @author wimukthirajapaksha
 */
public class HammingDistance {

    /**
     * @param args the command line arguments
     */
    
    public int hammingDistance(int x, int y) {
        int z=x^y;
        int c=0;
        while(z!=0) {
            c+=(z&1);
            z=z>>>1;
        }
        return c;
    }
    
    
//    ---------------------ALTERNATE----------------------
//    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x^y);
//    }
    
    public static void main(String[] args) {
        HammingDistance h=new HammingDistance();
        System.out.println(h.hammingDistance(1, 4));
        System.out.println(h.hammingDistance(1, 3));
    }
    
}
