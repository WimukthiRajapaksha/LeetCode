/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nth.digit;

/**
 *
 * @author wimukthirajapaksha
 */
public class NthDigit {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(LOGN), O(1)---------------
    public int findNthDigit(int n) {
        long digits=9;
        int first=1;
        int length=1;
        while(n>length*digits) {
            n-=(length*digits);
            first*=10;
            length++;
            digits*=10;
        }
        first+=((n-1)/length);
        String s=Integer.toString(first);
        return Character.getNumericValue(s.charAt((n-1)%length));
    }
    
    
        
    
//    --------------OPTIMAL -> O(LOGN), O(1)---------------
//    public int findNthDigit(int n) {
//        int len = 1;
//        long count = 9;
//        int start = 1;
//
//        while (n > len * count) {
//                n -= len * count;
//                len += 1;
//                count *= 10;
//                start *= 10;
//        }
//
//        start += (n - 1) / len;
//        String s = Integer.toString(start);
//        return Character.getNumericValue(s.charAt((n - 1) % len));
//    }
    
    
    
    public static void main(String[] args) {
        NthDigit n=new NthDigit();
        System.out.println(n.findNthDigit(9));
        System.out.println(n.findNthDigit(11));
        System.out.println(n.findNthDigit(1000000000));
        System.out.println(n.findNthDigit(811));
    }
}
