/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximum.candies.allocated.to.k.children;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaximumCandiesAllocatedToKChildren {

    /**
     * @param args the command line arguments
     */
    
//    ----------------------OPTIMAL -> O(N*LOGN), O(1)--------------------------
//    public int maximumCandies(int[] candies, long k) {
//        long total=0;
//        for(int c: candies) {
//            total+=c;
//        }
//        if(total<k) return 0;
//        if(total==k) return 1;
//        int l=1;
//        int r=(int)(total/k);
//        while(l<r) {
//            int mid=l+(r-l+1)/2; // to find the last possible item
//            if(isValid(candies, mid, k)) {
//                l=mid;
//            } else {
//                r=mid-1;
//            }
//        }
//        return l;
//    }
//    
//    private boolean isValid(int[] candy, int m, long t) {
//        long count=0;
//        for(int c: candy) {
//            count+=c/m;
//        }
//        return count>=t;
//    }
    
    
    
//    ----------------------OPTIMAL -> O(N*LOGN), O(1)--------------------------
    public int maximumCandies(int[] candies, long k) {
        long total=0;
        int r=0;
        for(int c: candies) {
            total+=c;
            if(r<c) r=c;
        }
        if(total<k) return 0;
        if(total==k) return 1;
        int l=1;
        int answer=0;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(isValid(candies, mid, k)) {
                answer=mid;
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return answer;
    }
    
    private boolean isValid(int[] candy, int m, long t) {
        for(int c: candy) {
            t-=c/m;
        }
        return t<=0;
    }
    
    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren m=new MaximumCandiesAllocatedToKChildren();
        System.out.println(m.maximumCandies(new int[]{5,8,6}, 3));
        System.out.println(m.maximumCandies(new int[]{2,5}, 11));
    }
}
