/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.consecutive.ones;

/**
 *
 * @author wimukthirajapaksha
 */
public class MaxConsecutiveOnes {

    /**
     * @param args the command line arguments
     */
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int max=0;
        for(int i: nums) {
            if(i==0) {
                max=Math.max(c, max);
                c=0;
            } else {
                c++;
            }
        }
        return Math.max(max, c);
    }
    
    
//    ----------------------ALTERNATE -> OPTIMAL-------------------------
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int max=nums[0];
//        
//        for(int i=1; i<nums.length; i++) {
//            if(nums[i]==1) {
//                nums[i]+=nums[i-1];
//            }
//            if(max<nums[i]) {
//                max=nums[i];
//            }
//        }
//        return max;
//    }
    
    
    
//    ----------------------ALTERNATE -> OPTIMAL-------------------------
//    public int findMaxConsecutiveOnes(int[] nums) {
//        int i=0;
//        int c=0;
//        int max=0;
//        while(i<nums.length) {
//            if(nums[i]==0) {
//                c=0;
//                while(i<nums.length && nums[i]==0) i++;
//            } else {
//                c++;
//                if(c>max) {
//                    max=c;
//                }
//                i++;
//            }
//        }
//        return max;
//    }
    
    public static void main(String[] args) {
        MaxConsecutiveOnes m=new MaxConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1,1,1,1}));
        System.out.println(m.findMaxConsecutiveOnes(new int[]{0}));
    }
}
