/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remove.element;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class RemoveElement {

    /**
     * @param args the command line arguments
     */
    
    public int removeElement(int[] nums, int val) {
        int j=nums.length-1;
        int count=0;
        for (int i=0; i<=j;) {
            if (nums[j]==val) {
                j--;
                count++;
                continue;
            } 
            if(nums[i]==val) {
                nums[i]=nums[j];
                j--;
                count++;
            }
            i++;
        }
        for (int k: nums) {
            System.out.print(k+" ");
        }
        System.out.println("\n"+(nums.length-count));
        return nums.length-count;


//          -----------------------ALTERNATE -> NOT OPTIMAL--------------------------------
//        int temp=0;
//        for (int i=0; i<nums.length; i++) {
//            if (nums[i]!=val) {
//                nums[temp]=nums[i];
//                temp++;
//            }
//        }
//        System.out.println(temp);
//        return temp;
    }
    
    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        r.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        r.removeElement(new int[]{3,2,2,3}, 3);
        r.removeElement(new int[]{1}, 1);
        r.removeElement(new int[]{3,3}, 3);
    }
}
