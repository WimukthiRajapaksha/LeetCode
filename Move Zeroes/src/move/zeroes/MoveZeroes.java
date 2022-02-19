/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move.zeroes;

/**
 *
 * @author wimukthirajapaksha
 */
public class MoveZeroes {

    /**
     * @param args the command line arguments
     */
    
//    public void moveZeroes(int[] nums) {
//        int i=0;
//        for (int j=0; j<nums.length; j++) {
//            if(nums[j]!=0) {
//                int t=nums[i];
//                nums[i]=nums[j];
//                nums[j]=t;
//                i++;
//            }
//        }
//        for(int k: nums) {
//            System.out.print(k+" ");
//        }
//        System.out.println();
//    }
    
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j]!=0) {
                nums[i]=nums[j];
                i++;
            }
        }
        for(int k=i; k<nums.length; k++) {
            nums[k]=0;
        }
        for(int k: nums) {
            System.out.print(k+" ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        MoveZeroes m=new MoveZeroes();
        m.moveZeroes(new int[]{0,1,0,3,12});
        m.moveZeroes(new int[]{0,0});
        m.moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
        m.moveZeroes(new int[]{0,0,1});
    }
}
