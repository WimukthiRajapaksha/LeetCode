/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting.bits;

/**
 *
 * @author wimukthirajapaksha
 */
public class CountingBits {

    /**
     * @param args the command line arguments
     */
    
//    ------------------OPTIMAL -> BUT NOT NICE LOGIC------------------
//    public int[] countBits(int n) {
//        int[] a=new int[n+1];
//        a[1]=1;
//        int j=1;
//        int k=2;
//        while(true) {
//            int m=j;
//            boolean add=false;
//            for(int l=k; l<(k<<1); l++) {
//                a[l]= add ? a[m]+1: a[m];
//                m++;
//                if(m>=k) {
//                    m=j;
//                    add=true;
//                }
//                if(l>=a.length-1) return a;
//            }
//            j=k;
//            k=(k<<1);
//        }
//    }
    
    
//    --------------OPTIMAL-------------
//    public int[] countBits(int n) {
//        int[] a=new int[n+1];
//        if(n==0) return a;
//        a[1]=1;
//        if(n==1) return a;
//        int i=2;
//        int t=0;
//        while(i<a.length) {
//            t=a[i/2];
//            a[i]=t;
//            if(i+1>=a.length) return a;
//            a[i+1]=t+1;
//            i+=2;
//        }
//        return a;
//    }
    
    
//    --------------OPTIMAL------------
//    public int[] countBits(int n) {
//        int[] a=new int[n+1];
//        if(n==0) return a;
//        a[1]=1;
//        int t=0;
//        for(int i=2; i<=n; i++) {
//            t=a[i/2];
//            if(i%2==0) {
//                a[i]=t;
//            } else {
//                a[i]=t+1;
//            }
//        }
//        return a;
//    }
    
    
    public int[] countBits(int n) {
        int[] a=new int[n+1];
        for(int i=1; i<=n; i++) {
            a[i]=a[i>>>1]+(i&1);
        }
        return a;
    }
    
    public static void main(String[] args) {
        CountingBits c=new CountingBits();
        int[] a=c.countBits(0);
        for(int i: a) {
            System.out.print(i+" ");
        }
    }
    
}
