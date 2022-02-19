/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decode.xored.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class DecodeXORedArray {

    /**
     * @param args the command line arguments
     */
    
    public int[] decode(int[] encoded, int first) {
        int[] ret=new int[encoded.length+1];
        ret[0]=first;
        for (int i=0; i<encoded.length; i++) {
            ret[i+1]=encoded[i]^first;
            first=ret[i+1];
        }
        for (int i: ret) {
            System.out.print(i+" ");
        }
        System.out.println();
        return new int[]{};
    }
    
    public static void main(String[] args) {
        DecodeXORedArray d=new DecodeXORedArray();
        d.decode(new int[]{6,2,7,3}, 4);
        d.decode(new int[]{6}, 1);
    }
}
