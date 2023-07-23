/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koko.eating.bananas;

/**
 *
 * @author wimukthirajapaksha
 */
public class KokoEatingBananas {

    /**
     * @param args the command line arguments
     */
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
    public int minEatingSpeed(int[] piles, int h) {
        int r=0;
        for(int p: piles) {
            if(r<p) r=p;
        }
        int l=1;
        while(l<=r) {
            int m=l+(r-l)/2;
            if(isValid(piles, m, h)) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return l;
    }
    
    private boolean isValid(int[] pile, int m, int t) {
        for(int p: pile) {
            t-=(p+m-1)/m;
            if(t<0) return false;
        }
        return true;
    }
    
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
//    public int minEatingSpeed(int[] piles, int h) {
//        int r=0;
//        for(int p: piles) {
//            if(r<p) r=p;
//        }
//        int l=1;
//        while(l<=r) {
//            int m=l+(r-l)/2;
//            if(isValid(piles, m, h)) {
//                r=m-1;
//            } else {
//                l=m+1;
//            }
//        }
//        return l;
//    }
//    
//    private boolean isValid(int[] pile, int m, int t) {
//        long c=0;
//        for(int p: pile) {
//            c+=(p+m-1)/m;
//        }
//        return c<=t;
//    }
    
    public static void main(String[] args) {
        KokoEatingBananas k=new KokoEatingBananas();
        System.out.println(k.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
