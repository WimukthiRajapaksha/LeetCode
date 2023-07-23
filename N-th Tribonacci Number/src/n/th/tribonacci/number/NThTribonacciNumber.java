/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.th.tribonacci.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class NThTribonacciNumber {

    /**
     * @param args the command line arguments
     */
    
//    public int tribonacci(int n) {
//        if(n==0) return 0;
//        int a=0;
//        int b=1;
//        int c=1;
//        while(n-->2) {
//            int next=a+b+c;
//            a=b;
//            b=c;
//            c=next;
//        }
//        return c;
//    }
    
    public int tribonacci(int n) {
        int[] arr={0, 1, 1};
        for(int i=3; i<=n; i++) {
            arr[i%3]=arr[0]+arr[1]+arr[2];
        }
        return arr[n%3];
    }
    
    public static void main(String[] args) {
        NThTribonacciNumber n=new NThTribonacciNumber();
        System.out.println(n.tribonacci(4));
        System.out.println(n.tribonacci(25));
    }
}
