/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divide.two.integers;

/**
 *
 * @author wimukthirajapaksha
 */
public class DivideTwoIntegers {

    /**
     * @param args the command line arguments
     */
    
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
        boolean neg=false;
        if(dividend<0 ^ divisor<0) neg=true;
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        System.out.println(dvd+" "+dvs);
        int sum=0;
        while(dvd>=dvs) {
            int x=1;
            long temp=dvs;
            while(dvd>=(temp<<1)) {
                temp<<=1;
                x<<=1;
            }
            sum+=x;
            dvd-=temp;
        }
        return (neg) ? -sum : sum;
    }
    
    public static void main(String[] args) {
        DivideTwoIntegers d=new DivideTwoIntegers();
        System.out.println(d.divide(10, 3));
        System.out.println(d.divide(7, -3));
        System.out.println(d.divide(-2147483648, 1));
    }
}
