/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.integer;

/**
 *
 * @author wimukthirajapaksha
 */
public class ReverseInteger {

    /**
     * @param args the command line arguments
     */
    
//    -------------CAN BE REJECTED AS WE ARE USING LONG---------------
//    public int reverse(int x) {
//        long r=0;
//        while(x!=0) {
//            r=(r*10)+x%10;
//            x/=10;
//        }
//        if(r>=Integer.MAX_VALUE || r<=Integer.MIN_VALUE) return 0;
//        return (int)r;
//    }
    
    
    
    public int reverse(int x) {
        int r=0;
        int pre=0;
        while(x!=0) {
            r=(r*10)+x%10;
            if((r-(x%10))/10!=pre) return 0;
            pre=r;
            x/=10;
        }
        return r;
    }
    
    
//    --------------------------ALTERNATE-------------------------
//    public int reverse(int x) {
//        int r=0;
//        while(x!=0) {
//            if(r>Integer.MAX_VALUE/10 || (r==Integer.MAX_VALUE/10 && x>=Integer.MAX_VALUE%10) || r<Integer.MIN_VALUE/10 || (r==Integer.MIN_VALUE/10 && x<=Integer.MIN_VALUE%10)) return 0;
//            r=(r*10)+x%10;
//            x/=10;
//        }
//        return r;
//    }
    
    public static void main(String[] args) {
        ReverseInteger r=new ReverseInteger();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-12));
        System.out.println(r.reverse(1534236469));
//        System.out.println(Integer.bitCount(1534236469)>Math.pow(2, 31));
    }
}
