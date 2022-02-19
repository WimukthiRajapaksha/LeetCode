/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majority.element;

import java.util.Arrays;

/**
 *
 * @author wimukthirajapaksha
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    
//    --------------------ALTERNATE -> NOT OPTIMAL -> BIT MASKING---------------
//    public int majorityElement(int[] nums) {
//        int r=0;
//        for (int i=0, ma=1; i<32; i++, ma<<=1) {
//            System.out.println(ma);
//            int co=0;
//            for (int j: nums) {
//                if((j&ma)==ma) {
//                    co++;
//                }
//            }
//            if (co>nums.length/2) {
//                r|=ma;
//            }
//        }
//        System.out.println(r);
//        return r;
//    }
    
    
    public int majorityElement(int[] nums) {
        int c=0;
        int v=0;
        for(int i=0; i<nums.length; i++){
            if (c==0) {
                v=nums[i];
                c++;
            } else if(nums[i]==v) {
                c++;
            } else {
                c--;
            }
        }
        return v;
    }
    
    public static void main(String[] args) {
        MajorityElement m=new MajorityElement();
        m.majorityElement(new int[]{1,2,3,4,5,3,3,3});
    }
}
