/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count.primes;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountPrimes {

    /**
     * @param args the command line arguments
     */
    
//    -----------------------OPTIMAL-------------------------
//    public int countPrimes(int n) {
//        if(n<2) {
//            return 0;
//        }
//        boolean[] arr=new boolean[n];
//        Arrays.fill(arr, true);
//        int c=0;
//        for(int i=2; i<n; i++) {
//            if(!arr[i]) {
//                continue;
//            }
//            c++;
//            for(int j=2; j*i<n; j++) {
//                arr[j*i]=false;
//            }
//        }
//        return c;
//    }
    
    
//    -----------------------OPTIMAL-------------------------
    public int countPrimes(int n) {
        if(n<2) {
            return 0;
        }
        boolean[] arr=new boolean[n];
        int c=0;
        for(int i=2; i<n; i++) {
            if(arr[i]) {
                continue;
            }
            c++;
            for(int j=2; j*i<n; j++) {
                arr[j*i]=true;
            }
        }
        return c;
    }
    
    
    
//    -----------------------OPTIMAL-------------------------
//    public int countPrimes(int n) {
//        if(n<2) {
//            return 0;
//        }
//        boolean[] arr=new boolean[n];
//        for(int i=2; i*i<=n; i++) {
//            if(arr[i]) {
//                continue;
//            }
//            for(int j=2; j*i<n; j++) {
//                arr[j*i]=true;
//            }
//        }
//        
//        for(int i=2; i<n; i++) {
//            c+=(!arr[i]) ? 1 : 0;
//        }
//        return c;
//    }
    
    
//    -----------------------OPTIMAL-------------------------
//    public int countPrimes(int n) {
//        if(n<2) {
//            return 0;
//        }
//        boolean[] arr=new boolean[n];
//        Arrays.fill(arr, true);
//        arr[0]=false;
//        for(int i=1; i<arr.length; i++) {
//            int j=i+1;
//            if(!arr[j-1]) {
//                continue;
//            }
//            j+=j;
//            while(j<=arr.length) {
//                arr[j-1]=false;
//                j+=i+1;
//            }
//        }
//        int c=0;
//        for(int i=1; i<arr.length-1; i++) {
//            c+= arr[i] ? 1 : 0;
//        }
//        return c;
//    }
    
    
//    -------------------NOT OPTIMAL -> TLE EXCEPTION-------------------------
//    private boolean isPrime(int n) {
//        for(int i=2; i*i<=n; i++) {
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//    
//    public int countPrimes(int n) {
//        if(n<2) {
//            return 0;
//        }
//        if(n==2) {
//            return 0;
//        }
//        int c=1;
//        for(int i=3; i<n; i++) {
//            c+=isPrime(i) ? 1 : 0;
//        }
//        return c;
//    }
    
    public static void main(String[] args) {
        CountPrimes c=new CountPrimes();
        System.out.println(c.countPrimes(2));
        System.out.println(c.countPrimes(3));
        System.out.println(c.countPrimes(0));
        System.out.println(c.countPrimes(30));
        System.out.println(c.countPrimes(100));
        System.out.println(c.countPrimes(5000000));
    }
}


//0
//1
//0
//25
//78498