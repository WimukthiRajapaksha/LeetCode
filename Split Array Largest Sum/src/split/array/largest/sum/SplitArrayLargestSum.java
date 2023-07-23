/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package split.array.largest.sum;

/**
 *
 * @author wimukthirajapaksha
 */
public class SplitArrayLargestSum {

    /**
     * @param args the command line arguments
     */
    
//    ------------OPTIMAL -> O(N*LOGS), O(1)-----------------
    public int splitArray(int[] nums, int m) {
        int maxVal=0;
        int sum=0;
        for(int n: nums) {
            maxVal=Math.max(maxVal, n);
            sum+=n;
        }
        return bs(nums, maxVal, sum, m);
    }
    
    public int bs(int[] arr, int l, int r, int t) {
        if(l>r) return l;
        int m=l+(r-l)/2;
        if(isPossible(arr, m, t)) {
            return bs(arr, l, m-1, t);
        } else {
            return bs(arr, m+1, r, t);
        }
    }
    
    public boolean isPossible(int[] nums, int max, int req) {
        int s=0;
        int count=1;
        for(int n: nums) {
            s+=n;
            if(s>max) {
                s=n;
                count++;
            }
        }
        return count<=req;
    }
    
    

//    ------------OPTIMAL -> O(N*LOGS), O(1)-----------------
//    public int splitArray(int[] nums, int m) {
//        int maxVal=0;
//        int sum=0;
//        for(int n: nums) {
//            maxVal=Math.max(maxVal, n);
//            sum+=n;
//        }
//        int l=maxVal;
//        int r=sum;
//        int ret=0;
//        while(l<=r) {
//            int mid=l+(r-l)/2;
//            if(isPossible(nums, mid, m)) {
//                ret=mid;
//                r=mid-1;
//            } else {
//                l=mid+1;
//            }
//        }
//        return ret;
//    }
//    
//    public boolean isPossible(int[] nums, int max, int req) {
//        int s=0;
//        int count=1;
//        for(int n: nums) {
//            s+=n;
//            if(s>max) {
//                s=n;
//                count++;
//            }
//        }
//        return count<=req;
//    }
    
    public static void main(String[] args) {
        SplitArrayLargestSum s=new SplitArrayLargestSum();
        System.out.println(s.splitArray(new int[]{7,2,5,10,8}, 2));
        System.out.println(s.splitArray(new int[]{1,2,3,4,5}, 2));
    }
}
