/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.greatest.common.divisor.of.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindGreatestCommonDivisorOfArray {

    /**
     * @param args the command line arguments
     */
    
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i: nums) {
            if (min>i) {
                min=i;
            }
            if (max<i) {
                max=i;
            }
        }
        return euclid(max, min);
    }
    
    public int euclid(int a, int b) {
        if(b==0) {
            return a;
        }
        return euclid(b, a%b);
    }
    
//    public int findGCD(int[] nums) {
//        int min=Integer.MAX_VALUE;
//        int max=Integer.MIN_VALUE;
//        for (int i: nums) {
//            if (min>i) {
//                min=i;
//            }
//            if (max<i) {
//                max=i;
//            }
//        }
//        if (max%min==0) {
//            return min;
//        }
//        for (int i=min/2; i>=1; i--) {
//            if (min%i==0 && max%i==0) {
//                return i;
//            }
//        }
//        return 0;
//    }
    
    public static void main(String[] args) {
        FindGreatestCommonDivisorOfArray f=new FindGreatestCommonDivisorOfArray();
        System.out.println(f.findGCD(new int[]{2,5,6,9,10}));
    }
}
