/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.index;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class HIndex {

    /**
     * @param args the command line arguments
     */
    
//    -------------------------OPTIMAL -> O(N) -> O(N)----------------------------
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int[] nums=new int[citations.length+1];
        for(int i: citations) {
            if(i>nums.length-2) {
                nums[nums.length-1]++;
            } else {
                nums[i]++;
            }
        }
        int total=0;
        for(int i=nums.length-1; i>=0; i--) {
            total+=nums[i];
            if(total>=i) return i;
        }
        return 0;
    }
    
    
//    ----------------------NOT OPTIMAL---------------------------------
//    public int hIndex(int[] citations) {
//        if(citations.length==0) return 0;
//        int[] arr=new int[1001];
//        for(int i: citations) {
//            arr[i+1]++;
//        }
//        for(int i=1; i<arr.length; i++) {
//            arr[i]+=arr[i-1];
//        }
//        int i=0;
//        int j=arr.length-1;
//        while(i<=j) {
//            int m=i+(j-i)/2;
//            boolean em=eligible(arr, m);
//            boolean e=false;
//            if(m>0) {
//                e=eligible(arr, m-1);
//            }
//            if(e && !em) {
//                return m-2;
//            } else if(e && em) {
//                i=m+1;
//            } else {
//                j=m-1;
//            }
//        }
//        return 0;
//    }
//    
//    private boolean eligible(int[] arr, int i) {
//        return (arr[arr.length-1]-arr[i-1]>=i-1);
//    }
    
    
    
    
//    ----------------------NOT OPTIMAL---------------------------------
//    public int hIndex(int[] citations) {
//        if(citations.length==0) return 0;
//        int[] arr=new int[1001];
//        for(int i: citations) {
//            arr[i+1]++;
//        }
//        for(int i=1; i<arr.length; i++) {
//            arr[i]+=arr[i-1];
//        }
//        for(int i=arr.length-1; i>0; i--) {
//            if(arr[arr.length-1]-arr[i-1]>=i-1) {
//                return i-1;
//            }
//        }
//        return 0;
//    }
    
    
    
    
//    ----------------------NOT OPTIMAL---------------------------------
//    public int hIndex(int[] citations) {
//        if(citations.length==0) return 0;
//        Arrays.sort(citations);
//        int[] arr=new int[citations[citations.length-1]+2];
//        for(int i: citations) {
//            arr[i+1]++;
//        }
//        for(int i=1; i<arr.length; i++) {
//            arr[i]+=arr[i-1];
//        }
//        for(int i=arr.length-1; i>0; i--) {
//            if(arr[arr.length-1]-arr[i-1]>=i-1) {
//                return i-1;
//            }
//        }
//        return 0;
//    }
    
    public static void main(String[] args) {
        HIndex h=new HIndex();
        System.out.println(h.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(h.hIndex(new int[]{1,3,1}));
        System.out.println(h.hIndex(new int[]{2}));
    }
}
