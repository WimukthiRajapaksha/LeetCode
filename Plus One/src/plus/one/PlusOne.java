/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plus.one;

/**
 *
 * @author wimukthirajapaksha
 */
public class PlusOne {

    /**
     * @param args the command line arguments
     */
    
    public int[] plusOne(int[] digits) {
        int rem=1;
        for (int i=digits.length-1; i>=0; i--) {
            digits[i]=(rem+digits[i]);
            if (digits[i]<=9) {
                return digits;
            }
            rem=1;
            digits[i]=0;
        }
        int[] ret = new int[digits.length+1];
        ret[0]=1;
        return ret;
    }
    
    
//    -----------------------ALTERNATE -> NOT OPTIMAL----------------------
//    public int[] plusOne(int[] digits) {
//        int rem=1;
//        for (int i=digits.length-1; i>=0; i--) {
//            System.out.println(rem+" "+i);
//            int temp = digits[i];
//            digits[i]=(rem+digits[i])%10;
//            rem=(rem+temp)/10;
//            if (rem==0) {
//                System.out.println("0000 "+i);
//                return digits;
//            }
//        }
//        System.out.println(rem);
//        if (rem==1) {
//            int[] ret = new int[digits.length+1];
//            ret[0]=1;
//            return ret;
//        }
//        return new int[]{};
//    }
    
    public static void main(String[] args) {
        PlusOne p = new PlusOne();
//        p.plusOne(new int[]{4,3,2,1});
        p.plusOne(new int[]{9, 9});
    }
    
}
