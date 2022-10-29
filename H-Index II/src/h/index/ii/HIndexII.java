/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.index.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class HIndexII {

    /**
     * @param args the command line arguments
     */
    
    public int hIndex(int[] citations) {
        int i=0;
        int j=citations.length-1;
        while(i<=j) {
            int m=i+(j-i)/2;
            if(citations[m]==citations.length-m) return citations[m];
            else if(citations[m]<citations.length-m) {
                i=m+1;
            } else {
                j=m-1;
            }
        }
        return citations.length-i;
    }
    
    public static void main(String[] args) {
        HIndexII h=new HIndexII();
        System.out.println(h.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(h.hIndex(new int[]{1,2,100}));
        System.out.println(h.hIndex(new int[]{0}));
        System.out.println(h.hIndex(new int[]{100}));
        System.out.println(h.hIndex(new int[]{3,3,3}));
        System.out.println(h.hIndex(new int[]{0,0,4,4,4}));
        System.out.println();
        System.out.println(h.hIndex(new int[]{1,2,4,8,9}));
        System.out.println(h.hIndex(new int[]{0,1,2,3,4}));
        System.out.println(h.hIndex(new int[]{1,8,9,10}));
    }
}
