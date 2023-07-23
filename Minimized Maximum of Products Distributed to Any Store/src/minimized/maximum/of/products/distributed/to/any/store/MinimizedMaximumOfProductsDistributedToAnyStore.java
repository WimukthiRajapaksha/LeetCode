/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimized.maximum.of.products.distributed.to.any.store;

/**
 *
 * @author wimukthirajapaksha
 */
public class MinimizedMaximumOfProductsDistributedToAnyStore {

    /**
     * @param args the command line arguments
     */
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
    public int minimizedMaximum(int n, int[] quantities) {
        int max=0;
        for(int i:  quantities) {
            if(max<i) max=i;
        }
        int l=1;
        int r=max;
        while(l<r) {
            int mid=l+(r-l)/2;
            if(isPossible(quantities, mid, n)) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }
    
    public boolean isPossible(int[] arr, int m, int t) {
        int count=0;
        for(int a: arr) {
            count+=(a+m-1)/m;
        }
        return count<=t;
    }
    
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
//    public int minimizedMaximum(int n, int[] quantities) {
//        int max=0;
//        for(int i:  quantities) {
//            if(max<i) max=i;
//        }
//        int l=1;
//        int r=max;
//        while(l<=r) {
//            int mid=l+(r-l)/2;
//            if(isPossible(quantities, mid, n)) {
//                r=mid-1;
//            } else {
//                l=mid+1;
//            }
//        }
//        return l;
//    }
//    
//    public boolean isPossible(int[] arr, int m, int t) {
//        int count=0;
//        for(int a: arr) {
//            count+=(a+m-1)/m;
//        }
//        return count<=t;
//    }
    
    
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
//    public int minimizedMaximum(int n, int[] quantities) {
//        int max=0;
//        for(int i:  quantities) {
//            if(max<i) max=i;
//        }
//        int l=1;
//        int r=max;
//        while(l<=r) {
//            int mid=l+(r-l)/2;
//            if(isPossible(quantities, mid, n)) {
//                r=mid-1;
//            } else {
//                l=mid+1;
//            }
//        }
//        return l;
//    }
//    
//    public boolean isPossible(int[] arr, int m, int t) {
//        int count=0;
//        for(int a: arr) {
//            count+=Math.ceil(a/(double)m);
//        }
//        return count<=t;
//    }
    
    
//    -------------------------OPTIMAL -> O(N*LOGN), O(N)-----------------------
//    public int minimizedMaximum(int n, int[] quantities) {
//        int max=0;
//        for(int i:  quantities) {
//            if(max<i) max=i;
//        }
//        int l=1;
//        int r=max;
//        while(l<=r) {
//            int mid=l+(r-l)/2;
//            if(isPossible(quantities, mid, n)) {
//                r=mid-1;
//            } else {
//                l=mid+1;
//            }
//        }
//        return l;
//    }
//    
//    public boolean isPossible(int[] arr, int m, int t) {
//        int count=0;
//        for(int a: arr) {
//            count+=(a/m)+(a%m==0 ? 0 : 1);
//        }
//        return count<=t;
//    }
    
    public static void main(String[] args) {
        MinimizedMaximumOfProductsDistributedToAnyStore m=new MinimizedMaximumOfProductsDistributedToAnyStore();
        System.out.println(m.minimizedMaximum(6, new int[]{11,6}));
        System.out.println(m.minimizedMaximum(7, new int[]{15,10,10}));
        System.out.println(m.minimizedMaximum(1, new int[]{100000}));
    }
}
