/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shuffle.the.array;

/**
 *
 * @author wimukthirajapaksha
 */
public class ShuffleTheArray {

    /**
     * @param args the command line arguments
     */
    
    public int[] shuffle(int[] nums, int n) {
        for (int i=0; i<n; i++) {
            nums[i]=nums[i]+(nums[n+i]*10000);
        }
        for (int i: nums) {
            System.out.print(i+" ");
        }
        int k=n-1;
        System.out.println();
        for (int i=2*n-1; i>=0; i-=2) {
            nums[i]=nums[k]/10000;
            nums[i-1]=nums[k]%10000;
            k--;
        }
        for (int i: nums) {
            System.out.print(i+" ");
        }
        return nums;
    }
    
//    public int[] shuffle(int[] nums, int n) {
//        int[] ret=new int[nums.length];
//        for (int i=0; i<n; i++) {
//            ret[2*i]=nums[i];
//            ret[2*i+1]=nums[n+i];
//        }
//        for (int i: ret) {
//            System.out.print(i+" ");
//        }
//        return ret;
//    }
    
    public static void main(String[] args) {
        ShuffleTheArray s=new ShuffleTheArray();
        s.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4);
    }
    
}
