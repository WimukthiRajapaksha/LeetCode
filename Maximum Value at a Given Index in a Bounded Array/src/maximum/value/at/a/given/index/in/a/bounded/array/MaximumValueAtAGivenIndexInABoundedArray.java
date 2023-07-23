/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.value.at.a.given.index.in.a.bounded.array;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumValueAtAGivenIndexInABoundedArray {

    /**
     * @param args the command line arguments
     */
    
    
//    --------------OPTIMAL -> O(LOG MAXSUM), O(1)---------------
    public int maxValue(int n, int index, int maxSum) {
        int l=1;
        int r=maxSum;
        while(l<r) {
            int m=l+(r-l+1)/2;
            long sum=sum(index+1, m)+sum(n-index, m)-m;
            if(sum<=maxSum) {
                l=m;
            } else {
                r=m-1;
            }
        }
        return l;
    }
    
    private long sum(int len, long max) {
        if(max>=len) {
            return ((max+max-len+1)*len)/2;
        }
        return (((1+max)*max)/2)+len-max;
    }
    
    
//    --------------OPTIMAL -> O(LOG MAXSUM), O(1)---------------
//    public int maxValue(int n, int index, int maxSum) {
//        int l=1;
//        int r=maxSum;
//        int ret=1;
//        while(l<=r) {
//            int m=l+(r-l)/2;
//            long sum=sum(index+1, m)+sum(n-index, m)-m;
//            if(sum<=maxSum) {
//                ret=m;
//                l=m+1;
//            } else {
//                r=m-1;
//            }
//        }
//        return ret;
//    }
//    
//    private long sum(int len, long max) {
//        if(max>=len) {
//            return ((max+max-len+1)*len)/2;
//        }
//        return (((1+max)*max)/2)+len-max;
//    }
    
    public static void main(String[] args) {
        MaximumValueAtAGivenIndexInABoundedArray m=new MaximumValueAtAGivenIndexInABoundedArray();
        System.out.println(m.maxValue(4, 2, 6));
        System.out.println(m.maxValue(6, 1, 10));
        System.out.println(m.maxValue(6, 1, 6));
        System.out.println(m.maxValue(6, 2, 931384943));
    }
}

