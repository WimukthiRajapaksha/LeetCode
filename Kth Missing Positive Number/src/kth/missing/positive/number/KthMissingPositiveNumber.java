/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kth.missing.positive.number;

/**
 *
 * @author wimukthirajapaksha
 */
public class KthMissingPositiveNumber {

    /**
     * @param args the command line arguments
     */
    
    
//    -------------------OPTIMAL -> O(LOG N), O(1)--------------
    public int findKthPositive(int[] arr, int k) {
        int l=0;
        int r=arr.length-1;
        while(l<=r) {
            int m=l+((r-l)/2);
            if(arr[m]-(m+1)<k) {
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return l+k;
    }
    
    
//    -------------------OPTIMAL -> O(LOG N), O(1)--------------
//    public int findKthPositive(int[] A, int k) {
//        int l = 0, r = A.length, m;
//        while (l < r) {
//            m = (l + r) / 2;
//            if (A[m] - (1+m) < k)
//                l = m + 1;
//            else
//                r = m;
//        }
//        return l + k;
//    }
    
    
//    -------------------NOT OPTIMAL -> O(N), O(1)--------------
//    public int findKthPositive(int[] arr, int k) {
//        int c=0;
//        int i=0;
//        while(k>0) {
//            c++;
//            if(i<arr.length && c==arr[i]) {
//                i++;
//            } else {
//                k--;
//            }
//        }
//        return c;
//    }
    
    public static void main(String[] args) {
        KthMissingPositiveNumber k=new KthMissingPositiveNumber();
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 1));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 2));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 3));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 4));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 6));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 7));
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 8));
        System.out.println(k.findKthPositive(new int[]{1,2,3,4}, 2));
    }
}


//1
//5
//6
//8
//9
//10
//12
//13
//6