/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.closest.number.to.zero;

/**
 *
 * @author wimukthirajapaksha
 */
public class FindClosestNumberToZero {

    /**
     * @param args the command line arguments
     */
    
    
//    ----------------------OPTIMAL -> O(N), O(1)-------------------------------
    public int findClosestNumber(int[] nums) {
        int max=Integer.MAX_VALUE/2;
        for(int i: nums) {
            if(Math.abs(i)<Math.abs(max) || (Math.abs(i)==Math.abs(max) && max<i)) {
                max=i;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        FindClosestNumberToZero f=new FindClosestNumberToZero();
        System.out.println(f.findClosestNumber(new int[]{-4,-2,1,4,8}));
        System.out.println(f.findClosestNumber(new int[]{2,-1,1}));
    }
}
