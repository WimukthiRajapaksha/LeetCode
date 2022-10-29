/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.ugly.number;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author wimukthirajapaksha
 */
public class SuperUglyNumber {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL----------------------
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<long[]> pq=new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        for(int i: primes) {
            pq.offer(new long[]{i, i, 0});
        }
        int[] uglyNums=new int[n];
        uglyNums[0]=1;
        int i=1;
        while(i<n) {
            System.out.println(Arrays.toString(pq.peek()));
            long[] entry=pq.poll();
            if(uglyNums[i-1]!=entry[1]) {
                uglyNums[i]=(int)entry[1];
                i++;
            }
            pq.offer(new long[]{
                entry[0],
                entry[0]*uglyNums[(int)entry[2]+1],
                entry[2]+1
            });
        }
        System.out.println(Arrays.toString(uglyNums));
        return uglyNums[uglyNums.length-1];
    }
    
//    ---------------------OPTIMAL-----------------------
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        if(n==1) return 1;
//        int[] indexes=new int[primes.length];
//        int[] uglyNums=new int[n];
//        long[] vals=new long[primes.length];
//        Arrays.fill(vals, 1);
//        
//        long min=1;
//        for(int i=0; i<n; i++) {
//            uglyNums[i]=(int)min;
//            min=Integer.MAX_VALUE;
//            for(int j=0; j<indexes.length; j++) {
//                if(vals[j]==uglyNums[i]) {
//                    vals[j]=uglyNums[indexes[j]++]*(long)primes[j];
//                }
//                min=Math.min(min, vals[j]);
//            }
//            System.out.println(Arrays.toString(uglyNums)+" "+Arrays.toString(indexes)+" "+min);
//        }
//        System.out.println(Arrays.toString(uglyNums));
//        return uglyNums[uglyNums.length-1];
//    }
    
    
    
//    -----------------NOT OPTIMAL--------------------
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        if(n==1) return 1;
//        int[] place=new int[primes.length];
//        int[] arr=new int[n];
//        arr[0]=1;
//        for(int i=1; i<n; i++) {
//            long min=Integer.MAX_VALUE;
//            for(int j=0; j<place.length; j++) {
//                min=Math.min(min, arr[place[j]]*(long)primes[j]);
//            }
//            for(int j=0; j<place.length; j++) {
//                if(min==primes[j]*(long)arr[place[j]]) {
//                    place[j]++;
//                }
//            }
//            arr[i]=(int)min;
//        }
//        return arr[arr.length-1];
//    }
    
    public static void main(String[] args) {
        SuperUglyNumber s=new SuperUglyNumber();
        System.out.println(s.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
//        System.out.println(s.nthSuperUglyNumber(1, new int[]{2,3,5}));
    }
}
