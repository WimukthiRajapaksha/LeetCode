/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallest.value.after.replacing.with.sum.of.prime.factors;

/**
 *
 * @author wimukthirajapaksha
 */
public class SmallestValueAfterReplacingWithSumOfPrimeFactors {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL - ITERATIVE -> ?, ?---------------------
    public int smallestValue(int n) {
        while(true) {
            int tempSum=primeSum(n);
            if(n<=tempSum) return n;
            n=tempSum;
        }
    }
    
    private int primeSum(int n) {
        int sum=0;
        for(int i=2; i*i<=n; i++) {
            while(n%i==0) {
                sum+=i;
                n=n/i;
            }
        }
        return n==1 ? sum : sum+n;
    }
    
    
//    ------------------------OPTIMAL - RECURSIVE -> ?, ?-----------------------
//    public int smallestValue(int n) {
//        int p=primeSum(n);
//        if(n==p) {
//            return n;
//        }
//        return smallestValue(p);
//    }
//    
//    private int primeSum(int n) {
//        if(n==1) return 0;
//        for(int i=2; i*i<=n; i++) {
//            if(n%i==0) {
//                return i+primeSum(n/i);
//            }
//        }
//        return n;
//    }
    
    public static void main(String[] args) {
        SmallestValueAfterReplacingWithSumOfPrimeFactors s=new SmallestValueAfterReplacingWithSumOfPrimeFactors();
        System.out.println(s.smallestValue(15));
        System.out.println(s.smallestValue(3));
        System.out.println(s.smallestValue(16));
    }
}
