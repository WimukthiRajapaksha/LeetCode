/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house.robber.ii;

/**
 *
 * @author wimukthirajapaksha
 */
public class HouseRobberII {

    /**
     * @param args the command line arguments
     */
    
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int f=max(nums, 0, nums.length-2);
        int s=max(nums, 1, nums.length-1);
        return Math.max(f, s);
    }
    
    private int max(int[] nums, int i, int j) {
        int f=0;
        int s=0;
        for(int k=i; k<=j; k++) {
            int t=Math.max(s, f+nums[k]);
            f=s;
            s=t;
        }
        return s;
    }
    
//    public int rob(int[] nums) {
//        if(nums.length==1) return nums[0];
//        int[] rob=new int[nums.length];
//        for(int i=0; i<nums.length-1; i++) {
//            if(i<2) {
//                rob[i]=nums[i];
//                continue;
//            }
//            if(i==2) {
//                rob[i]=nums[i]+rob[0];
//                continue;
//            }
//            rob[i]=nums[i]+Math.max(rob[i-2], rob[i-3]);
//        }
//        int m1=Math.max(rob[rob.length-2], rob.length>2 ? rob[rob.length-3] : 0);
//        for(int i=1; i<nums.length; i++) {
//            if(i<3) {
//                rob[i]=nums[i];
//                continue;
//            }
//            if(i==3) {
//                rob[i]=nums[i]+nums[1];
//                continue;
//            }
//            rob[i]=nums[i]+Math.max(rob[i-2], rob[i-3]);
//        }
//        int m2=Math.max(rob[rob.length-1], rob[rob.length-2]);
//        System.out.println(m1+" "+m2);
//        return Math.max(m1, m2);
//    }
    
    public static void main(String[] args) {
        HouseRobberII h=new HouseRobberII();
        System.out.println(h.rob(new int[]{1,2,3,1}));
        System.out.println(h.rob(new int[]{2,3,2}));
        System.out.println(h.rob(new int[]{1,2,3}));
        System.out.println(h.rob(new int[]{1,2}));
        System.out.println(h.rob(new int[]{1,2,1,1}));
        System.out.println(h.rob(new int[]{1,3,1,3,100}));
    }
}
