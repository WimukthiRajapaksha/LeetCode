/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house.robber;

/**
 *
 * @author wimukthirajapaksha
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    
//    ---------------------OPTIMAL---------------------------
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int first=0;
        int second=0;
        for(int i: nums) {
            int temp=Math.max(second, first+i);
            first=second;
            second=temp;
        }
        return second;
    }
    
    
//    ---------------------OPTIMAL---------------------------
//    public int rob(int[] nums) {
//        if(nums.length==1) return nums[0];
//        int[] max=new int[nums.length+1];
//        max[1]=nums[0];
//        for(int i=1; i<nums.length; i++) {
//            max[i+1]=Math.max(max[i], nums[i]+max[i-1]);
//        }
//        return max[max.length-1];
//    }
    
    
//    ----------------------OPTIMAL -> WITH MEMORIZATION------------------------
//    public int rob(int[] nums) {
//        Integer[] arr=new Integer[nums.length];
//        return rob(nums, arr, nums.length-1);
//    }
//    
//    private int rob(int[] arr, Integer[] mem, int i) {
//        if(i<0) {
//            return 0;
//        }
//        if(mem[i]!=null) return mem[i];
//        mem[i]=Math.max(rob(arr, mem, i-2)+arr[i], rob(arr, mem, i-1));
//        return mem[i];
//    }
    
    
//    -------------------NOT OPTIMAL -> OPTIMIZE USING MEMORIZATION-------------
//    public int rob(int[] nums) {
//        return rob(nums, nums.length-1);
//    }
//    
//    private int rob(int[] arr, int i) {
//        if(i<0) {
//            return 0;
//        }
//        return Math.max(rob(arr, i-2)+arr[i], rob(arr, i-1));
//    }
    
    public static void main(String[] args) {
        HouseRobber h=new HouseRobber();
        System.out.println(h.rob(new int[]{1,2,3,1}));
        System.out.println(h.rob(new int[]{2,7,9,3,1}));
        System.out.println(h.rob(new int[]{2,1,1,2}));
        System.out.println(h.rob(new int[]{1,1}));
    }
}
