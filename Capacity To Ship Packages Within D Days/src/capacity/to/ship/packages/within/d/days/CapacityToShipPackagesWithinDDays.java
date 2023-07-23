/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacity.to.ship.packages.within.d.days;

/**
 *
 * @author wimukthirajapaksha
 */
public class CapacityToShipPackagesWithinDDays {

    /**
     * @param args the command line arguments
     */
    
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=0;
        for(int i: weights) {
            max=Math.max(max, i);
            sum+=i;
        }
        return min(weights, max, sum, days);
//        int l=max;
//        int r=sum;
//        while(l<r) {
//            int m=l+(r-l)/2;
//            if(isPossible(weights, m, days)) {
//                r=m;
//            } else {
//                l=m+1;
//            }
//        }
//        return l;
    }
    
    private int min(int[] arr, int l, int r, int days) {
        if(l>r) {
            return l;
        }
        int m=l+((r-l)/2);
        if(isPossible(arr, m, days)) {
            return min(arr, l, m-1, days);
        }
        return min(arr, m+1, r, days);
    }
    
    private boolean isPossible(int[] arr, int m, int d) {
        int sum=0;
        int c=1;
        for(int i: arr) {
            if(sum+i>m) {
                sum=i;
                c++;
            } else {
                sum+=i;
            }
        }
        return c<=d;
    }
    
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c=new CapacityToShipPackagesWithinDDays();
        System.out.println(c.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(c.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(c.shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
