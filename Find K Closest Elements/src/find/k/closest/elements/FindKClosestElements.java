/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.k.closest.elements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindKClosestElements {

    /**
     * @param args the command line arguments
     */
    
//    -------------------ALTERNATE -> O(N), O(K)----------------------
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> ret=new ArrayList<>();
//        int l=0;
//        int r=arr.length-1;
//        while(r-l>=k) {
//            if(Math.abs(arr[l]-x)>Math.abs(arr[r]-x)) {
//                l++;
//            } else {
//                r--;
//            }
//        }
//        for(int i=l; i<=r; i++) {
//            ret.add(arr[i]);
//        }
//        return ret;
//    }
    
    
//    --------------------OPTIMAL -> O(LOG(N-K)), O(K)--------------------------
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-k;
        List<Integer> ret=new ArrayList<>();
        while(l<r) {
            int m=l+(r-l)/2;
            if(Math.abs(x-arr[m])>Math.abs(arr[m+k]-x)) {
                l=m+1;
            } else {
                r=m;
            }
        }
        for(int i=l; i<l+k; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        FindKClosestElements f=new FindKClosestElements();
        System.out.println(f.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(f.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }
}
