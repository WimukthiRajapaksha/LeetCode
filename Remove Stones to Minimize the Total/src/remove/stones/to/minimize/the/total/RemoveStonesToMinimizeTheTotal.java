/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.stones.to.minimize.the.total;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveStonesToMinimizeTheTotal {

    /**
     * @param args the command line arguments
     */
    
    
//    -----------OPTIMAL -> O(N+K), O(1001)--------
    public int minStoneSum(int[] piles, int k) {
        int[] arr=new int[10001];
        int sum=0;
        for(int p: piles) {
            arr[p]++;
            sum+=p;
        }
        for(int i=arr.length-1; i>=0 && k>0; i--) {
            while(arr[i]>0 && k>0) {
                k--;
                sum-=i/2;
                arr[(i+1)/2]++;
                arr[i]--;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal r=new RemoveStonesToMinimizeTheTotal();
        System.out.println(r.minStoneSum(new int[]{5,4,9}, 2));
    }
}
