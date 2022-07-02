/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number.complement;

/**
 *
 * @author wimukthirajapaksha
 */
public class NumberComplement {

    /**
     * @param args the command line arguments
     */
    
    public int findComplement(int num) {
        if(num==0) return 0;
        return (findComplement(num>>1)<<1) | ((num&0x00000001)^1);
    }
    
//    public int findComplement(int num) {
//        int v=num;
//        int mask=1;
//        while(num!=0) {
//            v=v^mask;
//            mask<<=1;
//            num>>>=1;
//        }
//        return v;
//    }
    
    public static void main(String[] args) {
        NumberComplement n=new NumberComplement();
        System.out.println(n.findComplement(26));
        System.out.println(n.findComplement(5));
        System.out.println(n.findComplement(1));
    }
}
