/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class FibonacciNumber {
    
    
//    ------------------ALTERNATE -> OPTIMAL -> NO ARRAYS USED-----------------
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int a=0;
        int b=1;
        int s=0;
        for(int i=2; i<=n; i++) {
            s=a+b;
            a=b;
            b=s;
        }
        return s;
    }
    
    
//    ------------------ALTERNATE -> OPTIMAL-----------------
//    public int fib(int n) {
//        if(n==0 || n==1) return n;
//        int[] arr=new int[n+1];
//        arr[0]=0;
//        arr[1]=1;
//        for(int i=2; i<arr.length; i++) {
//            arr[i]=arr[i-1]+arr[i-2];
//        }
//        return arr[arr.length-1];
//    }
    
    public static void main(String[] args) {
        
    }
}
